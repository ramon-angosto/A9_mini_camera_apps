package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.cg */
class C2048cg extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3869a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2048cg(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f3869a = xMPushService;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean a = XMPushService.m4759a(this.f3869a);
        C1524b.m2141a("ExtremePowerMode:" + a);
        if (a) {
            XMPushService xMPushService = this.f3869a;
            xMPushService.mo18412a((XMPushService.C1956i) new XMPushService.C1953f(23, (Exception) null));
            return;
        }
        this.f3869a.mo18418a(true);
    }
}
