package com.bytedance.sdk.openadsdk.core;

import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: SingleAppData */
public class r {
    private static r a;
    private c b;
    private boolean c = true;
    private n d;
    private b e;
    private com.com.bytedance.overseas.sdk.a.c f;
    private com.bytedance.sdk.openadsdk.a.c.c g;
    private com.bytedance.sdk.openadsdk.a.d.c h;
    private boolean i = false;

    private r() {
    }

    public static r a() {
        if (a == null) {
            a = new r();
        }
        return a;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }

    public n c() {
        return this.d;
    }

    public void a(n nVar) {
        this.d = nVar;
    }

    public b d() {
        return this.e;
    }

    public com.bytedance.sdk.openadsdk.a.c.c e() {
        return this.g;
    }

    public com.bytedance.sdk.openadsdk.a.d.c f() {
        return this.h;
    }

    public void a(com.bytedance.sdk.openadsdk.a.c.c cVar) {
        this.g = cVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(com.bytedance.sdk.openadsdk.a.d.c cVar) {
        this.h = cVar;
    }

    public com.com.bytedance.overseas.sdk.a.c g() {
        return this.f;
    }

    public void a(com.com.bytedance.overseas.sdk.a.c cVar) {
        this.f = cVar;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public void h() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.f = null;
        this.i = false;
        this.c = true;
    }
}
