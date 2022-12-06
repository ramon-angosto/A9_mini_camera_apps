package com.xiaomi.push;

/* renamed from: com.xiaomi.push.fr */
class C1805fr extends Thread {

    /* renamed from: a */
    final /* synthetic */ C1804fq f2418a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1805fr(C1804fq fqVar, String str) {
        super(str);
        this.f2418a = fqVar;
    }

    public void run() {
        try {
            this.f2418a.f2414a.mo17631a();
        } catch (Exception e) {
            this.f2418a.mo17679c(9, e);
        }
    }
}
