package com.mbridge.msdk.foundation.same.report.c;

/* compiled from: LogFileController */
public class a {
    public static final String a = a.class.getSimpleName();
    private static a b = null;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }
}
