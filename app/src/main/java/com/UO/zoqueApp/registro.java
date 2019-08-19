package com.UO.zoqueApp;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registro extends AppCompatActivity {

    EditText CorreoReg;
    EditText ContraReg;
    Button RegBut, inicbut;
    FirebaseAuth mAuth;
    ProgressBar barra;
    ImageView viewpass, hidepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro); CorreoReg = findViewById(R.id.CorreoRegistro);
        ContraReg=findViewById(R.id.ContraRegistro);
        RegBut = findViewById(R.id.RegButton);
        mAuth = FirebaseAuth.getInstance();
        barra = findViewById(R.id.progressBar2);
        barra.setVisibility(View.INVISIBLE);
        viewpass=findViewById(R.id.ViewPass);
        hidepass=findViewById(R.id.HidePass);
        hidepass.setVisibility(View.INVISIBLE);
        RegBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barra.setVisibility(View.VISIBLE);
                RegBut.setVisibility(View.INVISIBLE);
                Registrar();
            }
        });
        inicbut = findViewById(R.id.botonIniciar);
        inicbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), inicioSesion.class);
                startActivity(intent);
                finish();
            }
        });
        viewpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContraReg.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                viewpass.setVisibility(View.INVISIBLE);
                hidepass.setVisibility(View.VISIBLE);
                ContraReg.setSelection(ContraReg.length());
            }
        });
        hidepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContraReg.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                viewpass.setVisibility(View.VISIBLE);
                hidepass.setVisibility(View.INVISIBLE);
                ContraReg.setSelection(ContraReg.length());

            }
        });

    }

    public void Registrar() {
        final String email = CorreoReg.getText().toString();
        final String pass = ContraReg.getText().toString();
        if (email.isEmpty()) {
            CorreoReg.setError("Ingrese un correo");
            RegBut.setVisibility(View.VISIBLE);
            barra.setVisibility(View.INVISIBLE);


        }else if (pass.isEmpty()) {
            ContraReg.setError("Ingrese una contraseña");
            RegBut.setVisibility(View.VISIBLE);
            barra.setVisibility(View.INVISIBLE);
        }else if(pass.contains(" ")){
            ContraReg.setError("la contraseña no debe contener espacios, intenta de nuevo");
            RegBut.setVisibility(View.VISIBLE);
            barra.setVisibility(View.INVISIBLE);
        }else if(!email.contains("@")) {
            CorreoReg.setError("El correo debe contener '@'");
            RegBut.setVisibility(View.VISIBLE);
            barra.setVisibility(View.INVISIBLE);

        }else if((pass.length())<6){
            ContraReg.setError("la contraseña debe ser mayor a 6 caracteres");
            RegBut.setVisibility(View.VISIBLE);
            barra.setVisibility(View.INVISIBLE);
        }else
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Registro completado", Toast.LENGTH_SHORT).show();
                        barra.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(getApplicationContext(), Verificacion.class);
                        startActivity(intent);
                        finish();
                    } else {
                        barra.setVisibility(View.INVISIBLE);
                        RegBut.setVisibility(View.VISIBLE);
                        CorreoReg.setError("El correo ya se encuentra registrado, Intenta iniciar sesión");
                        ContraReg.setError("O intenta recuperar tu contraseña");
                    }
                }
            });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), splashScreen.class);
        startActivity(intent);
        finish();
    }
}