package com.UO.zoqueApp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class opcionesUsuario extends AppCompatActivity {
    Button CerrarSesion, CambioContra;
    FirebaseAuth mAuth;
    TextView tvhola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_usuario);
        CerrarSesion=findViewById(R.id.ButCierraSesion);
        CambioContra=findViewById(R.id.ButCamContra);
        tvhola=findViewById(R.id.textView16);
        mAuth=FirebaseAuth.getInstance();
        try{
            tvhola.setText("hola "+mAuth.getCurrentUser().getEmail());}
        catch(NullPointerException exception) {
            Toast.makeText(getApplicationContext(),"A ocurrido un error, lo sentimos", Toast.LENGTH_LONG).show();
        }
        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), inicioSesion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        CambioContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cambioContra.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent (getApplicationContext(), menuPrincipal.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}