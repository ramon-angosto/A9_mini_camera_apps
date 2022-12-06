package com.a.a.a.a.g;

import android.os.Handler;
import android.webkit.WebView;
import com.a.a.a.a.b.d;
import com.a.a.a.a.b.l;
import com.a.a.a.a.b.m;
import com.a.a.a.a.c.e;
import com.a.a.a.a.e.b;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class c extends a {
    /* access modifiers changed from: private */
    public WebView a;
    private Long b = null;
    private final Map<String, l> c;
    private final String d;

    public c(Map<String, l> map, String str) {
        this.c = map;
        this.d = str;
    }

    public void a() {
        super.a();
        k();
    }

    public void a(m mVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, l> c2 = dVar.c();
        for (String next : c2.keySet()) {
            b.a(jSONObject, next, c2.get(next));
        }
        a(mVar, dVar, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new Runnable() {
            private final WebView b = c.this.a;

            public void run() {
                this.b.destroy();
            }
        }, Math.max(4000 - (this.b == null ? 4000 : TimeUnit.MILLISECONDS.convert(com.a.a.a.a.e.d.a() - this.b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.a = null;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.a = new WebView(com.a.a.a.a.c.d.a().b());
        this.a.getSettings().setJavaScriptEnabled(true);
        a(this.a);
        e.a().a(this.a, this.d);
        for (String next : this.c.keySet()) {
            e.a().a(this.a, this.c.get(next).b().toExternalForm(), next);
        }
        this.b = Long.valueOf(com.a.a.a.a.e.d.a());
    }
}
