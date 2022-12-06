package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzf;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.regex.Pattern;

public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final Pattern zzbSX = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static FirebaseMessaging zzbSY;
    private final FirebaseInstanceId zzbSB;
    private PendingIntent zzbSZ;

    private FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        this.zzbSB = firebaseInstanceId;
    }

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            if (zzbSY == null) {
                zzbSY = new FirebaseMessaging(FirebaseInstanceId.getInstance());
            }
            firebaseMessaging = zzbSY;
        }
        return firebaseMessaging;
    }

    private synchronized void zzk(Context context, Intent intent) {
        if (this.zzbSZ == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzbSZ = PendingIntent.getBroadcast(context, 0, intent2, 0);
        }
        intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, this.zzbSZ);
    }

    public void send(RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            zzk(applicationContext, intent);
            intent.setPackage(zzf.zzaX(applicationContext));
            remoteMessage.zzF(intent);
            applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void subscribeToTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str = str.substring(8);
        }
        if (str == null || !zzbSX.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 55 + "[a-zA-Z0-9-_.~%]{1,900}".length());
            sb.append("Invalid topic name: ");
            sb.append(str);
            sb.append(" does not match the allowed format ");
            sb.append("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(sb.toString());
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        String valueOf = String.valueOf(str);
        instance.zziy(valueOf.length() != 0 ? "S!".concat(valueOf) : new String("S!"));
    }

    public void unsubscribeFromTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
            str = str.substring(8);
        }
        if (str == null || !zzbSX.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 55 + "[a-zA-Z0-9-_.~%]{1,900}".length());
            sb.append("Invalid topic name: ");
            sb.append(str);
            sb.append(" does not match the allowed format ");
            sb.append("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(sb.toString());
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        String valueOf = String.valueOf(str);
        instance.zziy(valueOf.length() != 0 ? "U!".concat(valueOf) : new String("U!"));
    }
}
