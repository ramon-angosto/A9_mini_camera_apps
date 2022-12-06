package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;

class b extends XMPushService.g {
    final /* synthetic */ a b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(a aVar, int i) {
        super(i);
        this.b = aVar;
    }

    public void a() {
        this.b.c();
    }

    public String b() {
        return "Handling bind stats";
    }
}
