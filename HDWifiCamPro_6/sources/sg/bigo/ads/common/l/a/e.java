package sg.bigo.ads.common.l.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.f.b;
import sg.bigo.ads.common.l.b.c;

public abstract class e implements Runnable {
    private static final ExecutorService a = new ThreadPoolExecutor(0, 12, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("Net"));
    private final c b;
    private final sg.bigo.ads.common.l.b c;

    public e(c cVar, sg.bigo.ads.common.l.b bVar) {
        this.b = cVar;
        this.c = bVar;
    }

    public static void a() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(c cVar, sg.bigo.ads.common.l.b bVar);

    public final void b() {
        a.execute(this);
    }

    public final void run() {
        this.c.a(this.b);
        a(this.b, this.c);
    }
}
