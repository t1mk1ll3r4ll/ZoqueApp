package com.UO.zoqueApp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class correctasNumeros extends AppCompatActivity {
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correctas_numeros);

        resultado=findViewById(R.id.resultados);
        int score = getIntent().getExtras().getInt("score");
        resultado.setText("Puntuale \n"+valueOf(score)+"/10");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(correctasNumeros.this, menuPrincipal.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

    }
}
