package com.UO.zoqueApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class about extends AppCompatActivity {
    TextView versnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        versnum = findViewById(R.id.versnum);

        String versionCode = BuildConfig.VERSION_NAME;
        versnum.setText("Ver. "+versionCode);

    }
    public void quees (View view){
        Intent intent = new Intent (this, quees.class);
        startActivity(intent);
    }
    public void objetivos(View view){
        Intent intent = new Intent (this, objetivos.class);
        startActivity(intent);
    }
    public void misionvision(View view){
        Intent intent = new Intent (this, mision.class);
        startActivity(intent);
    }
}
