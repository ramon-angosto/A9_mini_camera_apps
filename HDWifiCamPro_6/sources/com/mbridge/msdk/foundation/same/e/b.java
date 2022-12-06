package com.mbridge.msdk.foundation.same.e;

import android.content.Context;
import com.mbridge.msdk.foundation.same.e.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoader */
public final class b {
    ThreadPoolExecutor a;
    HashMap<Long, a> b;
    WeakReference<Context> c;

    public b(Context context, int i) {
        if (i == 0) {
            this.a = new ThreadPoolExecutor(1, 5, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.a = new ThreadPoolExecutor(i, (i * 2) + 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        }
        this.a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    public b(Context context) {
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
        this.a.allowCoreThreadTimeOut(true);
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.b bVar) {
        this.b.put(Long.valueOf(a.b), aVar);
        aVar.d = new a.b() {
            public final void a(a.C0062a aVar) {
                if (aVar == a.C0062a.CANCEL) {
                    HashMap<Long, a> hashMap = b.this.b;
                    a aVar2 = aVar;
                    hashMap.remove(Long.valueOf(a.b));
                } else if (aVar == a.C0062a.FINISH) {
                    HashMap<Long, a> hashMap2 = b.this.b;
                    a aVar3 = aVar;
                    hashMap2.remove(Long.valueOf(a.b));
                } else if (aVar == a.C0062a.RUNNING && ((Context) b.this.c.get()) == null) {
                    b.this.a();
                }
                a.b bVar = bVar;
                if (bVar != null) {
                    bVar.a(aVar);
                }
            }
        };
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            com.mbridge.msdk.foundation.same.e.a r1 = (com.mbridge.msdk.foundation.same.e.a) r1     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r1.d()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x000b
        L_0x0021:
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r0.clear()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x002a
        L_0x0027:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x002a:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.e.b.a():void");
    }

    public final void a(a aVar) {
        b(aVar, (a.b) null);
        this.a.execute(aVar);
    }

    public final void a(a aVar, a.b bVar) {
        b(aVar, bVar);
        this.a.execute(aVar);
    }
}
