package com.bytedance.sdk.component.d.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory */
public class a implements ThreadFactory {
    private final ThreadGroup a;
    private final AtomicInteger b = new AtomicInteger(1);

    public a(String str) {
        this.a = new ThreadGroup("tt_img_" + str);
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.a;
        Thread thread = new Thread(threadGroup, runnable, "tt_img_" + this.b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
