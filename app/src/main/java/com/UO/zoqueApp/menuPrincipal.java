package com.UO.zoqueApp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class menuPrincipal extends AppCompatActivity {

    List<Course> lstCourse;
    int coins;
    FirebaseAuth fba= FirebaseAuth.getInstance();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        final FloatingActionMenu floatingMenu = findViewById(R.id.fab);
        RecyclerView rv = findViewById(R.id.recyclerView);
        lstCourse = new ArrayList<>();
        reciclerViewAdapter myAdapter = new reciclerViewAdapter(this, lstCourse);

        lstCourse.add(new Course("Numeros", "Categoria: numeros", "Descrición: Los numeros del 1 al 10", R.drawable.cursouno, "10"));
        lstCourse.add(new Course("Expresiones", "Categoria: Relaciones ", "descricion: expresioens de comunicación", R.drawable.cursodos , "20"));
        lstCourse.add(new Course("trabajo en equipo", "categoria: relaciones personales", "descricion: como trabajar en equipo", R.drawable.cursotres, "30"));
        lstCourse.add(new Course("networking computadoras", "categoria: topologia de red", "descricion: curso sobre topologias", R.drawable.cursocuatro, "40"));
        lstCourse.add(new Course("training", "categoria: entrenamiento personal", "descricion: curso sobre la salud", R.drawable.cursocinco, "50"));
        lstCourse.add(new Course("traduccion", "categoria: lenguas", "descricion: curso sobre traduccion dah!", R.drawable.cursoseis, "60"));
        lstCourse.add(new Course("conversacion", "categoria: lenguas", "descricion: curso sobre conversaciones en otro idioma dah!", R.drawable.cursosiete,"70"));
        lstCourse.add(new Course("aprende a programar!", "categoria: IT", "descricion: curso basico de programacion", R.drawable.cursoocho,"80"));

        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setAdapter(myAdapter);

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy < 0) {
                    floatingMenu.showMenuButton(true);
                } else if (dy > 0) {
                    floatingMenu.hideMenuButton(true);
                }
                else if(dy==0){
                    floatingMenu.showMenuButton(true);
                }
            }
        });

        final DocumentReference docRef = db.collection("coins").document(fba.getCurrentUser().getUid());
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                if (snapshot != null && snapshot.exists()) {




                }
                else {
                    Map<String, Object> coins = new HashMap<>();

                    coins.put("coin Ammount", FieldValue.increment(0));
                    coins.put("timestamp", FieldValue.serverTimestamp());

                    db.collection("coins").document(fba.getCurrentUser().getUid()).set(coins).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
                }

            }
        });
    }

    public void maraton(View view){
        Intent intent = new Intent(this,MarathonQuestions.class);
        startActivity(intent);
    }
    public void opciones(View view){
        Intent intent = new Intent(this,opcionesUsuario.class);
        startActivity(intent);
    }
    public void tienda(View view){
        Intent intent = new Intent(this,tienda.class);
        startActivity(intent);
    }


}
