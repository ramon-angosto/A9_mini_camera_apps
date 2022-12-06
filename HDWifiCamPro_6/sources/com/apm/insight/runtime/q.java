package com.apm.insight.runtime;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

public class q {
    /* access modifiers changed from: private */
    public static long a = -1;

    public static class a {
        private static long a = -1;

        public static long a() {
            if (q.a == -1) {
                long unused = q.a = 1000 / b();
            }
            return q.a;
        }

        public static long a(long j) {
            long j2 = a;
            if (j2 > 0) {
                return j2;
            }
            long sysconf = Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : Build.VERSION.SDK_INT >= 14 ? a("_SC_CLK_TCK", j) : j;
            if (sysconf > 0) {
                j = sysconf;
            }
            a = j;
            return a;
        }

        private static long a(String str, long j) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt((Object) null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                Class<?> cls2 = Class.forName("libcore.io.Os");
                Object obj = cls.getField("os").get((Object) null);
                return ((Long) cls2.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return j;
            }
        }

        public static long b() {
            return a(100);
        }
    }
}
