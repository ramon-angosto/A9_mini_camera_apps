package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.a.c;
import com.bytedance.sdk.openadsdk.component.reward.view.d;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: RewardFullAdType */
public abstract class a {
    protected Activity a;
    protected n b;
    protected int c;
    protected int d;
    protected int e;
    protected float f;
    protected String g;
    protected e h;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.b.a$a  reason: collision with other inner class name */
    /* compiled from: RewardFullAdType */
    public interface C0042a {
        void a(boolean z);
    }

    public C0042a a() {
        return null;
    }

    public abstract void a(FrameLayout frameLayout);

    public abstract void a(c cVar, d dVar);

    public abstract boolean b();

    public abstract boolean c();

    public a(Activity activity, n nVar, int i, int i2) {
        this.a = activity;
        this.b = nVar;
        this.c = i;
        this.d = i2;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a(float f2) {
        this.f = f2;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(e eVar) {
        this.h = eVar;
    }
}
