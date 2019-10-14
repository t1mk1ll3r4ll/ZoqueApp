package com.UO.zoqueApp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class discount extends AppCompatActivity {

    int costo =0;
    String CostoIntent;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth fba = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        Intent intent = getIntent();
         CostoIntent= intent.getExtras().getString("costo");
         costo= Integer.parseInt(CostoIntent);


        final DocumentReference docRef = db.collection("coins").document(fba.getCurrentUser().getUid());
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    decrement();
                }

                   // Toast.makeText(getApplicationContext(),snapshot.get("coin Ammount")+getEmojiByUnicode(127805)+" restantes",Toast.LENGTH_LONG).show();
                 else {
                    Toast.makeText(getApplicationContext(),"costo del intent: "+CostoIntent+" /n variable costo:"+costo,Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));

    }
    public void decrement (){
        final DocumentReference docRef = db.collection("coins").document(fba.getCurrentUser().getUid());


        Map<String,Object> updates = new HashMap<>();
        updates.put("coin Ammount", FieldValue.increment(-costo));
        updates.put("timestamp", FieldValue.serverTimestamp());
        try{
        docRef.update(updates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(discount.this, "gastaste:"+costo+getEmojiByUnicode(127805), Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
        }
        catch(Exception e){
            Toast.makeText(this, "NANI??????????", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
