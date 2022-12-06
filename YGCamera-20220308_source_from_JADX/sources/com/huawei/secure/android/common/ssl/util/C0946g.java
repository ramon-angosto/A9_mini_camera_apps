package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

/* renamed from: com.huawei.secure.android.common.ssl.util.g */
public class C0946g {

    /* renamed from: a */
    private static final String f1245a = "SecurityComp10105306: ";

    /* renamed from: a */
    public static void m1577a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m1578a(String str, String str2, Throwable th) {
        Log.e(m1576a(str), str2, th);
    }

    /* renamed from: b */
    public static void m1579b(String str, String str2) {
        Log.e(m1576a(str), str2);
    }

    /* renamed from: c */
    public static void m1580c(String str, String str2) {
        Log.i(m1576a(str), str2);
    }

    /* renamed from: d */
    public static void m1581d(String str, String str2) {
        Log.v(m1576a(str), str2);
    }

    /* renamed from: e */
    public static void m1582e(String str, String str2) {
        Log.w(m1576a(str), str2);
    }

    /* renamed from: a */
    private static String m1576a(String str) {
        return f1245a + str;
    }
}
