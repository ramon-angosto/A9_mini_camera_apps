package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.gd */
class C1821gd extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1819gb f2483a;

    /* renamed from: a */
    final /* synthetic */ Exception f2484a;

    /* renamed from: b */
    final /* synthetic */ int f2485b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1821gd(C1819gb gbVar, int i, int i2, Exception exc) {
        super(i);
        this.f2483a = gbVar;
        this.f2485b = i2;
        this.f2484a = exc;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "shutdown the connection. " + this.f2485b + ", " + this.f2484a;
    }

    /* renamed from: a */
    public void m3703a() {
        this.f2483a.f2473b.mo18410a(this.f2485b, this.f2484a);
    }
}
