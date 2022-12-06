package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;

class n extends XMPushService.g {
    final /* synthetic */ int b;
    final /* synthetic */ Exception c;
    final /* synthetic */ l d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(l lVar, int i, int i2, Exception exc) {
        super(i);
        this.d = lVar;
        this.b = i2;
        this.c = exc;
    }

    public void a() {
        this.d.y.a(this.b, this.c);
    }

    public String b() {
        return "shutdown the connection. " + this.b + ", " + this.c;
    }
}
