package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.push.u */
/* compiled from: ReceiverThreadPoolExecutor */
public class C0891u {

    /* renamed from: a */
    public static final Object f932a = new Object();

    /* renamed from: b */
    public static ThreadPoolExecutor f933b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static ThreadPoolExecutor m1326a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f932a) {
            threadPoolExecutor = f933b;
        }
        return threadPoolExecutor;
    }
}
