package com.xiaomi.clientreport.manager;

import com.xiaomi.push.C1664bp;

/* renamed from: com.xiaomi.clientreport.manager.h */
class C1535h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1528a f1605a;

    /* renamed from: a */
    final /* synthetic */ C1664bp f1606a;

    C1535h(C1528a aVar, C1664bp bpVar) {
        this.f1605a = aVar;
        this.f1606a = bpVar;
    }

    public void run() {
        this.f1606a.run();
    }
}
