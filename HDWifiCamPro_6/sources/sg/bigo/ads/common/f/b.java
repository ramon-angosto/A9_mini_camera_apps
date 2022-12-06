package sg.bigo.ads.common.f;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements ThreadFactory {
    private final String a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final ThreadFactory c = Executors.defaultThreadFactory();

    public b(String str) {
        this.a = "BGAd-".concat(String.valueOf(str));
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.c.newThread(runnable);
        newThread.setName(this.a + "-" + this.b.getAndIncrement());
        return newThread;
    }
}
