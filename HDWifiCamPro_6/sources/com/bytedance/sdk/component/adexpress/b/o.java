package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.i;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.l;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WebViewRenderInterceptor */
public class o implements i {
    private Context a;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.component.adexpress.d.a b;
    private g c;
    private l d;
    private ScheduledFuture<?> e;
    private AtomicBoolean f = new AtomicBoolean(false);

    public o(Context context, l lVar, com.bytedance.sdk.component.adexpress.d.a aVar, g gVar) {
        this.a = context;
        this.d = lVar;
        this.c = gVar;
        this.b = aVar;
        this.b.a(this.c);
    }

    public boolean a(final i.a aVar) {
        int d2 = this.d.d();
        if (d2 < 0) {
            a(aVar, 107);
        } else {
            this.e = e.d().schedule(new a(1, aVar), (long) d2, TimeUnit.MILLISECONDS);
            this.b.a((f) new f() {
                public void a(View view, m mVar) {
                    n b2;
                    o.this.e();
                    if (!aVar.c() && (b2 = aVar.b()) != null) {
                        b2.a(o.this.b, mVar);
                        aVar.a(true);
                    }
                }

                public void a(int i) {
                    o.this.a(aVar, i);
                }
            });
        }
        return true;
    }

    public void a() {
        this.b.d();
        e();
    }

    public void b() {
        this.b.h();
    }

    public void c() {
        this.b.i();
    }

    public com.bytedance.sdk.component.adexpress.d.a d() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            if (this.e != null && !this.e.isCancelled()) {
                this.e.cancel(false);
                this.e = null;
            }
            l.b("RenderInterceptor", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* compiled from: WebViewRenderInterceptor */
    private class a implements Runnable {
        i.a a;
        private int c;

        public a(int i, i.a aVar) {
            this.c = i;
            this.a = aVar;
        }

        public void run() {
            if (this.c == 1) {
                l.b("RenderInterceptor", "WebView Render timeout");
                o.this.b.a(true);
                o.this.a(this.a, 107);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(i.a aVar, int i) {
        if (!aVar.c() && !this.f.get()) {
            e();
            this.d.c().a(i);
            if (aVar.b(this)) {
                aVar.a((i) this);
            } else {
                n b2 = aVar.b();
                if (b2 != null) {
                    b2.a_(i);
                } else {
                    return;
                }
            }
            this.f.getAndSet(true);
        }
    }
}
