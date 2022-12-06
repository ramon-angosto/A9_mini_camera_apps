package com.bytedance.sdk.component.adexpress.a.a;

import com.bytedance.sdk.component.d.n;

/* compiled from: AdapterInstance */
public class a {
    private static volatile a e;
    private volatile b a;
    private volatile d b;
    private volatile c c;
    private volatile n d;

    private a() {
    }

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public b b() {
        return this.a;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public c c() {
        return this.c;
    }

    public void a(d dVar) {
        this.b = dVar;
    }

    public d d() {
        return this.b;
    }

    public void a(n nVar) {
        this.d = nVar;
    }

    public n e() {
        return this.d;
    }
}
