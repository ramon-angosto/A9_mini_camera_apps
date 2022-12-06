package com.meizu.cloud.pushsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.a.b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

public class PushManager {
    static final String KEY_PUSH_ID = "pushId";
    static final String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    public static final String TAG = "3.3.170110";

    @Deprecated
    public static void register(Context context) {
        DebugLogger.initDebugLogger(context);
        String a = MzSystemUtils.a(context, "com.meizu.cloud");
        DebugLogger.i("3.3.170110", context.getPackageName() + " start register cloudVersion_name " + a);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.a(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(a) && MzSystemUtils.a(a, "4.5.7")) {
            DebugLogger.e("3.3.170110", "flyme 4.x start register cloud versionName " + a);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (TextUtils.isEmpty(a) || !a.startsWith("3")) {
            DebugLogger.e("3.3.170110", context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            DebugLogger.e("3.3.170110", "flyme 3.x start register cloud versionName " + a);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    @Deprecated
    public static void unRegister(Context context) {
        String a = MzSystemUtils.a(context, "com.meizu.cloud");
        DebugLogger.e("3.3.170110", context.getPackageName() + " start unRegister cloud versionName " + a);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.a(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(a) && MzSystemUtils.a(a, "4.5.7")) {
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (TextUtils.isEmpty(a) || !a.startsWith("3")) {
            DebugLogger.e("3.3.170110", context.getPackageName() + " start unRegister ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            intent.setAction(PushConstants.REQUEST_UNREGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    public static String getPushId(Context context) {
        return context.getSharedPreferences("com.meizu.flyme.push", 0).getString("pushId", (String) null);
    }

    public static void checkPush(Context context, String str, String str2, String str3) {
        b.a(context).c(str, str2, str3);
    }

    public static void switchPush(Context context, String str, String str2, String str3, int i, boolean z) {
        b.a(context).a(str, str2, str3, i, z);
    }

    public static void register(Context context, String str, String str2) {
        DebugLogger.initDebugLogger(context);
        b.a(context).a(str, str2);
    }

    public static void unRegister(Context context, String str, String str2) {
        b.a(context).b(str, str2);
    }

    public static void subScribeTags(Context context, String str, String str2, String str3, String str4) {
        b.a(context).a(str, str2, str3, str4);
    }

    public static void unSubScribeTags(Context context, String str, String str2, String str3, String str4) {
        b.a(context).b(str, str2, str3, str4);
    }

    public static void checkSubScribeTags(Context context, String str, String str2, String str3) {
        b.a(context).d(str, str2, str3);
    }

    public static void subScribeAlias(Context context, String str, String str2, String str3, String str4) {
        b.a(context).c(str, str2, str3, str4);
    }

    public static void unSubScribeAlias(Context context, String str, String str2, String str3, String str4) {
        b.a(context).d(str, str2, str3, str4);
    }

    public static void checkSubScribeAlias(Context context, String str, String str2, String str3) {
        b.a(context).e(str, str2, str3);
    }

    public static void checkNotificationMessage(Context context) {
        String a = MzSystemUtils.a(context, "com.meizu.cloud");
        DebugLogger.i("3.3.170110", context.getPackageName() + " checkNotificationMessage cloudVersion_name " + a);
        if (!TextUtils.isEmpty(a) && a.startsWith("6")) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
            intent.putExtra(PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }
}
