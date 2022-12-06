package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.a;
import com.meizu.cloud.pushsdk.b.b.f;
import com.meizu.cloud.pushsdk.b.c.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import java.util.HashMap;
import java.util.Map;

public class d {
    public static void a(Context context, String str, int i, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            a(context, context.getPackageName(), str3, str2, "3.3.170110", str, i);
        }
    }

    public static void a(Context context, Intent intent, String str, int i) {
        a(context, intent, "3.3.170110", str, i);
    }

    public static void a(Context context, Intent intent, String str, String str2, int i) {
        if (!TextUtils.isEmpty(a(intent))) {
            a(context, context.getPackageName(), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), a(intent), str, str2, i);
        }
    }

    public static String a(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        try {
            MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            if (mPushMessage != null) {
                return mPushMessage.getTaskId();
            }
            return stringExtra;
        } catch (Exception e) {
            DebugLogger.e("UxIPUtils", "paese MessageV2 error " + e.getMessage());
            return "no push platform task";
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("taskId", str3);
        hashMap.put("deviceId", str2);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", str4);
        hashMap.put("push_info", str5);
        hashMap.put("push_info_type", String.valueOf(i));
        a(context, "notification_service_message", hashMap);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, "show_push_message", str5);
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, "delete_push_message", str5);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, "receive_push_event", str5);
    }

    public static void d(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, "receive_push_event", str5);
    }

    public static void e(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, str, str2, str3, str4, "click_push_message", str5);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("taskId", str3);
        hashMap.put("deviceId", str2);
        if (TextUtils.isEmpty(str6)) {
            str6 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        hashMap.put("timestamp", str6);
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", "3.3.170110");
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("seq_id", str4);
        }
        a(context, str5, hashMap);
    }

    public static void a(Context context, String str, Map<String, String> map) {
        DebugLogger.e("UxIPUtils", "onLogEvent eventName [" + str + "] properties = " + map);
        if (!"notification_service_message".equals(str)) {
            a.a(context, (f) null).a(((b.a) b.d().a(str).a(Long.valueOf(map.get("timestamp")).longValue())).c(map.get("deviceId")).e(map.get("package_name")).d(map.get("pushsdk_version")).b(map.get("taskId")).f(TextUtils.isEmpty(map.get("seq_id")) ? "null" : map.get("seq_id")).g(String.valueOf(c.g(context, map.get("package_name")))).b());
        }
    }
}
