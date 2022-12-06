package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MessageV4;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.a;
import com.meizu.cloud.pushsdk.util.b;
import java.io.File;

public class d extends c {
    public d(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* access modifiers changed from: protected */
    public void a(Notification.Builder builder, MessageV3 messageV3) {
        if (b.a()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.setSummaryText(messageV3.getContent());
            bigTextStyle.bigText(messageV3.getmNotificationStyle().getExpandableText());
            builder.setStyle(bigTextStyle);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Notification notification, MessageV3 messageV3) {
        super.a(notification, messageV3);
        MessageV4 parse = MessageV4.parse(messageV3);
        if (parse.getActVideoSetting() == null || (parse.getActVideoSetting().isWifiDisplay() && !a.b(this.a))) {
            DebugLogger.e("AbstractPushNotification", "only wifi can download act");
            return;
        }
        final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdkAct/" + messageV3.getUploadDataPackageName();
        String valueOf = String.valueOf(System.currentTimeMillis());
        String actUrl = parse.getActVideoSetting().getActUrl();
        if (!TextUtils.isEmpty(actUrl) && com.meizu.cloud.pushsdk.a.a.a(actUrl, str, valueOf).a().b().b()) {
            DebugLogger.i("AbstractPushNotification", "down load " + actUrl + " success");
            String str2 = str + File.separator + "ACT-" + valueOf;
            boolean a = new com.meizu.cloud.pushsdk.notification.b.d(str + File.separator + valueOf, str2).a();
            StringBuilder sb = new StringBuilder();
            sb.append("zip file ");
            sb.append(a);
            DebugLogger.i("AbstractPushNotification", sb.toString());
            if (a) {
                Bundle bundle = new Bundle();
                bundle.putString("path", str2);
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("big", bundle);
                if (b.c()) {
                    notification.extras.putBundle("flyme.active", bundle2);
                }
            }
        }
        com.meizu.cloud.pushsdk.b.b.a.b.a((Runnable) new Runnable() {
            public void run() {
                for (File file : com.meizu.cloud.pushsdk.notification.b.a.b(str, String.valueOf(System.currentTimeMillis() - 86400000))) {
                    com.meizu.cloud.pushsdk.notification.b.a.b(file.getPath());
                    DebugLogger.i("AbstractPushNotification", "Delete file directory " + file.getName() + "\n");
                }
            }
        });
    }
}
