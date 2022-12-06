package com.bytedance.sdk.component.adexpress.b;

import com.bytedance.sdk.component.adexpress.b.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RenderRealChain */
public class k implements i.a {
    n a;
    private List<i> b;
    private h c;
    private AtomicBoolean d = new AtomicBoolean(false);

    public k(List<i> list, h hVar) {
        this.b = list;
        this.c = hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000b A[LOOP:0: B:1:0x000b->B:4:0x001b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r2 = this;
            com.bytedance.sdk.component.adexpress.b.h r0 = r2.c
            r0.a()
            java.util.List<com.bytedance.sdk.component.adexpress.b.i> r0 = r2.b
            java.util.Iterator r0 = r0.iterator()
        L_0x000b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            com.bytedance.sdk.component.adexpress.b.i r1 = (com.bytedance.sdk.component.adexpress.b.i) r1
            boolean r1 = r1.a(r2)
            if (r1 == 0) goto L_0x000b
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.b.k.a():void");
    }

    public void a(i iVar) {
        int indexOf = this.b.indexOf(iVar);
        if (indexOf >= 0) {
            do {
                indexOf++;
                if (indexOf >= this.b.size() || this.b.get(indexOf).a(this)) {
                }
                indexOf++;
                return;
            } while (this.b.get(indexOf).a(this));
        }
    }

    public boolean b(i iVar) {
        int indexOf = this.b.indexOf(iVar);
        return indexOf < this.b.size() - 1 && indexOf >= 0;
    }

    public n b() {
        return this.a;
    }

    public void a(n nVar) {
        this.a = nVar;
    }

    public void a(boolean z) {
        this.d.getAndSet(z);
    }

    public boolean c() {
        return this.d.get();
    }
}
