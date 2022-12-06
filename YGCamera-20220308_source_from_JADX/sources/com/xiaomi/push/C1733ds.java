package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ds */
public class C1733ds {

    /* renamed from: a */
    private static volatile C1733ds f2073a;

    /* renamed from: a */
    private C1732dr f2074a;

    /* renamed from: a */
    public static C1733ds mo17399a() {
        if (f2073a == null) {
            synchronized (C1733ds.class) {
                if (f2073a == null) {
                    f2073a = new C1733ds();
                }
            }
        }
        return f2073a;
    }

    /* renamed from: a */
    public C1732dr m3041a() {
        return this.f2074a;
    }

    /* renamed from: a */
    public void mo17400a(C1732dr drVar) {
        this.f2074a = drVar;
    }
}
