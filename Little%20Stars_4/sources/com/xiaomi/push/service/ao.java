package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.y;

class ao implements y.a {
    final /* synthetic */ XMPushService a;

    ao(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a() {
        this.a.n();
        if (y.a().c() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a((XMPushService.g) new XMPushService.e(12, (Exception) null));
        }
    }
}
