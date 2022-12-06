package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.b;

class ap extends XMPushService.g {
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ String d;
    final /* synthetic */ XMPushService e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.e = xMPushService;
        this.b = i2;
        this.c = bArr;
        this.d = str;
    }

    public void a() {
        g.b(this.e);
        y.a().a("5");
        a.a(this.b);
        this.e.b.c(b.b());
        this.e.a(this.c, this.d);
    }

    public String b() {
        return "clear account cache.";
    }
}
