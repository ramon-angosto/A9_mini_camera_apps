package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C2003az;

/* renamed from: com.xiaomi.push.service.ae */
final class C1973ae implements C2003az.C2005b.C2006a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3661a;

    C1973ae(XMPushService xMPushService) {
        this.f3661a = xMPushService;
    }

    /* renamed from: a */
    public void mo17751a(C2003az.C2009c cVar, C2003az.C2009c cVar2, int i) {
        if (cVar2 == C2003az.C2009c.binded) {
            C2076r.m5326a(this.f3661a);
            C2076r.m5328b(this.f3661a);
        } else if (cVar2 == C2003az.C2009c.unbind) {
            C2076r.m5324a(this.f3661a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
