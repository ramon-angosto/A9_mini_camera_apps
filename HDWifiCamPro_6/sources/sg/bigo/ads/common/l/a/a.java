package sg.bigo.ads.common.l.a;

import java.io.Closeable;
import sg.bigo.ads.common.l.b;
import sg.bigo.ads.common.l.b.c;
import sg.bigo.ads.common.l.d;
import sg.bigo.ads.common.l.e;
import sg.bigo.ads.common.l.h;

public final class a implements d {
    private final b a = new b();
    private sg.bigo.ads.common.l.a b;

    /* renamed from: sg.bigo.ads.common.l.a.a$a  reason: collision with other inner class name */
    static class C0124a implements Closeable {
        private final d a;

        public C0124a(d dVar) {
            this.a = dVar;
        }

        public final void close() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a.disconnect();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0145 A[Catch:{ all -> 0x0182 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0148 A[Catch:{ all -> 0x0182 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(sg.bigo.ads.common.l.a.c r17, sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.c> r18, boolean r19) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            java.lang.String r5 = "AndroidNetClient"
            r0 = 9999000(0x989298, float:1.4011583E-38)
            android.net.TrafficStats.setThreadStatsTag(r0)
            r6 = 0
            r7 = 0
            sg.bigo.ads.common.l.a.d r8 = new sg.bigo.ads.common.l.a.d     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0139 }
            sg.bigo.ads.common.l.a.d$a r0 = r8.b()     // Catch:{ Exception -> 0x0137 }
            r9 = 3
            if (r0 == 0) goto L_0x006e
            sg.bigo.ads.common.l.b.c r10 = r2.a     // Catch:{ Exception -> 0x0137 }
            java.lang.String r11 = r0.c     // Catch:{ Exception -> 0x0137 }
            int r12 = r0.e     // Catch:{ Exception -> 0x0137 }
            r3.a(r10, r11, r12)     // Catch:{ Exception -> 0x0137 }
            int r10 = r0.a     // Catch:{ Exception -> 0x0137 }
            r11 = 2
            if (r10 != r11) goto L_0x006e
            java.net.URL r10 = r0.b     // Catch:{ Exception -> 0x0137 }
            if (r10 == 0) goto L_0x006e
            sg.bigo.ads.common.l.a.b r10 = r1.a     // Catch:{ Exception -> 0x0137 }
            java.net.URL r11 = r17.a()     // Catch:{ Exception -> 0x0137 }
            java.net.URL r12 = r0.b     // Catch:{ Exception -> 0x0137 }
            r10.a(r11, r12)     // Catch:{ Exception -> 0x0137 }
            java.net.URL r10 = r0.b     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.l.a.c r10 = r2.a(r10)     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            java.lang.String r12 = "process redirect, "
            r11.<init>(r12)     // Catch:{ Exception -> 0x0137 }
            java.net.URL r0 = r0.b     // Catch:{ Exception -> 0x0137 }
            r11.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.k.a.a(r6, r9, r5, r0)     // Catch:{ Exception -> 0x0137 }
            boolean r0 = r2.e     // Catch:{ Exception -> 0x0137 }
            if (r0 == 0) goto L_0x005f
            sg.bigo.ads.common.l.b.c r0 = r2.a     // Catch:{ Exception -> 0x0137 }
            java.lang.String r9 = "Accept-Encoding"
            r0.a(r9)     // Catch:{ Exception -> 0x0137 }
        L_0x005f:
            r1.a((sg.bigo.ads.common.l.a.c) r10, (sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.c>) r3, (boolean) r4)     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            java.net.HttpURLConnection r0 = r8.a
            r0.disconnect()
            android.net.TrafficStats.clearThreadStatsTag()
            return
        L_0x006e:
            sg.bigo.ads.common.l.b.c r10 = r2.a     // Catch:{ Exception -> 0x0137 }
            int r11 = r8.b     // Catch:{ Exception -> 0x0137 }
            boolean r10 = r3.a(r10, (int) r11)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r11 = ", responseCode = "
            if (r10 == 0) goto L_0x00c4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r0.<init>()     // Catch:{ Exception -> 0x0137 }
            r0.append(r2)     // Catch:{ Exception -> 0x0137 }
            r0.append(r11)     // Catch:{ Exception -> 0x0137 }
            int r10 = r8.b     // Catch:{ Exception -> 0x0137 }
            r0.append(r10)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r10 = ", is valid."
            r0.append(r10)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.k.a.a(r6, r9, r5, r0)     // Catch:{ Exception -> 0x0137 }
            java.io.InputStream r9 = r8.a()     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.l.c.a r0 = new sg.bigo.ads.common.l.c.a     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            sg.bigo.ads.common.l.b.c r10 = r2.a     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            int r11 = r10.c     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            int r12 = r8.b     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            sg.bigo.ads.common.utils.g<java.util.List<java.lang.String>> r14 = r8.c     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            if (r4 == 0) goto L_0x00a8
        L_0x00a6:
            r15 = r7
            goto L_0x00ae
        L_0x00a8:
            sg.bigo.ads.common.l.a.a$a r7 = new sg.bigo.ads.common.l.a.a$a     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            goto L_0x00a6
        L_0x00ae:
            r10 = r0
            r13 = r9
            r10.<init>(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            sg.bigo.ads.common.l.c.c r0 = r3.a((sg.bigo.ads.common.l.c.a) r0)     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            r1.a((sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.c>) r3, (sg.bigo.ads.common.l.a.c) r2, (sg.bigo.ads.common.l.c.c) r0)     // Catch:{ Exception -> 0x00c0, all -> 0x00bc }
            r7 = r9
            goto L_0x0127
        L_0x00bc:
            r0 = move-exception
            r7 = r9
            goto L_0x0183
        L_0x00c0:
            r0 = move-exception
            r7 = r9
            goto L_0x013e
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            java.lang.String r0 = r0.d     // Catch:{ Exception -> 0x0137 }
            goto L_0x00ca
        L_0x00c9:
            r0 = r7
        L_0x00ca:
            java.net.HttpURLConnection r9 = r8.a     // Catch:{ Exception -> 0x0137 }
            java.io.InputStream r7 = r9.getErrorStream()     // Catch:{ Exception -> 0x0137 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0137 }
            if (r9 == 0) goto L_0x00da
            java.lang.String r0 = sg.bigo.ads.common.utils.f.a((java.io.InputStream) r7)     // Catch:{ Exception -> 0x0137 }
        L_0x00da:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r9.<init>()     // Catch:{ Exception -> 0x0137 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0137 }
            if (r10 != 0) goto L_0x00ed
            r9.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = ", "
            r9.append(r0)     // Catch:{ Exception -> 0x0137 }
        L_0x00ed:
            java.lang.String r0 = "responseCode is "
            r9.append(r0)     // Catch:{ Exception -> 0x0137 }
            int r0 = r8.b     // Catch:{ Exception -> 0x0137 }
            r9.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = ", validate fail."
            r9.append(r0)     // Catch:{ Exception -> 0x0137 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0137 }
            r0.<init>()     // Catch:{ Exception -> 0x0137 }
            r0.append(r2)     // Catch:{ Exception -> 0x0137 }
            r0.append(r11)     // Catch:{ Exception -> 0x0137 }
            int r10 = r8.b     // Catch:{ Exception -> 0x0137 }
            r0.append(r10)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r10 = ", is invalid."
            r0.append(r10)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.k.a.a(r6, r5, r0)     // Catch:{ Exception -> 0x0137 }
            sg.bigo.ads.common.l.e r0 = new sg.bigo.ads.common.l.e     // Catch:{ Exception -> 0x0137 }
            int r10 = r8.b     // Catch:{ Exception -> 0x0137 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0137 }
            r0.<init>(r10, r9)     // Catch:{ Exception -> 0x0137 }
            r1.a((sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.c>) r3, (sg.bigo.ads.common.l.a.c) r2, (sg.bigo.ads.common.l.h) r0)     // Catch:{ Exception -> 0x0137 }
            r6 = 1
        L_0x0127:
            if (r4 != 0) goto L_0x012b
            if (r6 == 0) goto L_0x0133
        L_0x012b:
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            java.net.HttpURLConnection r0 = r8.a
            r0.disconnect()
        L_0x0133:
            android.net.TrafficStats.clearThreadStatsTag()
            return
        L_0x0137:
            r0 = move-exception
            goto L_0x013e
        L_0x0139:
            r0 = move-exception
            r8 = r7
            goto L_0x0183
        L_0x013c:
            r0 = move-exception
            r8 = r7
        L_0x013e:
            r0.printStackTrace()     // Catch:{ all -> 0x0182 }
            boolean r9 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x0182 }
            if (r9 == 0) goto L_0x0148
            r9 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0151
        L_0x0148:
            boolean r9 = r0 instanceof org.apache.http.conn.ConnectTimeoutException     // Catch:{ all -> 0x0182 }
            if (r9 == 0) goto L_0x014f
            r9 = 1001(0x3e9, float:1.403E-42)
            goto L_0x0151
        L_0x014f:
            r9 = 1000(0x3e8, float:1.401E-42)
        L_0x0151:
            sg.bigo.ads.common.l.h r10 = new sg.bigo.ads.common.l.h     // Catch:{ all -> 0x0182 }
            r10.<init>((int) r9, (java.lang.Exception) r0)     // Catch:{ all -> 0x0182 }
            r1.a((sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.c>) r3, (sg.bigo.ads.common.l.a.c) r2, (sg.bigo.ads.common.l.h) r10)     // Catch:{ all -> 0x0182 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0182 }
            r3.<init>()     // Catch:{ all -> 0x0182 }
            r3.append(r2)     // Catch:{ all -> 0x0182 }
            java.lang.String r2 = ", error = "
            r3.append(r2)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0182 }
            r3.append(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0182 }
            sg.bigo.ads.common.k.a.a(r6, r5, r0)     // Catch:{ all -> 0x0182 }
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            if (r8 == 0) goto L_0x017e
            java.net.HttpURLConnection r0 = r8.a
            r0.disconnect()
        L_0x017e:
            android.net.TrafficStats.clearThreadStatsTag()
            return
        L_0x0182:
            r0 = move-exception
        L_0x0183:
            if (r4 == 0) goto L_0x018f
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            if (r8 == 0) goto L_0x018f
            java.net.HttpURLConnection r2 = r8.a
            r2.disconnect()
        L_0x018f:
            android.net.TrafficStats.clearThreadStatsTag()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.l.a.a.a(sg.bigo.ads.common.l.a.c, sg.bigo.ads.common.l.b, boolean):void");
    }

    private void a(b<c, sg.bigo.ads.common.l.c.c> bVar, c cVar, sg.bigo.ads.common.l.c.c cVar2) {
        sg.bigo.ads.common.l.a aVar = this.b;
        if (aVar != null) {
            aVar.b(cVar.a);
        }
        bVar.a(cVar.a, cVar2);
    }

    private void a(b<c, sg.bigo.ads.common.l.c.c> bVar, c cVar, h hVar) {
        if (this.b != null) {
            if (hVar.getClass() == h.class) {
                this.b.a(cVar.a);
            } else if (hVar.getClass() == e.class) {
                this.b.b(cVar.a);
            }
        }
        bVar.a(cVar.a, hVar);
    }

    public final void a() {
        e.a();
    }

    public final void a(sg.bigo.ads.common.l.a aVar) {
        this.b = aVar;
    }

    public final void a(c cVar, b bVar) {
        new e(cVar, bVar) {
            /* access modifiers changed from: protected */
            public final void a(c cVar, b bVar) {
                a.this.a(cVar, (b<c, sg.bigo.ads.common.l.c.c>) bVar, true);
            }
        }.b();
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar, b<c, sg.bigo.ads.common.l.c.c> bVar, boolean z) {
        a(new c(cVar, this.b, this.a), bVar, z);
    }

    public final void b(c cVar, b bVar) {
        new e(cVar, bVar) {
            /* access modifiers changed from: protected */
            public final void a(c cVar, b bVar) {
                a.this.a(cVar, (b<c, sg.bigo.ads.common.l.c.c>) bVar, true);
            }
        }.b();
    }

    public final void c(c cVar, b bVar) {
        a(cVar, (b<c, sg.bigo.ads.common.l.c.c>) bVar, false);
    }
}
