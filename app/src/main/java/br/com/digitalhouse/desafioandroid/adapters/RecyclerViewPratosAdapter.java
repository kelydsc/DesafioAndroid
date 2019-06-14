package br.com.digitalhouse.desafioandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewPratoClickListener;
import br.com.digitalhouse.desafioandroid.model.Prato;

public class RecyclerViewPratosAdapter extends RecyclerView.Adapter<
        RecyclerViewPratosAdapter.ViewHolder> {

    //Declaração de atributos
    private List<Prato> pratos;
    private RecyclerViewPratoClickListener listener;

    //Construtor especifico
    public RecyclerViewPratosAdapter(List<Prato> pratos, RecyclerViewPratoClickListener listener) {
        this.pratos = pratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewPratosAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.prato_recyclerview_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerViewPratosAdapter.ViewHolder viewHolder, int position) {

        final Prato prato = pratos.get(position);

        viewHolder.setaPratosNaTela(prato);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onClick(prato);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos dos elementos
        private ImageView imageViewFotoPrato;
        private TextView textViewNomePrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Inicialização das views
            imageViewFotoPrato = itemView.findViewById(R.id.imageViewRPrato);
            textViewNomePrato = itemView.findViewById(R.id.textViewNomeDoPrato);
        }

        //Atribui as views os valores da variável prato
        public void setaPratosNaTela(Prato prato) {

            imageViewFotoPrato.setImageDrawable(ContextCompat.getDrawable(
                    imageViewFotoPrato.getContext(), prato.getFotoPrato()));

            textViewNomePrato.setText(prato.getNomePrato());
        }
    }
}
