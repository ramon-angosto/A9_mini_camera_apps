package com.huawei.hms.framework.network.grs.p016c;

import com.huawei.hms.framework.network.grs.p014a.C0728c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.framework.network.grs.c.d */
class C0746d implements Callable<C0748f> {

    /* renamed from: a */
    final /* synthetic */ ExecutorService f513a;

    /* renamed from: b */
    final /* synthetic */ String f514b;

    /* renamed from: c */
    final /* synthetic */ C0728c f515c;

    /* renamed from: d */
    final /* synthetic */ C0747e f516d;

    C0746d(C0747e eVar, ExecutorService executorService, String str, C0728c cVar) {
        this.f516d = eVar;
        this.f513a = executorService;
        this.f514b = str;
        this.f515c = cVar;
    }

    public C0748f call() {
        return this.f516d.m588b(this.f513a, this.f514b, this.f515c);
    }
}
