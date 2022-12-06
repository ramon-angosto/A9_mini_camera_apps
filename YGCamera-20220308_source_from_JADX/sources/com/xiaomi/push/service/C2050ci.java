package com.xiaomi.push.service;

import com.xiaomi.push.C1653bi;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.ci */
class C2050ci extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3871a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2050ci(XMPushService xMPushService, int i) {
        super(i);
        this.f3871a = xMPushService;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "prepare the mi push account.";
    }

    /* renamed from: a */
    public void m5206a() {
        C1970ab.m4884a(this.f3871a);
        if (C1653bi.m2685b(this.f3871a)) {
            this.f3871a.mo18418a(true);
        }
    }
}
