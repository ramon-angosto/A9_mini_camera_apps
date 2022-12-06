package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.ay */
class C1639ay {

    /* renamed from: a */
    static int f1826a;

    /* renamed from: a */
    public static C1633at m2598a(Context context) {
        if (C1638ax.m2591a(context)) {
            f1826a = 1;
            return new C1638ax(context);
        } else if (C1629ar.m2553a(context)) {
            f1826a = 2;
            return new C1629ar(context);
        } else if (C1642ba.m2643a(context)) {
            f1826a = 4;
            return new C1642ba(context);
        } else if (C1649be.m2658a(context)) {
            f1826a = 5;
            return new C1649be(context);
        } else if (C1637aw.m2589a(context)) {
            f1826a = 3;
            return new C1634au(context);
        } else {
            f1826a = 0;
            return new C1648bd();
        }
    }
}
