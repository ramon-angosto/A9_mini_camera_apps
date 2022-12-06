package com.bytedance.sdk.component.e.a.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.e.a.b.a.a;
import com.bytedance.sdk.component.e.a.b.c.c;
import com.bytedance.sdk.component.e.a.c.b;
import com.bytedance.sdk.component.e.a.e.e;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LogThreadCenter */
public class d {
    public static final d a = new d();
    public static final a d = new a();
    public static final AtomicLong e = new AtomicLong(0);
    public static final AtomicLong f = new AtomicLong(0);
    public static final long g = System.currentTimeMillis();
    public static long h = 0;
    public volatile boolean b = false;
    public volatile boolean c = false;
    private volatile c i;
    private volatile Handler j;
    private final Comparator<com.bytedance.sdk.component.e.a.d.a> k = new Comparator<com.bytedance.sdk.component.e.a.d.a>() {
        /* renamed from: a */
        public int compare(com.bytedance.sdk.component.e.a.d.a aVar, com.bytedance.sdk.component.e.a.d.a aVar2) {
            return d.this.a(aVar, aVar2);
        }
    };
    private final PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> l = new PriorityBlockingQueue<>(8, this.k);

    public PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> a() {
        return this.l;
    }

    private d() {
    }

    /* access modifiers changed from: private */
    public int a(com.bytedance.sdk.component.e.a.d.a aVar, com.bytedance.sdk.component.e.a.d.a aVar2) {
        long j2;
        long j3;
        long j4;
        long j5;
        if (aVar.e() != aVar2.e()) {
            return aVar.e() - aVar2.e();
        }
        if (aVar.a() != null) {
            j3 = aVar.a().a();
            j2 = aVar.a().b();
        } else {
            j3 = 0;
            j2 = 0;
        }
        if (aVar2.a() != null) {
            j5 = aVar2.a().a();
            j4 = aVar2.a().b();
        } else {
            j4 = 0;
            j5 = 0;
        }
        if (j3 == 0 || j5 == 0) {
            return 0;
        }
        long j6 = j3 - j5;
        if (Math.abs(j6) > 2147483647L) {
            return 0;
        }
        if (j6 != 0) {
            return (int) j6;
        }
        if (j2 == 0 || j4 == 0) {
            return 0;
        }
        return (int) (j2 - j4);
    }

    public void b() {
        d();
        e();
    }

    public void a(Handler handler) {
        this.j = handler;
    }

    public synchronized void c() {
        if (this.i != null && this.i.isAlive()) {
            if (this.j != null) {
                this.j.removeCallbacksAndMessages((Object) null);
            }
            this.i.a(false);
            if (Build.VERSION.SDK_INT >= 18) {
                this.i.quitSafely();
            } else {
                this.i.quit();
            }
            this.i = null;
        }
    }

    public synchronized boolean d() {
        try {
            if (this.i != null) {
                if (this.i.isAlive()) {
                    com.bytedance.sdk.component.e.a.c.c.a("LogThread state:" + this.i.getState());
                    return false;
                }
            }
            com.bytedance.sdk.component.e.a.c.c.a("--start LogThread--");
            this.i = new c(this.l);
            this.i.start();
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.e.a.c.c.d(th.getMessage());
            return false;
        }
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        d();
        f m = i.e().m();
        if (this.i != null) {
            a(m, aVar);
            this.i.a(aVar, aVar.e() == 4);
        }
    }

    private void a(f fVar, com.bytedance.sdk.component.e.a.d.a aVar) {
        if (fVar != null && fVar.h()) {
            long j2 = 0;
            if (!(aVar == null || aVar.a() == null)) {
                j2 = aVar.a().b();
            }
            final long j3 = j2;
            if (j3 == 1) {
                h = System.currentTimeMillis();
            }
            b.a(d.aa(), 1);
            if (j3 != 200) {
                return;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Executor e2 = fVar.e();
                if (e2 == null) {
                    e2 = fVar.f();
                }
                if (e2 != null) {
                    final f fVar2 = fVar;
                    e2.execute(new e(ReportDBAdapter.ReportColumns.TABLE_NAME) {
                        public void run() {
                            d.this.a(fVar2, j3);
                        }
                    });
                    return;
                }
                return;
            }
            com.bytedance.sdk.component.e.a.c.c.a("==> monitor upload index1:" + j3);
            a(fVar, j3);
        }
    }

    /* access modifiers changed from: private */
    public void a(f fVar, long j2) {
        if (fVar != null && this.i != null) {
            this.i.a(fVar.a(d.b(j2)), true);
            d.P();
        }
    }

    public void e() {
        b.a(d.H(), 1);
        com.bytedance.sdk.component.e.a.c.c.c("flushMemoryAndDB()");
        this.i.a(2);
    }
}
