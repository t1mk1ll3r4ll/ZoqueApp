package com.UO.zoqueApp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sabiasque extends AppCompatActivity {
    TextView sabiasque;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabiasque);
        String dyk[]={"La lengua popoluca de la sierra es hablada en el sureste del estado de Veracruz\n" +
                "por  las comunidades de San Pedro Soteapan.","El Popoluca de la sierra también es conocido como Soteapaneco.","Las comunidades que hablan popoluca tienen el español como segunda lengua.","En su lengua original “Popoluca” es nombrada como nuntajɨɨyi.","El popoluca de la sierra  pertenece a la familia Mixe-zoqueana.","Según la CDI, en el 2015 había cerca de 44,500 popolucas de la sierra.", "Para la cultura popoluca Jomxuk es el dios del maíz.","Existen por lo menos 25 pueblos que hablan popoluca de la sierra.","En el estado de Puebla hay una lengua que se llama “Popoloca” pero no tiene\n" +
                "ninguna relación con la lengua “Popoluca”","El nombre “popoluca” se emplea para designar 4 lenguas habladas en Veracruz:\n" +
                "Popoluca de Oluta, popoluca de Sayula, popoluca de Tetixtepec y popoluca de la\n" +
                "sierra, siendo está ultima la que estamos estudiando.","El popoluca de la sierra no es una lengua que esté en riesgo de desaparición,\n" +
                "hablando por el número de personas que aún hablan esta lengua."};
        sabiasque = findViewById(R.id.sabias_que_text);
        double x = (Math.random()*((11-0)+1))+0;

        int index=(int)x;

        sabiasque.setText(dyk[index]);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), menuPrincipal.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }


}
