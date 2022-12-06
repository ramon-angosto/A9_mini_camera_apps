package com.bytedance.sdk.openadsdk.j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashMonitor */
public class b {
    /* access modifiers changed from: private */
    public ScheduledExecutorService a = null;
    /* access modifiers changed from: private */
    public g b;
    /* access modifiers changed from: private */
    public long c = 0;
    /* access modifiers changed from: private */
    public a d;

    /* compiled from: CrashMonitor */
    public interface a {
        void a();
    }

    public b(g gVar) {
        this.b = gVar;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(int i) {
        this.a = Executors.newScheduledThreadPool(1);
        this.a.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (System.currentTimeMillis() - b.this.c > 2000) {
                    b.this.a.shutdown();
                    if (b.this.b != null) {
                        b.this.b.t();
                    }
                    if (b.this.d != null) {
                        b.this.d.a();
                    }
                }
            }
        }, 0, (long) i, TimeUnit.MILLISECONDS);
    }

    public void a() {
        ScheduledExecutorService scheduledExecutorService = this.a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
