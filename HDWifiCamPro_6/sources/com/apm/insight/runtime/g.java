package com.apm.insight.runtime;

import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.q;
import java.util.Comparator;

public class g {
    private static final Comparator<a> a = new Comparator<a>() {
        /* renamed from: a */
        public final int compare(a aVar, a aVar2) {
            int i = aVar.b + aVar.c;
            int i2 = aVar2.b + aVar2.c;
            if (i != i2) {
                return i > i2 ? -1 : 1;
            }
            return 0;
        }
    };
    private static byte[] b = new byte[4096];

    public static class a {
        public String a = "unknown";
        public int b;
        public int c;

        a() {
        }
    }

    public static long a(int i) {
        return NativeImpl.c(i) * q.a.a();
    }
}
