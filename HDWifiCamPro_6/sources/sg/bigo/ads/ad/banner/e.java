package sg.bigo.ads.ad.banner;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sg.bigo.ads.ad.b;

public final class e {
    private final List<WeakReference<b>> a;

    static class a {
        /* access modifiers changed from: private */
        public static e a = new e((byte) 0);
    }

    private e() {
        this.a = new LinkedList();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(sg.bigo.ads.ad.b r8) {
        /*
            r7 = this;
            boolean r0 = r8.isExpired()
            r1 = 0
            if (r0 != 0) goto L_0x0061
            boolean r0 = r8.e
            if (r0 != 0) goto L_0x0061
            boolean r0 = r8.g
            if (r0 == 0) goto L_0x0010
            goto L_0x0061
        L_0x0010:
            java.util.List<java.lang.ref.WeakReference<sg.bigo.ads.ad.b>> r0 = r7.a
            monitor-enter(r0)
            java.util.List<java.lang.ref.WeakReference<sg.bigo.ads.ad.b>> r2 = r7.a     // Catch:{ all -> 0x005e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x005e }
            r3 = 1
            r4 = r1
        L_0x001b:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x005e }
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5     // Catch:{ all -> 0x005e }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x005e }
            sg.bigo.ads.ad.b r5 = (sg.bigo.ads.ad.b) r5     // Catch:{ all -> 0x005e }
            if (r5 != r8) goto L_0x0031
            r4 = r3
            goto L_0x001b
        L_0x0031:
            if (r5 == 0) goto L_0x0041
            boolean r6 = r5.isExpired()     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0041
            boolean r6 = r5.e     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0041
            boolean r5 = r5.g     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x001b
        L_0x0041:
            r2.remove()     // Catch:{ all -> 0x005e }
            goto L_0x001b
        L_0x0045:
            if (r4 != 0) goto L_0x005c
            java.util.List<java.lang.ref.WeakReference<sg.bigo.ads.ad.b>> r2 = r7.a     // Catch:{ all -> 0x005e }
            int r2 = r2.size()     // Catch:{ all -> 0x005e }
            r4 = 3
            if (r2 >= r4) goto L_0x005c
            java.util.List<java.lang.ref.WeakReference<sg.bigo.ads.ad.b>> r1 = r7.a     // Catch:{ all -> 0x005e }
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x005e }
            r2.<init>(r8)     // Catch:{ all -> 0x005e }
            r1.add(r2)     // Catch:{ all -> 0x005e }
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return r3
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return r1
        L_0x005e:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            throw r8
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.banner.e.a(sg.bigo.ads.ad.b):boolean");
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        synchronized (this.a) {
            Iterator<WeakReference<b>> it = this.a.iterator();
            while (it.hasNext()) {
                if (((b) it.next().get()) == bVar) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }
}
