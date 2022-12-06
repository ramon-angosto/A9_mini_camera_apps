package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.C1938m;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.channel.commonutils.logger.b */
public abstract class C1524b {

    /* renamed from: a */
    private static int f1576a = 2;

    /* renamed from: a */
    private static Context f1577a = null;

    /* renamed from: a */
    private static LoggerInterface f1578a = new C1525a();

    /* renamed from: a */
    private static final Integer f1579a = -1;

    /* renamed from: a */
    private static String f1580a = ("XMPush-" + Process.myPid());

    /* renamed from: a */
    private static final HashMap<Integer, Long> f1581a = new HashMap<>();

    /* renamed from: a */
    private static AtomicInteger f1582a = new AtomicInteger(1);

    /* renamed from: a */
    private static boolean f1583a = false;

    /* renamed from: b */
    private static final HashMap<Integer, String> f1584b = new HashMap<>();

    /* renamed from: com.xiaomi.channel.commonutils.logger.b$a */
    static class C1525a implements LoggerInterface {

        /* renamed from: a */
        private String f1585a = C1524b.m2140a();

        C1525a() {
        }

        public void log(String str) {
            Log.v(this.f1585a, str);
        }

        public void log(String str, Throwable th) {
            Log.v(this.f1585a, str, th);
        }

        public void setTag(String str) {
            this.f1585a = str;
        }
    }

    /* renamed from: a */
    public static int m2140a() {
        return f1576a;
    }

    /* renamed from: a */
    public static Integer m2141a(String str) {
        if (f1576a > 1) {
            return f1579a;
        }
        Integer valueOf = Integer.valueOf(f1582a.incrementAndGet());
        f1581a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f1584b.put(valueOf, str);
        LoggerInterface loggerInterface = f1578a;
        loggerInterface.log(str + " starts");
        return valueOf;
    }

    /* renamed from: a */
    private static String m2143a(String str) {
        return m2156b() + str;
    }

    /* renamed from: a */
    public static String m2144a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    /* renamed from: a */
    public static void m2145a(int i) {
        if (i < 0 || i > 5) {
            m2146a(2, "set log level as " + i);
        }
        f1576a = i;
    }

    /* renamed from: a */
    public static void m2146a(int i, String str) {
        if (i >= f1576a) {
            f1578a.log(str);
        }
    }

    /* renamed from: a */
    public static void m2147a(int i, String str, Throwable th) {
        if (i >= f1576a) {
            f1578a.log(str, th);
        }
    }

    /* renamed from: a */
    public static void m2148a(int i, Throwable th) {
        if (i >= f1576a) {
            f1578a.log("", th);
        }
    }

    /* renamed from: a */
    public static void m2149a(Context context) {
        f1577a = context;
        if (C1938m.m4714a(context)) {
            f1583a = true;
        }
    }

    /* renamed from: a */
    public static void m2150a(LoggerInterface loggerInterface) {
        f1578a = loggerInterface;
    }

    /* renamed from: a */
    public static void m2151a(Integer num) {
        if (f1576a <= 1 && f1581a.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f1581a.remove(num).longValue();
            LoggerInterface loggerInterface = f1578a;
            loggerInterface.log(f1584b.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a */
    public static void m2152a(String str) {
        m2146a(2, m2141a(str));
    }

    /* renamed from: a */
    public static void m2153a(String str, String str2) {
        m2146a(2, m2157b(str, str2));
    }

    /* renamed from: a */
    public static void m2154a(String str, Throwable th) {
        m2147a(4, m2141a(str), th);
    }

    /* renamed from: a */
    public static void m2155a(Throwable th) {
        m2148a(4, th);
    }

    /* renamed from: b */
    private static String m2156b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* renamed from: b */
    private static String m2157b(String str, String str2) {
        return m2156b() + m2144a(str, str2);
    }

    /* renamed from: b */
    public static void m2158b(String str) {
        m2146a(0, m2141a(str));
    }

    /* renamed from: c */
    public static void m2159c(String str) {
        m2146a(1, m2141a(str));
    }

    /* renamed from: d */
    public static void m2160d(String str) {
        m2146a(4, m2141a(str));
    }

    /* renamed from: e */
    public static void m2161e(String str) {
        if (f1583a) {
            m2141a(str);
        } else {
            Log.i(f1580a, m2141a(str));
        }
    }
}
