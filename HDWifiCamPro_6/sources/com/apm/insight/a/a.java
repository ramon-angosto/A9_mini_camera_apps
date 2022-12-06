package com.apm.insight.a;

import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.runtime.p;

public class a implements ICrashCallback {
    private static volatile a d;
    private volatile String a;
    private volatile b b;
    private volatile c c;
    private volatile boolean e = false;

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public void a(CrashType crashType, long j, String str) {
    }

    public void a(String str) {
    }

    public void a(String str, b bVar, c cVar) {
        this.a = str;
        this.b = bVar;
        this.c = cVar;
        if (!this.e) {
            this.e = true;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                }
            });
        }
    }

    public void b() {
    }

    public void onCrash(CrashType crashType, String str, Thread thread) {
        boolean equals = crashType.equals(CrashType.NATIVE);
    }
}
