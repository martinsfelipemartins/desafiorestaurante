package br.com.digitalhouse.desafiorestaurante.detalhe.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.model.views.Prato;

public class DetalhePratoActivity extends AppCompatActivity {

    //Declaração de atributos
    private ImageView imageViewFotoDetalhePrato;
    private ImageView imageViewBackDetalhePrato;
    private TextView textViewDetalheNomePrato;
    private TextView textViewDetalheDescricaoPrato;
    private Prato prato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);

        //Inicialização das Views
        initViews();

        //Valido se veio alguma coisa na intent
        if (getIntent() != null && getIntent().getExtras() != null) {
            prato = getIntent().getParcelableExtra("PRATO");

            if (prato != null) {

                imageViewFotoDetalhePrato.setImageResource(prato.getFotoPrato());
                textViewDetalheNomePrato.setText(prato.getNomePrato());
                textViewDetalheDescricaoPrato.setText(prato.getDescricaoPrato());
            }
        }

        mostrarPratos();
    }

    private void initViews() {

        imageViewFotoDetalhePrato = findViewById(R.id.imageDetalhePrato);
        imageViewBackDetalhePrato = findViewById(R.id.imageBackDetalhePrato);
        textViewDetalheNomePrato = findViewById(R.id.textViewDetalheNomePrato);
        textViewDetalheDescricaoPrato = findViewById(R.id.textViewDetalheDescricaoPrato);
    }

    private void mostrarPratos() {

        imageViewBackDetalhePrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }
}
