package com.bykv.vk.openvk.component.video.a.b.e;

import com.bykv.vk.openvk.component.video.a.b.i;
import com.bytedance.sdk.component.b.a.e;
import com.bytedance.sdk.component.b.a.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VolleyResponseWrapper */
public class f extends a {
    private m c;

    public f(m mVar, e eVar) {
        e g;
        this.c = mVar;
        this.a = new ArrayList();
        if (!(mVar == null || (g = mVar.g()) == null)) {
            for (int i = 0; i < g.a(); i++) {
                this.a.add(new i.b(g.a(i), g.b(i)));
            }
        }
        this.b = eVar;
    }

    public int a() {
        return this.c.c();
    }

    public boolean b() {
        return this.c.c() >= 200 && this.c.c() < 300;
    }

    public String a(String str, String str2) {
        return a(str) != null ? a(str).b : str2;
    }

    public List<i.b> c() {
        return this.a;
    }

    public InputStream d() {
        return this.c.f().c();
    }

    public String e() {
        m mVar = this.c;
        return (mVar == null || mVar.h() == null) ? "http/1.1" : this.c.h().toString();
    }

    public String f() {
        return a(this.c.c());
    }
}
