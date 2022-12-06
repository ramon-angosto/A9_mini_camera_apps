package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.xmpush.thrift.p;

final class m extends XMPushService.g {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ p c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(int i, XMPushService xMPushService, p pVar) {
        super(i);
        this.b = xMPushService;
        this.c = pVar;
    }

    public void a() {
        try {
            this.b.a(k.a((Context) this.b, this.c));
        } catch (com.xiaomi.smack.p e) {
            b.a((Throwable) e);
            this.b.a(10, (Exception) e);
        }
    }

    public String b() {
        return "send ack message for message.";
    }
}
