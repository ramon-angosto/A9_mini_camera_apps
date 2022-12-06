package com.shix.fcmpush1;

import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.HashMap;

public class FcmPush {
    private static final String TAG = "FCM";
    /* access modifiers changed from: private */
    public static String authorizedEntity = "";
    public static Context context;

    public static void init(Context context2) {
        HashMap<String, String> resolve = ResolveJson.resolve(context2);
        if (context2 != null || !resolve.isEmpty()) {
            context = context2;
            authorizedEntity = resolve.get("ProjectId");
            FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
            builder.setApiKey(resolve.get("ApiKey"));
            builder.setApplicationId(resolve.get("ApplicationId"));
            builder.setDatabaseUrl(resolve.get("DatabaseUrl"));
            builder.setGcmSenderId(resolve.get("GcmSenderId"));
            FirebaseApp.initializeApp(context2, builder.build());
            Log.d("FCM", "FirebaseAPP初始化完");
        }
    }

    public static void unRegister() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    FirebaseApp.getInstance();
                    FirebaseInstanceId.getInstance().deleteInstanceId();
                    FirebaseInstanceId.getInstance().deleteToken(FcmPush.authorizedEntity, "GCM");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("FCM", "FirebaseAPP结束异常");
                }
            }
        }).start();
    }

    public static String getToken() {
        String token = FirebaseInstanceId.getInstance().getToken();
        return token == null ? "" : token;
    }
}
