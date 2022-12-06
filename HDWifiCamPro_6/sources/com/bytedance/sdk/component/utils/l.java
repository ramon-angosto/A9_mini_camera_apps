package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.a;

/* compiled from: Logger */
public class l {
    private static boolean a = false;
    private static int b = 4;
    private static a c = null;
    private static String d = "";

    public static void a(String str) {
        d = str;
    }

    public static void a(int i) {
        b = i;
    }

    public static boolean a() {
        return b <= 3;
    }

    public static void b() {
        a = true;
        a(3);
    }

    public static void c() {
        a = false;
        a(7);
    }

    public static boolean d() {
        return a;
    }

    public static void a(String str, String str2) {
        a aVar = c;
        if (aVar != null) {
            aVar.a(e(str), str2);
        }
        if (a && str2 != null && b <= 2) {
            Log.v(e(str), str2);
        }
    }

    public static void b(String str) {
        if (a) {
            b("Logger", str);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            b(f(str, str2), str3);
        }
    }

    public static void b(String str, String str2) {
        a aVar = c;
        if (aVar != null) {
            aVar.b(e(str), str2);
        }
        if (a && str2 != null && b <= 3) {
            Log.d(e(str), str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a aVar = c;
        if (aVar != null) {
            String e = e(str);
            aVar.b(e, str2 + Log.getStackTraceString(th));
        }
        if (a) {
            if (!(str2 == null && th == null) && b <= 3) {
                Log.d(e(str), str2, th);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        a aVar = c;
        if (aVar != null) {
            aVar.b(e(str), a(objArr));
        }
        if (a && objArr != null && b <= 3) {
            Log.v(e(str), a(objArr));
        }
    }

    public static void b(String str, String str2, String str3) {
        if (a) {
            c(f(str, str2), str3);
        }
    }

    public static void c(String str, String str2) {
        a aVar = c;
        if (aVar != null) {
            aVar.c(e(str), str2);
        }
        if (a && str2 != null && b <= 4) {
            Log.i(e(str), str2);
        }
    }

    public static void b(String str, Object... objArr) {
        a aVar = c;
        if (aVar != null) {
            aVar.c(e(str), a(objArr));
        }
        if (a && objArr != null && b <= 4) {
            Log.v(e(str), a(objArr));
        }
    }

    public static void c(String str) {
        if (a) {
            d("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        a aVar = c;
        if (aVar != null) {
            aVar.d(e(str), str2);
        }
        if (a && str2 != null && b <= 5) {
            Log.w(e(str), str2);
        }
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        if (a) {
            b(f(str, str2), str3, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        a aVar = c;
        if (aVar != null) {
            aVar.a(e(str), str2, th);
        }
        if (a) {
            if (!(str2 == null && th == null) && b <= 5) {
                Log.w(e(str), str2, th);
            }
        }
    }

    public static void c(String str, Object... objArr) {
        a aVar = c;
        if (aVar != null) {
            aVar.d(e(str), a(objArr));
        }
        if (a && objArr != null && b <= 5) {
            Log.v(e(str), a(objArr));
        }
    }

    public static void d(String str) {
        if (a) {
            e("Logger", str);
        }
    }

    public static void c(String str, String str2, String str3) {
        if (a) {
            e(f(str, str2), str3);
        }
    }

    public static void e(String str, String str2) {
        a aVar = c;
        if (aVar != null) {
            aVar.e(e(str), str2);
        }
        if (a && str2 != null && b <= 6) {
            Log.e(e(str), str2);
        }
    }

    public static void b(String str, String str2, String str3, Throwable th) {
        if (a) {
            c(f(str, str2), str3, th);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        a aVar = c;
        if (aVar != null) {
            aVar.b(e(str), str2, th);
        }
        if (a) {
            if (!(str2 == null && th == null) && b <= 6) {
                Log.e(e(str), str2, th);
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

    public static String e(String str) {
        if (TextUtils.isEmpty(d)) {
            return str;
        }
        return a("[" + d + "]-[" + str + "]");
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(d)) {
            return str;
        }
        return a(str2 + "]-[" + str);
    }
}
