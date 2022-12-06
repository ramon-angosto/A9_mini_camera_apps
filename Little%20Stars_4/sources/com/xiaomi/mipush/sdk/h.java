package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.s;
import java.util.HashMap;
import java.util.Map;

final class h implements Runnable {
    h() {
    }

    public void run() {
        if (e.c(MiPushClient.sContext) != null) {
            s sVar = new s();
            sVar.b(a.a(MiPushClient.sContext).c());
            sVar.c("client_info_update");
            sVar.a(MiPushClient.generatePacketID());
            sVar.a((Map<String, String>) new HashMap());
            sVar.h().put(Constants.EXTRA_KEY_IMEI_MD5, d.a(e.c(MiPushClient.sContext)));
            int b = e.b();
            if (b >= 0) {
                sVar.h().put("space_id", Integer.toString(b));
            }
            o.a(MiPushClient.sContext).a(sVar, a.Notification, false, (i) null);
        }
    }
}
