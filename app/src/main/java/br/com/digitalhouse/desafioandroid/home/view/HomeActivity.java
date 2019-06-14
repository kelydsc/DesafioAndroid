package br.com.digitalhouse.desafioandroid.home.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapters.RecyclerViewRestaurantesAdapter;
import br.com.digitalhouse.desafioandroid.detalhe.view.DetalheRestauranteActivity;
import br.com.digitalhouse.desafioandroid.interfaces.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafioandroid.model.Prato;
import br.com.digitalhouse.desafioandroid.model.Restaurante;
import br.com.digitalhouse.desafioandroid.profile.ProfileActivity;

public class HomeActivity extends AppCompatActivity implements RecyclerViewRestauranteClickListener {

    //Declaração de Atributos
    private RecyclerView recyclerViewRestaurante;
    private RecyclerViewRestaurantesAdapter adapterRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicialização das views
        recyclerViewRestaurante = findViewById(R.id.recyclerViewRestaurantes);

        // Adiciona o layout manager ao recyclerview
        recyclerViewRestaurante.setLayoutManager(new LinearLayoutManager(this));

        // Adiciona o adapter ao recyclerview
        adapterRestaurante = new RecyclerViewRestaurantesAdapter(getRestaurante(), this);

        recyclerViewRestaurante.setAdapter(adapterRestaurante);
    }

    private List<Restaurante> getRestaurante() {

        //Adiciona os restaurantes e seus respectivos cardapios
        List<Restaurante> restaurantes = new ArrayList<>();

        //Pratos do Restaurante America
        List<Prato> pratosAmerica = new ArrayList<>();

        //Pratos do restaurante America
        pratosAmerica.add(new Prato("Carpaccio America", "Carpaccio, " +
                "alface " + "americana e rúcula com molho de alcaparras, azeitonas pretas, " +
                "crostini " + "e queijo parmesão.",
                R.drawable.ic_saladacarpaccio_america));

        pratosAmerica.add(new Prato("Minuano", "Ribeye grelhado de 220 " +
                "gramas " + "acompanhado de salada Cole Slaw (repolho, cenoura, uvas passas com " +
                "molho de " + "creme e maionese) e baked potato com molho de queijos e creme" +
                " gorgonzola.",
                R.drawable.ic_grelhadominuano_america));

        pratosAmerica.add(new Prato("Polpettone", "Polpettone servido com " +
                "fettuccine ou penne ao molho de tomates e manjericão.",
                R.drawable.ic_polpettone_america));

        pratosAmerica.add(new Prato("Milanesa Spaghetti Al Limone", "Filet " +
                "mignon" + " à milanesa servido com spaghetti ao molho Limone, rúcula selvagem e" +
                " parmesão.",
                R.drawable.ic_milanesaespaghetti_america));

        pratosAmerica.add(new Prato("Veggie Sandwich", "Berinjela e " +
                "abobrinha" + " grelhadas, mozzarella de búfala, tomate seco e rúcula com molho" +
                " mostarda, no " + "pão ciabatta.",
                R.drawable.ic_veggiesandwich_america));

        pratosAmerica.add(new Prato("Burger Patriota", "Hamburger de 200" +
                " gramas " + "servido com queijo gorgonzola derretido, fatias crocantes de bacon" +
                " caramelizado " + "com mel, tomate e maionese America," + "no pão sem gergelim. " +
                " Acompanha batatas fritas rústicas ou palito e molho barbecue.",
                R.drawable.ic_sburguerpatriota_america));

        pratosAmerica.add(new Prato("Deluxe Burger", "Hamburger de 150 " +
                "gramas, " + "queijo gruyère, cogumelos frescos salteados, alface frisée e " +
                "maionese" + " trufada, " + " pão sem gergelim. Acompanha batatas fritas.",
                R.drawable.ic_deluxeburguer_america));

        pratosAmerica.add(new Prato("Pork Tacos", "Tacos recheados com " +
                "pernil " + "desfiado, temperado com barbecue, pico de galo, coalhada seca, " +
                "parmesão e " + "pimenta " + "sriracha, levemente picante. Acompanha Guacamole.",
                R.drawable.ic_porkstacos_america));

        pratosAmerica.add(new Prato("Volcano", "Delicioso sorvete de doce " +
                "de leite" + " Premium, totalmente coberto por uma casquinha de chocolate ao leite" +
                " recheada de " + "doce de leite argentino na hora de servir.",
                R.drawable.ic_volcano_america));

        pratosAmerica.add(new Prato("Milk Shake Farofino", "Milk Shake de " +
                "chocolate " + "com farofa crocante, cobertura de chocolate e creme chantilly.",
                R.drawable.ic_milkshakefarofino_america));

        //Restaurante America
        restaurantes.add(new Restaurante("America", "Av. Roque Petroni Júnior, 1089" +
                " - Morumbi", "Fecha às 23:00",
                R.drawable.ic_restaurante_america, pratosAmerica));

        //******************************************************************************************
        //Pratos do Restaurante China In Box
        List<Prato> pratosChinaBox = new ArrayList<>();

        //Pratos do restaurante China in Box
        pratosChinaBox.add(new Prato("Frango Xadrez", "Generosos cubos de " +
                "peito " + "de frango servidos com cebola, pimentão e amendoim, com molho " +
                "exclusivo à base de shoyu.",
                R.drawable.ic_frangoxadrez_chinainbox));

        pratosChinaBox.add(new Prato("Yakisoba Clássico", "Yakisoba de " +
                "carne" + " e " + "frango acompanhado por legumes frescos e champignon.",
                R.drawable.ic_yakisoba_chinainbox));

        pratosChinaBox.add(new Prato("Gyoza", "Clássica e deliciosa massa " +
                "fina" + " recheada com lombo temperado e cebolinha." +
                " Grelhado ou a vapor e " + "acompanhado com molho à base de shoyu.",
                R.drawable.ic_gyoza_chinainbox));

        pratosChinaBox.add(new Prato("Rolinho Primavera", "Massa fina " +
                "recheada com " + "carne, repolho e cenoura, acompanhada com molho agridoce.",
                R.drawable.ic_rolinhoprimavera_chinainbox));

        pratosChinaBox.add(new Prato("Salada China In Box", "Alface, " +
                "rúcula, " + "cenoura" + " desfiada, palmito pupunha e azeitonas pretas. Opções: " +
                "frango ou" + " camarões" + " fritos " + "exclusivo à base de shoyu.",
                R.drawable.ic_salada_chinainbox));

        pratosChinaBox.add(new Prato("Frango a Passarinho", "Frango " +
                "desossado e " + "frito, temperado com alho e cebolinha. Sequinho e crocante. " +
                "Opções de molho: barbecue ou agridoce.",
                R.drawable.ic_frangoapassarinho_chinainbox));

        pratosChinaBox.add(new Prato("Frango Empanado Executivo", "Cubinhos " +
                "de " + "peito" + " de frango cobertos por uma massinha, dourados e temperados com " +
                "alho e " + "cebolinha." + " Acompanhado com arroz Yakimeshi, refogado com flocos " +
                "de ovos, " + "pedacinhos de cenoura, apresuntado e cebolinha. Opções de molho: " +
                "barbecue " + "ou agridoce.",
                R.drawable.ic_frangoempanado_chinainbox));

        pratosChinaBox.add(new Prato("Camarão Empanado", "Camarão empanado " +
                "acompanhado com molho agridoce.",
                R.drawable.ic_camaraoempanado_chinainbox));

        pratosChinaBox.add(new Prato("Carne com Batata Imperial", "Combinação" +
                " de " + "fatias de carne com batatas e cebolinha com acompanhamento de molho à " +
                "base de " + "shoyu.",
                R.drawable.ic_carnebatataimperial_chinainbox));

        pratosChinaBox.add(new Prato("Banana Caramelada", "Pedaços de banana" +
                " empanados e caramelados, salpicados com gergelim.",
                R.drawable.ic_bananacaramelada_chinainbox));

        //Restaurante China In Box
        restaurantes.add(new Restaurante("China in Box", "Rua Emília " +
                "Marengo, 531 - Vila Regente Feijó", "Fecha às 23:00",
                R.drawable.ic_chinainbox_restaurante, pratosChinaBox));

        //******************************************************************************************
        //Pratos do Restaurante Outback
        List<Prato> pratosOutback = new ArrayList<>();

        //Pratos do restaurante Outback
        pratosOutback.add(new Prato("Bloomin Onion", "O autêntico sabor do " +
                "Outback!" + " Nossa tradicional cebola gigante dourada em formato de flor servida " +
                "com o molho" + "Bloom com toque levemente picante.",
                R.drawable.ic_cebola_outback));

        pratosOutback.add(new Prato("Firecracker Shrimp Nachos", "Esses " +
                "deliciosos" + " camarões empanados são temperados com nosso surpreendente molho" +
                " Firecracker" + " e servidos com saborosas tortillas crocantes.",
                R.drawable.ic_firecrackernachos_outback));

        pratosOutback.add(new Prato("Junior Ribs ", "Essa versão traz meia " +
                "costela grelhada em chama aberta e temperada com blend de especiarias.",
                R.drawable.ic_juniorribs_outback));

        pratosOutback.add(new Prato("Steakhouse Pasta", "Fettuccine " +
                "suculento com " + "champignons, tomates frescos e cortes de filet mignon, " +
                "refogado com um toque de" + " vinho Chardonnay e black pepper.",
                R.drawable.ic_steakhousepasta_outback));

        pratosOutback.add(new Prato("Ridgy Didgy Mini Burgers", "Seis" +
                " suculentos " + "mini burgers com queijo especial, ketchup, mostarda, picles e " +
                "cebola roxa." + " Tudo preparado e temperado no melhor estilo Outback. Servidos " +
                "com fritas.",
                R.drawable.ic_miniburguers_outback));

        pratosOutback.add(new Prato("Havanna Thunder", "O nosso brownie, com" +
                "nozes pecans, agora em uma versão de doce de leite Havanna. Servido com sorvete" +
                "de baunilha, chantilly, " + "crumble de biscoito e finalizado com a deliciosa" +
                " calda de doce de leite Havanna.",
                R.drawable.ic_havannathunder_outback));

        pratosOutback.add(new Prato("Lajotinha Magma Cake", "Um bolo quente " +
                "de " + "chocolate com pedaços de Lajotinha Kopenhagen e para completar sorvete de " +
                "baunilha, morango e nossa calda de caramelo. Contém nozes ou derivado de nozes.",
                R.drawable.ic_lajotinhamagma_outback));

        pratosOutback.add(new Prato("Outback Rack", "Temperada com um blend " +
                "de " + "ervas finas, a costela de cordeiro é perfeitamente preparada na chapa e" +
                " servida " + "com o delicioso molho Cabernet.",
                R.drawable.ic_rack_outback));

        pratosOutback.add(new Prato("Super Wings", "Nossas famosas " +
                "Kookaburra Wings" + " numa porção ainda maior. São 15 sobreasas de frango " +
                "servidas com o molho Blue" + " Cheese " + "e aipo crocante. Nas opções light," +
                " médio ou hot.",
                R.drawable.ic_superwings_outback));

        pratosOutback.add(new Prato("The Porterhouse", "Cerca de 500g de" +
                " um corte" + " nobre e macio em formato de T: o encontro delicioso de " +
                "contra-filet e filet " + "mignon. Preparado na chapa com um mix dos nossos " +
                "temperos secretos.",
                R.drawable.ic_porterhouse_outback));

        //Restaurante Outback
        restaurantes.add(new Restaurante("Outback", "Av. Paulista, 1230 - Bela " +
                "Vista, São Paulo", "Fecha às 23:00",
                R.drawable.ic_restaurante_outback, pratosOutback));

        //******************************************************************************************

        //Pratos do Restaurante PizzaHut
        List<Prato> pratosPizzaHut = new ArrayList<>();

        //Pratos do restaurante Pizza Hut
        pratosPizzaHut.add(new Prato("Breadsticks Recheado", "Uma cesta " +
                "com " + "exclusivos breadsticks, nos sabores: Peito de Peru com Philadelphia, " +
                "Pepperoni, " + "Lombinho com cebola.",
                R.drawable.ic_breadsticksrecheado_pizzahut));

        pratosPizzaHut.add(new Prato("Caesar Salad com Frango", "Alface " +
                "fresca, " + " ralado, peito de frango, croutons crocantes e uma opção de molho.",
                R.drawable.ic_saladacaeserfrango_pizzahut));

        pratosPizzaHut.add(new Prato("Penne Bolognese", "Massa penne com o " +
                "tradicional e saboroso molho de carne com deliciosos tomates.",
                R.drawable.ic_pennebolognese_pizzahut));

        pratosPizzaHut.add(new Prato("Brownie com Sorvete", "Maravilhoso," +
                " fofinho " + "e gostoso." + " Delicioso brownie recheado " + "com chocolate" +
                " Choc-Chip " + "e nozes picadas," + " servido com sorvete de creme e calda " +
                "quente de chocolate.",
                R.drawable.ic_browniesorvete_pizzahut));

        pratosPizzaHut.add(new Prato(" Pizza de Pepperoni", "Pizza de " +
                "mussarela " + "com " + "fatias de pepperoni (salame especial condimentado com" +
                " páprica).",
                R.drawable.ic_pizzapeperoni_pizzahut));

        pratosPizzaHut.add(new Prato("Pizza Portuguesa", "Pizza de " +
                "mussarela, " + "presunto, azeitona e cebola.",
                R.drawable.ic_pizzaportuguesa_pizzahut));

        pratosPizzaHut.add(new Prato("Petit Gateau de Chocolate", "Bolinho " +
                "de " + "chocolate macio e fofinho, recheado com chocolate cremoso e acompanhado de" +
                " uma " + "bola de sorvete de creme e cobertura de chocolate.",
                R.drawable.ic_petitgateau_pizzahut));

        pratosPizzaHut.add(new Prato("Pizza de Mussarela", "Exclusiva " +
                "mussarela do " + "Pizza Hut servida sobre molho de tomate especial.",
                R.drawable.ic_pizzamussarela_pizzahut));

        pratosPizzaHut.add(new Prato("Lasanha Bolognesa", "Lasanha com" +
                " molho " + "bolonhesa e carne selecionada e presunto. Acompanha 1/2 porção de" +
                " Garlic " + "Bread Mussarela.",
                R.drawable.ic_lasanha_pizzahut));

        pratosPizzaHut.add(new Prato("Hut Brigadeiro com Sorvete", "Pizza " +
                "com " + "recheio de brigadeiro, uma generosa bola de sorvete de creme com " +
                "cobertura de " + "chocolate.",
                R.drawable.ic_pizzabrigadeiro_pizzahut));

        //Restaurante PizzaHut
        restaurantes.add(new Restaurante("Pizza Hut", "Rua Gonçalves Crespo, 78" +
                " - São Paulo", "Fecha às 22:00",
                R.drawable.ic_restaurante_pizzahut, pratosPizzaHut));

        //******************************************************************************************
        //Pratos do Republica dos Camaroes
        List<Prato> pratosRepCamarao = new ArrayList<>();

        //Pratos do restaurante Republica dos Camaroes
        pratosRepCamarao.add(new Prato("Risoto de Camarão", "Risoto de" +
                " camarão, " + "com a " + "deliciosa combinação de azeitona verde, evilha palmito " +
                "e parmesão.",
                R.drawable.ic_risotocamarao_republicacamarao));

        pratosRepCamarao.add(new Prato("Strogonoff de Camarão", "Flambado " +
                "ao " + "conhaque, " + "com creme de leite, mostarda, catchup, champignon, com " +
                "arroz" + " branco" + " e batata palha.",
                R.drawable.ic_strogonoffcamarao_republicacamarao));

        pratosRepCamarao.add(new Prato("Camarão ao Creme de Moranga",
                "Camarão com" + " catupiry, creme de leite e sufle de moranga, com " +
                        "arroz branco.",
                R.drawable.ic_camaraonamoranga_republicacamarao));

        pratosRepCamarao.add(new Prato("Casquinha de Siri", "Preparado com " +
                "carne de " + "siri pura.",
                R.drawable.ic_casquinhadesiri_republicacamarao));

        pratosRepCamarao.add(new Prato("Bolinho de Camarão", "Deliciosos" +
                " bolinhos de " + "camarão acompanhados com limão.",
                R.drawable.ic_bolinhocamarao_republicacamarao));

        pratosRepCamarao.add(new Prato("Ostras", "Deliciosas ostras" +
                " acompanhadas com " + "gelo e limão.",
                R.drawable.ic_ostras_republicacamarao));

        pratosRepCamarao.add(new Prato("Bacalhau à Portuguesa", "Postas de" +
                " Gadus" + " Morhua, cozido no azeite com legumes e arroz branco.",
                R.drawable.ic_bacalhauportuguesa_republicacamarao));

        pratosRepCamarao.add(new Prato("Camarão Empanado", "Camarão sem " +
                "cabeça" + " empanado e frito com molho tártaro e limão.",
                R.drawable.ic_camaraoempanado_republicacamarao));

        pratosRepCamarao.add(new Prato("Tilápia Grelhada", "Filé de tilápia" +
                " grelhado " + "com legumes na manteiga, com arroz branco.",
                R.drawable.ic_tilapiagrelhada_republicacamarao));

        pratosRepCamarao.add(new Prato("Salmon a Belle Munier", "Filé " +
                "grelhado com" + " camarão, alcaparra, champignon e batata sotê na manteiga, com" +
                " arroz branco.",
                R.drawable.ic_salmongrelhado_republicacamarao));

        //Restaurante Republica dos Camaroes
        restaurantes.add(new Restaurante("República dos Camarões", "Av. Conde de" +
                " Frontim, 450" + " - Radial Leste", "Fecha às 21:00",
                R.drawable.ic_restaurante_republicacamarao, pratosRepCamarao));

        //Retorna a lista de Restaurantes
        return restaurantes;
    }

    @Override
    public void onClick(Restaurante restaurante) {

        Intent intentDetalheRestaurante = new Intent(this,
                DetalheRestauranteActivity.class);

        //Passa todos os dados do Array para outra Actitivty
        intentDetalheRestaurante.putExtra("RESTAURANTE", restaurante);

        startActivity(intentDetalheRestaurante);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu Profile; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(getApplicationContext());

        inflater.inflate(R.menu.menu_profile, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_profile) {

            //Chama a tela de Perfil
            Intent intentTelaProfile = new Intent(
                    HomeActivity.this, ProfileActivity.class);

            startActivity(intentTelaProfile);

        }
        return true;
    }

}