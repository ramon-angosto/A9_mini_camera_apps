package ms.bd.o.Pgl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;

public final class p0 extends o0 {
    /* access modifiers changed from: private */
    public long a;

    class pgla implements NetworkParams.AddSecurityFactorProcessCallback {
        pgla() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r9v7, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0159  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<java.lang.String, java.lang.String> onCallToAddSecurityFactor(java.lang.String r19, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r20) {
            /*
                r18 = this;
                r0 = r18
                r5 = r19
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                if (r5 == 0) goto L_0x016e
                if (r20 != 0) goto L_0x000f
                goto L_0x016e
            L_0x000f:
                java.lang.String r1 = r19.toLowerCase()
                r2 = 4
                byte[] r13 = new byte[r2]
                r13 = {42, 117, 81, 5} // fill-array
                r8 = 16777217(0x1000001, float:2.350989E-38)
                r9 = 0
                r10 = 0
                java.lang.String r12 = "3c6a83"
                java.lang.Object r3 = ms.bd.o.Pgl.pblk.a(r8, r9, r10, r12, r13)
                java.lang.String r3 = (java.lang.String) r3
                boolean r3 = r1.contains(r3)
                r4 = 2
                if (r3 != 0) goto L_0x007d
                r3 = 5
                byte[] r13 = new byte[r3]
                r13 = {33, 46, 4, 86, 73} // fill-array
                r8 = 16777217(0x1000001, float:2.350989E-38)
                r9 = 0
                r10 = 0
                java.lang.String r12 = "88c2e2"
                java.lang.Object r3 = ms.bd.o.Pgl.pblk.a(r8, r9, r10, r12, r13)
                java.lang.String r3 = (java.lang.String) r3
                boolean r3 = r1.contains(r3)
                if (r3 != 0) goto L_0x007d
                byte[] r13 = new byte[r4]
                r13 = {63, 39} // fill-array
                r8 = 16777217(0x1000001, float:2.350989E-38)
                r9 = 0
                r10 = 0
                java.lang.String r12 = "96cf73"
                java.lang.Object r3 = ms.bd.o.Pgl.pblk.a(r8, r9, r10, r12, r13)
                java.lang.String r3 = (java.lang.String) r3
                boolean r3 = r1.contains(r3)
                if (r3 == 0) goto L_0x0062
                goto L_0x007d
            L_0x0062:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r2 = 25
                byte[] r8 = new byte[r2]
                r8 = {125, 36, 6, 78, 75, 61, 114, 83, 102, 98, 52, 56, 82, 87, 78, 97, 110, 7, 112, 119, 103, 127, 81, 80, 77} // fill-array
                r3 = 16777217(0x1000001, float:2.350989E-38)
                r4 = 0
                r5 = 0
                java.lang.String r7 = "e257a9"
                java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r3, r4, r5, r7, r8)
                java.lang.String r2 = (java.lang.String) r2
                r1.<init>(r2)
                throw r1
            L_0x007d:
                ms.bd.o.Pgl.y0 r3 = ms.bd.o.Pgl.y0.a()
                r3.c()
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Set r6 = r20.entrySet()
                java.util.Iterator r6 = r6.iterator()
            L_0x0091:
                boolean r8 = r6.hasNext()
                r9 = 0
                r10 = 0
                if (r8 == 0) goto L_0x00cf
                java.lang.Object r8 = r6.next()
                java.util.Map$Entry r8 = (java.util.Map.Entry) r8
                java.lang.Object r11 = r8.getKey()
                java.lang.String r11 = (java.lang.String) r11
                java.lang.Object r12 = r8.getValue()
                if (r12 == 0) goto L_0x00c4
                java.lang.Object r12 = r8.getValue()
                java.util.List r12 = (java.util.List) r12
                int r12 = r12.size()
                if (r12 <= 0) goto L_0x00c4
                java.lang.Object r8 = r8.getValue()
                java.util.List r8 = (java.util.List) r8
                java.lang.Object r8 = r8.get(r10)
                r9 = r8
                java.lang.String r9 = (java.lang.String) r9
            L_0x00c4:
                if (r11 == 0) goto L_0x0091
                if (r9 == 0) goto L_0x0091
                r3.add(r11)
                r3.add(r9)
                goto L_0x0091
            L_0x00cf:
                byte[] r2 = new byte[r2]
                r2 = {46, 119, 84, 84} // fill-array
                r12 = 16777217(0x1000001, float:2.350989E-38)
                r13 = 0
                r14 = 0
                java.lang.String r16 = "7a30e4"
                r17 = r2
                java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r12, r13, r14, r16, r17)
                java.lang.String r2 = (java.lang.String) r2
                boolean r2 = r1.startsWith(r2)
                if (r2 == 0) goto L_0x0107
                java.lang.String[] r1 = new java.lang.String[r10]
                java.lang.Object[] r1 = r3.toArray(r1)
                r6 = r1
                java.lang.String[] r6 = (java.lang.String[]) r6
                ms.bd.o.Pgl.p0 r1 = ms.bd.o.Pgl.p0.this
                long r3 = r1.a
                r1 = 50331649(0x3000001, float:3.7615824E-37)
                r2 = 0
                r5 = r19
                java.lang.Object r1 = ms.bd.o.Pgl.pblb.a(r1, r2, r3, r5, r6)
            L_0x0103:
                r9 = r1
                java.lang.String[] r9 = (java.lang.String[]) r9
                goto L_0x0157
            L_0x0107:
                byte[] r2 = new byte[r4]
                r2 = {49, 37} // fill-array
                r11 = 16777217(0x1000001, float:2.350989E-38)
                r12 = 0
                r13 = 0
                java.lang.String r15 = "746072"
                r16 = r2
                java.lang.Object r2 = ms.bd.o.Pgl.pblk.a(r11, r12, r13, r15, r16)
                java.lang.String r2 = (java.lang.String) r2
                boolean r1 = r1.startsWith(r2)
                if (r1 == 0) goto L_0x0157
                r1 = 3
                byte[] r1 = new byte[r1]
                r1 = {16, 8, 107} // fill-array
                r11 = 16777217(0x1000001, float:2.350989E-38)
                r12 = 0
                r13 = 0
                java.lang.String r15 = "48481f"
                r16 = r1
                java.lang.Object r1 = ms.bd.o.Pgl.pblk.a(r11, r12, r13, r15, r16)
                java.lang.String r1 = (java.lang.String) r1
                r3.add(r1)
                r3.add(r5)
                java.lang.String[] r1 = new java.lang.String[r10]
                java.lang.Object[] r1 = r3.toArray(r1)
                r16 = r1
                java.lang.String[] r16 = (java.lang.String[]) r16
                ms.bd.o.Pgl.p0 r1 = ms.bd.o.Pgl.p0.this
                long r13 = r1.a
                r11 = 100663297(0x6000001, float:2.4074127E-35)
                r15 = 0
                java.lang.Object r1 = ms.bd.o.Pgl.pblb.a(r11, r12, r13, r15, r16)
                goto L_0x0103
            L_0x0157:
                if (r9 == 0) goto L_0x016e
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
            L_0x015e:
                int r2 = r9.length
                if (r10 >= r2) goto L_0x016d
                r2 = r9[r10]
                int r3 = r10 + 1
                r3 = r9[r3]
                r1.put(r2, r3)
                int r10 = r10 + 2
                goto L_0x015e
            L_0x016d:
                return r1
            L_0x016e:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.p0.pgla.onCallToAddSecurityFactor(java.lang.String, java.util.Map):java.util.Map");
        }
    }

    /* access modifiers changed from: protected */
    public Object a(long j) {
        this.a = j;
        pgla pgla2 = new pgla();
        synchronized (this) {
            NetworkParams.setAddSecurityFactorProcessCallback(pgla2);
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        pblb.a(50331650, this.a);
        pblk.a(100663298, 0, this.a, (String) null, (Object) null);
        this.a = -1;
        super.finalize();
    }
}
