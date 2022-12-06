package sg.bigo.ads.core.b.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    public static Handler a;
    private static final ExecutorService b = Executors.newFixedThreadPool(1, new sg.bigo.ads.common.f.b("Callback-Worker"));

    static class a extends C0134b {
        /* access modifiers changed from: private */
        public Future c;

        a(Runnable runnable) {
            super(runnable);
        }

        /* access modifiers changed from: protected */
        public final void a() {
            if (this.a != null) {
                this.c = b.a(this.a);
            }
        }
    }

    /* renamed from: sg.bigo.ads.core.b.c.b$b  reason: collision with other inner class name */
    public static abstract class C0134b implements Runnable {
        final Runnable a;
        final AtomicBoolean b = new AtomicBoolean(false);

        C0134b(Runnable runnable) {
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
        HandlerThread handlerThread = new HandlerThread("BGAd-Callback-Handler");
        handlerThread.start();
        a = new Handler(handlerThread.getLooper());
    }

    public static Future<?> a(final Runnable runnable) {
        return b.submit(new Runnable() {
            public final void run() {
                StringBuilder sb;
                String localizedMessage;
                try {
                    runnable.run();
                } catch (Exception e) {
                    sb = new StringBuilder("callback thread get exception:");
                    localizedMessage = e.getLocalizedMessage();
                    sb.append(localizedMessage);
                    a.a(sb.toString());
                } catch (Throwable th) {
                    sb = new StringBuilder("callback thread get throwable:");
                    localizedMessage = th.getLocalizedMessage();
                    sb.append(localizedMessage);
                    a.a(sb.toString());
                }
            }
        });
    }

    public static C0134b a(Runnable runnable, long j) {
        a aVar = new a(runnable);
        a.postDelayed(aVar, j);
        return aVar;
    }

    public static void a(C0134b bVar) {
        if (bVar != null) {
            bVar.b.set(true);
            if (bVar instanceof a) {
                a aVar = (a) bVar;
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
