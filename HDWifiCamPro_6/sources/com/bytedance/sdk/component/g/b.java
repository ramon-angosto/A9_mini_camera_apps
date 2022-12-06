package com.bytedance.sdk.component.g;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.l;

/* compiled from: DelegateRunnable */
class b implements Comparable, Runnable {
    private g a = null;
    private a b = null;
    private long c = 0;
    private Thread d = null;

    public b(g gVar, a aVar) {
        this.a = gVar;
        this.b = aVar;
        this.c = SystemClock.uptimeMillis();
    }

    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.c;
        this.d = Thread.currentThread();
        g gVar = this.a;
        if (gVar != null) {
            gVar.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (this.b != null) {
            d.a();
        }
        if (l.a()) {
            Object[] objArr = new Object[8];
            objArr[0] = "run: pool  = ";
            a aVar = this.b;
            String str = "null";
            objArr[1] = aVar != null ? aVar.a() : str;
            objArr[2] = " waitTime =";
            objArr[3] = Long.valueOf(j);
            objArr[4] = " taskCost = ";
            objArr[5] = Long.valueOf(uptimeMillis2);
            objArr[6] = " name=";
            g gVar2 = this.a;
            if (gVar2 != null) {
                str = gVar2.getName();
            }
            objArr[7] = str;
            l.b("DelegateRunnable", objArr);
        }
    }

    public g a() {
        return this.a;
    }

    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.a.compareTo(((b) obj).a());
        }
        return 0;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof com.bytedance.sdk.component.g.b
            if (r0 == 0) goto L_0x0016
            com.bytedance.sdk.component.g.g r0 = r1.a
            if (r0 == 0) goto L_0x0016
            com.bytedance.sdk.component.g.b r2 = (com.bytedance.sdk.component.g.b) r2
            com.bytedance.sdk.component.g.g r2 = r2.a()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.b.equals(java.lang.Object):boolean");
    }
}
