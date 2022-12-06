package com.huawei.hms.framework.network.grs.p016c;

import com.huawei.hms.framework.network.grs.C0729b;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;

/* renamed from: com.huawei.hms.framework.network.grs.c.l */
class C0754l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0743c f557a;

    /* renamed from: b */
    final /* synthetic */ String f558b;

    /* renamed from: c */
    final /* synthetic */ C0728c f559c;

    /* renamed from: d */
    final /* synthetic */ C0729b f560d;

    /* renamed from: e */
    final /* synthetic */ C0755m f561e;

    C0754l(C0755m mVar, C0743c cVar, String str, C0728c cVar2, C0729b bVar) {
        this.f561e = mVar;
        this.f557a = cVar;
        this.f558b = str;
        this.f559c = cVar2;
        this.f560d = bVar;
    }

    public void run() {
        C0755m mVar = this.f561e;
        mVar.m629a(mVar.mo13883a(this.f557a, this.f558b, this.f559c), this.f560d);
    }
}
