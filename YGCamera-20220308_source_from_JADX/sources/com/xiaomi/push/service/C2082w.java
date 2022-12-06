package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.w */
final class C2082w extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3961a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3962a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2082w(int i, XMPushService xMPushService, C1891ik ikVar) {
        super(i);
        this.f3962a = xMPushService;
        this.f3961a = ikVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send ack message for unrecognized new miui message.";
    }

    /* renamed from: a */
    public void m5363a() {
        try {
            C1891ik a = C2078s.m5334a((Context) this.f3962a, this.f3961a);
            a.mo18043a().mo17881a("miui_message_unrecognized", "1");
            C1970ab.m4885a(this.f3962a, a);
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3962a.mo18410a(10, (Exception) e);
        }
    }
}
