package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.C1811fv;
import com.xiaomi.push.C1814fy;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ce */
class C2046ce extends C1811fv {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3867a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2046ce(XMPushService xMPushService, Map map, int i, String str, C1814fy fyVar) {
        super(map, i, str, fyVar);
        this.f3867a = xMPushService;
    }

    /* renamed from: a */
    public byte[] mo17670a() {
        try {
            C1747ed.C1749b bVar = new C1747ed.C1749b();
            bVar.mo17444a(C2027bo.mo18506a().mo18506a());
            return bVar.mo17407a();
        } catch (Exception e) {
            C1524b.m2141a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
