package com.mbridge.msdk.foundation.same.f;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public final class b {
    public static ThreadPoolExecutor a;

    public static ThreadPoolExecutor a() {
        if (a == null) {
            a = new ThreadPoolExecutor(5, 200, 15, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("CommonThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return a;
    }
}
