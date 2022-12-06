package sg.bigo.ads.common.utils;

import android.os.Handler;
import android.os.SystemClock;

public abstract class l {
    private long a;
    private final Handler b = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r13) {
            /*
                r12 = this;
                sg.bigo.ads.common.utils.l r13 = sg.bigo.ads.common.utils.l.this
                monitor-enter(r13)
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                boolean r0 = r0.h     // Catch:{ all -> 0x0073 }
                if (r0 != 0) goto L_0x0071
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                boolean r0 = r0.i     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0010
                goto L_0x0071
            L_0x0010:
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r0 = r0.e     // Catch:{ all -> 0x0073 }
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0073 }
                long r0 = r0 - r2
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                r5 = 1
                if (r4 > 0) goto L_0x002a
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                r0.i = r5     // Catch:{ all -> 0x0073 }
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                r0.a()     // Catch:{ all -> 0x0073 }
                goto L_0x006f
            L_0x002a:
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r6 = r4.f     // Catch:{ all -> 0x0073 }
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x004d
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r6 = r4.g     // Catch:{ all -> 0x0073 }
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x004d
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r6 = r4.d     // Catch:{ all -> 0x0073 }
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r8 = r4.g     // Catch:{ all -> 0x0073 }
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r10 = r4.f     // Catch:{ all -> 0x0073 }
                long r8 = r8 - r10
                long r6 = r6 - r8
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                r4.g = r2     // Catch:{ all -> 0x0073 }
                goto L_0x0051
            L_0x004d:
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r6 = r4.d     // Catch:{ all -> 0x0073 }
            L_0x0051:
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x005b
                sg.bigo.ads.common.utils.l r4 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r8 = r4.d     // Catch:{ all -> 0x0073 }
                long r6 = r6 + r8
                goto L_0x0051
            L_0x005b:
                sg.bigo.ads.common.utils.l r2 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                r2.a(r0)     // Catch:{ all -> 0x0073 }
                sg.bigo.ads.common.utils.l r0 = sg.bigo.ads.common.utils.l.this     // Catch:{ all -> 0x0073 }
                long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0073 }
                r0.f = r1     // Catch:{ all -> 0x0073 }
                android.os.Message r0 = r12.obtainMessage(r5)     // Catch:{ all -> 0x0073 }
                r12.sendMessageDelayed(r0, r6)     // Catch:{ all -> 0x0073 }
            L_0x006f:
                monitor-exit(r13)     // Catch:{ all -> 0x0073 }
                return
            L_0x0071:
                monitor-exit(r13)     // Catch:{ all -> 0x0073 }
                return
            L_0x0073:
                r0 = move-exception
                monitor-exit(r13)     // Catch:{ all -> 0x0073 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.l.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    final long d = 1000;
    long e;
    long f;
    long g;
    boolean h = false;
    boolean i = false;

    public l(long j) {
        this.a = j;
    }

    public abstract void a();

    public abstract void a(long j);

    public final synchronized void b() {
        this.h = true;
        this.b.removeMessages(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized sg.bigo.ads.common.utils.l c() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r6.h = r0     // Catch:{ all -> 0x002e }
            long r0 = r6.a     // Catch:{ all -> 0x002e }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 > 0) goto L_0x0018
            boolean r0 = r6.i     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0016
            r6.i = r1     // Catch:{ all -> 0x002e }
            r6.a()     // Catch:{ all -> 0x002e }
        L_0x0016:
            monitor-exit(r6)
            return r6
        L_0x0018:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x002e }
            long r4 = r6.a     // Catch:{ all -> 0x002e }
            long r2 = r2 + r4
            r6.e = r2     // Catch:{ all -> 0x002e }
            android.os.Handler r0 = r6.b     // Catch:{ all -> 0x002e }
            android.os.Handler r2 = r6.b     // Catch:{ all -> 0x002e }
            android.os.Message r1 = r2.obtainMessage(r1)     // Catch:{ all -> 0x002e }
            r0.sendMessage(r1)     // Catch:{ all -> 0x002e }
            monitor-exit(r6)
            return r6
        L_0x002e:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.utils.l.c():sg.bigo.ads.common.utils.l");
    }

    public final void d() {
        if (!this.i && !this.h) {
            b();
            this.g = SystemClock.elapsedRealtime();
            this.a = this.e - this.g;
        }
    }

    public final boolean e() {
        return !this.i && this.h;
    }
}
