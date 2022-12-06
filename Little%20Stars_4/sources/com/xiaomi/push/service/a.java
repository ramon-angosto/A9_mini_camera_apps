package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.p;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;

public class a extends XMPushService.g {
    private XMPushService b = null;
    private c[] c;

    public a(XMPushService xMPushService, c[] cVarArr) {
        super(4);
        this.b = xMPushService;
        this.c = cVarArr;
    }

    public void a() {
        try {
            this.b.a((d[]) this.c);
        } catch (p e) {
            b.a((Throwable) e);
            this.b.a(10, (Exception) e);
        }
    }

    public String b() {
        return "batch send message.";
    }
}
