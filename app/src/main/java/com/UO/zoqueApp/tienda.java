package com.UO.zoqueApp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tienda extends AppCompatActivity {
    int coinValue=0;
    TextView tvElotitos;
    List<Course> lstCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        lstCourse = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.recyclerViewStores);

        lstCourse.add(new Course("finanzas", "categoria: Monedas", "descricion: curso sobre manejo de finanzas", R.drawable.clothesone , "30"));
        lstCourse.add(new Course("networking", "categoria: relaciones", "descricion: curso sobre relaciones para el exito", R.drawable.clothestwo, "50"));
        lstCourse.add(new Course("trabajo en equipo", "categoria: relaciones personales", "descricion: como trabajar en equipo", R.drawable.clothesthree, "100"));

        recyclerViewAdapterStore myAdapter = new recyclerViewAdapterStore(tienda.this, lstCourse);
        rv.setLayoutManager(new GridLayoutManager(tienda.this, 2));
        rv.setAdapter(myAdapter);



        FirebaseAuth fba= FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        tvElotitos= findViewById(R.id.textviewelotitos);
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
                    tvElotitos.setText("cantidad de elotitos: " + snapshot.get("coin Ammount"));
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });

    }

}
