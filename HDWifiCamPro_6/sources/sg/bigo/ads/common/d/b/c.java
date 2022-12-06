package sg.bigo.ads.common.d.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.f.b;

class c extends ThreadPoolExecutor {
    private static c a;

    private c(TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(5, 8, 3000, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    protected static synchronized sg.bigo.ads.common.d.b.c a() {
        /*
            java.lang.Class<sg.bigo.ads.common.d.b.c> r0 = sg.bigo.ads.common.d.b.c.class
            monitor-enter(r0)
            sg.bigo.ads.common.d.b.c r1 = a     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0014
            monitor-enter(r0)     // Catch:{ all -> 0x0018 }
            sg.bigo.ads.common.d.b.c r1 = a     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x000f
            b()     // Catch:{ all -> 0x0011 }
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1     // Catch:{ all -> 0x0018 }
        L_0x0014:
            sg.bigo.ads.common.d.b.c r1 = a     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return r1
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.d.b.c.a():sg.bigo.ads.common.d.b.c");
    }

    private static synchronized void b() {
        synchronized (c.class) {
            a = new c(TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new b("Download"), new ThreadPoolExecutor.AbortPolicy());
        }
    }
}
