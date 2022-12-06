package com.bytedance.sdk.component.d.c;

import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.k;
import java.util.Map;

/* compiled from: ImageResponse */
public class d<T> implements k {
    private String a;
    private String b;
    private T c;
    private T d;
    private int e;
    private int f;
    private Map<String, String> g;
    private boolean h;
    private boolean i;
    private g j;
    private int k;

    public d a(c cVar, T t) {
        this.c = t;
        this.a = cVar.e();
        this.b = cVar.a();
        this.e = cVar.b();
        this.f = cVar.c();
        this.i = cVar.n();
        this.j = cVar.o();
        this.k = cVar.p();
        return this;
    }

    public d a(c cVar, T t, Map<String, String> map, boolean z) {
        this.g = map;
        this.h = z;
        return a(cVar, t);
    }

    public String a() {
        return this.b;
    }

    public T b() {
        return this.c;
    }

    public T c() {
        return this.d;
    }

    public void a(Object obj) {
        this.d = this.c;
        this.c = obj;
    }

    public Map<String, String> d() {
        return this.g;
    }

    public boolean e() {
        return this.i;
    }

    public g f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }
}
