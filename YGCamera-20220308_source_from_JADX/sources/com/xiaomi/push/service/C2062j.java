package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.xiaomi.push.service.j */
public class C2062j {

    /* renamed from: a */
    private static long f3897a;

    /* renamed from: b */
    private static long f3898b = f3897a;

    /* renamed from: c */
    private static long f3899c;

    /* renamed from: a */
    private final C2063a f3900a;

    /* renamed from: a */
    private final C2065c f3901a;

    /* renamed from: com.xiaomi.push.service.j$a */
    private static final class C2063a {

        /* renamed from: a */
        private final C2065c f3902a;

        C2063a(C2065c cVar) {
            this.f3902a = cVar;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            try {
                synchronized (this.f3902a) {
                    boolean unused = this.f3902a.f3909c = true;
                    this.f3902a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.j$b */
    public static abstract class C2064b implements Runnable {

        /* renamed from: a */
        protected int f3903a;

        public C2064b(int i) {
            this.f3903a = i;
        }
    }

    /* renamed from: com.xiaomi.push.service.j$c */
    private static final class C2065c extends Thread {

        /* renamed from: a */
        private volatile long f3904a = 0;

        /* renamed from: a */
        private C2066a f3905a = new C2066a();

        /* renamed from: a */
        private volatile boolean f3906a = false;

        /* renamed from: b */
        private long f3907b = 50;

        /* renamed from: b */
        private boolean f3908b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f3909c;

        /* renamed from: com.xiaomi.push.service.j$c$a */
        private static final class C2066a {

            /* renamed from: a */
            private int f3910a;

            /* renamed from: a */
            private C2067d[] f3911a;

            /* renamed from: b */
            private int f3912b;

            /* renamed from: c */
            private int f3913c;

            private C2066a() {
                this.f3910a = 256;
                this.f3911a = new C2067d[this.f3910a];
                this.f3912b = 0;
                this.f3913c = 0;
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public int mo18549a(C2067d dVar) {
                int i = 0;
                while (true) {
                    C2067d[] dVarArr = this.f3911a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            /* renamed from: c */
            private void m5277c() {
                int i = this.f3912b - 1;
                int i2 = (i - 1) / 2;
                while (this.f3911a[i].f3915a < this.f3911a[i2].f3915a) {
                    C2067d[] dVarArr = this.f3911a;
                    C2067d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            /* renamed from: c */
            private void m5278c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.f3912b;
                    if (i2 < i3 && i3 > 0) {
                        int i4 = i2 + 1;
                        if (i4 < i3 && this.f3911a[i4].f3915a < this.f3911a[i2].f3915a) {
                            i2 = i4;
                        }
                        if (this.f3911a[i].f3915a >= this.f3911a[i2].f3915a) {
                            C2067d[] dVarArr = this.f3911a;
                            C2067d dVar = dVarArr[i];
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

            /* renamed from: a */
            public C2067d mo18546a() {
                return this.f3911a[0];
            }

            /* renamed from: a */
            public void m5280a() {
                this.f3911a = new C2067d[this.f3910a];
                this.f3912b = 0;
            }

            /* renamed from: a */
            public void mo18547a(int i) {
                for (int i2 = 0; i2 < this.f3912b; i2++) {
                    if (this.f3911a[i2].f3914a == i) {
                        this.f3911a[i2].mo18553a();
                    }
                }
                mo18550b();
            }

            /* renamed from: a */
            public void mo18548a(int i, C2064b bVar) {
                for (int i2 = 0; i2 < this.f3912b; i2++) {
                    if (this.f3911a[i2].f3916a == bVar) {
                        this.f3911a[i2].mo18553a();
                    }
                }
                mo18550b();
            }

            /* renamed from: a */
            public void m5283a(C2067d dVar) {
                C2067d[] dVarArr = this.f3911a;
                int length = dVarArr.length;
                int i = this.f3912b;
                if (length == i) {
                    C2067d[] dVarArr2 = new C2067d[(i * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f3911a = dVarArr2;
                }
                C2067d[] dVarArr3 = this.f3911a;
                int i2 = this.f3912b;
                this.f3912b = i2 + 1;
                dVarArr3[i2] = dVar;
                m5277c();
            }

            /* renamed from: a */
            public boolean m5284a() {
                return this.f3912b == 0;
            }

            /* renamed from: a */
            public boolean m5285a(int i) {
                for (int i2 = 0; i2 < this.f3912b; i2++) {
                    if (this.f3911a[i2].f3914a == i) {
                        return true;
                    }
                }
                return false;
            }

            /* renamed from: b */
            public void mo18550b() {
                int i = 0;
                while (i < this.f3912b) {
                    if (this.f3911a[i].f3918a) {
                        this.f3913c++;
                        mo18551b(i);
                        i--;
                    }
                    i++;
                }
            }

            /* renamed from: b */
            public void mo18551b(int i) {
                int i2;
                if (i >= 0 && i < (i2 = this.f3912b)) {
                    C2067d[] dVarArr = this.f3911a;
                    int i3 = i2 - 1;
                    this.f3912b = i3;
                    dVarArr[i] = dVarArr[i3];
                    dVarArr[this.f3912b] = null;
                    m5278c(i);
                }
            }
        }

        C2065c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5270a(C2067d dVar) {
            this.f3905a.mo18549a(dVar);
            notify();
        }

        /* renamed from: a */
        public synchronized void mo18544a() {
            this.f3908b = true;
            this.f3905a.mo18546a();
            notify();
        }

        /* renamed from: a */
        public boolean m5274a() {
            return this.f3906a && SystemClock.uptimeMillis() - this.f3904a > 600000;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|(2:8|(3:83|10|11)(2:12|13))(2:17|26)|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r10.f3904a = android.os.SystemClock.uptimeMillis();
            r10.f3906a = true;
            r2.f3916a.run();
            r10.f3906a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a6, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a7, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            r10.f3908b = true;
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
                boolean r0 = r10.f3908b     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                return
            L_0x0007:
                com.xiaomi.push.service.j$c$a r0 = r10.f3905a     // Catch:{ all -> 0x00b5 }
                boolean r0 = r0.mo18546a()     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r10.f3909c     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x0015
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                return
            L_0x0015:
                r10.wait()     // Catch:{ InterruptedException -> 0x0018 }
            L_0x0018:
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                goto L_0x0000
            L_0x001a:
                long r0 = com.xiaomi.push.service.C2062j.mo18537a()     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.j$c$a r2 = r10.f3905a     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.j$d r2 = r2.mo18546a()     // Catch:{ all -> 0x00b5 }
                java.lang.Object r3 = r2.f3917a     // Catch:{ all -> 0x00b5 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b5 }
                boolean r4 = r2.f3918a     // Catch:{ all -> 0x00b2 }
                r5 = 0
                if (r4 == 0) goto L_0x0033
                com.xiaomi.push.service.j$c$a r0 = r10.f3905a     // Catch:{ all -> 0x00b2 }
                r0.mo18551b(r5)     // Catch:{ all -> 0x00b2 }
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                goto L_0x0018
            L_0x0033:
                long r6 = r2.f3915a     // Catch:{ all -> 0x00b2 }
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch:{ all -> 0x00b2 }
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L_0x005a
                long r2 = r10.f3907b     // Catch:{ all -> 0x00b5 }
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0047
                long r6 = r10.f3907b     // Catch:{ all -> 0x00b5 }
            L_0x0047:
                long r2 = r10.f3907b     // Catch:{ all -> 0x00b5 }
                long r2 = r2 + r0
                r10.f3907b = r2     // Catch:{ all -> 0x00b5 }
                long r0 = r10.f3907b     // Catch:{ all -> 0x00b5 }
                r2 = 500(0x1f4, double:2.47E-321)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0056
                r10.f3907b = r2     // Catch:{ all -> 0x00b5 }
            L_0x0056:
                r10.wait(r6)     // Catch:{ InterruptedException -> 0x0018 }
                goto L_0x0018
            L_0x005a:
                r10.f3907b = r0     // Catch:{ all -> 0x00b5 }
                java.lang.Object r0 = r2.f3917a     // Catch:{ all -> 0x00b5 }
                monitor-enter(r0)     // Catch:{ all -> 0x00b5 }
                com.xiaomi.push.service.j$c$a r1 = r10.f3905a     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.j$d r1 = r1.mo18546a()     // Catch:{ all -> 0x00af }
                long r6 = r1.f3915a     // Catch:{ all -> 0x00af }
                long r8 = r2.f3915a     // Catch:{ all -> 0x00af }
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L_0x0074
                com.xiaomi.push.service.j$c$a r1 = r10.f3905a     // Catch:{ all -> 0x00af }
                int r1 = r1.mo18549a((com.xiaomi.push.service.C2062j.C2067d) r2)     // Catch:{ all -> 0x00af }
                goto L_0x0075
            L_0x0074:
                r1 = 0
            L_0x0075:
                boolean r6 = r2.f3918a     // Catch:{ all -> 0x00af }
                if (r6 == 0) goto L_0x0086
                com.xiaomi.push.service.j$c$a r1 = r10.f3905a     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.j$c$a r3 = r10.f3905a     // Catch:{ all -> 0x00af }
                int r2 = r3.mo18549a((com.xiaomi.push.service.C2062j.C2067d) r2)     // Catch:{ all -> 0x00af }
                r1.mo18551b(r2)     // Catch:{ all -> 0x00af }
                monitor-exit(r0)     // Catch:{ all -> 0x00af }
                goto L_0x0018
            L_0x0086:
                long r6 = r2.f3915a     // Catch:{ all -> 0x00af }
                r2.mo18552a(r6)     // Catch:{ all -> 0x00af }
                com.xiaomi.push.service.j$c$a r6 = r10.f3905a     // Catch:{ all -> 0x00af }
                r6.mo18551b(r1)     // Catch:{ all -> 0x00af }
                r2.f3915a = r3     // Catch:{ all -> 0x00af }
                monitor-exit(r0)     // Catch:{ all -> 0x00af }
                monitor-exit(r10)     // Catch:{ all -> 0x00b5 }
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00a6 }
                r10.f3904a = r3     // Catch:{ all -> 0x00a6 }
                r10.f3906a = r0     // Catch:{ all -> 0x00a6 }
                com.xiaomi.push.service.j$b r1 = r2.f3916a     // Catch:{ all -> 0x00a6 }
                r1.run()     // Catch:{ all -> 0x00a6 }
                r10.f3906a = r5     // Catch:{ all -> 0x00a6 }
                goto L_0x0000
            L_0x00a6:
                r1 = move-exception
                monitor-enter(r10)
                r10.f3908b = r0     // Catch:{ all -> 0x00ac }
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
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2062j.C2065c.run():void");
        }
    }

    /* renamed from: com.xiaomi.push.service.j$d */
    static class C2067d {

        /* renamed from: a */
        int f3914a;

        /* renamed from: a */
        long f3915a;

        /* renamed from: a */
        C2064b f3916a;

        /* renamed from: a */
        final Object f3917a = new Object();

        /* renamed from: a */
        boolean f3918a;

        /* renamed from: b */
        private long f3919b;

        C2067d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo18552a(long j) {
            synchronized (this.f3917a) {
                this.f3919b = j;
            }
        }

        /* renamed from: a */
        public boolean mo18553a() {
            boolean z;
            synchronized (this.f3917a) {
                z = !this.f3918a && this.f3915a > 0;
                this.f3918a = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f3897a = j;
    }

    public C2062j() {
        this(false);
    }

    public C2062j(String str) {
        this(str, false);
    }

    public C2062j(String str, boolean z) {
        if (str != null) {
            this.f3901a = new C2065c(str, z);
            this.f3900a = new C2063a(this.f3901a);
            return;
        }
        throw new NullPointerException("name == null");
    }

    public C2062j(boolean z) {
        this("Timer-" + mo18542b(), z);
    }

    /* renamed from: a */
    static synchronized long mo18537a() {
        long j;
        synchronized (C2062j.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f3898b) {
                f3897a += elapsedRealtime - f3898b;
            }
            f3898b = elapsedRealtime;
            j = f3897a;
        }
        return j;
    }

    /* renamed from: b */
    private static synchronized long mo18542b() {
        long j;
        synchronized (C2062j.class) {
            j = f3899c;
            f3899c = 1 + j;
        }
        return j;
    }

    /* renamed from: b */
    private void m5259b(C2064b bVar, long j) {
        synchronized (this.f3901a) {
            if (!C2065c.m5268a(this.f3901a)) {
                long a = j + mo18537a();
                if (a >= 0) {
                    C2067d dVar = new C2067d();
                    dVar.f3914a = bVar.f3903a;
                    dVar.f3916a = bVar;
                    dVar.f3915a = a;
                    this.f3901a.m5270a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    /* renamed from: a */
    public void m5260a() {
        C1524b.m2141a("quit. finalizer:" + this.f3900a);
        this.f3901a.mo18544a();
    }

    /* renamed from: a */
    public void mo18538a(int i) {
        synchronized (this.f3901a) {
            C2065c.m5268a(this.f3901a).mo18547a(i);
        }
    }

    /* renamed from: a */
    public void mo18539a(int i, C2064b bVar) {
        synchronized (this.f3901a) {
            C2065c.m5268a(this.f3901a).mo18548a(i, bVar);
        }
    }

    /* renamed from: a */
    public void mo18540a(C2064b bVar) {
        if (C1524b.m2140a() >= 1 || Thread.currentThread() == this.f3901a) {
            bVar.run();
        } else {
            C1524b.m2160d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    /* renamed from: a */
    public void mo18541a(C2064b bVar, long j) {
        if (j >= 0) {
            m5259b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }

    /* renamed from: a */
    public boolean m5265a() {
        return this.f3901a.mo18544a();
    }

    /* renamed from: a */
    public boolean m5266a(int i) {
        boolean a;
        synchronized (this.f3901a) {
            a = C2065c.m5268a(this.f3901a).mo18547a(i);
        }
        return a;
    }

    /* renamed from: b */
    public void m5267b() {
        synchronized (this.f3901a) {
            C2065c.m5268a(this.f3901a).mo18546a();
        }
    }
}
