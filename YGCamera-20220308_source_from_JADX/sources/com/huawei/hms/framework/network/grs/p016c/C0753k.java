package com.huawei.hms.framework.network.grs.p016c;

import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.c.k */
class C0753k implements Callable<C0748f> {

    /* renamed from: a */
    final /* synthetic */ C0743c f553a;

    /* renamed from: b */
    final /* synthetic */ String f554b;

    /* renamed from: c */
    final /* synthetic */ C0728c f555c;

    /* renamed from: d */
    final /* synthetic */ C0755m f556d;

    C0753k(C0755m mVar, C0743c cVar, String str, C0728c cVar2) {
        this.f556d = mVar;
        this.f553a = cVar;
        this.f554b = str;
        this.f555c = cVar2;
    }

    public C0748f call() {
        return new C0747e(this.f553a, this.f556d.f565d).mo13859a(this.f556d.f562a, this.f554b, this.f555c);
    }
}
