package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.c */
class C2041c extends XMPushService.C1956i {

    /* renamed from: a */
    private XMPushService f3859a = null;

    /* renamed from: a */
    private C1793fj[] f3860a;

    public C2041c(XMPushService xMPushService, C1793fj[] fjVarArr) {
        super(4);
        this.f3859a = xMPushService;
        this.f3860a = fjVarArr;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "batch send message.";
    }

    /* renamed from: a */
    public void m5197a() {
        try {
            if (this.f3860a != null) {
                this.f3859a.mo18420a(this.f3860a);
            }
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3859a.mo18410a(10, (Exception) e);
        }
    }
}
