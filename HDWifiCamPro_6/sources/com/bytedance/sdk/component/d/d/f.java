package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;

/* compiled from: DiskCacheVisitor */
public class f extends a {
    public String a() {
        return "disk_cache";
    }

    public void a(c cVar) {
        String i = cVar.i();
        com.bytedance.sdk.component.d.c c = cVar.r().c(cVar.s());
        if (c == null) {
            cVar.a((i) new k());
            return;
        }
        byte[] bArr = (byte[]) c.a(i);
        if (bArr == null) {
            cVar.a((i) new k());
            return;
        }
        cVar.a((i) new b(bArr, (com.bytedance.sdk.component.d.f) null));
        cVar.r().b(cVar.s()).a(i, bArr);
    }
}
