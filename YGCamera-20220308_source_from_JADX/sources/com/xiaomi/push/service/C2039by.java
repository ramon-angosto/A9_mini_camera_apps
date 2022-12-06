package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;

/* renamed from: com.xiaomi.push.service.by */
final class C2039by implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1894in f3857a;

    C2039by(C1894in inVar) {
        this.f3857a = inVar;
    }

    public void run() {
        byte[] a = C1905iy.m4543a(C1970ab.m4880a(this.f3857a.mo18088c(), this.f3857a.mo18085b(), this.f3857a, C1868ho.Notification));
        if (C2038bx.mo17759a() instanceof XMPushService) {
            ((XMPushService) C2038bx.mo17759a()).mo18417a(this.f3857a.mo18088c(), a, true);
        } else {
            C1524b.m2141a("UNDatas UploadNotificationDatas failed because not xmsf");
        }
    }
}
