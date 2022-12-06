package com.bytedance.sdk.component.b.a.a.a;

import com.bytedance.sdk.component.b.a.b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: NetDispatcher */
public class d extends com.bytedance.sdk.component.b.a.d {
    private ExecutorService a;
    private List<b> b = new CopyOnWriteArrayList();
    private List<b> c = new CopyOnWriteArrayList();
    private AtomicInteger d = new AtomicInteger(64);

    public d() {
        if (this.a == null) {
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "systemHttp Dispatcher");
                    thread.setDaemon(false);
                    thread.setPriority(10);
                    return thread;
                }
            });
        }
    }

    public ExecutorService b() {
        return this.a;
    }

    public void a(int i) {
        this.d.set(i);
    }

    public List<b> c() {
        return this.b;
    }

    public List<b> d() {
        return this.c;
    }

    public int a() {
        return this.d.get();
    }
}
