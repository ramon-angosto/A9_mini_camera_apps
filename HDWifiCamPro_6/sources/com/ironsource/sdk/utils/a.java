package com.ironsource.sdk.utils;

import android.content.Context;
import com.ironsource.environment.h;

public final class a {
    private static a g;
    public String a = h.h();
    public String b = h.g();
    public String c = h.i();
    public String d = h.e();
    public int e = h.f();
    public String f;

    private a(Context context) {
        this.f = h.i(context);
    }

    public static a a(Context context) {
        if (g == null) {
            g = new a(context);
        }
        return g;
    }

    public static void a() {
        g = null;
    }

    public static float b(Context context) {
        return h.l(context);
    }
}
