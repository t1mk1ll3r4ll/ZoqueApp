package com.UO.zoqueApp;

import android.content.Intent;
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
    Button nxt,bck,nxtact;
    int index=0;
    ImageView slow;

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
        slow = findViewById(R.id.slow);
        nxtact = findViewById(R.id.nextact);


        if(index<=0){
            bck.setVisibility(View.INVISIBLE);}


        numero.setText(numeros[index]);
        espanol.setText(numeros_espanol[index]);
        popoluca.setText(numeros_popoluca[index]);
        final MediaPlayer mpone = MediaPlayer.create(this,R.raw.one);
        final MediaPlayer mptwo = MediaPlayer.create(this,R.raw.two);
        final MediaPlayer mpthree = MediaPlayer.create(this,R.raw.three);
        final MediaPlayer mpfour = MediaPlayer.create(this,R.raw.four);
        final MediaPlayer mpfive = MediaPlayer.create(this,R.raw.five);
        final MediaPlayer mpsix = MediaPlayer.create(this,R.raw.six);
        final MediaPlayer mpseven = MediaPlayer.create(this,R.raw.seven);
        final MediaPlayer mpeight = MediaPlayer.create(this,R.raw.eight);
        final MediaPlayer mpnine = MediaPlayer.create(this,R.raw.nine);
        final MediaPlayer mpten = MediaPlayer.create(this,R.raw.ten);

        final MediaPlayer slowone = MediaPlayer.create(this,R.raw.ones);
        final MediaPlayer slowtwo = MediaPlayer.create(this,R.raw.twos);
        final MediaPlayer slowthree = MediaPlayer.create(this,R.raw.threes);
        final MediaPlayer slowfour = MediaPlayer.create(this,R.raw.fours);
        final MediaPlayer slowfive = MediaPlayer.create(this,R.raw.fives);
        final MediaPlayer slowsix = MediaPlayer.create(this,R.raw.sixs);
        final MediaPlayer slowseven = MediaPlayer.create(this,R.raw.sevens);
        final MediaPlayer sloweight = MediaPlayer.create(this,R.raw.eights);
        final MediaPlayer slownine = MediaPlayer.create(this,R.raw.nines);
        final MediaPlayer slowten = MediaPlayer.create(this,R.raw.tens);

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
                    case 6:
                        mpsix.start();
                        break;
                    case 7:
                        mpseven.start();
                        break;
                    case 8:
                        mpeight.start();
                        break;
                    case 9:
                        mpnine.start();
                        break;
                    case 10:
                        mpten.start();
                        break;
                }

            }
        });
        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp=index+1;
                switch (temp){
                    case 1:
                        slowone.start();
                        break;
                    case 2:
                        slowtwo.start();
                        break;
                    case 3:
                        slowthree.start();
                        break;
                    case 4:
                        slowfour.start();
                        break;
                    case 5:
                        slowfive.start();
                        break;
                    case 6:
                        slowsix.start();
                        break;
                    case 7:
                        slowseven.start();
                        break;
                    case 8:
                        sloweight.start();
                        break;
                    case 9:
                        slownine.start();
                        break;
                    case 10:
                        slowten.start();
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
                    nxtact.setVisibility(View.VISIBLE);
                }
            }
        });
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(nxt.getVisibility()==view.INVISIBLE){
                    nxt.setVisibility(View.VISIBLE);
                    nxtact.setVisibility(View.INVISIBLE);
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
        nxtact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), actividadNumeros.class);
                startActivity(intent);
            }
        });
    }
}
