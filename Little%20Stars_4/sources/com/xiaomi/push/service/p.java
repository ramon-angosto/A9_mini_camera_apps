package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

final class p extends XMPushService.g {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.p c;
    final /* synthetic */ String d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.p pVar, String str) {
        super(i);
        this.b = xMPushService;
        this.c = pVar;
        this.d = str;
    }

    public void a() {
        try {
            com.xiaomi.xmpush.thrift.p a = k.a((Context) this.b, this.c);
            a.m().a("absent_target_package", this.d);
            this.b.a(a);
        } catch (com.xiaomi.smack.p e) {
            b.a((Throwable) e);
            this.b.a(10, (Exception) e);
        }
    }

    public String b() {
        return "send app absent ack message for message.";
    }
}
