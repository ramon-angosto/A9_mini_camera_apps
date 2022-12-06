package com.xiaomi.mipush.sdk;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1759ee;
import com.xiaomi.push.C1764ej;
import com.xiaomi.push.C1768en;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.C1999aw;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.c */
public class C1580c implements C1768en {
    /* renamed from: a */
    public void mo17185a(Context context, HashMap<String, String> hashMap) {
        C1894in inVar = new C1894in();
        inVar.mo18084b(C1764ej.m3355a(context).mo17523a());
        inVar.mo18091d(C1764ej.m3355a(context).mo17530b());
        inVar.mo18087c(C1878hy.AwakeAppResponse.f2959a);
        inVar.mo18078a(C1999aw.m5064a());
        inVar.f3224a = hashMap;
        C1568ao.m2317a(context).mo17144a(inVar, C1868ho.Notification, true, (C1882ib) null, true);
        C1524b.m2141a("MoleInfo：　send data in app layer");
    }

    /* renamed from: b */
    public void mo17186b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1, C1759ee.m3332a(hashMap));
        C1524b.m2141a("MoleInfo：　send data in app layer");
    }

    /* renamed from: c */
    public void mo17187c(Context context, HashMap<String, String> hashMap) {
        C1524b.m2141a("MoleInfo：　" + C1759ee.m3334b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(PointerIconCompat.TYPE_CROSSHAIR).equals(hashMap.get("event_type"))) {
            C1593o.m2460a(context, str);
        }
    }
}
