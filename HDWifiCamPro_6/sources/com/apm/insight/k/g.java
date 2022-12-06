package com.apm.insight.k;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.apm.insight.Npth;
import com.apm.insight.entity.c;
import com.apm.insight.l.q;
import com.apm.insight.runtime.a;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.p;
import com.apm.insight.runtime.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

public final class g {
    private static final ConcurrentHashMap<Object, ConcurrentLinkedQueue<c>> a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static final HashMap<Object, HashMap<String, ConcurrentLinkedQueue<c>>> b = new HashMap<>();
    private static volatile g c;
    /* access modifiers changed from: private */
    public final u d = p.b();
    private volatile boolean e = false;
    /* access modifiers changed from: private */
    public Runnable f = new Runnable() {
        public void run() {
            if (!Npth.isStopUpload()) {
                if (!g.b.isEmpty() && o.e()) {
                    g.f();
                }
                g.this.c();
                g.this.d.a(g.this.f, (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }
    };

    private g() {
    }

    public static g a() {
        if (c == null) {
            synchronized (g.class) {
                if (c == null) {
                    c = new g();
                }
            }
        }
        return c;
    }

    public static void a(c cVar) {
        a(com.apm.insight.g.a(), cVar);
    }

    public static void a(final Object obj, final c cVar) {
        Handler a2 = p.b().a();
        if (a2 == null || a2.getLooper() != Looper.myLooper()) {
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    g.a(obj, cVar);
                }
            });
            return;
        }
        if (obj == null) {
            obj = com.apm.insight.g.a();
        }
        if (!o.e()) {
            q.a("EventUploadQueue", (Object) "enqueue before init.");
            c(obj, cVar);
            return;
        }
        if (!a.a(obj)) {
            a.b();
        }
        f();
        String str = null;
        try {
            str = cVar.h().getString("log_type");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(str) || !a.a(obj, str)) {
            q.a("EventUploadQueue", (Object) "logType " + str + " not sampled");
            return;
        }
        q.a("EventUploadQueue", (Object) "logType " + str + " enqueued");
        b(obj, cVar);
    }

    private static void b(Object obj, c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (obj) {
            concurrentLinkedQueue = a.get(obj);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                a.put(obj, concurrentLinkedQueue);
            }
        }
        concurrentLinkedQueue.add(cVar);
        int size = a.size();
        boolean z = size >= 30;
        q.b((Object) "[enqueue] size=" + size);
        if (z) {
            g();
        }
    }

    private static void c(Object obj, c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        try {
            String string = cVar.h().getString("log_type");
            synchronized (b) {
                HashMap hashMap = b.get(string);
                if (hashMap == null) {
                    hashMap = new HashMap();
                    b.put(obj, hashMap);
                }
                concurrentLinkedQueue = (ConcurrentLinkedQueue) hashMap.get(string);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    hashMap.put(string, concurrentLinkedQueue);
                }
            }
            concurrentLinkedQueue.add(cVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void f() {
        HashMap hashMap;
        synchronized (b) {
            hashMap = new HashMap(b);
            b.clear();
        }
        if (!a.b()) {
            q.a("EventUploadQueue", (Object) "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (a.b() && !a.a(entry.getKey(), str))) {
                    q.a("EventUploadQueue", (Object) "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            c cVar = (c) concurrentLinkedQueue.poll();
                            if (cVar == null) {
                                break;
                            }
                            b(entry.getKey(), cVar);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private static void g() {
        if (o.e() && !Npth.isStopUpload()) {
            try {
                p.b().a((Runnable) new Runnable() {
                    public void run() {
                        g.a().c();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        if (a.isEmpty()) {
            this.d.a(this.f, (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } else {
            this.d.a(this.f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1.hasNext() == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r2 = r1.next();
        r4 = (java.util.concurrent.ConcurrentLinkedQueue) r2.getValue();
        r2 = r2.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007d, code lost:
        r7.e = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r0 = new java.util.LinkedList();
        r1 = a.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r7 = this;
            com.apm.insight.runtime.u r0 = r7.d
            monitor-enter(r0)
            boolean r1 = r7.e     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            return
        L_0x0009:
            r1 = 1
            r7.e = r1     // Catch:{ all -> 0x0080 }
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.util.concurrent.ConcurrentLinkedQueue<com.apm.insight.entity.c>> r1 = a
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x007d
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getValue()
            java.util.concurrent.ConcurrentLinkedQueue r4 = (java.util.concurrent.ConcurrentLinkedQueue) r4
            java.lang.Object r2 = r2.getKey()
        L_0x0033:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x001c
            r5 = r3
        L_0x003a:
            r6 = 30
            if (r5 >= r6) goto L_0x004f
            boolean r6 = r4.isEmpty()     // Catch:{ all -> 0x0078 }
            if (r6 == 0) goto L_0x0045
            goto L_0x004f
        L_0x0045:
            java.lang.Object r6 = r4.poll()     // Catch:{ all -> 0x0078 }
            r0.add(r6)     // Catch:{ all -> 0x0078 }
            int r5 = r5 + 1
            goto L_0x003a
        L_0x004f:
            boolean r5 = r0.isEmpty()     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0056
            goto L_0x001c
        L_0x0056:
            com.apm.insight.runtime.a.f r5 = com.apm.insight.runtime.a.f.a()     // Catch:{ all -> 0x0078 }
            org.json.JSONArray r6 = com.apm.insight.entity.b.a((java.lang.Object) r2)     // Catch:{ all -> 0x0078 }
            com.apm.insight.entity.a r5 = r5.a((java.util.List<com.apm.insight.entity.a>) r0, (org.json.JSONArray) r6)     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0074
            java.lang.String r6 = "upload events"
            com.apm.insight.l.q.a((java.lang.Object) r6)     // Catch:{ all -> 0x0078 }
            com.apm.insight.k.d r6 = com.apm.insight.k.d.a()     // Catch:{ all -> 0x0078 }
            org.json.JSONObject r5 = r5.h()     // Catch:{ all -> 0x0078 }
            r6.a(r5)     // Catch:{ all -> 0x0078 }
        L_0x0074:
            r0.clear()     // Catch:{ all -> 0x0078 }
            goto L_0x0033
        L_0x0078:
            r5 = move-exception
            com.apm.insight.l.q.b((java.lang.Throwable) r5)
            goto L_0x0033
        L_0x007d:
            r7.e = r3
            return
        L_0x0080:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.g.c():void");
    }
}
