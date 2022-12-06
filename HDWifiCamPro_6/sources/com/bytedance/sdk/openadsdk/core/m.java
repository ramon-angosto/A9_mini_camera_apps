package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.a.c;
import com.bytedance.sdk.openadsdk.core.settings.f;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.h.c.b;
import java.lang.reflect.Method;

/* compiled from: InternalContainer */
public class m {
    private static volatile Context a = null;
    private static volatile n<com.bytedance.sdk.openadsdk.c.a> b = null;
    private static int c = -1;

    public static synchronized Context a() {
        Context context;
        synchronized (m.class) {
            if (a == null) {
                a((Context) null);
            }
            context = a;
        }
        return context;
    }

    public static synchronized void a(Context context) {
        synchronized (m.class) {
            if (a == null) {
                if (context == null) {
                    context = a.a();
                    if (context == null) {
                        return;
                    }
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                a = context;
            }
        }
    }

    public static int b() {
        Context a2;
        if (c < 0 && (a2 = a()) != null) {
            c = ViewConfiguration.get(a2).getScaledTouchSlop();
        }
        return c;
    }

    public static n<com.bytedance.sdk.openadsdk.c.a> c() {
        Class<m> cls = m.class;
        if (b == null) {
            synchronized (cls) {
                if (b == null) {
                    b = new o(a);
                }
            }
        }
        return b;
    }

    public static j d() {
        return j.b();
    }

    public static com.bytedance.sdk.openadsdk.h.c.a e() {
        return !f.a() ? b.a() : c.a();
    }

    /* compiled from: InternalContainer */
    private static class a {
        private static volatile Application a;

        public static Application a() {
            return a;
        }

        static {
            try {
                Object b = b();
                a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                l.e("MyApplication", "application get success");
            } catch (Throwable th) {
                l.c("MyApplication", "application get failed", th);
            }
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke((Object) null, new Object[0]);
            } catch (Throwable th) {
                l.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
