package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class u {
    static final b<d, Runnable> a = new b<d, Runnable>() {
    };
    static final b<Message, Runnable> b = new b<Message, Runnable>() {
    };
    private final HandlerThread c;
    /* access modifiers changed from: private */
    public final Queue<d> d = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public final Queue<Message> e = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public volatile Handler f;
    /* access modifiers changed from: private */
    public final Object g = new Object();

    class a implements Runnable {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (!u.this.d.isEmpty()) {
                d dVar = (d) u.this.d.poll();
                if (u.this.f != null) {
                    try {
                        u.this.f.sendMessageAtTime(dVar.a, dVar.b);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            while (!u.this.e.isEmpty()) {
                if (u.this.f != null) {
                    try {
                        u.this.f.sendMessageAtFrontOfQueue((Message) u.this.e.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        public void run() {
            b();
            a();
        }
    }

    public interface b<A, B> {
    }

    class c extends HandlerThread {
        volatile int a = 0;
        volatile boolean b = false;

        c(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|22|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            com.apm.insight.b.g.a(com.apm.insight.h.g()).a().c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
            if (r4.a < 5) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
            com.apm.insight.b.a().a("NPTH_CATCH", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
            if (r4.b == false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            r4.b = true;
            com.apm.insight.b.a().a("NPTH_ERR_MAX", (java.lang.Throwable) new java.lang.RuntimeException());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
            r4.a++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0025 A[LOOP:0: B:6:0x0025->B:21:0x0025, LOOP_START, SYNTHETIC, Splitter:B:6:0x0025] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onLooperPrepared() {
            /*
                r4 = this;
                super.onLooperPrepared()
                com.apm.insight.runtime.u r0 = com.apm.insight.runtime.u.this
                java.lang.Object r0 = r0.g
                monitor-enter(r0)
                com.apm.insight.runtime.u r1 = com.apm.insight.runtime.u.this     // Catch:{ all -> 0x0063 }
                android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0063 }
                r2.<init>()     // Catch:{ all -> 0x0063 }
                android.os.Handler unused = r1.f = r2     // Catch:{ all -> 0x0063 }
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                com.apm.insight.runtime.u r0 = com.apm.insight.runtime.u.this
                android.os.Handler r0 = r0.f
                com.apm.insight.runtime.u$a r1 = new com.apm.insight.runtime.u$a
                com.apm.insight.runtime.u r2 = com.apm.insight.runtime.u.this
                r1.<init>()
                r0.post(r1)
            L_0x0025:
                android.os.Looper.loop()     // Catch:{ all -> 0x0029 }
                goto L_0x0025
            L_0x0029:
                r0 = move-exception
                android.content.Context r1 = com.apm.insight.h.g()     // Catch:{ all -> 0x0025 }
                com.apm.insight.b.g r1 = com.apm.insight.b.g.a(r1)     // Catch:{ all -> 0x0025 }
                com.apm.insight.b.b r1 = r1.a()     // Catch:{ all -> 0x0025 }
                r1.c()     // Catch:{ all -> 0x0025 }
                int r1 = r4.a     // Catch:{ all -> 0x0025 }
                r2 = 5
                r3 = 1
                if (r1 >= r2) goto L_0x0049
                com.apm.insight.c r1 = com.apm.insight.b.a()     // Catch:{ all -> 0x0025 }
                java.lang.String r2 = "NPTH_CATCH"
                r1.a((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0025 }
                goto L_0x005d
            L_0x0049:
                boolean r0 = r4.b     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x005d
                r4.b = r3     // Catch:{ all -> 0x0025 }
                com.apm.insight.c r0 = com.apm.insight.b.a()     // Catch:{ all -> 0x0025 }
                java.lang.String r1 = "NPTH_ERR_MAX"
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0025 }
                r2.<init>()     // Catch:{ all -> 0x0025 }
                r0.a((java.lang.String) r1, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0025 }
            L_0x005d:
                int r0 = r4.a     // Catch:{ all -> 0x0025 }
                int r0 = r0 + r3
                r4.a = r0     // Catch:{ all -> 0x0025 }
                goto L_0x0025
            L_0x0063:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.u.c.onLooperPrepared():void");
        }
    }

    static class d {
        Message a;
        long b;

        d(Message message, long j) {
            this.a = message;
            this.b = j;
        }
    }

    public u(String str) {
        this.c = new c(str);
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.f, runnable);
    }

    public Handler a() {
        return this.f;
    }

    public final boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(b(runnable), j);
    }

    public void b() {
        this.c.start();
    }

    public final boolean b(Message message, long j) {
        if (this.f == null) {
            synchronized (this.g) {
                if (this.f == null) {
                    this.d.add(new d(message, j));
                    return true;
                }
            }
        }
        try {
            return this.f.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    public HandlerThread c() {
        return this.c;
    }
}
