package sg.bigo.ads.common.c.a;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.f.b;

public final class c {
    final LinkedList<Runnable> a = new LinkedList<>();
    final Object b = new Object();
    final ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("Waitable"));

    static class a implements Runnable {
        final CountDownLatch a = new CountDownLatch(1);
        Runnable b = new Runnable() {
            public final void run() {
                try {
                    a.this.a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };
        private final Runnable c;

        public a(Runnable runnable) {
            this.c = runnable;
        }

        public final void run() {
            this.c.run();
            this.a.countDown();
        }
    }

    public c() {
        this.c.allowCoreThreadTimeOut(true);
    }
}
