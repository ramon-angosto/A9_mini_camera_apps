package sg.bigo.ads.common.o;

import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static final AtomicInteger a = new AtomicInteger();

    public static int a() {
        return a.incrementAndGet();
    }

    public static void a(int i) {
        a.set(i);
    }
}
