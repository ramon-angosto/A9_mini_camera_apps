package com.xiaomi.push;

/* renamed from: com.xiaomi.push.df */
class C1717df implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2017a;

    /* renamed from: a */
    final /* synthetic */ C1716de f2018a;

    /* renamed from: a */
    final /* synthetic */ Thread f2019a;

    /* renamed from: a */
    final /* synthetic */ Throwable f2020a;

    C1717df(C1716de deVar, Thread thread, Throwable th, int i) {
        this.f2018a = deVar;
        this.f2019a = thread;
        this.f2020a = th;
        this.f2017a = i;
    }

    public void run() {
        this.f2018a.f2016a.m2983a(this.f2019a, this.f2020a, this.f2017a);
    }
}
