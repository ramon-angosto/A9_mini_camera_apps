package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;

final class k extends f.b {
    final /* synthetic */ XMPushService a;

    k(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void b() {
        ArrayList arrayList;
        synchronized (j.c) {
            arrayList = new ArrayList(j.d);
            j.d.clear();
        }
        j.b(this.a, arrayList);
    }
}
