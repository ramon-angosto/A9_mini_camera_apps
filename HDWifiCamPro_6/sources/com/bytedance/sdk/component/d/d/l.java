package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.f;

/* compiled from: RawCacheVisitor */
public class l extends a {
    public String a() {
        return "raw_cache";
    }

    public void a(c cVar) {
        byte[] bArr = (byte[]) cVar.r().b(cVar.s()).a(cVar.i());
        if (bArr == null) {
            cVar.a((i) new f());
        } else {
            cVar.a((i) new b(bArr, (f) null));
        }
    }
}
