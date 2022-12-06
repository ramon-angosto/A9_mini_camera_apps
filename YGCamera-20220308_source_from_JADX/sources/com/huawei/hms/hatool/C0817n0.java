package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.hatool.n0 */
public class C0817n0 {

    /* renamed from: b */
    public static C0817n0 f714b = new C0817n0();

    /* renamed from: c */
    public static C0817n0 f715c = new C0817n0();

    /* renamed from: a */
    public ThreadPoolExecutor f716a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));

    /* renamed from: com.huawei.hms.hatool.n0$a */
    public static class C0818a implements Runnable {

        /* renamed from: a */
        public Runnable f717a;

        public C0818a(Runnable runnable) {
            this.f717a = runnable;
        }

        public void run() {
            Runnable runnable = this.f717a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    C0841y.m1091e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    static {
        new C0817n0();
        new C0817n0();
    }

    /* renamed from: a */
    public static C0817n0 m970a() {
        return f715c;
    }

    /* renamed from: b */
    public static C0817n0 m971b() {
        return f714b;
    }

    /* renamed from: a */
    public void mo14082a(C0814m0 m0Var) {
        try {
            this.f716a.execute(new C0818a(m0Var));
        } catch (RejectedExecutionException unused) {
            C0841y.m1091e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
