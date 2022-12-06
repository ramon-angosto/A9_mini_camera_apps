package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1854he;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;
import java.util.Hashtable;

/* renamed from: com.xiaomi.push.hi */
public class C1860hi {

    /* renamed from: a */
    private static final int f2639a = C1789ff.PING_RTT.mo17573a();

    /* renamed from: a */
    private static long f2640a = 0;

    /* renamed from: com.xiaomi.push.hi$a */
    static class C1861a {

        /* renamed from: a */
        static Hashtable<Integer, Long> f2641a = new Hashtable<>();
    }

    /* renamed from: a */
    public static void m3860a() {
        if (f2640a == 0 || SystemClock.elapsedRealtime() - f2640a > 7200000) {
            f2640a = SystemClock.elapsedRealtime();
            m3862a(0, f2639a);
        }
    }

    /* renamed from: a */
    public static void m3861a(int i) {
        C1790fg a = C1857hg.mo17753a().mo17753a();
        a.mo17576a(C1789ff.CHANNEL_STATS_COUNTER.mo17573a());
        a.mo17586c(i);
        C1857hg.mo17753a().mo17755a(a);
    }

    /* renamed from: a */
    public static synchronized void m3862a(int i, int i2) {
        synchronized (C1860hi.class) {
            if (i2 < 16777215) {
                C1861a.f2641a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                C1524b.m2160d("stats key should less than 16777215");
            }
        }
    }

    /* renamed from: a */
    public static void m3863a(int i, int i2, int i3, String str, int i4) {
        C1790fg a = C1857hg.mo17753a().mo17753a();
        a.mo17575a((byte) i);
        a.mo17576a(i2);
        a.mo17581b(i3);
        a.mo17582b(str);
        a.mo17586c(i4);
        C1857hg.mo17753a().mo17755a(a);
    }

    /* renamed from: a */
    public static synchronized void m3864a(int i, int i2, String str, int i3) {
        synchronized (C1860hi.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (C1861a.f2641a.containsKey(Integer.valueOf(i4))) {
                C1790fg a = C1857hg.mo17753a().mo17753a();
                a.mo17576a(i2);
                a.mo17581b((int) (currentTimeMillis - C1861a.f2641a.get(Integer.valueOf(i4)).longValue()));
                a.mo17582b(str);
                if (i3 > -1) {
                    a.mo17586c(i3);
                }
                C1857hg.mo17753a().mo17755a(a);
                C1861a.f2641a.remove(Integer.valueOf(i2));
            } else {
                C1524b.m2160d("stats key not found");
            }
        }
    }

    /* renamed from: a */
    public static void m3865a(XMPushService xMPushService, C2003az.C2005b bVar) {
        new C1851hb(xMPushService, bVar).mo17750a();
    }

    /* renamed from: a */
    public static void m3866a(String str, int i, Exception exc) {
        C1790fg a = C1857hg.mo17753a().mo17753a();
        if (!(C1857hg.mo17753a() == null || C1857hg.mo17753a().f2623a == null)) {
            a.mo17586c(C1653bi.m2686c(C1857hg.mo17753a().f2623a) ? 1 : 0);
        }
        if (i > 0) {
            a.mo17576a(C1789ff.GSLB_REQUEST_SUCCESS.mo17573a());
            a.mo17582b(str);
            a.mo17581b(i);
            C1857hg.mo17753a().mo17755a(a);
            return;
        }
        try {
            C1854he.C1855a a2 = C1854he.m3834a(exc);
            a.mo17576a(a2.f2618a.mo17573a());
            a.mo17587c(a2.f2619a);
            a.mo17582b(str);
            C1857hg.mo17753a().mo17755a(a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public static void m3867a(String str, Exception exc) {
        try {
            C1854he.C1855a b = C1854he.m3836b(exc);
            C1790fg a = C1857hg.mo17753a().mo17753a();
            a.mo17576a(b.f2618a.mo17573a());
            a.mo17587c(b.f2619a);
            a.mo17582b(str);
            if (!(C1857hg.mo17753a() == null || C1857hg.mo17753a().f2623a == null)) {
                a.mo17586c(C1653bi.m2686c(C1857hg.mo17753a().f2623a) ? 1 : 0);
            }
            C1857hg.mo17753a().mo17755a(a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public static byte[] m3868a() {
        C1791fh a = C1857hg.mo17753a().mo17753a();
        if (a != null) {
            return C1905iy.m4543a(a);
        }
        return null;
    }

    /* renamed from: b */
    public static void m3869b() {
        m3864a(0, f2639a, (String) null, -1);
    }

    /* renamed from: b */
    public static void m3870b(String str, Exception exc) {
        try {
            C1854he.C1855a d = C1854he.m3838d(exc);
            C1790fg a = C1857hg.mo17753a().mo17753a();
            a.mo17576a(d.f2618a.mo17573a());
            a.mo17587c(d.f2619a);
            a.mo17582b(str);
            if (!(C1857hg.mo17753a() == null || C1857hg.mo17753a().f2623a == null)) {
                a.mo17586c(C1653bi.m2686c(C1857hg.mo17753a().f2623a) ? 1 : 0);
            }
            C1857hg.mo17753a().mo17755a(a);
        } catch (NullPointerException unused) {
        }
    }
}
