package br.com.digitalhouse.desafiorestaurante.cadastro.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.login.views.LoginActivity;

public class CadastroActivity extends AppCompatActivity {

    TextInputLayout nameUser;
    TextInputLayout emailUserCadastro;
    TextInputLayout passwordUserCadastro;
    TextInputLayout repeatPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Register");

        iniciarViewsCadastro();
        validarCadastro();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }

    public void pegarPreenchimentoCadastro() {

        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorPreferences = sharedPreferences.edit();
        editorPreferences.putString("EMAIL", emailUserCadastro.getEditText().getText().toString());
        editorPreferences.putString("SENHA", passwordUserCadastro.getEditText().getText().toString());
        editorPreferences.commit();
    }

    private void validarCadastro() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameUser.getEditText().getText().toString();
                String email = emailUserCadastro.getEditText().getText().toString();
                String senha = passwordUserCadastro.getEditText().getText().toString();
                String repeatSenha = repeatPassword.getEditText().getText().toString();


                if (name.isEmpty()) {
                    nameUser.setError("Coloque seu nome.");
                    return;
                }
                if (email.isEmpty()) {
                    emailUserCadastro.setError("Coloque seu email.");
                    return;
                }
                if (senha.isEmpty()) {
                    passwordUserCadastro.setError("Coloque a senha.");
                    return;
                }
                if (repeatSenha.isEmpty()) {
                    repeatPassword.setError("Repita sua senha.");
                    return;
                }
                if (!senha.equals(repeatSenha)) {
                    repeatPassword.setError("As senhas estão diferentes");
                }
                if (!(name.isEmpty()) && !(email.isEmpty()) && !(senha.isEmpty())
                        && !(repeatSenha.isEmpty()) && (senha.equals(repeatSenha))) {

                    pegarPreenchimentoCadastro();

                    Intent goToLogin = new Intent(CadastroActivity.this, LoginActivity.class);
                    pegarPreenchimentoCadastro();
                    startActivity(goToLogin);

                }
            }
        });
    }

    private void iniciarViewsCadastro() {
        emailUserCadastro = findViewById(R.id.emailUserCadastro);
        passwordUserCadastro = findViewById(R.id.passwordUserCadastro);
        repeatPassword = findViewById(R.id.repeatPasswordUserCadastro);
        btnRegister = findViewById(R.id.btnRegisterCadastro);
        nameUser = findViewById(R.id.nameUserCadastro);
    }
}
