package br.com.digitalhouse.desafiorestaurante.detalhe.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.adapters.views.RecyclerViewPratosAdapter;
import br.com.digitalhouse.desafiorestaurante.home.views.HomeActivity;
import br.com.digitalhouse.desafiorestaurante.interfaces.views.RecyclerViewPratoClickListener;
import br.com.digitalhouse.desafiorestaurante.model.views.Prato;
import br.com.digitalhouse.desafiorestaurante.model.views.Restaurante;


public class DetalheRestauranteActivity extends AppCompatActivity implements RecyclerViewPratoClickListener {

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

        iniciarViews();

        recyclerViewPratos = findViewById(R.id.recyclerviewPratos);

        if (getIntent() != null && getIntent().getExtras() != null) {
            restaurante = getIntent().getParcelableExtra("RESTAURANTE");

            if (restaurante != null) {

                imageViewFotoDetalheRestaurante.setImageResource(restaurante.getFotoRestaurante());
                textViewDetalheNomeRestaurante.setText(restaurante.getNome());

            }
        }

        recyclerViewPratos.setLayoutManager(new GridLayoutManager(this, 2));

        adapterPratos = new RecyclerViewPratosAdapter(getPrato(), this);

        recyclerViewPratos.setAdapter(adapterPratos);

        chamaListarRestaurantes();
    }

    private void iniciarViews() {

        imageViewFotoDetalheRestaurante = findViewById(R.id.imageDetalheRestaurante);
        imageViewBackDetalheRestaurante = findViewById(R.id.imageBackDetalheRestaurante);
        textViewDetalheNomeRestaurante = findViewById(R.id.textViewDetalheNomeRestaurante);
    }

    private List<Prato> getPrato() {

        List<Prato> pratos = new ArrayList<>();

        for (Prato registroPrato : restaurante.getPratosCardapio()) {

            pratos.add(registroPrato);
        }

        return pratos;
    }

    @Override
    public void onClick(Prato prato) {

        Intent intentDetalhePrato = new Intent(this, DetalhePratoActivity.class);

        intentDetalhePrato.putExtra("PRATO", prato);

        startActivity(intentDetalhePrato);

    }

    private void chamaListarRestaurantes() {

        imageViewBackDetalheRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentListaRestaurantes = new Intent(
                        DetalheRestauranteActivity.this, HomeActivity.class);

                startActivity(intentListaRestaurantes);
            }
        });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
