package com.UO.zoqueApp;

import android.media.MediaPlayer;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class Numeros extends AppCompatActivity {
    ImageView rectangulo;
    TextView numero,espanol,popoluca;
    Button nxt,bck;
    int index=0;

    String numeros_espanol[] = {"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez"};
    String numeros_popoluca[] = {"Tumm","wɨsteen","tukuteen","maktasteen","mosteen","mosnatuum","monaswɨsten","mosnatukuten","mosnamaktasten","makna’"};
    String numeros[] = {"1","2","3","4","5","6","7","8","9","10"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);
        bck = findViewById(R.id.buttonBck);
        bck.setVisibility(View.INVISIBLE);
        nxt =findViewById(R.id.botonNxt);
        rectangulo = findViewById(R.id.imagenNumero);
        numero =findViewById(R.id.numerocambiar);
        espanol = findViewById(R.id.textoNumeroEspanol);
        popoluca = findViewById(R.id.textoNumeroPopoluca);


        if(index<=0){
            bck.setVisibility(View.INVISIBLE);}


        numero.setText(numeros[index]);
        espanol.setText(numeros_espanol[index]);
        popoluca.setText(numeros_popoluca[index]);
        final MediaPlayer mpone = MediaPlayer.create(this,R.raw.wipone);
        final MediaPlayer mptwo = MediaPlayer.create(this,R.raw.wiptwo);
        final MediaPlayer mpthree = MediaPlayer.create(this,R.raw.wipthree);
        final MediaPlayer mpfour = MediaPlayer.create(this,R.raw.wipfour);
        final MediaPlayer mpfive = MediaPlayer.create(this,R.raw.wipfive);



        rectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp=index+1;
                switch (temp){
                    case 1:
                        mpone.start();
                        break;
                    case 2:
                        mptwo.start();
                        break;
                    case 3:
                        mpthree.start();
                        break;
                    case 4:
                        mpfour.start();
                        break;
                    case 5:
                        mpfive.start();
                        break;
                }

            }
        });
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bck.setVisibility(View.VISIBLE);

                index++;
                numero.setText(numeros[index]);
                espanol.setText(numeros_espanol[index]);
                popoluca.setText(numeros_popoluca[index]);

                if(index==9){
                    nxt.setVisibility(View.INVISIBLE);
                }
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(nxt.getVisibility()==view.INVISIBLE){
                    nxt.setVisibility(View.VISIBLE);
                }
                if(index==0){
                    bck.setVisibility(View.INVISIBLE);
                    numero.setText(numeros[index]);
                    espanol.setText(numeros_espanol[index]);
                    popoluca.setText(numeros_popoluca[index]);
                }else{
                    numero.setText(numeros[index]);
                    espanol.setText(numeros_espanol[index]);
                    popoluca.setText(numeros_popoluca[index]);
                }



            }
        });
    }
}
