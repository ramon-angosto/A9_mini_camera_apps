package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery */
public class d implements c {
    private final String a = d.class.getSimpleName();
    private final Executor b;

    public d(final Handler handler) {
        this.b = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(i<?> iVar, k<?> kVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new a(iVar, kVar));
        }
    }

    public final void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.a.a aVar) {
        if (this.b != null) {
            this.b.execute(new a(iVar, k.a(aVar)));
        }
    }

    public final void a(final i<?> iVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    iVar.p();
                }
            });
        }
    }

    public final void b(final i<?> iVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    iVar.n();
                }
            });
        }
    }

    public final void c(final i<?> iVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    iVar.o();
                }
            });
        }
    }

    public final void d(final i<?> iVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    iVar.r();
                }
            });
        }
    }

    public final void e(final i<?> iVar) {
        Executor executor = this.b;
        if (executor != null) {
            executor.execute(new Runnable() {
                public final void run() {
                    iVar.q();
                }
            });
        }
    }

    public final void a(i<?> iVar, long j, long j2) {
        Executor executor = this.b;
        if (executor != null) {
            final i<?> iVar2 = iVar;
            final long j3 = j;
            final long j4 = j2;
            executor.execute(new Runnable() {
                public final void run() {
                    iVar2.a(j3, j4);
                }
            });
        }
    }

    /* compiled from: ExecutorDelivery */
    private class a implements Runnable {
        private final i b;
        private final k c;

        public a(i iVar, k kVar) {
            this.b = iVar;
            this.c = kVar;
        }

        public final void run() {
            if (this.b.c()) {
                this.b.a("canceled-at-delivery");
                this.b.n();
                return;
            }
            if (this.c.b == null) {
                this.b.a(this.c);
            } else {
                this.b.a(this.c.b);
            }
            this.b.a("done");
            this.b.p();
        }
    }
}
