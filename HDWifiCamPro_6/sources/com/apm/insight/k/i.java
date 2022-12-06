package com.apm.insight.k;

import android.content.Context;
import com.apm.insight.h;
import com.apm.insight.l.a;
import com.apm.insight.runtime.p;

public final class i implements Runnable {
    private Context a;

    private i(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        a(context, 0);
    }

    public static void a(Context context, int i) {
        p.b().a((Runnable) new i(context), (long) i);
    }

    public static boolean a() {
        return b.a().c() || !a.b(h.g());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|(1:5)(1:6)|7|(1:21)|14|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.apm.insight.l.q.b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0048, code lost:
        com.apm.insight.runtime.s.a().a(com.apm.insight.h.a().b(), com.apm.insight.entity.b.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        if (com.apm.insight.runtime.p.b().a() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
        com.apm.insight.runtime.s.a().a(com.apm.insight.h.a().b(), com.apm.insight.entity.b.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0093, code lost:
        if (com.apm.insight.runtime.p.b().a() != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        com.apm.insight.j.d.a(com.apm.insight.runtime.p.b().a(), r4.a).a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a6, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000d */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0015 A[Catch:{ all -> 0x0044, all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023 A[Catch:{ all -> 0x0044, all -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            android.content.Context r0 = r4.a     // Catch:{ all -> 0x000d }
            com.apm.insight.b.g r0 = com.apm.insight.b.g.a(r0)     // Catch:{ all -> 0x000d }
            com.apm.insight.b.b r0 = r0.a()     // Catch:{ all -> 0x000d }
            r0.f()     // Catch:{ all -> 0x000d }
        L_0x000d:
            android.content.Context r0 = r4.a     // Catch:{ all -> 0x0044 }
            boolean r0 = com.apm.insight.l.a.b(r0)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0023
            com.apm.insight.k.b r0 = com.apm.insight.k.b.a()     // Catch:{ all -> 0x0044 }
            android.content.Context r1 = r4.a     // Catch:{ all -> 0x0044 }
            boolean r1 = com.apm.insight.l.p.b(r1)     // Catch:{ all -> 0x0044 }
            r0.a((boolean) r1)     // Catch:{ all -> 0x0044 }
            goto L_0x0026
        L_0x0023:
            com.apm.insight.nativecrash.NativeImpl.i()     // Catch:{ all -> 0x0044 }
        L_0x0026:
            com.apm.insight.runtime.s r0 = com.apm.insight.runtime.s.a()
            com.apm.insight.runtime.d r1 = com.apm.insight.h.a()
            java.util.Map r1 = r1.b()
            org.json.JSONArray r2 = com.apm.insight.entity.b.b()
            r0.a((java.util.Map<java.lang.String, java.lang.Object>) r1, (org.json.JSONArray) r2)
            com.apm.insight.runtime.u r0 = com.apm.insight.runtime.p.b()
            android.os.Handler r0 = r0.a()
            if (r0 == 0) goto L_0x0076
            goto L_0x0065
        L_0x0044:
            r0 = move-exception
            com.apm.insight.l.q.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x0077 }
            com.apm.insight.runtime.s r0 = com.apm.insight.runtime.s.a()
            com.apm.insight.runtime.d r1 = com.apm.insight.h.a()
            java.util.Map r1 = r1.b()
            org.json.JSONArray r2 = com.apm.insight.entity.b.b()
            r0.a((java.util.Map<java.lang.String, java.lang.Object>) r1, (org.json.JSONArray) r2)
            com.apm.insight.runtime.u r0 = com.apm.insight.runtime.p.b()
            android.os.Handler r0 = r0.a()
            if (r0 == 0) goto L_0x0076
        L_0x0065:
            com.apm.insight.runtime.u r0 = com.apm.insight.runtime.p.b()
            android.os.Handler r0 = r0.a()
            android.content.Context r1 = r4.a
            com.apm.insight.j.d r0 = com.apm.insight.j.d.a(r0, r1)
            r0.a()
        L_0x0076:
            return
        L_0x0077:
            r0 = move-exception
            com.apm.insight.runtime.s r1 = com.apm.insight.runtime.s.a()
            com.apm.insight.runtime.d r2 = com.apm.insight.h.a()
            java.util.Map r2 = r2.b()
            org.json.JSONArray r3 = com.apm.insight.entity.b.b()
            r1.a((java.util.Map<java.lang.String, java.lang.Object>) r2, (org.json.JSONArray) r3)
            com.apm.insight.runtime.u r1 = com.apm.insight.runtime.p.b()
            android.os.Handler r1 = r1.a()
            if (r1 == 0) goto L_0x00a6
            com.apm.insight.runtime.u r1 = com.apm.insight.runtime.p.b()
            android.os.Handler r1 = r1.a()
            android.content.Context r2 = r4.a
            com.apm.insight.j.d r1 = com.apm.insight.j.d.a(r1, r2)
            r1.a()
        L_0x00a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.i.run():void");
    }
}
