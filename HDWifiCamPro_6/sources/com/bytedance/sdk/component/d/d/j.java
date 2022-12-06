package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.u;

/* compiled from: MemoryCacheVisitor */
public class j extends a {
    public String a() {
        return "memory_cache";
    }

    public void a(c cVar) {
        Object obj;
        u k = cVar.k();
        if (k == u.BITMAP || k == u.AUTO) {
            obj = cVar.r().a(cVar.s()).a(cVar.e());
        } else {
            obj = null;
        }
        if (obj == null) {
            cVar.a((i) new l());
        } else {
            cVar.a((i) new m(obj, (f) null, false));
        }
    }
}
