package com.UO.zoqueApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class storeConfirm extends AppCompatActivity {
    private TextView tvtitle, tvDescription, tvCategory,tvreward;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_confirm);

        tvtitle=findViewById(R.id.tituloCurso);
        tvDescription=findViewById(R.id.DescripcionCurso);
        tvCategory=findViewById(R.id.categoriaCurso);
        img = findViewById(R.id.courseFoto);
        tvreward = findViewById(R.id.cost);



        Intent intent = getIntent();


        String titulo, categoria, descripcion;
        titulo= intent.getExtras().getString("titulo");
        categoria= intent.getExtras().getString("categoria");
        descripcion= intent.getExtras().getString("descripcion");
        int image = intent.getExtras().getInt("foto");
        String reward = intent.getExtras().getString("reward");

        tvtitle.setText(titulo);
        tvCategory.setText(categoria);
        tvDescription.setText(descripcion);
        img.setImageResource(image);
        tvreward.setText(reward);

    }
}
