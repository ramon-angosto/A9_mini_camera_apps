package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;

public class c {
    private static SharedPreferences h(Context context, String str) {
        return context.getSharedPreferences(str, 4);
    }

    public static void a(Context context, String str, String str2, String str3) {
        h(context, str).edit().putString(str2, str3).commit();
    }

    public static String a(Context context, String str, String str2) {
        return h(context, str).getString(str2, (String) null);
    }

    public static void a(Context context, String str, String str2, int i) {
        h(context, str).edit().putInt(str2, i).commit();
    }

    public static int b(Context context, String str, String str2) {
        return h(context, str).getInt(str2, 0);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        h(context, str).edit().putBoolean(str2, z).commit();
    }

    public static boolean c(Context context, String str, String str2) {
        return h(context, str).getBoolean(str2, true);
    }

    public static String a(Context context) {
        return a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, PushConstants.KEY_PUSH_ID);
    }

    public static void a(Context context, String str) {
        a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, PushConstants.KEY_PUSH_ID, str);
    }

    public static void a(Context context, int i) {
        a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, PushConstants.KEY_PUSH_ID_EXPIRE_TIME, i);
    }

    public static int b(Context context) {
        return b(context, PushConstants.PUSH_ID_PREFERENCE_NAME, PushConstants.KEY_PUSH_ID_EXPIRE_TIME);
    }

    public static String c(Context context) {
        return h(context, "mz_push_preference").getString(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, (String) null);
    }

    public static void b(Context context, String str) {
        a(context, "mz_push_preference", PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, str);
    }

    public static void a(Context context, String str, int i) {
        a(context, "mz_push_preference", str + ".notification_id", i);
    }

    public static int c(Context context, String str) {
        SharedPreferences h = h(context, "mz_push_preference");
        return h.getInt(str + ".notification_id", 0);
    }

    public static void b(Context context, String str, int i) {
        a(context, "mz_push_preference", str + ".notification_push_task_id", i);
    }

    public static int d(Context context, String str) {
        SharedPreferences h = h(context, "mz_push_preference");
        return h.getInt(str + ".notification_push_task_id", 0);
    }

    public static void a(Context context, String str, boolean z) {
        a(context, "mz_push_preference", "switch_notification_message_" + str, z);
    }

    public static boolean e(Context context, String str) {
        return c(context, "mz_push_preference", "switch_notification_message_" + str);
    }

    public static void b(Context context, String str, boolean z) {
        a(context, "mz_push_preference", "switch_through_message_" + str, z);
    }

    public static boolean f(Context context, String str) {
        return c(context, "mz_push_preference", "switch_through_message_" + str);
    }

    public static void c(Context context, String str, int i) {
        a(context, "mz_push_preference", str + ".message_seq", i);
    }

    public static int g(Context context, String str) {
        int b = b(context, "mz_push_preference", str + ".message_seq") + 1;
        c(context, str, b);
        DebugLogger.e("mz_push_preference", "current messageSeq " + b);
        return b;
    }
}
