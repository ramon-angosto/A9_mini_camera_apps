package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.t */
final class C2079t extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3955a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3956a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2079t(int i, XMPushService xMPushService, C1891ik ikVar) {
        super(i);
        this.f3956a = xMPushService;
        this.f3955a = ikVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send app absent message.";
    }

    /* renamed from: a */
    public void m5357a() {
        try {
            C1970ab.m4885a(this.f3956a, C1970ab.m4879a(this.f3955a.mo18052b(), this.f3955a.mo18043a()));
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3956a.mo18410a(10, (Exception) e);
        }
    }
}
