package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

public class d {
    private static long a;
    private final c b;
    private final a c;

    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            try {
                synchronized (this.a) {
                    boolean unused = this.a.e = true;
                    this.a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    public static abstract class b implements Runnable {
        protected int a;

        b(int i) {
            this.a = i;
        }
    }

    private static final class c extends Thread {
        private volatile long a = 0;
        private volatile boolean b = false;
        private long c = 50;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public boolean e;
        /* access modifiers changed from: private */
        public a f = new a();

        private static final class a {
            private int a;
            private C0054d[] b;
            private int c;
            private int d;

            private a() {
                this.a = 256;
                this.b = new C0054d[this.a];
                this.c = 0;
                this.d = 0;
            }

            /* access modifiers changed from: private */
            public int b(C0054d dVar) {
                int i = 0;
                while (true) {
                    C0054d[] dVarArr = this.b;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void d(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.c;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3 && this.b[i4].c < this.b[i2].c) {
                            i2 = i4;
                        }
                        if (this.b[i].c >= this.b[i2].c) {
                            C0054d[] dVarArr = this.b;
                            C0054d dVar = dVarArr[i];
                            dVarArr[i] = dVarArr[i2];
                            dVarArr[i2] = dVar;
                            int i5 = i2;
                            i2 = (i2 * 2) + 1;
                            i = i5;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            private void e() {
                int i = this.c - 1;
                int i2 = (i - 1) / 2;
                while (this.b[i].c < this.b[i2].c) {
                    C0054d[] dVarArr = this.b;
                    C0054d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public C0054d a() {
                return this.b[0];
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].d == bVar) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public void a(C0054d dVar) {
                C0054d[] dVarArr = this.b;
                int length = dVarArr.length;
                int i = this.c;
                if (length == i) {
                    C0054d[] dVarArr2 = new C0054d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.b = dVarArr2;
                }
                C0054d[] dVarArr3 = this.b;
                int i2 = this.c;
                this.c = i2 + 1;
                dVarArr3[i2] = dVar;
                e();
            }

            public boolean a(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        return true;
                    }
                }
                return false;
            }

            public void b(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public boolean b() {
                return this.c == 0;
            }

            public void c() {
                this.b = new C0054d[this.a];
                this.c = 0;
            }

            public void c(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.c)) {
                    C0054d[] dVarArr = this.b;
                    int i3 = i2 - 1;
                    this.c = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[this.c] = null;
                    d(i);
                }
            }

            public void d() {
                int i = 0;
                while (i < this.c) {
                    if (this.b[i].b) {
                        this.d++;
                        c(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        public void a(C0054d dVar) {
            this.f.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.d = true;
            this.f.c();
            notify();
        }

        public boolean b() {
            return this.b && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|(2:8|(3:83|10|11)(2:12|13))(2:17|26)|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.b = true;
            r2.d.run();
            r10.b = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a6, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a7, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            r10.d = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ab, code lost:
            throw r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0018 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                monitor-enter(r10)
                boolean r0 = r10.d     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                return
            L_0x0007:
                com.xiaomi.push.service.d$c$a r0 = r10.f     // Catch:{ all -> 0x00b5 }
                boolean r0 = r0.b()     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r10.e     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0015
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                return
            L_0x0015:
                r10.wait()     // Catch:{ InterruptedException -> 0x0018 }
            L_0x0018:
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                goto L_0x0000
            L_0x001a:
                long r0 = com.xiaomi.push.service.d.a()     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.d$c$a r2 = r10.f     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.d$d r2 = r2.a()     // Catch:{ all -> 0x00b5 }
                java.lang.Object r3 = r2.a     // Catch:{ all -> 0x00b5 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b5 }
                boolean r4 = r2.b     // Catch:{ all -> 0x00b2 }
                r5 = 0
                if (r4 == 0) goto L_0x0033
                com.xiaomi.push.service.d$c$a r0 = r10.f     // Catch:{ all -> 0x00b2 }
                r0.c(r5)     // Catch:{ all -> 0x00b2 }
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                goto L_0x0018
            L_0x0033:
                long r6 = r2.c     // Catch:{ all -> 0x00b2 }
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L_0x005a
                long r2 = r10.c     // Catch:{ all -> 0x00b5 }
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0047
                long r6 = r10.c     // Catch:{ all -> 0x00b5 }
            L_0x0047:
                long r2 = r10.c     // Catch:{ all -> 0x00b5 }
                long r2 = r2 + r0
                r10.c = r2     // Catch:{ all -> 0x00b5 }
                long r0 = r10.c     // Catch:{ all -> 0x00b5 }
                r2 = 500(0x1f4, double:2.47E-321)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0056
                r10.c = r2     // Catch:{ all -> 0x00b5 }
            L_0x0056:
                r10.wait(r6)     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0018
            L_0x005a:
                r10.c = r0     // Catch:{ all -> 0x00b5 }
                java.lang.Object r0 = r2.a     // Catch:{ all -> 0x00b5 }
                monitor-enter(r0)     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.d$c$a r1 = r10.f     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.d$d r1 = r1.a()     // Catch:{ all -> 0x00af }
                long r6 = r1.c     // Catch:{ all -> 0x00af }
                long r8 = r2.c     // Catch:{ all -> 0x00af }
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x0074
                com.xiaomi.push.service.d$c$a r1 = r10.f     // Catch:{ all -> 0x00af }
                int r1 = r1.b((com.xiaomi.push.service.d.C0054d) r2)     // Catch:{ all -> 0x00af }
                goto L_0x0075
            L_0x0074:
                r1 = 0
            L_0x0075:
                boolean r6 = r2.b     // Catch:{ all -> 0x00af }
                if (r6 == 0) goto L_0x0086
                com.xiaomi.push.service.d$c$a r1 = r10.f     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.d$c$a r3 = r10.f     // Catch:{ all -> 0x00af }
                int r2 = r3.b((com.xiaomi.push.service.d.C0054d) r2)     // Catch:{ all -> 0x00af }
                r1.c(r2)     // Catch:{ all -> 0x00af }
                monitor-exit(r0)     // Catch:{ all -> 0x00af }
                goto L_0x0018
            L_0x0086:
                long r6 = r2.c     // Catch:{ all -> 0x00af }
                r2.a(r6)     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.d$c$a r6 = r10.f     // Catch:{ all -> 0x00af }
                r6.c(r1)     // Catch:{ all -> 0x00af }
                r2.c = r3     // Catch:{ all -> 0x00af }
                monitor-exit(r0)     // Catch:{ all -> 0x00af }
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00a6 }
                r10.a = r3     // Catch:{ all -> 0x00a6 }
                r10.b = r0     // Catch:{ all -> 0x00a6 }
                com.xiaomi.push.service.d$b r1 = r2.d     // Catch:{ all -> 0x00a6 }
                r1.run()     // Catch:{ all -> 0x00a6 }
                r10.b = r5     // Catch:{ all -> 0x00a6 }
                goto L_0x0000
            L_0x00a6:
                r1 = move-exception
                monitor-enter(r10)
                r10.d = r0     // Catch:{ all -> 0x00ac }
                monitor-exit(r10)     // Catch:{ all -> 0x00ac }
                throw r1
            L_0x00ac:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00ac }
                throw r0
            L_0x00af:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00af }
                throw r1     // Catch:{ all -> 0x00b5 }
            L_0x00b2:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                throw r0     // Catch:{ all -> 0x00b5 }
            L_0x00b5:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                goto L_0x00b9
            L_0x00b8:
                throw r0
            L_0x00b9:
                goto L_0x00b8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.d.c.run():void");
        }
    }

    /* renamed from: com.xiaomi.push.service.d$d  reason: collision with other inner class name */
    static class C0054d {
        final Object a = new Object();
        boolean b;
        long c;
        b d;
        int e;
        private long f;

        C0054d() {
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            synchronized (this.a) {
                this.f = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.a) {
                z = !this.b && this.c > 0;
                this.b = true;
            }
            return z;
        }
    }

    public d() {
        this(false);
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        if (str != null) {
            this.b = new c(str, z);
            this.c = new a(this.b);
            return;
        }
        throw new NullPointerException("name == null");
    }

    public d(boolean z) {
        this("Timer-" + e(), z);
    }

    static long a() {
        return SystemClock.elapsedRealtime();
    }

    private void b(b bVar, long j) {
        synchronized (this.b) {
            if (!this.b.d) {
                long a2 = j + a();
                if (a2 >= 0) {
                    C0054d dVar = new C0054d();
                    dVar.e = bVar.a;
                    dVar.d = bVar;
                    dVar.c = a2;
                    this.b.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    private static synchronized long e() {
        long j;
        synchronized (d.class) {
            j = a;
            a = 1 + j;
        }
        return j;
    }

    public void a(int i, b bVar) {
        synchronized (this.b) {
            this.b.f.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.b) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    public boolean a(int i) {
        boolean a2;
        synchronized (this.b) {
            a2 = this.b.f.a(i);
        }
        return a2;
    }

    public void b() {
        this.b.a();
    }

    public void b(int i) {
        synchronized (this.b) {
            this.b.f.b(i);
        }
    }

    public void c() {
        synchronized (this.b) {
            this.b.f.c();
        }
    }

    public boolean d() {
        return this.b.b();
    }
}
