package com.bytedance.sdk.component.e.a.a.b;

import com.bytedance.sdk.component.e.a.d.a;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: EventMemoryCacheManager */
public abstract class d<T extends a> {
    private com.bytedance.sdk.component.e.a.d.b.a a;
    private Queue<T> b = new ConcurrentLinkedQueue();
    private Queue<String> c;

    public d(com.bytedance.sdk.component.e.a.d.b.a aVar, Queue<String> queue) {
        this.a = aVar;
        this.c = queue;
    }

    public void a(T t) {
        Queue<T> queue = this.b;
        if (queue != null && t != null) {
            queue.offer(t);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.component.e.a.d.a> a(int r2, int r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r2 = r1.b(r2, r3)     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x002d
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.b.a r3 = r1.a     // Catch:{ all -> 0x0030 }
            int r3 = r3.a()     // Catch:{ all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ all -> 0x0030 }
        L_0x0012:
            java.util.Queue<T> r3 = r1.b     // Catch:{ all -> 0x0030 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.a r3 = (com.bytedance.sdk.component.e.a.d.a) r3     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x002b
            r2.add(r3)     // Catch:{ all -> 0x0030 }
            int r3 = r2.size()     // Catch:{ all -> 0x0030 }
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.a     // Catch:{ all -> 0x0030 }
            int r0 = r0.b()     // Catch:{ all -> 0x0030 }
            if (r3 != r0) goto L_0x0012
        L_0x002b:
            monitor-exit(r1)
            return r2
        L_0x002d:
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x0030:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.b.d.a(int, int):java.util.List");
    }

    public synchronized void a(int i, List<T> list) {
        if (!(i == -1 || i == 200 || i == 509)) {
            this.b.addAll(list);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(int r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r4 = 2
            r0 = 0
            r1 = 1
            if (r3 == r4) goto L_0x001a
            if (r3 != r1) goto L_0x0009
            goto L_0x001a
        L_0x0009:
            java.util.Queue<T> r3 = r2.b     // Catch:{ all -> 0x002b }
            int r3 = r3.size()     // Catch:{ all -> 0x002b }
            com.bytedance.sdk.component.e.a.d.b.a r4 = r2.a     // Catch:{ all -> 0x002b }
            int r4 = r4.a()     // Catch:{ all -> 0x002b }
            if (r3 < r4) goto L_0x0018
            r0 = r1
        L_0x0018:
            monitor-exit(r2)
            return r0
        L_0x001a:
            java.util.Queue<T> r3 = r2.b     // Catch:{ all -> 0x002b }
            int r3 = r3.size()     // Catch:{ all -> 0x002b }
            com.bytedance.sdk.component.e.a.d.b.a r4 = r2.a     // Catch:{ all -> 0x002b }
            int r4 = r4.a()     // Catch:{ all -> 0x002b }
            if (r3 < r4) goto L_0x0029
            r0 = r1
        L_0x0029:
            monitor-exit(r2)
            return r0
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.b.d.b(int, int):boolean");
    }
}
