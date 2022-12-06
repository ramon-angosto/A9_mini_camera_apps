package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.y */
final class C2084y extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3966a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3967a;

    /* renamed from: a */
    final /* synthetic */ String f3968a;

    /* renamed from: b */
    final /* synthetic */ String f3969b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2084y(int i, XMPushService xMPushService, C1891ik ikVar, String str, String str2) {
        super(i);
        this.f3967a = xMPushService;
        this.f3966a = ikVar;
        this.f3968a = str;
        this.f3969b = str2;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send wrong message ack for message.";
    }

    /* renamed from: a */
    public void m5367a() {
        try {
            C1891ik a = C2078s.m5334a((Context) this.f3967a, this.f3966a);
            a.f3189a.mo17881a("error", this.f3968a);
            a.f3189a.mo17881a("reason", this.f3969b);
            C1970ab.m4885a(this.f3967a, a);
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3967a.mo18410a(10, (Exception) e);
        }
    }
}
