package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.p;
import com.xiaomi.smack.packet.d;

public class ag extends XMPushService.g {
    private XMPushService b = null;
    private d c;

    public ag(XMPushService xMPushService, d dVar) {
        super(4);
        this.b = xMPushService;
        this.c = dVar;
    }

    public void a() {
        try {
            this.b.a(this.c);
        } catch (p e) {
            b.a((Throwable) e);
            this.b.a(10, (Exception) e);
        }
    }

    public String b() {
        return "send a message.";
    }
}
