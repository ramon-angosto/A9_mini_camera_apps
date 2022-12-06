package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zao implements zam {
    private zao() {
    }

    /* synthetic */ zao(zan zan) {
    }

    public final ExecutorService zaa(ThreadFactory threadFactory, int i) {
        return zac(1, threadFactory, 1);
    }

    public final ExecutorService zab(int i, int i2) {
        return zac(4, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zac(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
