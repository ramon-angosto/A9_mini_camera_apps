package com.xiaomi.push.service;

import com.xiaomi.push.protobuf.b;
import com.xiaomi.smack.b;
import com.xiaomi.smack.e;
import java.util.Map;

class am extends b {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    am(XMPushService xMPushService, Map map, int i, String str, e eVar) {
        super(map, i, str, eVar);
        this.a = xMPushService;
    }

    public byte[] a() {
        try {
            b.a aVar = new b.a();
            aVar.a(ah.a().c());
            return aVar.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
