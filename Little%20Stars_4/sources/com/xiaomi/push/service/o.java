package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.xmpush.thrift.p;

final class o extends XMPushService.g {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ p c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(int i, XMPushService xMPushService, p pVar) {
        super(i);
        this.b = xMPushService;
        this.c = pVar;
    }

    public void a() {
        try {
            p a = k.a((Context) this.b, this.c);
            a.m().a("miui_message_unrecognized", "1");
            this.b.a(a);
        } catch (com.xiaomi.smack.p e) {
            b.a((Throwable) e);
            this.b.a(10, (Exception) e);
        }
    }

    public String b() {
        return "send ack message for unrecognized new miui message.";
    }
}
