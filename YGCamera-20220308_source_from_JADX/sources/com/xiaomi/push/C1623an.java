package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.an */
public class C1623an {

    /* renamed from: a */
    private int f1777a;

    /* renamed from: a */
    private Handler f1778a;

    /* renamed from: a */
    private C1624a f1779a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile C1625b f1780a;

    /* renamed from: a */
    private volatile boolean f1781a;

    /* renamed from: b */
    private final boolean f1782b;

    /* renamed from: com.xiaomi.push.an$a */
    private class C1624a extends Thread {

        /* renamed from: a */
        private final LinkedBlockingQueue<C1625b> f1784a = new LinkedBlockingQueue<>();

        public C1624a() {
            super("PackageProcessor");
        }

        /* renamed from: a */
        private void m2545a(int i, C1625b bVar) {
            try {
                C1623an.m2537a(C1623an.this).sendMessage(C1623an.m2537a(C1623an.this).obtainMessage(i, bVar));
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }

        /* renamed from: a */
        public void mo17225a(C1625b bVar) {
            try {
                this.f1784a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            long a = C1623an.m2537a(C1623an.this) > 0 ? (long) C1623an.m2537a(C1623an.this) : Long.MAX_VALUE;
            while (!C1623an.m2537a(C1623an.this)) {
                try {
                    C1625b poll = this.f1784a.poll(a, TimeUnit.SECONDS);
                    C1625b unused = C1623an.this.f1780a = poll;
                    if (poll != null) {
                        m2545a(0, poll);
                        poll.mo17228b();
                        m2545a(1, poll);
                    } else if (C1623an.m2537a(C1623an.this) > 0) {
                        C1623an.m2537a(C1623an.this);
                    }
                } catch (InterruptedException e) {
                    C1524b.m2155a((Throwable) e);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.an$b */
    public static abstract class C1625b {
        /* renamed from: a */
        public void mo17227a() {
        }

        /* renamed from: b */
        public abstract void mo17228b();

        /* renamed from: c */
        public void mo17229c() {
        }
    }

    public C1623an() {
        this(false);
    }

    public C1623an(boolean z) {
        this(z, 0);
    }

    public C1623an(boolean z, int i) {
        this.f1778a = null;
        this.f1781a = false;
        this.f1777a = 0;
        this.f1778a = new C1626ao(this, Looper.getMainLooper());
        this.f1782b = z;
        this.f1777a = i;
    }

    /* renamed from: a */
    private synchronized void m2540a() {
        this.f1779a = null;
        this.f1781a = true;
    }

    /* renamed from: a */
    public synchronized void mo17223a(C1625b bVar) {
        if (this.f1779a == null) {
            this.f1779a = new C1624a();
            this.f1779a.setDaemon(this.f1782b);
            this.f1781a = false;
            this.f1779a.start();
        }
        this.f1779a.mo17225a(bVar);
    }

    /* renamed from: a */
    public void mo17224a(C1625b bVar, long j) {
        this.f1778a.postDelayed(new C1627ap(this, bVar), j);
    }
}
