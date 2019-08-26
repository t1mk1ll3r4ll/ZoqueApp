package com.UO.zoqueApp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;


public class miFirebaseInstanceIdService extends FirebaseMessagingService {

    public static final String TAG = "Noticias";
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG,"token"+token);

    }
}
