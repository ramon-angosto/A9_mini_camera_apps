package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

/* renamed from: com.huawei.secure.android.common.encrypt.utils.b */
public class C0932b {
    private static final String TAG = "SecurityComp10105302: ";

    /* renamed from: c */
    public static void m1494c(String str, String str2) {
    }

    /* renamed from: b */
    public static void m1493b(String str, String str2) {
        Log.v(m1498i(str), str2);
    }

    /* renamed from: d */
    public static void m1495d(String str, String str2) {
        Log.i(m1498i(str), str2);
    }

    /* renamed from: e */
    public static void m1496e(String str, String str2) {
        Log.w(m1498i(str), str2);
    }

    /* renamed from: f */
    public static void m1497f(String str, String str2) {
        Log.e(m1498i(str), str2);
    }

    /* renamed from: a */
    public static void m1492a(String str, String str2, Throwable th) {
        Log.e(m1498i(str), str2, th);
    }

    /* renamed from: i */
    private static String m1498i(String str) {
        return TAG + str;
    }
}
