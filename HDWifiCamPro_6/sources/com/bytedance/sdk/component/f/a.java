package com.bytedance.sdk.component.f;

import android.content.Context;
import com.bytedance.sdk.component.b.a.g;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.f.c.b;
import com.bytedance.sdk.component.f.c.f;
import com.bytedance.sdk.component.f.d.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: NetClient */
public class a {
    private i a;
    private f b;
    private int c;

    private a(C0035a aVar) {
        i.a b2 = new i.a().a((long) aVar.a, TimeUnit.MILLISECONDS).c((long) aVar.c, TimeUnit.MILLISECONDS).b((long) aVar.b, TimeUnit.MILLISECONDS);
        if (aVar.d) {
            this.b = new f();
            b2.a(this.b);
        }
        if (aVar.e != null && aVar.e.size() > 0) {
            for (g a2 : aVar.e) {
                b2.a(a2);
            }
        }
        this.a = b2.a();
    }

    public void a(Context context, boolean z, boolean z2, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        } else if (bVar != null) {
            this.c = bVar.a();
            f fVar = this.b;
            if (fVar != null) {
                fVar.a(this.c);
            }
            com.bytedance.sdk.component.f.c.g.a().a(this.c).a(z2);
            com.bytedance.sdk.component.f.c.g.a().a(this.c).a(bVar);
            com.bytedance.sdk.component.f.c.g.a().a(this.c).a(context, com.bytedance.sdk.component.f.d.f.b(context));
            if (com.bytedance.sdk.component.f.d.f.a(context) || (!com.bytedance.sdk.component.f.d.f.b(context) && z)) {
                com.bytedance.sdk.component.f.c.g.a().a(this.c, context).d();
                com.bytedance.sdk.component.f.c.g.a().a(this.c, context).a();
            }
            if (com.bytedance.sdk.component.f.d.f.b(context)) {
                com.bytedance.sdk.component.f.c.g.a().a(this.c, context).d();
                com.bytedance.sdk.component.f.c.g.a().a(this.c, context).a();
            }
        } else {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
    }

    public static void a() {
        com.bytedance.sdk.component.f.d.b.a(b.a.DEBUG);
    }

    public d b() {
        return new d(this.a);
    }

    public com.bytedance.sdk.component.f.b.b c() {
        return new com.bytedance.sdk.component.f.b.b(this.a);
    }

    public com.bytedance.sdk.component.f.b.a d() {
        return new com.bytedance.sdk.component.f.b.a(this.a);
    }

    public i e() {
        return this.a;
    }

    /* renamed from: com.bytedance.sdk.component.f.a$a  reason: collision with other inner class name */
    /* compiled from: NetClient */
    public static final class C0035a {
        int a = 10000;
        int b = 10000;
        int c = 10000;
        boolean d = true;
        final List<g> e = new ArrayList();

        public C0035a a(long j, TimeUnit timeUnit) {
            this.a = a("timeout", j, timeUnit);
            return this;
        }

        public C0035a b(long j, TimeUnit timeUnit) {
            this.b = a("timeout", j, timeUnit);
            return this;
        }

        public C0035a c(long j, TimeUnit timeUnit) {
            this.c = a("timeout", j, timeUnit);
            return this;
        }

        public C0035a a(boolean z) {
            this.d = z;
            return this;
        }

        private static int a(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public a a() {
            return new a(this);
        }
    }
}
