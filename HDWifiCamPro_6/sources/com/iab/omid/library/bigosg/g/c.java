package com.iab.omid.library.bigosg.g;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.bigosg.b.k;
import com.iab.omid.library.bigosg.b.l;
import com.iab.omid.library.bigosg.c.d;
import com.iab.omid.library.bigosg.c.e;
import com.iab.omid.library.bigosg.e.b;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class c extends a {
    WebView f;
    private Long g = null;
    private Map<String, k> h;
    private final String i;

    public c(Map<String, k> map, String str) {
        this.h = map;
        this.i = str;
    }

    public final void a() {
        super.a();
        this.f = new WebView(d.a().a);
        this.f.getSettings().setJavaScriptEnabled(true);
        a(this.f);
        e.a();
        e.a(this.f, this.i);
        for (String next : this.h.keySet()) {
            String externalForm = this.h.get(next).b.toExternalForm();
            e.a();
            WebView webView = this.f;
            if (externalForm != null && !TextUtils.isEmpty(next)) {
                e.a(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", next));
            }
        }
        this.g = Long.valueOf(System.nanoTime());
    }

    public final void a(l lVar, com.iab.omid.library.bigosg.b.d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, k> unmodifiableMap = Collections.unmodifiableMap(dVar.d);
        for (String next : unmodifiableMap.keySet()) {
            b.a(jSONObject, next, unmodifiableMap.get(next));
        }
        a(lVar, dVar, jSONObject);
    }

    public final void b() {
        super.b();
        new Handler().postDelayed(new Runnable() {
            private WebView b = c.this.f;

            public final void run() {
                this.b.destroy();
            }
        }, Math.max(4000 - (this.g == null ? 4000 : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.g.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.f = null;
    }
}
