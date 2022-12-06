package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.same.net.g.c;
import com.mbridge.msdk.foundation.same.report.a.a;
import com.mbridge.msdk.foundation.tools.q;
import org.json.JSONObject;

/* compiled from: Listener */
public class f<T> implements e<T> {
    private long a;
    private a b = null;
    public String d = "";
    public String e = "";
    public int f = 0;

    public void a(long j, long j2) {
    }

    public void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
    }

    public void b() {
    }

    public void c() {
    }

    public final void d() {
    }

    public final void e() {
    }

    public void a() {
        this.a = System.currentTimeMillis();
    }

    public void a(k<T> kVar) {
        try {
            String str = com.mbridge.msdk.foundation.controller.a.e().h() + "_" + this.e + "_" + this.d + "_" + this.f;
            if (kVar.a instanceof JSONObject) {
                c.a().a(str, ((JSONObject) kVar.a).optInt("status"), ((JSONObject) kVar.a).toString(), System.currentTimeMillis());
            }
            if (kVar.a instanceof String) {
                c.a().a(str, new JSONObject((String) kVar.a).optInt("status"), (String) kVar.a, System.currentTimeMillis());
            }
        } catch (Exception e2) {
            q.d("Listener", e2.getMessage());
        }
    }

    public final void a(long j) {
        this.b = new a(new g());
        this.b.b(this.d);
        this.b.a(1);
        a aVar = this.b;
        aVar.a((j - this.a) + "");
    }

    public final void a(int i) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b(i);
            this.b.a();
        }
    }

    public final void b(int i) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(i);
        }
    }
}
