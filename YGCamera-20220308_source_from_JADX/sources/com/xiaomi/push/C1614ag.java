package com.xiaomi.push;

import android.text.TextUtils;

/* renamed from: com.xiaomi.push.ag */
public class C1614ag {

    /* renamed from: a */
    public static String f1763a = "10.237.14.141";

    /* renamed from: a */
    public static boolean f1764a = false;

    /* renamed from: b */
    public static boolean f1765b = false;

    static {
        try {
            String a = C2086t.m5370a("log.tag.debug.xmsf", "false");
            if (!TextUtils.isEmpty(a)) {
                f1764a = Boolean.parseBoolean(a);
            }
        } catch (Throwable unused) {
        }
    }
}
