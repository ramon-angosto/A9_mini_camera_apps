package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.bb */
class C2012bb extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C2003az.C2005b.C2008c f3767a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2012bb(C2003az.C2005b.C2008c cVar, int i) {
        super(i);
        this.f3767a = cVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "clear peer job";
    }

    /* renamed from: a */
    public void m5111a() {
        if (this.f3767a.f3756a == this.f3767a.f3757a.f3732a) {
            C1524b.m2158b("clean peer, chid = " + this.f3767a.f3757a.f3748g);
            this.f3767a.f3757a.f3732a = null;
        }
    }
}
