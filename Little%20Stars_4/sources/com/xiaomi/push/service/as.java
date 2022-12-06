package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.a;
import com.xiaomi.smack.packet.f;

class as extends XMPushService.g {
    final /* synthetic */ XMPushService b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    as(XMPushService xMPushService, int i) {
        super(i);
        this.b = xMPushService;
    }

    public void a() {
        if (this.b.h != null) {
            this.b.h.a(new f(f.b.unavailable), 15, (Exception) null);
            a unused = this.b.h = null;
        }
    }

    public String b() {
        return "disconnect for service destroy.";
    }
}
