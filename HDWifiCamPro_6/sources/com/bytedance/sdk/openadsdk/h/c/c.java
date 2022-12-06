package com.bytedance.sdk.openadsdk.h.c;

import com.bytedance.sdk.openadsdk.h.a;

/* compiled from: LogUploaderImplEmpty */
class c implements a {
    private static volatile c a;

    public void a() {
    }

    public void a(a aVar) {
    }

    public void a(a aVar, boolean z) {
    }

    public static c b() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    private c() {
    }
}
