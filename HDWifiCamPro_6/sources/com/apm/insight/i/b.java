package com.apm.insight.i;

import android.content.Context;
import com.apm.insight.g.c;
import java.io.File;

public class b implements c {
    /* access modifiers changed from: private */
    public Context a;

    public b(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(long r17, java.lang.Thread r19, java.lang.Throwable r20, java.lang.String r21, java.io.File r22, java.lang.String r23, boolean r24) {
        /*
            r16 = this;
            r12 = r16
            monitor-enter(r16)
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x008e }
            android.content.Context r0 = r12.a     // Catch:{ all -> 0x008e }
            java.io.File r0 = com.apm.insight.l.o.a((android.content.Context) r0)     // Catch:{ all -> 0x008e }
            r10 = r21
            r11.<init>(r0, r10)     // Catch:{ all -> 0x008e }
            com.apm.insight.g.a r0 = com.apm.insight.g.a.a()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = r11.getName()     // Catch:{ all -> 0x008e }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x008e }
            r11.mkdirs()     // Catch:{ all -> 0x008e }
            com.apm.insight.l.i.f(r11)     // Catch:{ all -> 0x008e }
            boolean r4 = com.apm.insight.l.v.c((java.lang.Throwable) r20)     // Catch:{ all -> 0x008e }
            com.apm.insight.runtime.a.f r0 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x008e }
            com.apm.insight.CrashType r13 = com.apm.insight.CrashType.LAUNCH     // Catch:{ all -> 0x008e }
            r14 = 0
            com.apm.insight.i.b$1 r15 = new com.apm.insight.i.b$1     // Catch:{ all -> 0x008e }
            r1 = r15
            r2 = r16
            r3 = r20
            r5 = r17
            r7 = r23
            r8 = r24
            r9 = r19
            r10 = r21
            r1.<init>(r3, r4, r5, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x008e }
            r1 = 1
            com.apm.insight.entity.a r0 = r0.a(r13, r14, r15, r1)     // Catch:{ all -> 0x008e }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008e }
            long r1 = r1 - r17
            java.lang.String r3 = "crash_type"
            java.lang.String r4 = "normal"
            r0.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "crash_cost"
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0068 }
            r0.b((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "crash_cost"
            r4 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r4
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0068 }
            r0.a((java.lang.String) r3, (java.lang.String) r1)     // Catch:{ all -> 0x0068 }
            goto L_0x0072
        L_0x0068:
            r0 = move-exception
            com.apm.insight.c r1 = com.apm.insight.b.a()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "NPTH_CATCH"
            r1.a((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x008e }
        L_0x0072:
            r0 = 4
            boolean r0 = com.apm.insight.l.r.a((int) r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x007b
            monitor-exit(r16)
            return
        L_0x007b:
            boolean r0 = com.apm.insight.Npth.isStopUpload()     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x008c
            r0 = 2048(0x800, float:2.87E-42)
            boolean r0 = com.apm.insight.l.r.a((int) r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            monitor-exit(r16)
            return
        L_0x008c:
            monitor-exit(r16)
            return
        L_0x008e:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.i.b.b(long, java.lang.Thread, java.lang.Throwable, java.lang.String, java.io.File, java.lang.String, boolean):void");
    }

    public void a(long j, Thread thread, Throwable th, String str, File file, String str2, boolean z) {
        b(j, thread, th, str, file, str2, z);
    }

    public boolean a(Throwable th) {
        return true;
    }
}
