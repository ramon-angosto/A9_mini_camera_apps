package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.ch */
class C2049ch extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3870a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2049ch(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f3870a = xMPushService;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean b = XMPushService.m4783b(this.f3870a);
        C1524b.m2141a("SuperPowerMode:" + b);
        XMPushService.m4759a(this.f3870a);
        if (b) {
            XMPushService xMPushService = this.f3870a;
            xMPushService.mo18412a((XMPushService.C1956i) new XMPushService.C1953f(24, (Exception) null));
            return;
        }
        this.f3870a.mo18418a(true);
    }
}
