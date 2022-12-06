package com.bytedance.sdk.component.f.c;

import com.bytedance.sdk.component.b.a.g;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.m;
import java.io.IOException;

/* compiled from: TncHostInterceptor */
public class f implements g {
    private int a;

    public void a(int i) {
        this.a = i;
    }

    public m a(g.a aVar) throws IOException {
        m mVar;
        k a2 = aVar.a();
        if (g.a().a(this.a).b() != null) {
            g.a().a(this.a).b().e();
        }
        String fVar = a2.b().toString();
        String a3 = g.a().a(this.a).a(fVar);
        if (!fVar.equals(a3)) {
            a2 = a2.g().a(a3).b();
        }
        try {
            mVar = aVar.a(a2);
        } catch (Exception e) {
            g.a().a(this.a).a(a2, e);
            mVar = null;
        }
        g.a().a(this.a).a(a2, mVar);
        return mVar == null ? aVar.a(a2) : mVar;
    }
}
