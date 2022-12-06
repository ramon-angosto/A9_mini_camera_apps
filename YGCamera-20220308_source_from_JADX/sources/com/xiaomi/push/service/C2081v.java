package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.v */
final class C2081v extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3959a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3960a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2081v(int i, XMPushService xMPushService, C1891ik ikVar) {
        super(i);
        this.f3960a = xMPushService;
        this.f3959a = ikVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send ack message for obsleted message.";
    }

    /* renamed from: a */
    public void m5361a() {
        try {
            C1891ik a = C2078s.m5334a((Context) this.f3960a, this.f3959a);
            a.mo18043a().mo17881a("message_obsleted", "1");
            C1970ab.m4885a(this.f3960a, a);
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3960a.mo18410a(10, (Exception) e);
        }
    }
}
