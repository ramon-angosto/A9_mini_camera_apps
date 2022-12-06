package com.xiaomi.push.service;

import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.bc */
class C2013bc extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C2003az.C2005b.C2008c f3768a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2013bc(C2003az.C2005b.C2008c cVar, int i) {
        super(i);
        this.f3768a = cVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "check peer job";
    }

    /* renamed from: a */
    public void m5113a() {
        if (C2003az.mo18481a().mo18482a(this.f3768a.f3757a.f3748g, this.f3768a.f3757a.f3742b).f3732a == null) {
            C2003az.C2005b.m5089a(C2003az.C2005b.this).mo18416a(this.f3768a.f3757a.f3748g, this.f3768a.f3757a.f3742b, 2, (String) null, (String) null);
        }
    }
}
