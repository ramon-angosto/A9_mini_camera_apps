package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;

/* compiled from: NetVisitor */
public class k extends a {
    public String a() {
        return "net_request";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.bytedance.sdk.component.d.c.c r7) {
        /*
            r6 = this;
            com.bytedance.sdk.component.d.c.f r0 = r7.r()
            com.bytedance.sdk.component.d.d r1 = r0.c()
            r2 = 0
            r7.a((boolean) r2)
            com.bytedance.sdk.component.d.b.c r2 = new com.bytedance.sdk.component.d.b.c     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r7.a()     // Catch:{ all -> 0x006e }
            boolean r4 = r7.l()     // Catch:{ all -> 0x006e }
            boolean r5 = r7.m()     // Catch:{ all -> 0x006e }
            r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x006e }
            com.bytedance.sdk.component.d.f r1 = r1.a(r2)     // Catch:{ all -> 0x006e }
            int r2 = r1.b()     // Catch:{ all -> 0x006e }
            com.bytedance.sdk.component.d.g r3 = r1.a()     // Catch:{ all -> 0x006e }
            r7.a((com.bytedance.sdk.component.d.g) r3)     // Catch:{ all -> 0x006e }
            int r3 = r1.b()     // Catch:{ all -> 0x006e }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x004f
            java.lang.Object r2 = r1.c()     // Catch:{ all -> 0x006e }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x006e }
            com.bytedance.sdk.component.d.d.b r3 = new com.bytedance.sdk.component.d.d.b     // Catch:{ all -> 0x006e }
            r3.<init>(r2, r1)     // Catch:{ all -> 0x006e }
            r7.a((com.bytedance.sdk.component.d.d.i) r3)     // Catch:{ all -> 0x006e }
            java.util.concurrent.ExecutorService r1 = r0.e()     // Catch:{ all -> 0x006e }
            com.bytedance.sdk.component.d.d.k$1 r3 = new com.bytedance.sdk.component.d.d.k$1     // Catch:{ all -> 0x006e }
            r3.<init>(r7, r0, r2)     // Catch:{ all -> 0x006e }
            r1.submit(r3)     // Catch:{ all -> 0x006e }
            goto L_0x0076
        L_0x004f:
            com.bytedance.sdk.component.d.p r0 = r0.g()     // Catch:{ all -> 0x006e }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x006e }
            r0.a(r3)     // Catch:{ all -> 0x006e }
            r0 = 0
            java.lang.Object r3 = r1.c()     // Catch:{ all -> 0x006e }
            boolean r4 = r3 instanceof java.lang.Throwable     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x0066
            r0 = r3
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x006e }
        L_0x0066:
            java.lang.String r1 = r1.d()     // Catch:{ all -> 0x006e }
            r6.a(r2, r1, r0, r7)     // Catch:{ all -> 0x006e }
            goto L_0x0076
        L_0x006e:
            r0 = move-exception
            r1 = 1004(0x3ec, float:1.407E-42)
            java.lang.String r2 = "net request failed!"
            r6.a(r1, r2, r0, r7)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.d.k.a(com.bytedance.sdk.component.d.c.c):void");
    }

    private void a(int i, String str, Throwable th, c cVar) {
        cVar.a((i) new h(i, str, th));
    }
}
