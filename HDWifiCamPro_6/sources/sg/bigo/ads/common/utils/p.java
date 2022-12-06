package sg.bigo.ads.common.utils;

import android.os.SystemClock;
import sg.bigo.ads.common.n.b;

public final class p {
    private static a a = null;
    private static long b = 1619452800;

    static class a {
        private final long a;
        private final long b = SystemClock.elapsedRealtime();

        public a(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a + (SystemClock.elapsedRealtime() - this.b);
        }
    }

    public static long a() {
        long currentTimeMillis = System.currentTimeMillis() - ((Long) b.b("sp_fix_ts_diff", 0L, 1)).longValue();
        if (currentTimeMillis > 0) {
            return currentTimeMillis;
        }
        b.a("sp_fix_ts_diff", 0L, 1);
        return System.currentTimeMillis();
    }

    public static void a(long j) {
        if (j >= b) {
            a aVar = new a(j * 1000);
            if (a == null) {
                a = aVar;
            } else if (aVar.a() > a.a()) {
                a = aVar;
            }
        }
    }

    public static long b() {
        a aVar = a;
        return aVar == null ? System.currentTimeMillis() : aVar.a();
    }
}
