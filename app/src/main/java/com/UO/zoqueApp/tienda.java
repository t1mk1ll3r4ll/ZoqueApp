package com.UO.zoqueApp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tienda extends AppCompatActivity {
    int coinValue=0;
    List<Course> lstCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        lstCourse = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.recyclerViewStores);

        lstCourse.add(new Course("finanzas", "categoria: Monedas", "descricion: curso sobre manejo de finanzas", R.drawable.clothesone , 30));
        lstCourse.add(new Course("networking", "categoria: relaciones", "descricion: curso sobre relaciones para el exito", R.drawable.clothestwo, 50));
        lstCourse.add(new Course("trabajo en equipo", "categoria: relaciones personales", "descricion: como trabajar en equipo", R.drawable.clothesthree, 100));

        recyclerViewAdapterStore myAdapter = new recyclerViewAdapterStore(getApplicationContext(), lstCourse);
        rv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rv.setAdapter(myAdapter);


    }
    public void CoinsAdd(View view){

        FirebaseAuth fba= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> coins = new HashMap<>();

        coins.put("coin Ammount", coinValue);
        coins.put("timestamp", FieldValue.serverTimestamp());

        db.collection("coins").document(fba.getCurrentUser().getUid()).set(coins).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
