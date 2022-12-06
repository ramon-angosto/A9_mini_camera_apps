package com.apm.insight.k;

import com.apm.insight.entity.b;
import com.apm.insight.h;
import com.apm.insight.l.p;
import com.apm.insight.l.q;
import com.apm.insight.runtime.u;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.Map;

public class a {
    /* access modifiers changed from: private */
    public static Runnable a = new Runnable() {
        public void run() {
            long j;
            Runnable runnable;
            u uVar;
            if (p.b(h.g())) {
                a.i();
            }
            if (a.b > 0) {
                if (com.apm.insight.l.a.b(h.g())) {
                    uVar = com.apm.insight.runtime.p.b();
                    runnable = a.a;
                    j = 15000;
                } else {
                    uVar = com.apm.insight.runtime.p.b();
                    runnable = a.a;
                    j = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
                }
                uVar.a(runnable, j);
            }
        }
    };
    /* access modifiers changed from: private */
    public static int b = 0;

    public static void a() {
        b = 40;
        com.apm.insight.runtime.p.b().a(a);
    }

    public static void b() {
        if (!k.b()) {
            k.c();
        }
        if (p.b(h.g()) && k.a(false)) {
            i();
        }
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
    }

    private static byte[] h() {
        try {
            return e.a(h.i().getConfigUrl(), (Map<String, String>) null, b.a().toString().getBytes());
        } catch (Throwable th) {
            q.a(th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        if (com.apm.insight.k.k.a() != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void i() {
        /*
            java.lang.Class<com.apm.insight.k.a> r0 = com.apm.insight.k.a.class
            monitor-enter(r0)
            int r1 = b     // Catch:{ all -> 0x006a }
            r2 = 1
            if (r1 <= 0) goto L_0x000d
            int r1 = b     // Catch:{ all -> 0x006a }
            int r1 = r1 - r2
            b = r1     // Catch:{ all -> 0x006a }
        L_0x000d:
            java.lang.String r1 = "try fetchApmConfig"
            com.apm.insight.l.q.a((java.lang.Object) r1)     // Catch:{ all -> 0x006a }
            android.content.Context r1 = com.apm.insight.h.g()     // Catch:{ all -> 0x006a }
            boolean r1 = com.apm.insight.l.a.b(r1)     // Catch:{ all -> 0x006a }
            r3 = 0
            if (r1 == 0) goto L_0x005e
            r1 = 0
            byte[] r4 = h()     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x003b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0035 }
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0035 }
            r6.<init>(r4)     // Catch:{ all -> 0x0035 }
            r5.<init>(r6)     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = "data"
            org.json.JSONArray r1 = r5.optJSONArray(r4)     // Catch:{ all -> 0x0035 }
            goto L_0x003b
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = "npth"
            com.apm.insight.l.q.a((java.lang.String) r5, (java.lang.Throwable) r4)     // Catch:{ all -> 0x006a }
        L_0x003b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r4.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "after fetchApmConfig net "
            r4.append(r5)     // Catch:{ all -> 0x006a }
            r4.append(r1)     // Catch:{ all -> 0x006a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x006a }
            com.apm.insight.l.q.a((java.lang.Object) r4)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0057
            com.apm.insight.runtime.a.a((org.json.JSONArray) r1, (boolean) r2)     // Catch:{ all -> 0x006a }
        L_0x0054:
            b = r3     // Catch:{ all -> 0x006a }
            goto L_0x0068
        L_0x0057:
            int r1 = b     // Catch:{ all -> 0x006a }
            int r1 = r1 + -10
            b = r1     // Catch:{ all -> 0x006a }
            goto L_0x0068
        L_0x005e:
            com.apm.insight.k.k.c()     // Catch:{ all -> 0x006a }
            boolean r1 = com.apm.insight.k.k.a()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            goto L_0x0054
        L_0x0068:
            monitor-exit(r0)
            return
        L_0x006a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.a.i():void");
    }
}
