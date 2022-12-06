package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.ca */
class C2042ca extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ XMPushService f3861a;

    /* renamed from: a */
    final /* synthetic */ String f3862a;

    /* renamed from: a */
    final /* synthetic */ byte[] f3863a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2042ca(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f3861a = xMPushService;
        this.f3862a = str;
        this.f3863a = bArr;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "send mi push message";
    }

    /* renamed from: a */
    public void m5199a() {
        try {
            C1970ab.m4888a(this.f3861a, this.f3862a, this.f3863a);
        } catch (C1823gf e) {
            C1524b.m2155a((Throwable) e);
            this.f3861a.mo18410a(10, (Exception) e);
        }
    }
}
