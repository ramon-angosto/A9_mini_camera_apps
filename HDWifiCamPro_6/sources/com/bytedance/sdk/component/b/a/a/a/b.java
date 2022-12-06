package com.bytedance.sdk.component.b.a.a.a;

import com.bytedance.sdk.component.b.a.g;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.m;
import java.io.IOException;
import java.util.List;

/* compiled from: NetChain */
public class b implements g.a {
    List<g> a;
    k b;
    int c = 0;

    b(List<g> list, k kVar) {
        this.a = list;
        this.b = kVar;
    }

    public k a() {
        return this.b;
    }

    public m a(k kVar) throws IOException {
        this.b = kVar;
        this.c++;
        return this.a.get(this.c).a(this);
    }
}
