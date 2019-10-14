package com.UO.zoqueApp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class storeConfirm extends AppCompatActivity {
    private TextView tvtitle, tvDescription, tvCategory,tvreward;
    private ImageView img;
    String reward;
    Button botoncomprar;
    int money;
    int cost;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth fba = FirebaseAuth.getInstance();

    final DocumentReference dbU =db.collection("coins").document(fba.getCurrentUser().getUid());

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
        tvreward.setText(reward+getEmojiByUnicode(127805));

        botoncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botoncomprar.setVisibility(View.INVISIBLE);
                botoncomprar.setClickable(false);
                final String TAG="lul?";
                final DocumentReference docRef = db.collection("coins").document(fba.getCurrentUser().getUid());
                docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot snapshot,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen failed.", e);
                            return;
                        }

                        if (snapshot != null && snapshot.exists()) {
                             money = snapshot.getLong("coin Ammount").intValue();
                            cost= Integer.parseInt(reward);
                             if(money>=cost){
                                 Intent intent = new Intent (getApplicationContext(), discount.class);
                                 intent.putExtra("costo",reward);
                                 startActivity(intent);
                             }



                        } else {
                            Log.d(TAG, "Current data: null");
                        }

                    }
                });


            }
        });


    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));

    }

}
