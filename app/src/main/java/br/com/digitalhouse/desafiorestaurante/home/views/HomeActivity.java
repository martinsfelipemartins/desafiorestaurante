package br.com.digitalhouse.desafiorestaurante.home.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.adapters.views.RecyclerViewRestaurantesAdapter;
import br.com.digitalhouse.desafiorestaurante.detalhe.views.DetalheRestauranteActivity;
import br.com.digitalhouse.desafiorestaurante.interfaces.views.RecyclerViewRestauranteClickListener;
import br.com.digitalhouse.desafiorestaurante.model.views.Prato;
import br.com.digitalhouse.desafiorestaurante.model.views.Restaurante;
import br.com.digitalhouse.desafiorestaurante.profile.ProfileActivity;

public class HomeActivity extends AppCompatActivity implements RecyclerViewRestauranteClickListener {

    private RecyclerView recyclerViewRestaurante;
    private RecyclerViewRestaurantesAdapter adapterRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewRestaurante = findViewById(R.id.shapeHome);

        recyclerViewRestaurante.setLayoutManager(new LinearLayoutManager(this));

        adapterRestaurante = new RecyclerViewRestaurantesAdapter(pegarRestaurante(), this);

        recyclerViewRestaurante.setAdapter(adapterRestaurante);
    }

    private List<Restaurante> pegarRestaurante() {

        List<Restaurante> restaurantes = new ArrayList<>();

        List<Prato> pratosBeicola = new ArrayList<>();

        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));
        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));
        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));
        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));
        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));
        pratosBeicola.add(new Prato("Pastel de Queijo", "O famoso e delicioso pastel de queijo do Beiçola. ", R.drawable.pasteis));

        restaurantes.add(new Restaurante("Pastelaria do Beiçola", "Av. São Miguel, 92 - São Paulo", "Fecha às 22h", R.drawable.beicolapastel, pratosBeicola));

        List<Prato> pratosVegan = new ArrayList<>();

        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));
        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));
        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));
        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));
        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));
        pratosVegan.add(new Prato("Bowl Vegan", "Um delicioso bowl no estilo hawaiano. ", R.drawable.bowl));

        restaurantes.add(new Restaurante("Reino Vegetal", "Av. Paulista, 987 - Bela Vista", "Fecha às 23h", R.drawable.reinoveg, pratosVegan));

        List<Prato> pratosChurreria = new ArrayList<>();
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        pratosChurreria.add(new Prato("Churros de Chocolate",
                "¡Masa ligeramente crujiente y calidad chocolate!\n" +
                "Venga a probar las deliciosas churros de la señorita Florinda.", R.drawable.churroschoco));
        restaurantes.add(new Restaurante("Churreria Florinda", "Rua Gonzales, 8 - Freguesia Mexicana", "Fecha às 18h", R.drawable.churroslforinda, pratosChurreria));

        List<Prato> pratosIndianos=new ArrayList<>();
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));
        pratosIndianos.add(new Prato("Almoço Completo", "Em um ambiente pequeno, claro e decorado com peças indianas, tem uma cozinha típica bem cuidada e saborosa, com destaque para as samosas (pastéis indianos) com recheio de legumes, o pão indiano feito na hora, o carneiro ao curry e o frango tandoor (marinado em iogurte e páprica, lentamente grelhado no forno tandoor).",R.drawable.pratoscomidaindiana));

        restaurantes.add(new Restaurante("Taj Mahal", "Rua Emílio Mallet, 45 - Vila Olímpia","Fecha às 22h", R.drawable.tajmahalres,pratosIndianos));

        List<Prato> pratosMC = new ArrayList<>();
        pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));
 pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));
 pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));
 pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));
 pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));
 pratosMC.add(new Prato("MC Fritas","A batata frita mais famosa do mundo. \n" +
                "\n" +
                "Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar.",R.drawable.fritasmc));

        restaurantes.add(new Restaurante("Mc Donalds","Avenida Vergueiro, 81 - Liberdade", "Fechas às 22h ", R.drawable.mcdonaldlogo,pratosMC));

        return restaurantes;
    }

    @Override
    public void onClick(Restaurante restaurante) {

        Intent intentDetalheRestaurante = new Intent(this,
                DetalheRestauranteActivity.class);

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

            Intent intentTelaProfile = new Intent(HomeActivity.this, ProfileActivity.class);

            startActivity(intentTelaProfile);

        }
        return true;
    }

}