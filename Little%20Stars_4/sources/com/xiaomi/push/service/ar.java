package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.y;

class ar implements y.b.a {
    final /* synthetic */ XMPushService a;

    ar(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void a(y.c cVar, y.c cVar2, int i) {
        if (cVar2 == y.c.binded) {
            j.a(this.a);
            j.b(this.a);
        } else if (cVar2 == y.c.unbind) {
            j.a(this.a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
