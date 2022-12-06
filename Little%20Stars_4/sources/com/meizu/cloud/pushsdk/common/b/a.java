package com.meizu.cloud.pushsdk.common.b;

import com.meizu.cloud.pushsdk.common.b.e;

class a {
    private static String a = "android.os.BuildExt";
    private static e.c<Boolean> b;

    public static synchronized e.c<Boolean> a() {
        e.c<Boolean> cVar;
        synchronized (a.class) {
            if (b == null) {
                b = new e.c<>();
            }
            if (!b.a) {
                b = e.a(a).b("isProductInternational").a();
            }
            cVar = b;
        }
        return cVar;
    }
}
