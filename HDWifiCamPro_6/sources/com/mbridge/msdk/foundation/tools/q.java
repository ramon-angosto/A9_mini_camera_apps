package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: SameLogTool */
public final class q {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;

    static {
        if (!MBridgeConstans.DEBUG) {
        }
    }

    public static void a(String str, String str2) {
        if (b) {
            Log.d(a(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (c) {
            Log.i(a(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (d) {
            Log.w(a(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (e && str2 != null) {
            Log.e(a(str), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (e && str2 != null && th != null) {
            Log.e(a(str), str2, th);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }
}
