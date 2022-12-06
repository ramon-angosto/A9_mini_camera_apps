package com.xiaomi.mipush.sdk;

import com.xiaomi.push.C1873ht;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.mipush.sdk.g */
class C1584g extends C1995at.C1996a {

    /* renamed from: a */
    final /* synthetic */ C1583f f1722a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1584g(C1583f fVar, int i, String str) {
        super(i, str);
        this.f1722a = fVar;
    }

    /* access modifiers changed from: protected */
    public void onCallback() {
        boolean a = C1995at.m5047a(C1583f.m2418a(this.f1722a)).mo18472a(C1873ht.AggregatePushSwitch.mo17806a(), true);
        if (C1583f.m2418a(this.f1722a) != a) {
            boolean unused = this.f1722a.f1721a = a;
            C1586i.m2443b(C1583f.m2418a(this.f1722a));
        }
    }
}
