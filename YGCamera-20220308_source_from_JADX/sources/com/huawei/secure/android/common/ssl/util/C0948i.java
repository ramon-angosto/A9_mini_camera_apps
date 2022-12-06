package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.huawei.secure.android.common.ssl.util.i */
public class C0948i {

    /* renamed from: a */
    private static final String f1247a = "aegis";

    /* renamed from: b */
    private static SharedPreferences f1248b;

    /* renamed from: a */
    public static long m1586a(String str, long j, Context context) {
        return m1590b(context).getLong(str, j);
    }

    /* renamed from: b */
    public static synchronized SharedPreferences m1590b(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C0948i.class) {
            if (f1248b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f1248b = context.createDeviceProtectedStorageContext().getSharedPreferences(f1247a, 0);
                } else {
                    f1248b = context.getApplicationContext().getSharedPreferences(f1247a, 0);
                }
            }
            sharedPreferences = f1248b;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static int m1585a(String str, int i, Context context) {
        return m1590b(context).getInt(str, i);
    }

    /* renamed from: a */
    public static String m1587a(String str, String str2, Context context) {
        return m1590b(context).getString(str, str2);
    }

    /* renamed from: a */
    public static void m1589a(String str, Context context) {
        m1590b(context).edit().remove(str).apply();
    }

    /* renamed from: a */
    public static void m1588a(Context context) {
        m1590b(context).edit().clear().apply();
    }

    /* renamed from: b */
    public static void m1592b(String str, long j, Context context) {
        m1590b(context).edit().putLong(str, j).apply();
    }

    /* renamed from: b */
    public static void m1591b(String str, int i, Context context) {
        m1590b(context).edit().putInt(str, i).apply();
    }

    /* renamed from: b */
    public static void m1593b(String str, String str2, Context context) {
        m1590b(context).edit().putString(str, str2).apply();
    }
}
