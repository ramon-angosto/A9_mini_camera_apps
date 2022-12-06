package com.huawei.updatesdk.p039b.p048g;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.updatesdk.b.g.c */
public class C1034c {

    /* renamed from: a */
    public static final ThreadPoolExecutor f1394a = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1035a("UpdateSDK-ServerTask"));

    /* renamed from: b */
    public static final ThreadPoolExecutor f1395b = new ThreadPoolExecutor(0, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C1035a("UpdateSDK-CheckTask"));

    /* renamed from: com.huawei.updatesdk.b.g.c$a */
    private static class C1035a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f1396a = new AtomicInteger();

        /* renamed from: b */
        private String f1397b;

        public C1035a(String str) {
            this.f1397b = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f1397b + "#" + this.f1396a.incrementAndGet());
        }
    }
}
