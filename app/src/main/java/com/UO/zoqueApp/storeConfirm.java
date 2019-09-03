package com.UO.zoqueApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class storeConfirm extends AppCompatActivity {
    private TextView tvtitle, tvDescription, tvCategory,tvreward;
    private ImageView img;
    String reward;
    Button botoncomprar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_confirm);

        tvtitle=findViewById(R.id.tituloCurso);
        tvDescription=findViewById(R.id.DescripcionCurso);
        tvCategory=findViewById(R.id.categoriaCurso);
        img = findViewById(R.id.courseFoto);
        tvreward = findViewById(R.id.cost);
        botoncomprar = findViewById(R.id.comprarAhora);


        Intent intent = getIntent();


        String titulo, categoria, descripcion;
        titulo= intent.getExtras().getString("titulo");
        categoria= intent.getExtras().getString("categoria");
        descripcion= intent.getExtras().getString("descripcion");
        int image = intent.getExtras().getInt("foto");
        reward = intent.getExtras().getString("reward");

        tvtitle.setText(titulo);
        tvCategory.setText(categoria);
        tvDescription.setText(descripcion);
        img.setImageResource(image);
        tvreward.setText(reward);

        botoncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                FirebaseAuth fba = FirebaseAuth.getInstance();
                DocumentReference dbU =db.collection("coins").document(fba.getCurrentUser().getUid());
                int decrement = Integer.parseInt(reward)*-1;

                dbU.update("coin Ammount", FieldValue.increment(decrement));
            }
        });


    }
}
