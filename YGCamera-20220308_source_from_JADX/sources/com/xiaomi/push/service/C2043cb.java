package com.xiaomi.push.service;

import com.xiaomi.push.C1809fu;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.cb */
class C2043cb extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3864a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2043cb(XMPushService xMPushService, int i) {
        super(i);
        this.f3864a = xMPushService;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "disconnect for service destroy.";
    }

    /* renamed from: a */
    public void m5201a() {
        if (XMPushService.m4759a(this.f3864a) != null) {
            XMPushService.m4759a(this.f3864a).mo17662b(15, (Exception) null);
            C1809fu unused = this.f3864a.f3601a = null;
        }
    }
}
