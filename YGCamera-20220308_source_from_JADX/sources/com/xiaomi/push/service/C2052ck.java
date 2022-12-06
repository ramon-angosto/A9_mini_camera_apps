package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C1611ad;
import com.xiaomi.push.C1811fv;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.ck */
class C2052ck extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3874a;

    /* renamed from: a */
    final /* synthetic */ String f3875a;

    /* renamed from: a */
    final /* synthetic */ byte[] f3876a;

    /* renamed from: b */
    final /* synthetic */ int f3877b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2052ck(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f3874a = xMPushService;
        this.f3877b = i2;
        this.f3876a = bArr;
        this.f3875a = str;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "clear account cache.";
    }

    /* renamed from: a */
    public void m5209a() {
        C2072o.m5301a((Context) this.f3874a);
        C2003az.mo18481a().mo18483a("5");
        C1611ad.m2505a(this.f3877b);
        XMPushService.m4759a(this.f3874a).mo17675c(C1811fv.mo17670a());
        this.f3874a.mo18419a(this.f3876a, this.f3875a);
    }
}
