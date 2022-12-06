package com.xiaomi.push;

import com.xiaomi.push.C1623an;
import com.xiaomi.push.C1722dk;

/* renamed from: com.xiaomi.push.dm */
class C1727dm extends C1623an.C1625b {

    /* renamed from: a */
    C1623an.C1625b f2055a;

    /* renamed from: a */
    final /* synthetic */ C1722dk f2056a;

    C1727dm(C1722dk dkVar) {
        this.f2056a = dkVar;
    }

    /* renamed from: b */
    public void mo17228b() {
        C1722dk.C1724b bVar = (C1722dk.C1724b) C1722dk.m3008a(this.f2056a).peek();
        if (bVar != null && bVar.mo17227a()) {
            if (C1722dk.m3008a(this.f2056a).remove(bVar)) {
                this.f2055a = bVar;
            }
            C1623an.C1625b bVar2 = this.f2055a;
            if (bVar2 != null) {
                bVar2.mo17228b();
            }
        }
    }

    /* renamed from: c */
    public void mo17229c() {
        C1623an.C1625b bVar = this.f2055a;
        if (bVar != null) {
            bVar.mo17229c();
        }
    }
}
