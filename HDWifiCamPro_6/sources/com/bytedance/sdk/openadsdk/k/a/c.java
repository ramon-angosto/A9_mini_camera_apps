package com.bytedance.sdk.openadsdk.k.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: PAGDisplayMrcTracker */
public class c extends b {
    private int d = -1;

    /* access modifiers changed from: protected */
    public void b(int i) {
    }

    public int f() {
        return 100;
    }

    public c(Integer num, View view, n nVar, int i) {
        super(num, view, nVar, 1000, i);
        b(view);
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        boolean z = false;
        if (this.a == null || this.a.get() == null) {
            return false;
        }
        View view = (View) this.a.get();
        if (this.d == -1) {
            b(view);
        }
        if (this.d == 1) {
            z = true;
        }
        return f.a(view, z);
    }

    private void b(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                this.d = width * height >= 242500 ? 1 : 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
    }
}
