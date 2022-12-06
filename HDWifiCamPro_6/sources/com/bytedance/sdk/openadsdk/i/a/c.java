package com.bytedance.sdk.openadsdk.i.a;

import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.i.a.a;

/* compiled from: SplashGifLoader */
public class c extends a {
    public static volatile int a;
    private q b;

    private void a(k kVar) {
        g f = kVar.f();
        if (f != null && c()) {
            if (kVar.e()) {
                l.b("splashLoadAd", " GiftLoader doTask  Cache exists and returns cached data directly");
                a = 1;
                a(true);
            } else {
                l.b("splashLoadAd", " GiftLoader doTask  Cache not exists, load data from net");
                a = 2;
                a(false);
            }
            a(f.a());
        }
    }

    private boolean c() {
        q qVar = this.b;
        return qVar != null && qVar.c();
    }

    private void a(long j) {
        this.b.d(j);
        q qVar = this.b;
        qVar.b(j - qVar.b());
    }

    private void a(boolean z) {
        if (c()) {
            this.b.a(z);
        }
    }

    private void d() {
        if (c()) {
            long currentTimeMillis = System.currentTimeMillis();
            q qVar = this.b;
            qVar.a(currentTimeMillis - qVar.a());
            this.b.c(currentTimeMillis);
        }
    }

    /* access modifiers changed from: protected */
    public void a(k kVar, a.b bVar) {
        a(kVar);
        super.a(kVar, bVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        d();
    }
}
