package com.mbridge.msdk.foundation.same.e;

/* compiled from: CommonTask */
public abstract class a implements Runnable {
    public static long b;
    public C0062a c = C0062a.READY;
    public b d;

    /* renamed from: com.mbridge.msdk.foundation.same.e.a$a  reason: collision with other inner class name */
    /* compiled from: CommonTask */
    public enum C0062a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* compiled from: CommonTask */
    public interface b {
        void a(C0062a aVar);
    }

    public abstract void a();

    public abstract void b();

    public final void run() {
        try {
            if (this.c == C0062a.READY) {
                a(C0062a.RUNNING);
                a();
                a(C0062a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a() {
        b++;
    }

    public final void d() {
        if (this.c != C0062a.CANCEL) {
            a(C0062a.CANCEL);
            b();
        }
    }

    private void a(C0062a aVar) {
        this.c = aVar;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
