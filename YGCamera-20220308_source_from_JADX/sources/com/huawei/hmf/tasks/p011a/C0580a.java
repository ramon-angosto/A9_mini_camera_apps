package com.huawei.hmf.tasks.p011a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hmf.tasks.a.a */
public final class C0580a {

    /* renamed from: a */
    static final int f172a;

    /* renamed from: b */
    static final int f173b = ((f175e * 2) + 1);

    /* renamed from: c */
    private static final C0580a f174c = new C0580a();

    /* renamed from: e */
    private static final int f175e;

    /* renamed from: d */
    private final Executor f176d = new C0581a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a */
    static class C0581a implements Executor {
        private C0581a() {
        }

        /* synthetic */ C0581a(byte b) {
            this();
        }

        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f175e = availableProcessors;
        f172a = availableProcessors + 1;
    }

    /* renamed from: a */
    public static ExecutorService m140a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f172a, f173b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static Executor m141b() {
        return f174c.f176d;
    }
}
