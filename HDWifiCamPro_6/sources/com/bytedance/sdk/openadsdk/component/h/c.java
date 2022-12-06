package com.bytedance.sdk.openadsdk.component.h;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.c.a;

/* compiled from: TTAppOpenVideoController */
public class c extends a {
    private boolean B = false;

    /* access modifiers changed from: protected */
    public int t() {
        return 3;
    }

    public c(Context context, ViewGroup viewGroup, n nVar) {
        super(context, viewGroup, nVar);
        M();
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2) {
        if (this.h != null) {
            o.a aVar = new o.a();
            aVar.b(h());
            aVar.c(j());
            aVar.a(g());
            aVar.a(i);
            aVar.b(i2);
            com.bytedance.sdk.openadsdk.c.c.a.a.c(F(), aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        if (!this.B) {
            this.B = true;
            o.a aVar = new o.a();
            aVar.a(g());
            aVar.c(j());
            aVar.b(h());
            aVar.f(i());
            com.bytedance.sdk.openadsdk.c.c.a.a.b(this.d, aVar, (f) null);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        o.a aVar = new o.a();
        aVar.a(g());
        aVar.c(j());
        aVar.b(h());
        com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar);
    }

    /* access modifiers changed from: protected */
    public void w() {
        o.a aVar = new o.a();
        aVar.a(g());
        aVar.c(j());
        aVar.b(h());
        com.bytedance.sdk.openadsdk.c.c.a.a.b(F(), aVar);
    }

    /* access modifiers changed from: protected */
    public void x() {
        o.a aVar = new o.a();
        aVar.a(true);
        aVar.c(j());
        com.bytedance.sdk.openadsdk.c.c.a.a.a((Context) this.h.get(), (com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar, (f) null);
    }

    /* access modifiers changed from: protected */
    public void y() {
        com.bytedance.sdk.openadsdk.c.c.a.a.a(this.e, (com.bykv.vk.openvk.component.video.api.b.a) this.d, this.x);
    }

    public void a(o.a aVar) {
        com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar, (f) null);
    }

    public void z() {
        o.a aVar = new o.a();
        aVar.a(g());
        aVar.c(j());
        aVar.b(h());
        aVar.f(i());
        com.bytedance.sdk.openadsdk.c.c.a.a.e(this.d, aVar);
    }
}
