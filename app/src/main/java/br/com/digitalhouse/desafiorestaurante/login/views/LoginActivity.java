package br.com.digitalhouse.desafiorestaurante.login.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.cadastro.views.CadastroActivity;
import br.com.digitalhouse.desafiorestaurante.home.views.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout emailUser;
    TextInputLayout passwordUser;
    CheckBox rememberMeCheckBox;
    Button btnLogIn;
    Button btnLoginFacebook;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iniciarViewsLogin();
        pegarPreenchimentoCadastro();
        validarELogar();
        goToRegister();
    }

    private void validarELogar() {

        btnLogIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String senha = passwordUser.getEditText().getText().toString();
                String email = emailUser.getEditText().getText().toString();

                if (email.isEmpty()) {
                    emailUser.setError("Coloque o email");
                    return;
                }
                if (senha.isEmpty()) {
                    passwordUser.setError("Coloque a senha");
                    return;
                }
                if (!(senha.isEmpty()) && !(email.isEmpty())) {

                    if (rememberMeCheckBox.isChecked()) {

                        SharedPreferences preferences = getSharedPreferences(
                                "APP", MODE_PRIVATE);

                        emailUser.getEditText().setText(preferences.getString(
                                "EMAIL", ""));

                        passwordUser.getEditText().setText(preferences.getString(
                                "SENHA", ""));

                        Intent goToHome = new Intent(
                                LoginActivity.this, HomeActivity.class);

                        startActivity(goToHome);
                    }
                }
            }
        });
    }

    private void iniciarViewsLogin() {
        emailUser = findViewById(R.id.emailUserLogin);
        passwordUser = findViewById(R.id.passwordUserLogin);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);
        btnLogIn = findViewById(R.id.btnLogIn);
        btnLoginFacebook = findViewById(R.id.btnFacebookLogin);
        btnRegister = findViewById(R.id.btnRegisterLogin);
    }

    public void pegarPreenchimentoCadastro() {
        SharedPreferences preferences = getSharedPreferences("LOGIN", CadastroActivity.MODE_PRIVATE);
        String email = emailUser.getEditText().getText().toString();
        String senha = passwordUser.getEditText().getText().toString();
        emailUser.getEditText().setText(preferences.getString("EMAIL", ""));
        passwordUser.getEditText().setText(preferences.getString("SENHA", ""));
    }
    public void goToRegister(){

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goCadastro= new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(goCadastro);
            }
        });
    }
}
