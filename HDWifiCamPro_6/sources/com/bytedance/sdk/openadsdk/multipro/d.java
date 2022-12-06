package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.m;

/* compiled from: TTPathConst */
public class d {
    public static String a = "com.bytedance.openadsdk";
    public static String b = ("content://" + a + ".TTMultiProvider");

    static {
        a();
    }

    public static void a() {
        if (m.a() != null) {
            a = m.a().getPackageName();
            b = "content://" + a + ".TTMultiProvider";
        }
    }
}
