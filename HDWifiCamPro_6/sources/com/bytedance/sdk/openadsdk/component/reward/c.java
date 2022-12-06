package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.c.a;

/* compiled from: FullScreenVideoController */
public class c extends a {
    private f B;

    /* access modifiers changed from: protected */
    public int t() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void z() {
    }

    public c(Context context, ViewGroup viewGroup, n nVar, f fVar) {
        super(context, viewGroup, nVar);
        this.B = fVar;
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2) {
        if (this.e != null) {
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
        o.a aVar = new o.a();
        aVar.a(g());
        aVar.c(j());
        aVar.b(h());
        aVar.f(i());
        com.bytedance.sdk.openadsdk.c.c.a.a.b(this.d, aVar, this.B);
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
        com.bytedance.sdk.openadsdk.c.c.a.a.a(m.a(), (com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar, this.B);
    }

    /* access modifiers changed from: protected */
    public void y() {
        com.bytedance.sdk.openadsdk.c.c.a.a.a(this.e, (com.bykv.vk.openvk.component.video.api.b.a) this.d, this.x);
    }
}
