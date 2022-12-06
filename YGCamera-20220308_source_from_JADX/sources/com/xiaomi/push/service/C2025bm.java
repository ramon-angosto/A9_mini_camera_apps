package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.bm */
class C2025bm extends XMPushService.C1956i {

    /* renamed from: a */
    private C1793fj f3828a;

    /* renamed from: a */
    private XMPushService f3829a = null;

    public C2025bm(XMPushService xMPushService, C1793fj fjVar) {
        super(4);
        this.f3829a = xMPushService;
        this.f3828a = fjVar;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send a message.";
    }

    /* renamed from: a */
    public void m5145a() {
        try {
            if (this.f3828a != null) {
                this.f3829a.mo18411a(this.f3828a);
            }
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3829a.mo18410a(10, (Exception) e);
        }
    }
}
