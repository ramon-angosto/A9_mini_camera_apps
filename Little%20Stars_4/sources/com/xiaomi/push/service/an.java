package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.stats.f;

class an extends XMPushService.g {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    public void a() {
        f a = f.a();
        XMPushService xMPushService = this.b;
        a.a(xMPushService, xMPushService.g);
        this.b.j();
    }

    public String b() {
        return "prepare the mi push account.";
    }
}
