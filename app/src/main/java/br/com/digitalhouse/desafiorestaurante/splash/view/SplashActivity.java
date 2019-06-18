package br.com.digitalhouse.desafiorestaurante.splash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.desafiorestaurante.R;
import br.com.digitalhouse.desafiorestaurante.login.views.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageSplash;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageSplash = findViewById(R.id.imageSplash);
        imageSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump();


            }
        });
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();

            }
        }, 3000);
    }

    private void jump() {
        timer.cancel();
        Intent goToOtherWindow = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(goToOtherWindow);
        finish();
    }
}
