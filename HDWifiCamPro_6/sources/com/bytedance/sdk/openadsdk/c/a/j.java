package com.bytedance.sdk.openadsdk.c.a;

import com.bytedance.sdk.component.e.a.b;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.c.a;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: StatsLogAdLogImpl */
class j implements a {
    public static final j a = new j();

    public void a() {
    }

    private j() {
    }

    public void a(com.bytedance.sdk.openadsdk.h.a aVar) {
        a(aVar, false);
    }

    public void a(final com.bytedance.sdk.openadsdk.h.a aVar, final boolean z) {
        w.b(new g("uploadLogEvent") {
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.h.a.a a2 = aVar.a();
                    if (a2 != null) {
                        com.bytedance.sdk.component.e.a.d.a.a aVar = new com.bytedance.sdk.component.e.a.d.a.a(o.a(), a2.a());
                        aVar.c((byte) 0);
                        aVar.b(z ? (byte) 2 : 3);
                        aVar.a((byte) 1);
                        if (b.b()) {
                            c.a(m.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
                        }
                        b.a((com.bytedance.sdk.component.e.a.d.a) aVar);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
