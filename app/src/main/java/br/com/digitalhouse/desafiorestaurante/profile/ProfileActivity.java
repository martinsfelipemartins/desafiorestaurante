package br.com.digitalhouse.desafiorestaurante.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.desafiorestaurante.R;


public class ProfileActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutPerfilNome;
    private TextInputLayout textInputLayoutPerfilEmail;
    private TextInputLayout textInputLayoutPerfilSenha;
    private TextInputLayout textInputLayoutPerfilConfSenha;
    private Button btnSalvarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iniciarViews();

        pegarPreenchimentos();

        Intent intent = getIntent();
    }

    private void iniciarViews() {

        textInputLayoutPerfilNome = findViewById(R.id.nameUserProfile);
        textInputLayoutPerfilEmail = findViewById(R.id.emailUserProfile);
        textInputLayoutPerfilSenha = findViewById(R.id.passwordUserProfile);
        textInputLayoutPerfilConfSenha = findViewById(R.id.repeatPasswordUserProfile);
        btnSalvarPerfil = findViewById(R.id.btnSaveProfile);
    }

    private void pegarPreenchimentos() {
        btnSalvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = textInputLayoutPerfilNome.getEditText().getText().toString();

                textInputLayoutPerfilNome.setError("");

                SharedPreferences preferences = getSharedPreferences(
                        "APP", MODE_PRIVATE);

                textInputLayoutPerfilNome.getEditText().setText(preferences.getString(
                        "NOME", ""));

                textInputLayoutPerfilEmail.getEditText().setText(preferences.getString(
                        "EMAIL", ""));

                textInputLayoutPerfilSenha.getEditText().setText(preferences.getString(
                        "SENHA", ""));

                textInputLayoutPerfilConfSenha.getEditText().setText(preferences.getString(
                        "SENHA", ""));

                if (nome.isEmpty()) {

                    textInputLayoutPerfilNome.setError("Informe seu nome");

                    preferences.edit().putString("NOME", nome).commit();

                    return;

                } else {
                    finish();
                }
            }
        });
    }
}