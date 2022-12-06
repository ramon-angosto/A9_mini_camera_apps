package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.cw */
class C1706cw extends C1698cq {

    /* renamed from: a */
    C1698cq f1988a = this.f1990b;

    /* renamed from: a */
    final /* synthetic */ C1702cu f1989a;

    /* renamed from: b */
    final /* synthetic */ C1698cq f1990b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1706cw(C1702cu cuVar, String str, C1698cq cqVar) {
        super(str);
        this.f1989a = cuVar;
        this.f1990b = cqVar;
        this.f1959b = this.f1959b;
        C1698cq cqVar2 = this.f1990b;
        if (cqVar2 != null) {
            this.f1963f = cqVar2.f1963f;
        }
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo17333a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f1988a != null) {
            arrayList.addAll(this.f1988a.mo17333a(true));
        }
        synchronized (C1702cu.f1976b) {
            C1698cq cqVar = C1702cu.f1976b.get(this.f1959b);
            if (cqVar != null) {
                Iterator<String> it = cqVar.mo17333a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f1959b);
                arrayList.add(this.f1959b);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void mo17340a(String str, C1697cp cpVar) {
        if (this.f1988a != null) {
            this.f1988a.mo17340a(str, cpVar);
        }
    }

    /* renamed from: b */
    public boolean mo17346b() {
        return false;
    }
}
