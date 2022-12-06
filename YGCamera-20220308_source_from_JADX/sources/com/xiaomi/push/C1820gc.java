package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.C2061i;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.gc */
class C1820gc extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ long f2481a;

    /* renamed from: a */
    final /* synthetic */ C1819gb f2482a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1820gc(C1819gb gbVar, int i, long j) {
        super(i);
        this.f2482a = gbVar;
        this.f2481a = j;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "check the ping-pong." + this.f2481a;
    }

    /* renamed from: a */
    public void m3701a() {
        Thread.yield();
        if (this.f2482a.mo17666c() && !this.f2482a.mo17660a(this.f2481a)) {
            C2061i.m5236a((Context) this.f2482a.f2473b).mo18534b();
            this.f2482a.f2473b.mo18410a(22, (Exception) null);
        }
    }
}
