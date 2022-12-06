package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1759ee;
import com.xiaomi.push.C1764ej;
import com.xiaomi.push.C1768en;
import com.xiaomi.push.C1866hm;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.service.bf */
public class C2018bf implements C1768en {
    /* renamed from: a */
    public void mo17185a(Context context, HashMap<String, String> hashMap) {
        C1894in inVar = new C1894in();
        inVar.mo18084b(C1764ej.m3355a(context).mo17523a());
        inVar.mo18091d(C1764ej.m3355a(context).mo17530b());
        inVar.mo18087c(C1878hy.AwakeAppResponse.f2959a);
        inVar.mo18078a(C1999aw.m5064a());
        inVar.f3224a = hashMap;
        byte[] a = C1905iy.m4543a(C1970ab.m4880a(inVar.mo18088c(), inVar.mo18085b(), inVar, C1868ho.Notification));
        if (context instanceof XMPushService) {
            C1524b.m2141a("MoleInfo : send data directly in pushLayer " + inVar.mo18077a());
            ((XMPushService) context).mo18417a(context.getPackageName(), a, true);
            return;
        }
        C1524b.m2141a("MoleInfo : context is not correct in pushLayer " + inVar.mo18077a());
    }

    /* renamed from: b */
    public void mo17186b(Context context, HashMap<String, String> hashMap) {
        C1866hm a = C1866hm.m3887a(context);
        if (a != null) {
            a.mo17764a("category_awake_app", "wake_up_app", 1, C1759ee.m3332a(hashMap));
        }
    }

    /* renamed from: c */
    public void mo17187c(Context context, HashMap<String, String> hashMap) {
        C1524b.m2141a("MoleInfo：　" + C1759ee.m3334b(hashMap));
    }
}
