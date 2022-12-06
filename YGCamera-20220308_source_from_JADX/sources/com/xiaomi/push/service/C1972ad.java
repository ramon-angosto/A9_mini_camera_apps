package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.C1640az;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.service.C2030bq;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ad */
final class C1972ad extends C2030bq.C2031a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3659a;

    /* renamed from: a */
    final /* synthetic */ C2071n f3660a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1972ad(String str, long j, XMPushService xMPushService, C2071n nVar) {
        super(str, j);
        this.f3659a = xMPushService;
        this.f3660a = nVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18443a(C2030bq bqVar) {
        C1640az a = C1640az.m2599a((Context) this.f3659a);
        String a2 = bqVar.mo18509a("MSAID", "msaid");
        String str = a.mo17232a() + a.mo17233b() + a.mo17234c() + a.mo17235d();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a2, str)) {
            bqVar.mo18511a("MSAID", "msaid", str);
            C1894in inVar = new C1894in();
            inVar.mo18084b(this.f3660a.f3929d);
            inVar.mo18087c(C1878hy.ClientInfoUpdate.f2959a);
            inVar.mo18078a(C1999aw.m5064a());
            inVar.mo18080a((Map<String, String>) new HashMap());
            a.mo17240a((Map<String, String>) inVar.mo18077a());
            byte[] a3 = C1905iy.m4543a(C1970ab.m4880a(this.f3659a.getPackageName(), this.f3660a.f3929d, inVar, C1868ho.Notification));
            XMPushService xMPushService = this.f3659a;
            xMPushService.mo18417a(xMPushService.getPackageName(), a3, true);
        }
    }
}
