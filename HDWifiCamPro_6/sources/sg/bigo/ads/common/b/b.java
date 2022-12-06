package sg.bigo.ads.common.b;

import android.os.SystemClock;

public final class b {
    private static final b e = new b();
    boolean a = true;
    long b;
    long c;
    public a d;

    public interface a {
        void a(long j);

        void a(boolean z, long j, long j2, long j3);
    }

    private b() {
        b();
    }

    public static b a() {
        return e;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.b = SystemClock.elapsedRealtime();
        this.c = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.b > 0;
    }
}
