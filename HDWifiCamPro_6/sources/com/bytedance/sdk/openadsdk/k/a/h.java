package com.bytedance.sdk.openadsdk.k.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: PAGVideoMrcTracker */
public class h extends b {
    private int d = 0;

    public int f() {
        return 200;
    }

    public h(Integer num, View view, n nVar, int i) {
        super(num, view, nVar, 2000, i);
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return f.a((View) this.a.get()) && this.d == 1;
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
    }

    public void a() {
        if (this.d == 1) {
            super.a();
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i) {
        if (!i()) {
            if (i == 6 || i == 5) {
                this.d = 0;
                h();
            }
            if (i == 3 || i == 2) {
                this.d = 2;
                h();
            }
            if (this.d != 1 && i == 0) {
                this.d = 1;
                a();
            }
        }
    }

    public boolean l() {
        int i = this.d;
        boolean z = i == 2 || i == 0;
        if (z) {
            this.c.set(false);
        }
        if (!z || super.l()) {
            return true;
        }
        return false;
    }
}
