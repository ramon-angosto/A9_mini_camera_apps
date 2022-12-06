package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.p;

class aq extends XMPushService.g {
    final /* synthetic */ String b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ XMPushService d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aq(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.d = xMPushService;
        this.b = str;
        this.c = bArr;
    }

    public void a() {
        try {
            this.d.a(this.b, this.c);
        } catch (p e) {
            b.a((Throwable) e);
            this.d.a(10, (Exception) e);
        }
    }

    public String b() {
        return "send mi push message";
    }
}
