package com.apm.insight.b;

import android.content.Context;

public class g {
    private static volatile g a;
    private static h c;
    private final b b;

    private g(Context context) {
        this.b = new b(context);
        c = new h(0);
        c.b();
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    public static h b() {
        return c;
    }

    public b a() {
        return this.b;
    }

    public void c() {
        this.b.a();
    }

    public void d() {
        this.b.b();
    }
}
