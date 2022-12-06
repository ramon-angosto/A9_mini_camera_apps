package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1886if;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.z */
final class C2085z extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C1891ik f3970a;

    /* renamed from: a */
    final /* synthetic */ C1894in f3971a;

    /* renamed from: a */
    final /* synthetic */ XMPushService f3972a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2085z(int i, C1894in inVar, C1891ik ikVar, XMPushService xMPushService) {
        super(i);
        this.f3971a = inVar;
        this.f3970a = ikVar;
        this.f3972a = xMPushService;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send ack message for clear push message.";
    }

    /* renamed from: a */
    public void m5369a() {
        try {
            C1886if ifVar = new C1886if();
            ifVar.mo17968c(C1878hy.CancelPushMessageACK.f2959a);
            ifVar.mo17963a(this.f3971a.mo18077a());
            ifVar.mo17962a(this.f3971a.mo18077a());
            ifVar.mo17966b(this.f3971a.mo18085b());
            ifVar.mo17973e(this.f3971a.mo18088c());
            ifVar.mo17961a(0);
            ifVar.mo17971d("success clear push message.");
            C1970ab.m4885a(this.f3972a, C1970ab.m4890b(this.f3970a.mo18052b(), this.f3970a.mo18043a(), ifVar, C1868ho.Notification));
        } catch (C1823gf e) {
            C1524b.m2160d("clear push message. " + e);
            this.f3972a.mo18410a(10, (Exception) e);
        }
    }
}
