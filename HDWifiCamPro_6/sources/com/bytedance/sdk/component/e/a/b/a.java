package com.bytedance.sdk.component.e.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.c.c;
import com.bytedance.sdk.component.e.a.i;

/* compiled from: DBEventUtils */
public class a {
    public static long a(int i, Context context) {
        long b = b(i, context);
        c.a("ad limit by memory:" + b);
        return b;
    }

    private static long b(int i, Context context) {
        if (context == null) {
            return (long) i;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / 1048576;
        long maxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (maxMemory > 0) {
            long j = ((freeMemory + maxMemory) - 10) / 2;
            if (j <= 2) {
                return 1;
            }
            if (j <= 10) {
                return (long) Math.min(i, 10);
            }
            return Math.min(j * 10, (long) i);
        } else if (freeMemory <= 2) {
            return 1;
        } else {
            if (freeMemory <= 10) {
                return (long) Math.min(i, 10);
            }
            return Math.min((freeMemory / 2) * 10, (long) i);
        }
    }

    public static boolean a() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.a());
    }

    public static boolean b() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.b());
    }

    public static boolean c() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.d());
    }

    public static boolean d() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.e());
    }

    public static boolean e() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.c());
    }

    public static boolean f() {
        e b = i.e().b();
        return b != null && !TextUtils.isEmpty(b.f());
    }
}
