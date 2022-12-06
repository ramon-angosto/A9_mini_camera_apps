package com.bytedance.sdk.component.widget.a;

/* compiled from: BaseAdapterInstance */
public class a {
    private static volatile a b;
    private volatile b a;

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public b b() {
        return this.a;
    }
}
