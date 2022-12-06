package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.C1872hs;

/* renamed from: com.xiaomi.mipush.sdk.aa */
class C1554aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MiTinyDataClient.C1550a.C1551a f1641a;

    /* renamed from: a */
    final /* synthetic */ C1872hs f1642a;

    C1554aa(MiTinyDataClient.C1550a.C1551a aVar, C1872hs hsVar) {
        this.f1641a = aVar;
        this.f1642a = hsVar;
    }

    public void run() {
        this.f1641a.f1632a.add(this.f1642a);
        MiTinyDataClient.C1550a.C1551a.m2247a(this.f1641a);
    }
}
