package com.xiaomi.push;

import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1685ci;
import java.util.ArrayList;

/* renamed from: com.xiaomi.push.cj */
class C1691cj extends C1618ak.C1619a {

    /* renamed from: a */
    final /* synthetic */ C1685ci f1944a;

    C1691cj(C1685ci ciVar) {
        this.f1944a = ciVar;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "100957";
    }

    public void run() {
        synchronized (this.f1944a.f1922a) {
            if (this.f1944a.f1922a.size() > 0) {
                if (this.f1944a.f1922a.size() > 1) {
                    this.f1944a.mo17314a((ArrayList<C1685ci.C1686a>) this.f1944a.f1922a);
                } else {
                    this.f1944a.mo17315b((C1685ci.C1686a) this.f1944a.f1922a.get(0));
                }
                this.f1944a.f1922a.clear();
                System.gc();
            }
        }
    }
}
