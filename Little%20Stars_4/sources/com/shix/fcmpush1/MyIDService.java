package com.shix.fcmpush1;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FCM";

    private void sendRegistrationToServer(String str) {
    }

    public void onCreate() {
        super.onCreate();
        Log.d("FCM", "Token注册服务已经");
    }

    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM", "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }
}
