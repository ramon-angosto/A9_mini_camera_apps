package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.xmpush.thrift.p;

final class q extends XMPushService.g {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ p c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(int i, XMPushService xMPushService, p pVar, String str, String str2) {
        super(i);
        this.b = xMPushService;
        this.c = pVar;
        this.d = str;
        this.e = str2;
    }

    public void a() {
        try {
            p a = k.a((Context) this.b, this.c);
            a.h.a("error", this.d);
            a.h.a("reason", this.e);
            this.b.a(a);
        } catch (com.xiaomi.smack.p e2) {
            b.a((Throwable) e2);
            this.b.a(10, (Exception) e2);
        }
    }

    public String b() {
        return "send wrong message ack for message.";
    }
}
