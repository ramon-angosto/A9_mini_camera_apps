package com.meizu.cloud.pushsdk.a.d;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.meizu.cloud.pushsdk.a.h.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class h extends j {
    public static final g a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");
    public static final g c = g.a("multipart/digest");
    public static final g d = g.a("multipart/parallel");
    public static final g e = g.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final d i;
    private final g j;
    private final g k;
    private final List<b> l;
    private long m = -1;

    h(d dVar, g gVar, List<b> list) {
        this.i = dVar;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + dVar.a());
        this.l = m.a(list);
    }

    public g a() {
        return this.k;
    }

    public long b() throws IOException {
        long j2 = this.m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((com.meizu.cloud.pushsdk.a.h.b) null, true);
        this.m = a2;
        return a2;
    }

    public void a(com.meizu.cloud.pushsdk.a.h.b bVar) throws IOException {
        a(bVar, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.meizu.cloud.pushsdk.a.h.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.meizu.cloud.pushsdk.a.h.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.meizu.cloud.pushsdk.a.h.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: com.meizu.cloud.pushsdk.a.h.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.meizu.cloud.pushsdk.a.h.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(com.meizu.cloud.pushsdk.a.h.b r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            com.meizu.cloud.pushsdk.a.h.a r13 = new com.meizu.cloud.pushsdk.a.h.a
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<com.meizu.cloud.pushsdk.a.d.h$b> r1 = r12.l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00ab
            java.util.List<com.meizu.cloud.pushsdk.a.d.h$b> r6 = r12.l
            java.lang.Object r6 = r6.get(r3)
            com.meizu.cloud.pushsdk.a.d.h$b r6 = (com.meizu.cloud.pushsdk.a.d.h.b) r6
            com.meizu.cloud.pushsdk.a.d.c r7 = r6.a
            com.meizu.cloud.pushsdk.a.d.j r6 = r6.b
            byte[] r8 = h
            r13.c(r8)
            com.meizu.cloud.pushsdk.a.h.d r8 = r12.i
            r13.b((com.meizu.cloud.pushsdk.a.h.d) r8)
            byte[] r8 = g
            r13.c(r8)
            if (r7 == 0) goto L_0x005d
            int r8 = r7.a()
            r9 = 0
        L_0x003d:
            if (r9 >= r8) goto L_0x005d
            java.lang.String r10 = r7.a((int) r9)
            com.meizu.cloud.pushsdk.a.h.b r10 = r13.b((java.lang.String) r10)
            byte[] r11 = f
            com.meizu.cloud.pushsdk.a.h.b r10 = r10.c(r11)
            java.lang.String r11 = r7.b(r9)
            com.meizu.cloud.pushsdk.a.h.b r10 = r10.b((java.lang.String) r11)
            byte[] r11 = g
            r10.c(r11)
            int r9 = r9 + 1
            goto L_0x003d
        L_0x005d:
            com.meizu.cloud.pushsdk.a.d.g r7 = r6.a()
            if (r7 == 0) goto L_0x0076
            java.lang.String r8 = "Content-Type: "
            com.meizu.cloud.pushsdk.a.h.b r8 = r13.b((java.lang.String) r8)
            java.lang.String r7 = r7.toString()
            com.meizu.cloud.pushsdk.a.h.b r7 = r8.b((java.lang.String) r7)
            byte[] r8 = g
            r7.c(r8)
        L_0x0076:
            long r7 = r6.b()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0090
            java.lang.String r9 = "Content-Length: "
            com.meizu.cloud.pushsdk.a.h.b r9 = r13.b((java.lang.String) r9)
            com.meizu.cloud.pushsdk.a.h.b r9 = r9.e(r7)
            byte[] r10 = g
            r9.c(r10)
            goto L_0x0096
        L_0x0090:
            if (r14 == 0) goto L_0x0096
            r0.j()
            return r9
        L_0x0096:
            byte[] r9 = g
            r13.c(r9)
            if (r14 == 0) goto L_0x009f
            long r4 = r4 + r7
            goto L_0x00a2
        L_0x009f:
            r6.a(r13)
        L_0x00a2:
            byte[] r6 = g
            r13.c(r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00ab:
            byte[] r1 = h
            r13.c(r1)
            com.meizu.cloud.pushsdk.a.h.d r1 = r12.i
            r13.b((com.meizu.cloud.pushsdk.a.h.d) r1)
            byte[] r1 = h
            r13.c(r1)
            byte[] r1 = g
            r13.c(r1)
            if (r14 == 0) goto L_0x00c9
            long r13 = r0.a()
            long r4 = r4 + r13
            r0.j()
        L_0x00c9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.d.h.a(com.meizu.cloud.pushsdk.a.h.b, boolean):long");
    }

    public static final class b {
        /* access modifiers changed from: private */
        public final c a;
        /* access modifiers changed from: private */
        public final j b;

        public static b a(c cVar, j jVar) {
            if (jVar == null) {
                throw new NullPointerException("body == null");
            } else if (cVar != null && cVar.a(HttpHeaders.CONTENT_TYPE) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (cVar == null || cVar.a(HttpHeaders.CONTENT_LENGTH) == null) {
                return new b(cVar, jVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private b(c cVar, j jVar) {
            this.a = cVar;
            this.b = jVar;
        }
    }

    public static final class a {
        private final d a;
        private g b;
        private final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.a;
            this.c = new ArrayList();
            this.a = d.a(str);
        }

        public a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("type == null");
            } else if (gVar.a().equals("multipart")) {
                this.b = gVar;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + gVar);
            }
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public h a() {
            if (!this.c.isEmpty()) {
                return new h(this.a, this.b, this.c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}
