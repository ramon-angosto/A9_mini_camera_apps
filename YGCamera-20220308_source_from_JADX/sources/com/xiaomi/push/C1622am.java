package com.xiaomi.push;

import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.am */
class C1622am extends C1618ak.C1620b {

    /* renamed from: a */
    final /* synthetic */ C1618ak f1776a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1622am(C1618ak akVar, C1618ak.C1619a aVar) {
        super(aVar);
        this.f1776a = akVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo17221b() {
        synchronized (C1618ak.m2517a(this.f1776a)) {
            C1618ak.m2517a(this.f1776a).remove(this.f1772a.mo16986a());
        }
    }
}
