package com.bytedance.sdk.component.f.c;

import android.content.Context;
import java.util.HashMap;

/* compiled from: TncInstanceManager */
public class g {
    private static volatile g a;
    private static HashMap<Integer, e> b;
    private static HashMap<Integer, a> c;

    private g() {
        b = new HashMap<>();
        c = new HashMap<>();
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
    public static synchronized com.bytedance.sdk.component.f.c.g a() {
        /*
            java.lang.Class<com.bytedance.sdk.component.f.c.g> r0 = com.bytedance.sdk.component.f.c.g.class
            monitor-enter(r0)
            com.bytedance.sdk.component.f.c.g r1 = a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.bytedance.sdk.component.f.c.g r1 = a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.bytedance.sdk.component.f.c.g r1 = new com.bytedance.sdk.component.f.c.g     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.bytedance.sdk.component.f.c.g r1 = a     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.c.g.a():com.bytedance.sdk.component.f.c.g");
    }

    public e a(int i) {
        e eVar = b.get(Integer.valueOf(i));
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(i);
        b.put(Integer.valueOf(i), eVar2);
        return eVar2;
    }

    public a a(int i, Context context) {
        a aVar = c.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(context, i);
        c.put(Integer.valueOf(i), aVar2);
        return aVar2;
    }
}
