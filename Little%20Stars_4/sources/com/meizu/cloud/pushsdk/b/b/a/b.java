package com.meizu.cloud.pushsdk.b.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class b {
    private static ExecutorService a = null;
    private static int b = 2;

    private static ExecutorService a() {
        synchronized (b.class) {
            if (a == null) {
                a = Executors.newScheduledThreadPool(b);
            }
        }
        return a;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        b = i;
    }
}
