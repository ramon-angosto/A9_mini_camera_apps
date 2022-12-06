package sg.bigo.ads.common.n;

import android.text.format.DateUtils;

public final class a {
    public static int a() {
        return ((Integer) b.b("consent_gdpr", 0, 0)).intValue();
    }

    public static int a(String str) {
        return ((Integer) b.b("impression_num_".concat(String.valueOf(str)), 0, 0)).intValue();
    }

    public static void a(int i) {
        b.a("consent_gdpr", Integer.valueOf(i), 0);
    }

    public static void a(long j) {
        b.a("last_stat_cb_events_time", Long.valueOf(j), 1);
    }

    public static void a(String str, int i) {
        b.a("impression_num_".concat(String.valueOf(str)), Integer.valueOf(i), 0);
    }

    public static void a(String str, long j) {
        b.a("last_impression_ts_".concat(String.valueOf(str)), Long.valueOf(j), 1);
    }

    public static int b() {
        return ((Integer) b.b("consent_ccpa", 0, 0)).intValue();
    }

    public static void b(int i) {
        b.a("consent_ccpa", Integer.valueOf(i), 0);
    }

    public static void b(String str) {
        long c = c(str);
        if (c > 0 && !DateUtils.isToday(c)) {
            a(str, 0);
            a(str, 0);
        }
    }

    private static long c(String str) {
        return ((Long) b.b("last_impression_ts_".concat(String.valueOf(str)), 0, 1)).longValue();
    }

    public static boolean c() {
        return a() == 2 || b() == 2;
    }
}
