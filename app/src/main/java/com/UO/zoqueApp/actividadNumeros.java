package com.UO.zoqueApp;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class actividadNumeros extends AppCompatActivity {
            String numerocorrecto[] = {"6","1","2","7","3","8","5","10","9","4"};
            String numerosincorrectos[]={"1","9","3","5","7","6","4","8","10","2"};
            String numerocorrectoletra[]={"mosnatuum","tuum","wɨsteen","monaswɨsten","tukuteen","mosnatukuten","mosteen","makna’","mosnamaktasten","maktasteen"};
            int correctas=0;
            int index=0;
            ImageView correctoImg,IncorrectoImg;
            Button correcto,incorrecto;
            TextView Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_numeros);
        correcto = findViewById(R.id.respuesta1);
        incorrecto = findViewById(R.id.respuesat2);
        Nombre = findViewById(R.id.textView8);
        correctoImg=findViewById(R.id.correcto);
        IncorrectoImg=findViewById(R.id.incorrecto);

        correcto.setText(numerocorrecto[index]);
        incorrecto.setText(numerosincorrectos[index]);
        Nombre.setText(numerocorrectoletra[index]);


    }

    public void incorrecto(View view) {

        correcto.setVisibility(View.INVISIBLE);
        incorrecto.setVisibility(View.INVISIBLE);
        Nombre.setVisibility(View.INVISIBLE);
        IncorrectoImg.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                correcto.setVisibility(View.VISIBLE);
                incorrecto.setVisibility(View.VISIBLE);
                Nombre.setVisibility(View.VISIBLE);
                IncorrectoImg.setVisibility(View.INVISIBLE);
            }
        }, 1000);
        index++;
        correcto.setText(numerocorrecto[index]);
        incorrecto.setText(numerosincorrectos[index]);
        Nombre.setText(numerocorrectoletra[index]);


    }
    public void correcto (View view){
        correcto.setVisibility(View.INVISIBLE);
        incorrecto.setVisibility(View.INVISIBLE);
        Nombre.setVisibility(View.INVISIBLE);
        correctoImg.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                correcto.setVisibility(View.VISIBLE);
                incorrecto.setVisibility(View.VISIBLE);
                Nombre.setVisibility(View.VISIBLE);
                correctoImg.setVisibility(View.INVISIBLE);
            }
        }, 1000);

        index++;
        correctas++;
        correcto.setText(numerocorrecto[index]);
        incorrecto.setText(numerosincorrectos[index]);
        Nombre.setText(numerocorrectoletra[index]);
    }

}
