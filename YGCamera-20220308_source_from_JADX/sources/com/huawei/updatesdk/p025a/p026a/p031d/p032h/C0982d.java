package com.huawei.updatesdk.p025a.p026a.p031d.p032h;

/* renamed from: com.huawei.updatesdk.a.a.d.h.d */
public class C0982d {

    /* renamed from: a */
    private static int f1323a = -1;

    /* renamed from: a */
    public static int m1749a() {
        if (f1323a == -1) {
            f1323a = (!"zh".equals(C0981c.m1727a("ro.product.locale.language", "")) || !"CN".equals(C0981c.m1727a("ro.product.locale.region", ""))) ? 1 : 0;
        }
        return f1323a;
    }
}
