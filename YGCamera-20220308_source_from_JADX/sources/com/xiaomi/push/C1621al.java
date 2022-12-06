package com.xiaomi.push;

import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.al */
class C1621al extends C1618ak.C1620b {

    /* renamed from: a */
    final /* synthetic */ C1618ak f1773a;

    /* renamed from: a */
    final /* synthetic */ String f1774a;

    /* renamed from: a */
    final /* synthetic */ boolean f1775a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1621al(C1618ak akVar, C1618ak.C1619a aVar, boolean z, String str) {
        super(aVar);
        this.f1773a = akVar;
        this.f1775a = z;
        this.f1774a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17220a() {
        super.mo17220a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo17221b() {
        if (!this.f1775a) {
            C1618ak.m2517a(this.f1773a).edit().putLong(this.f1774a, System.currentTimeMillis()).commit();
        }
    }
}
