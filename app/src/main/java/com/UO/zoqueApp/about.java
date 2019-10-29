package com.UO.zoqueApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
