package br.com.digitalhouse.desafioandroid.detalhe.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapters.RecyclerViewPratosAdapter;
import br.com.digitalhouse.desafioandroid.home.view.HomeActivity;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewPratoClickListener;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;

public class DetalheRestauranteActivity extends AppCompatActivity implements
        RecyclerViewPratoClickListener {

    //Declaração de atributos
    public RecyclerView recyclerViewPratos;
    public RecyclerViewPratosAdapter adapterPratos;
    private Restaurante restaurante;
    private ImageView imageViewFotoDetalheRestaurante;
    private ImageView imageViewBackDetalheRestaurante;
    private TextView textViewDetalheNomeRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);

        //Inicialização das Views
        initViews();

        //Inicialização das Views de adapter
        recyclerViewPratos = findViewById(R.id.recyclerViewPratos);

        //Valido se veio alguma coisa na intent
        if (getIntent() != null && getIntent().getExtras() != null) {
            restaurante = getIntent().getParcelableExtra("RESTAURANTE");

            if (restaurante != null) {

                imageViewFotoDetalheRestaurante.setImageResource(restaurante.getFotoRestaurante());
                textViewDetalheNomeRestaurante.setText(restaurante.getNome());

            }
        }

        //Adiciona o layout manager ao recyclerview
        recyclerViewPratos.setLayoutManager(new GridLayoutManager(this, 2));

        // Adiciona o adapter ao recyclerview
        adapterPratos = new RecyclerViewPratosAdapter(getPrato(), this);

        recyclerViewPratos.setAdapter(adapterPratos);

        //Chama a tela com a lista de restaurantes
        chamaListarRestaurantes();
    }

    private void initViews() {

        imageViewFotoDetalheRestaurante = findViewById(R.id.imageViewDetalheRestaurante);
        imageViewBackDetalheRestaurante = findViewById(R.id.imageBackDetalheRestaurante);
        textViewDetalheNomeRestaurante = findViewById(R.id.textViewDetalheNomeRestaurante);
    }

    private List<Prato> getPrato() {

        List<Prato> pratos = new ArrayList<>();

        for (Prato registroPrato : restaurante.getPratosCardapio()) {

            pratos.add(registroPrato);
        }

        //Retorna a Lista de Pratos
        return pratos;
    }

    @Override
    public void onClick(Prato prato) {

        Intent intentDetalhePrato = new Intent(this, DetalhePratoActivity.class);

        //Passa todos os dados do Array para outra Actitivty
        intentDetalhePrato.putExtra("PRATO", prato);

        startActivity(intentDetalhePrato);

    }

    private void chamaListarRestaurantes() {

        imageViewBackDetalheRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama a tela de Lista de Restaurantes
                Intent intentListaRestaurantes = new Intent(
                        DetalheRestauranteActivity.this, HomeActivity.class);

                startActivity(intentListaRestaurantes);
            }
        });
    }
}
