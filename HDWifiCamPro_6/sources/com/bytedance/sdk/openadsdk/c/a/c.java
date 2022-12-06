package com.bytedance.sdk.openadsdk.c.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.b;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AdLogSwitchUtils */
public class c {
    public static AtomicInteger a = new AtomicInteger(0);
    public static AtomicInteger b = new AtomicInteger(0);

    public static synchronized void a(Context context, boolean z) {
        synchronized (c.class) {
            b.a(new a.C0032a().a((com.bytedance.sdk.component.e.a.b.c) new h()).b(com.bytedance.sdk.component.e.a.d.b.a.c()).c(com.bytedance.sdk.component.e.a.d.b.a.e()).a(com.bytedance.sdk.component.e.a.d.b.a.d()).a(z).a((f) new i()).a((e) f.a).a(), context);
        }
    }

    public static synchronized void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        synchronized (c.class) {
            l.b("log_process", "report:" + aVar.e());
            com.bytedance.sdk.component.e.a.d.a.a aVar2 = new com.bytedance.sdk.component.e.a.d.a.a(aVar.f(), (com.bytedance.sdk.component.e.a.d.a.b) aVar);
            aVar2.b(aVar.g() ? (byte) 1 : 2);
            aVar2.a((byte) 0);
            if (b.b()) {
                a(m.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
            }
            b.a((com.bytedance.sdk.component.e.a.d.a) aVar2);
        }
    }

    public static synchronized com.bytedance.sdk.openadsdk.h.c.a a() {
        j jVar;
        synchronized (c.class) {
            jVar = j.a;
        }
        return jVar;
    }

    public static void a(final List<String> list) {
        if (list != null) {
            com.bytedance.sdk.openadsdk.c.c.a((g) new g("track") {
                public void run() {
                    b.a(j.a(m.a()), list, true);
                }
            });
        }
    }

    public static void a(String str) {
        b.a(str);
    }

    public static synchronized void b() {
        synchronized (c.class) {
            b.c();
        }
    }

    public static synchronized void c() {
        synchronized (c.class) {
            try {
                b.d();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                b.e();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return;
    }
}
