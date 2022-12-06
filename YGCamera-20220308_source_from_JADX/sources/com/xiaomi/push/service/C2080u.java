package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.u */
final class C2080u extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3957a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3958a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2080u(int i, XMPushService xMPushService, C1891ik ikVar) {
        super(i);
        this.f3958a = xMPushService;
        this.f3957a = ikVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send ack message for message.";
    }

    /* renamed from: a */
    public void m5359a() {
        try {
            C1970ab.m4885a(this.f3958a, C2078s.m5334a((Context) this.f3958a, this.f3957a));
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3958a.mo18410a(10, (Exception) e);
        }
    }
}
