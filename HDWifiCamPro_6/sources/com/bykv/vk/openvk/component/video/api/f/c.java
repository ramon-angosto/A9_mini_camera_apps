package com.bykv.vk.openvk.component.video.api.f;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: VLogger */
public class c {
    private static boolean a = false;
    private static int b = 4;
    private static String c = "";

    public static void a(String str) {
        c = str;
    }

    public static void a(int i) {
        b = i;
    }

    public static void a() {
        a = true;
        a(3);
    }

    public static void b() {
        a = false;
        a(7);
    }

    public static boolean c() {
        return a;
    }

    public static void a(String str, String str2) {
        if (a && str2 != null && b <= 3) {
            Log.d(c(str), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && b <= 3) {
                Log.d(c(str), str2, th);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (a && objArr != null && b <= 3) {
            Log.v(c(str), a(objArr));
        }
    }

    public static void b(String str) {
        if (a) {
            b("Logger", str);
        }
    }

    public static void b(String str, String str2) {
        if (a && str2 != null && b <= 4) {
            Log.i(c(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && b <= 4) {
                Log.i(c(str), str2, th);
            }
        }
    }

    public static void b(String str, Object... objArr) {
        if (a && objArr != null && b <= 4) {
            Log.v(c(str), a(objArr));
        }
    }

    public static void c(String str, String str2) {
        if (a && str2 != null && b <= 6) {
            Log.e(c(str), str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (a) {
            if (!(str2 == null && th == null) && b <= 6) {
                Log.e(c(str), str2, th);
            }
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(c)) {
            return str;
        }
        return a("[" + c + "]-[" + str + "]");
    }
}
