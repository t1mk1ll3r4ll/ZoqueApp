package com.UO.zoqueApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class cursoDescripcion extends AppCompatActivity {
    private TextView tvtitle, tvDescription, tvCategory,tvreward;
    private ImageView img;
    FirebaseAuth fba= FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_descripcion);

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
        final String reward = intent.getExtras().getString("reward");

        tvtitle.setText(titulo);
        tvCategory.setText(categoria);
        tvDescription.setText(descripcion);
        img.setImageResource(image);
        tvreward.setText(reward+getEmojiByUnicode(127805));


        Button btnCurso = findViewById(R.id.botonIrACurso);

        btnCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DocumentReference dbU =db.collection("coins").document(fba.getCurrentUser().getUid());
                dbU.update("coin Ammount", FieldValue.increment(Integer.parseInt(reward)));
                dbU.update("timestamp", FieldValue.serverTimestamp());


//                Map<String, Object> coins = new HashMap<>();
//
//                    //coins.put("coin Ammount", FieldValue.increment(+coinValue));
//                    coins.put("timestamp", FieldValue.serverTimestamp());
//
//                    db.collection("coins").document(fba.getCurrentUser().getUid()).set(coins).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
//                             }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
//                        }
//                    });
            }
        });


    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
