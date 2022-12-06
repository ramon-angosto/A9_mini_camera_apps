package com.bytedance.sdk.component.e.a.a.a;

import com.bytedance.sdk.component.e.a.i;

/* compiled from: TTPathConst */
public class g {
    public static String a = "com.bytedance.openadsdk";
    public static String b = ("content://" + a + ".TTMultiProvider");

    static {
        a();
    }

    public static void a() {
        if (i.e().d() != null) {
            a = i.e().d().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}
