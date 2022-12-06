package com.bytedance.sdk.component.d.b;

import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.g;
import java.util.Map;

/* compiled from: HttpResponse */
public class d<T> implements f {
    Map<String, String> a;
    private int b;
    private T c;
    private String d;
    private g e;

    public d(int i, T t, String str) {
        this.b = i;
        this.c = t;
        this.d = str;
    }

    public d(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.a = map;
    }

    public g a() {
        return this.e;
    }

    public void a(g gVar) {
        this.e = gVar;
    }

    public int b() {
        return this.b;
    }

    public T c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public Map<String, String> e() {
        return this.a;
    }
}
