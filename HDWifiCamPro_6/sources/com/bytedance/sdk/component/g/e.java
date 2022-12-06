package com.bytedance.sdk.component.g;

import com.bytedance.sdk.component.g.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TTExecutor */
public class e {
    public static final int a = Runtime.getRuntime().availableProcessors();
    public static c b;
    public static int c = 120;
    public static boolean d = true;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;
    private static volatile ThreadPoolExecutor g;
    private static volatile ThreadPoolExecutor h;
    private static volatile ScheduledExecutorService i;

    public static ExecutorService a() {
        return a(10);
    }

    public static ExecutorService a(int i2) {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new a.C0037a().a("io").a(4).c(i2).a(40).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue(a)).a(f()).a();
                    e.allowCoreThreadTimeOut(true);
                }
            }
        }
        return e;
    }

    public static void a(g gVar) {
        if (e == null) {
            a();
        }
        if (e != null) {
            e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2) {
        if (e == null) {
            a();
        }
        if (gVar != null && e != null) {
            gVar.setPriority(i2);
            e.execute(gVar);
        }
    }

    public static void a(g gVar, int i2, int i3) {
        if (e == null) {
            a(i3);
        }
        if (gVar != null && e != null) {
            gVar.setPriority(i2);
            e.execute(gVar);
        }
    }

    public static ExecutorService b() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new a.C0037a().a("log").c(10).a(2).a(40).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue()).a(f()).a();
                    g.allowCoreThreadTimeOut(true);
                }
            }
        }
        return g;
    }

    public static void b(g gVar) {
        if (g == null) {
            b();
        }
        if (g != null) {
            g.execute(gVar);
        }
    }

    public static void b(g gVar, int i2) {
        if (g == null) {
            b();
        }
        if (gVar != null && g != null) {
            gVar.setPriority(i2);
            g.execute(gVar);
        }
    }

    public static void c(g gVar, int i2) {
        if (h == null) {
            c();
        }
        if (gVar != null && h != null) {
            gVar.setPriority(i2);
            h.execute(gVar);
        }
    }

    public static ExecutorService c() {
        if (h == null) {
            synchronized (e.class) {
                if (h == null) {
                    h = new a.C0037a().a("aidl").c(10).a(2).a(30).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new PriorityBlockingQueue()).a(f()).a();
                    h.allowCoreThreadTimeOut(true);
                }
            }
        }
        return h;
    }

    public static ScheduledExecutorService d() {
        if (i == null) {
            synchronized (e.class) {
                if (i == null) {
                    i = Executors.newSingleThreadScheduledExecutor(new h(5, "scheduled"));
                }
            }
        }
        return i;
    }

    public static boolean e() {
        return d;
    }

    public static void a(boolean z) {
        d = z;
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static c g() {
        return b;
    }

    public static void a(c cVar) {
        b = cVar;
    }

    public static ExecutorService b(int i2) {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = new a.C0037a().a("ad").b(1).c(i2).a(300).a(TimeUnit.SECONDS).a((BlockingQueue<Runnable>) new LinkedBlockingQueue()).a(f()).a();
                    f.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f;
    }

    public static void c(int i2) {
        c = i2;
    }
}
