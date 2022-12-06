package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class f {
    private a a;
    /* access modifiers changed from: private */
    public Handler b;
    /* access modifiers changed from: private */
    public volatile boolean c;
    private final boolean d;
    /* access modifiers changed from: private */
    public int e;
    /* access modifiers changed from: private */
    public volatile b f;

    private class a extends Thread {
        private final LinkedBlockingQueue<b> b = new LinkedBlockingQueue<>();

        public a() {
            super("PackageProcessor");
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }

        public void run() {
            int a2 = f.this.e > 0 ? f.this.e : 1;
            while (!f.this.c) {
                try {
                    b unused = f.this.f = this.b.poll((long) a2, TimeUnit.SECONDS);
                    if (f.this.f != null) {
                        f.this.b.sendMessage(f.this.b.obtainMessage(0, f.this.f));
                        f.this.f.b();
                        f.this.b.sendMessage(f.this.b.obtainMessage(1, f.this.f));
                    } else if (f.this.e > 0) {
                        f.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                }
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public f() {
        this(false);
    }

    public f(boolean z) {
        this(z, 0);
    }

    public f(boolean z, int i) {
        this.b = null;
        this.c = false;
        this.e = 0;
        this.b = new g(this, Looper.getMainLooper());
        this.d = z;
        this.e = i;
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        this.a = null;
        this.c = true;
    }

    public synchronized void a(b bVar) {
        if (this.a == null) {
            this.a = new a();
            this.a.setDaemon(this.d);
            this.c = false;
            this.a.start();
        }
        this.a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.b.postDelayed(new h(this, bVar), j);
    }
}
