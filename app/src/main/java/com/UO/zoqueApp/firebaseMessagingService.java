package com.UO.zoqueApp;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class firebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String from = remoteMessage.getFrom();

        Log.d(TAG,"Mensaje recivido de..." +from);

        if(remoteMessage.getNotification() != null){
            Log.d(TAG,"notificacion:"+remoteMessage.getNotification().getBody());
        }
    }
}
