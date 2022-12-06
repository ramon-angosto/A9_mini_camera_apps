package com.bytedance.sdk.component.g;

import java.util.concurrent.ThreadFactory;

/* compiled from: TTThreadFactory */
public class h implements ThreadFactory {
    private final ThreadGroup a;
    private final String b;
    private int c;

    public h(int i, String str) {
        this.c = i;
        this.a = new ThreadGroup("csj_g_" + str);
        this.b = "csj_" + str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.a, runnable, this.b);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.c;
        if (i > 10 || i < 1) {
            this.c = 5;
        }
        thread.setPriority(this.c);
        return thread;
    }
}
