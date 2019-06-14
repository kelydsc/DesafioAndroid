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
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class RecyclerViewRestaurantesAdapter extends RecyclerView.Adapter<
        RecyclerViewRestaurantesAdapter.ViewHolder> {

    //Declaração de atributos
    private List<Restaurante> restaurantes;
    private RecyclerViewRestauranteClickListener listener;

    //Construtor especifico
    public RecyclerViewRestaurantesAdapter(
            List<Restaurante> restaurantes, RecyclerViewRestauranteClickListener listener) {
        this.restaurantes = restaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewRestaurantesAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.restaurante_recyclerview_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerViewRestaurantesAdapter.ViewHolder viewHolder, int position) {

        final Restaurante restaurante = restaurantes.get(position);

        viewHolder.setaRestauranteNaTela(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listener.onClick(restaurante);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos dos elementos
        private ImageView imageViewFotoRestaurante;
        private TextView textViewNomeRestaurante;
        private TextView textViewEnderecoRestaurante;
        private TextView textViewHorarioRestaurante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Inicialização das views
            imageViewFotoRestaurante = itemView.findViewById(R.id.imageViewRestaurante);
            textViewNomeRestaurante = itemView.findViewById(R.id.textViewNomeRestaurante);
            textViewEnderecoRestaurante = itemView.findViewById(R.id.textViewEnderecoRestaurante);
            textViewHorarioRestaurante = itemView.findViewById(R.id.textViewHorarioRestaurante);
        }

        //Atribui as views os valores da variavel restaurante
        public void setaRestauranteNaTela(Restaurante restaurante) {

            imageViewFotoRestaurante.setImageDrawable(ContextCompat.getDrawable(
                    imageViewFotoRestaurante.getContext(), restaurante.getFotoRestaurante()));

            textViewNomeRestaurante.setText(restaurante.getNome());

            textViewEnderecoRestaurante.setText(restaurante.getEndereco());

            textViewHorarioRestaurante.setText(restaurante.getHorario());
        }
    }
}
