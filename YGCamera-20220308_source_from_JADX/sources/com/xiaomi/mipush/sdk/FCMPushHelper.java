package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;

public class FCMPushHelper {
    public static void clearToken(Context context) {
        C1586i.m2433a(context, C1582e.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        C1586i.m2437a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return C1586i.m2433a(context, C1582e.ASSEMBLE_PUSH_FCM) != null && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = C1586i.m2430a(context)) != null) {
            a.onNotificationMessageArrived(context, C1586i.m2429a(str));
        }
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = C1586i.m2430a(context)) != null) {
            a.onReceivePassThroughMessage(context, C1586i.m2429a(str));
        }
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(C1586i.m2442b(C1582e.ASSEMBLE_PUSH_FCM), "fcm", 1, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        C1586i.m2436a(context, C1582e.ASSEMBLE_PUSH_FCM, str);
    }
}
