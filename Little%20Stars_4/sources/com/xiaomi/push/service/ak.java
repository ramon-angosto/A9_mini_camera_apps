package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

class ak extends XMPushService.g {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    public void a() {
        if (this.b.f()) {
            this.b.a(18, (Exception) null);
        }
    }

    public String b() {
        return "disconnect because of connecting timeout";
    }
}
