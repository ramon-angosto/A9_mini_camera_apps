package com.meizu.cloud.pushsdk.common.b;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g {
    private static ExecutorService a;

    private static synchronized Executor a() {
        ExecutorService executorService;
        synchronized (g.class) {
            if (a == null) {
                a = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new ArrayBlockingQueue(100, true));
            }
            executorService = a;
        }
        return executorService;
    }

    public static void a(a aVar) {
        a();
        try {
            a.execute(aVar);
        } catch (RejectedExecutionException unused) {
            new Thread(aVar).start();
        }
    }

    public static abstract class a implements Runnable {
        public abstract void a();

        public final void run() {
            a();
        }
    }
}
