package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.download.g;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownLoadH5SourceListener */
public final class b implements g.c {
    private static String a = "DownLoadH5SourceListener";
    private ConcurrentMap<String, b> b;
    private j c;
    private CopyOnWriteArrayList<g.d> d = new CopyOnWriteArrayList<>();
    private String e;

    public final void a() {
    }

    public b(ConcurrentMap<String, b> concurrentMap, j jVar, g.d dVar, String str) {
        this.b = concurrentMap;
        this.c = jVar;
        this.d.add(dVar);
        this.e = str;
    }

    public final void a(g.d dVar) {
        this.d.add(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r2, byte[] r3, java.lang.String r4) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r2 = r1.b     // Catch:{ Exception -> 0x0075 }
            if (r2 != 0) goto L_0x0024
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.g$d> r2 = r1.d     // Catch:{ Exception -> 0x0075 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0075 }
        L_0x000a:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0075 }
            com.mbridge.msdk.videocommon.download.g$d r3 = (com.mbridge.msdk.videocommon.download.g.d) r3     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x000a
            java.lang.String r0 = "mResDownloadingMap  is null"
            r3.a(r4, r0)     // Catch:{ Exception -> 0x0075 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.g$d> r0 = r1.d     // Catch:{ Exception -> 0x0075 }
            r0.remove(r3)     // Catch:{ Exception -> 0x0075 }
            goto L_0x000a
        L_0x0023:
            return
        L_0x0024:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r2 = r1.b     // Catch:{ Exception -> 0x0075 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0075 }
            if (r2 == 0) goto L_0x0031
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.videocommon.download.b> r2 = r1.b     // Catch:{ Exception -> 0x0075 }
            r2.remove(r4)     // Catch:{ Exception -> 0x0075 }
        L_0x0031:
            if (r3 == 0) goto L_0x0072
            int r2 = r3.length     // Catch:{ Exception -> 0x0075 }
            if (r2 <= 0) goto L_0x0072
            com.mbridge.msdk.videocommon.download.j r2 = r1.c     // Catch:{ Exception -> 0x0075 }
            java.lang.String r2 = r2.a(r4, r3)     // Catch:{ Exception -> 0x0075 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x0060
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.g$d> r2 = r1.d     // Catch:{ Exception -> 0x0075 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0075 }
        L_0x0048:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0075 }
            com.mbridge.msdk.videocommon.download.g$d r3 = (com.mbridge.msdk.videocommon.download.g.d) r3     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x0048
            r3.a(r4)     // Catch:{ Exception -> 0x0075 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.g$d> r0 = r1.d     // Catch:{ Exception -> 0x0075 }
            r0.remove(r3)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0048
        L_0x005f:
            return
        L_0x0060:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075 }
            r3.<init>()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r0 = "data save failed:"
            r3.append(r0)     // Catch:{ Exception -> 0x0075 }
            r3.append(r2)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0075 }
            goto L_0x008e
        L_0x0072:
            java.lang.String r2 = "response data is error"
            goto L_0x008e
        L_0x0075:
            r2 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L_0x007d
            r2.printStackTrace()
        L_0x007d:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0082 }
            goto L_0x008e
        L_0x0082:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.String r0 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r3, r0, r2)
            java.lang.String r2 = ""
        L_0x008e:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.g$d> r3 = r1.d
            java.util.Iterator r3 = r3.iterator()
        L_0x0094:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x00a6
            java.lang.Object r0 = r3.next()
            com.mbridge.msdk.videocommon.download.g$d r0 = (com.mbridge.msdk.videocommon.download.g.d) r0
            if (r0 == 0) goto L_0x0094
            r0.a(r4, r2)
            goto L_0x0094
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.b.a(java.lang.String, byte[], java.lang.String):void");
    }

    public final void a(String str) {
        try {
            if (this.b == null) {
                Iterator<g.d> it = this.d.iterator();
                while (it.hasNext()) {
                    g.d next = it.next();
                    if (next != null) {
                        next.a(this.e, "mResDownloadingMap  is null");
                        this.d.remove(next);
                    }
                }
                return;
            }
            if (this.b.containsKey(this.e)) {
                this.b.remove(this.e);
            }
            Iterator<g.d> it2 = this.d.iterator();
            while (it2.hasNext()) {
                g.d next2 = it2.next();
                if (next2 != null) {
                    next2.a(this.e, str);
                    this.d.remove(next2);
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            str = e2.getMessage();
        } catch (Throwable th) {
            q.a(a, th.getMessage(), th);
        }
    }
}
