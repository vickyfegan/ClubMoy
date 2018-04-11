package com.example.declan.clubmoy.Notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class Notifications extends FirebaseInstanceIdService {

    private static final String REG_TOKEN = "REG_TOKEN";
    //https://www.youtube.com/watch?v=XijS62iP1Xo
    @Override
    public void onTokenRefresh()
    {
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN, recent_token);
    }
}

