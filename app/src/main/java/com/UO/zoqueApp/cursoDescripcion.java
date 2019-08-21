package com.UO.zoqueApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cursoDescripcion extends AppCompatActivity {
    private TextView tvtitle, tvDescription, tvCategory;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_descripcion);

        tvtitle=findViewById(R.id.tituloCurso);
        tvDescription=findViewById(R.id.DescripcionCurso);
        tvCategory=findViewById(R.id.categoriaCurso);
        img = findViewById(R.id.courseFoto);



        Intent intent = getIntent();


        String titulo, categoria, descripcion;
        titulo= intent.getExtras().getString("titulo");
        categoria= intent.getExtras().getString("categoria");
        descripcion= intent.getExtras().getString("descripcion");
        int image = intent.getExtras().getInt("foto");

        tvtitle.setText(titulo);
        tvCategory.setText(categoria);
        tvDescription.setText(descripcion);
        img.setImageResource(image);

    }
}
