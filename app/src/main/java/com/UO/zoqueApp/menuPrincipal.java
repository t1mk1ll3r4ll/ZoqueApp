package com.UO.zoqueApp;

import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;



public class menuPrincipal extends AppCompatActivity {

    List<Course> lstCourse;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        final FloatingActionMenu floatingMenu = findViewById(R.id.fab);
        RecyclerView rv = findViewById(R.id.recyclerView);
        lstCourse = new ArrayList<>();
        reciclerViewAdapter myAdapter = new reciclerViewAdapter(this, lstCourse);


        lstCourse.add(new Course("finanzas", "categoria: Monedas", "descricion: curso sobre manejo de finanzas", R.drawable.cursouno));
        lstCourse.add(new Course("networking", "categoria: relaciones", "descricion: curso sobre relaciones para el exito", R.drawable.cursodos));
        lstCourse.add(new Course("trabajo en equipo", "categoria: relaciones personales", "descricion: como trabajar en equipo", R.drawable.cursotres));
        lstCourse.add(new Course("networking computadoras", "categoria: topologia de red", "descricion: curso sobre topologias", R.drawable.cursocuatro));
        lstCourse.add(new Course("training", "categoria: entrenamiento personal", "descricion: curso sobre la salud", R.drawable.cursocinco));
        lstCourse.add(new Course("traduccion", "categoria: lenguas", "descricion: curso sobre traduccion dah!", R.drawable.cursoseis));
        lstCourse.add(new Course("conversacion", "categoria: lenguas", "descricion: curso sobre conversaciones en otro idioma dah!", R.drawable.cursosiete));
        lstCourse.add(new Course("aprende a programar!", "categoria: IT", "descricion: curso basico de programacion", R.drawable.cursoocho));


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
            }
        });
    }

    public void maraton(View view){
        Intent intent = new Intent(this,maraton.class);
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
