package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.service.C2030bq;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ac */
final class C1971ac extends C2030bq.C2031a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3657a;

    /* renamed from: a */
    final /* synthetic */ C2071n f3658a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1971ac(String str, long j, XMPushService xMPushService, C2071n nVar) {
        super(str, j);
        this.f3657a = xMPushService;
        this.f3658a = nVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18443a(C2030bq bqVar) {
        String a = bqVar.mo18509a("GAID", "gaid");
        String a2 = C1907j.m4553a((Context) this.f3657a);
        if (!TextUtils.isEmpty(a2) && !TextUtils.equals(a, a2)) {
            bqVar.mo18511a("GAID", "gaid", a2);
            C1894in inVar = new C1894in();
            inVar.mo18084b(this.f3658a.f3929d);
            inVar.mo18087c(C1878hy.ClientInfoUpdate.f2959a);
            inVar.mo18078a(C1999aw.m5064a());
            inVar.mo18080a((Map<String, String>) new HashMap());
            inVar.mo18077a().put("gaid", a2);
            byte[] a3 = C1905iy.m4543a(C1970ab.m4880a(this.f3657a.getPackageName(), this.f3658a.f3929d, inVar, C1868ho.Notification));
            XMPushService xMPushService = this.f3657a;
            xMPushService.mo18417a(xMPushService.getPackageName(), a3, true);
        }
    }
}
