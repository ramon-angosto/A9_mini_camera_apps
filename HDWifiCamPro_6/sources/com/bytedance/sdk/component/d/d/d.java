package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.b;
import com.bytedance.sdk.component.d.c.c;

/* compiled from: CachePolicyVisitor */
public class d extends a {
    public String a() {
        return "cache_policy";
    }

    public void a(c cVar) {
        b s = cVar.s();
        if (s != null) {
            if (s.c()) {
                cVar.a((i) new j());
                return;
            } else if (s.d()) {
                cVar.a((i) new f());
                return;
            }
        }
        cVar.a((i) new k());
    }
}
