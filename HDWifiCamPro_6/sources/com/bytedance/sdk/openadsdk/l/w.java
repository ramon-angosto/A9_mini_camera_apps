package com.bytedance.sdk.openadsdk.l;

import android.os.Looper;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadUtils */
public class w {
    private static volatile ThreadPoolExecutor a;

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (a()) {
                runnable.run();
            } else {
                k.d().post(runnable);
            }
        }
    }

    public static void a(g gVar) {
        a(gVar, 5);
    }

    public static void a(g gVar, int i) {
        if (gVar != null) {
            e.a(gVar, i);
        }
    }

    public static void a(g gVar, int i, int i2) {
        if (gVar != null) {
            e.a(gVar, i, i2);
        }
    }

    public static void b(g gVar) {
        if (gVar != null) {
            e.b(gVar);
        }
    }

    private static void b() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.f());
                    a.allowCoreThreadTimeOut(true);
                }
            }
        }
    }

    public static void c(g gVar) {
        if (a == null) {
            b();
        }
        if (a != null) {
            a.execute(gVar);
        }
    }
}
