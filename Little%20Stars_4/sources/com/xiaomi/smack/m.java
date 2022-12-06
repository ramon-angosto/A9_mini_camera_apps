package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;

class m extends XMPushService.g {
    final /* synthetic */ long b;
    final /* synthetic */ l c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(l lVar, int i, long j) {
        super(i);
        this.c = lVar;
        this.b = j;
    }

    public void a() {
        Thread.yield();
        if (this.c.i() && !this.c.a(this.b)) {
            this.c.y.a(22, (Exception) null);
            this.c.y.a(true);
        }
    }

    public String b() {
        return "check the ping-pong." + this.b;
    }
}
