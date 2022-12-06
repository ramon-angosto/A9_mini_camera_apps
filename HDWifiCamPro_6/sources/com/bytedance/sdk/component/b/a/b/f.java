package com.bytedance.sdk.component.b.a.b;

/* compiled from: SegmentPool */
final class f {
    static e a;
    static long b;

    private f() {
    }

    static e a() {
        synchronized (f.class) {
            if (a == null) {
                return new e();
            }
            e eVar = a;
            a = eVar.f;
            eVar.f = null;
            b -= 8192;
            return eVar;
        }
    }

    static void a(e eVar) {
        if (eVar.f != null || eVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!eVar.d) {
            synchronized (f.class) {
                if (b + 8192 <= 65536) {
                    b += 8192;
                    eVar.f = a;
                    eVar.c = 0;
                    eVar.b = 0;
                    a = eVar;
                }
            }
        }
    }
}
