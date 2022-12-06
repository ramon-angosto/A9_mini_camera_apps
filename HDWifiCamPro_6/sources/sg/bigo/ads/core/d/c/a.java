package sg.bigo.ads.core.d.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    public static Handler a;
    private static ExecutorService b = Executors.newFixedThreadPool(1, new sg.bigo.ads.common.f.b("Stat-Worker"));

    /* renamed from: sg.bigo.ads.core.d.c.a$a  reason: collision with other inner class name */
    static class C0137a extends b {
        /* access modifiers changed from: private */
        public Future c;

        C0137a(Runnable runnable) {
            super(runnable);
        }

        /* access modifiers changed from: protected */
        public final void a() {
            if (this.a != null) {
                this.c = a.a(this.a);
            }
        }
    }

    public static abstract class b implements Runnable {
        final Runnable a;
        final AtomicBoolean b = new AtomicBoolean(false);

        b(Runnable runnable) {
            this.a = runnable;
        }

        /* access modifiers changed from: protected */
        public abstract void a();

        public final void run() {
            if (!this.b.get()) {
                a();
            }
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BGAd-Stat-Handler");
        handlerThread.start();
        a = new Handler(handlerThread.getLooper());
    }

    public static Future a(final Runnable runnable) {
        return b.submit(new Runnable() {
            public final void run() {
                StringBuilder sb;
                String localizedMessage;
                try {
                    runnable.run();
                } catch (Exception e) {
                    sb = new StringBuilder("stat thread get exception:");
                    localizedMessage = e.getLocalizedMessage();
                    sb.append(localizedMessage);
                    sg.bigo.ads.common.k.a.a(0, "Stats", sb.toString());
                } catch (Throwable th) {
                    sb = new StringBuilder("stat thread get throwable:");
                    localizedMessage = th.getLocalizedMessage();
                    sb.append(localizedMessage);
                    sg.bigo.ads.common.k.a.a(0, "Stats", sb.toString());
                }
            }
        });
    }

    public static b a(Runnable runnable, long j) {
        C0137a aVar = new C0137a(runnable);
        a.postDelayed(aVar, j);
        return aVar;
    }

    public static void a(b bVar) {
        if (bVar != null) {
            bVar.b.set(true);
            if (bVar instanceof C0137a) {
                C0137a aVar = (C0137a) bVar;
                if (aVar.c != null) {
                    Future a2 = aVar.c;
                    if (a2 != null && !a2.isCancelled() && !a2.isDone()) {
                        a2.cancel(true);
                    }
                }
            }
            a.removeCallbacks(bVar);
        }
    }
}
