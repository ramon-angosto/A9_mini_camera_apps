package com.meizu.cloud.pushsdk.b.f;

import com.meizu.cloud.pushinternal.DebugLogger;

public class c {
    private static int a;

    public static void a(String str, String str2, Object... objArr) {
        if (a >= 1) {
            DebugLogger.e(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= 2) {
            DebugLogger.d(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= 3) {
            DebugLogger.i(a(str), a(str2, objArr));
        }
    }

    private static String a(String str, Object... objArr) {
        return a() + "|" + String.format(str, objArr);
    }

    private static String a(String str) {
        return "PushTracker->" + str;
    }

    private static String a() {
        return Thread.currentThread().getName();
    }

    public static void a(b bVar) {
        a = bVar.a();
    }
}
