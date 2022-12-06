package com.bytedance.sdk.openadsdk.k.a;

import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: PAGBaseMrcTracker */
public abstract class b {
    protected WeakReference<View> a;
    protected n b;
    protected final AtomicBoolean c;
    private final AtomicLong d;
    private final AtomicBoolean e;
    private final int f;
    private final Integer g;
    private volatile boolean h = false;
    private final int i;

    /* access modifiers changed from: protected */
    public abstract void b(int i2);

    /* access modifiers changed from: protected */
    public abstract boolean c();

    public abstract int f();

    public static b a(boolean z, Integer num, View view, n nVar, int i2) {
        return z ? new h(num, view, nVar, i2) : new c(num, view, nVar, i2);
    }

    public b(Integer num, View view, n nVar, int i2, int i3) {
        this.g = num;
        this.f = i2;
        this.b = nVar;
        this.i = i3;
        a(view);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicLong(-1);
        this.e = new AtomicBoolean(false);
    }

    public void a() {
        if (this.c.compareAndSet(false, true)) {
            g.a(this);
        }
    }

    public int b() {
        if (i()) {
            return 1;
        }
        WeakReference<View> weakReference = this.a;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || this.h) {
            return 3;
        }
        if (k().equals(view.getTag(t.e(m.a(), "tt_id_mrc_tracker_view"))) && c()) {
            return 1;
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.e.compareAndSet(false, true)) {
            d.a(this.b, e(), this.i);
        }
    }

    /* access modifiers changed from: protected */
    public a e() {
        WeakReference<View> weakReference = this.a;
        if (weakReference == null) {
            return new a(-1, -1, -1.0f);
        }
        View view = (View) weakReference.get();
        if (view == null) {
            return new a(0, 0, 0.0f);
        }
        return new a(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public void g() {
        if (!i()) {
            if (!this.c.get()) {
                h();
            } else if (!this.d.compareAndSet(-1, System.currentTimeMillis()) && System.currentTimeMillis() - this.d.get() >= ((long) this.f)) {
                d();
            }
        }
    }

    public void h() {
        this.d.set(-1);
    }

    public boolean i() {
        return this.e.get();
    }

    public void j() {
        this.h = true;
    }

    public void a(int i2) {
        if (i2 == 4) {
            a();
        } else if (i2 == 8) {
            m();
        } else if (i2 == 9) {
            d();
        } else {
            b(i2);
        }
    }

    public Integer k() {
        return this.g;
    }

    public boolean l() {
        return this.c.get();
    }

    public void m() {
        this.c.set(false);
        h();
    }

    public void a(View view) {
        if (view != null) {
            view.setTag(t.e(m.a(), "tt_id_mrc_tracker_view"), k());
        }
        this.a = new WeakReference<>(view);
    }
}
