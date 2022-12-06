package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.x */
final class C2083x extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3963a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3964a;

    /* renamed from: a */
    final /* synthetic */ String f3965a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2083x(int i, XMPushService xMPushService, C1891ik ikVar, String str) {
        super(i);
        this.f3964a = xMPushService;
        this.f3963a = ikVar;
        this.f3965a = str;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send app absent ack message for message.";
    }

    /* renamed from: a */
    public void m5365a() {
        try {
            C1891ik a = C2078s.m5334a((Context) this.f3964a, this.f3963a);
            a.mo18043a().mo17881a("absent_target_package", this.f3965a);
            C1970ab.m4885a(this.f3964a, a);
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3964a.mo18410a(10, (Exception) e);
        }
    }
}
