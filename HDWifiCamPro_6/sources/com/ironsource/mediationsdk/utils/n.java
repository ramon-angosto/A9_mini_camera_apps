package com.ironsource.mediationsdk.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n {
    private Map<String, Integer> a = new HashMap();
    private Map<String, Integer> b = new HashMap();

    public interface a {
        int j();

        String k();
    }

    public n(List<a> list) {
        for (a next : list) {
            this.a.put(next.k(), 0);
            this.b.put(next.k(), Integer.valueOf(next.j()));
        }
    }

    public final void a(a aVar) {
        synchronized (this) {
            String k = aVar.k();
            if (this.a.containsKey(k)) {
                this.a.put(k, Integer.valueOf(this.a.get(k).intValue() + 1));
            }
        }
    }

    public final boolean a() {
        for (String next : this.b.keySet()) {
            if (this.a.get(next).intValue() < this.b.get(next).intValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.ironsource.mediationsdk.utils.n.a r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r4.k()     // Catch:{ all -> 0x0025 }
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r3.a     // Catch:{ all -> 0x0025 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r3.a     // Catch:{ all -> 0x0025 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0025 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0025 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0025 }
            int r4 = r4.j()     // Catch:{ all -> 0x0025 }
            if (r0 < r4) goto L_0x0021
            r2 = 1
        L_0x0021:
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0023:
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0025:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.n.b(com.ironsource.mediationsdk.utils.n$a):boolean");
    }
}
