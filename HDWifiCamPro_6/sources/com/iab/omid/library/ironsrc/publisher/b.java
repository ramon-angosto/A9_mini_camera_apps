package com.iab.omid.library.ironsrc.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.VerificationScriptResource;
import com.iab.omid.library.ironsrc.adsession.a;
import com.iab.omid.library.ironsrc.b.e;
import com.iab.omid.library.ironsrc.d.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */
    public WebView a;
    private Long b = null;
    private Map<String, VerificationScriptResource> c;
    private final String d;

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.c = map;
        this.d = str;
    }

    public void a() {
        super.a();
        j();
    }

    public void a(a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            com.iab.omid.library.ironsrc.d.b.a(jSONObject, next, injectedResourcesMap.get(next));
        }
        a(aVar, adSessionContext, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new Runnable() {
            private WebView b = b.this.a;

            public void run() {
                this.b.destroy();
            }
        }, Math.max(4000 - (this.b == null ? 4000 : TimeUnit.MILLISECONDS.convert(d.a() - this.b.longValue(), TimeUnit.NANOSECONDS)), 2000));
        this.a = null;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.a = new WebView(com.iab.omid.library.ironsrc.b.d.a().b());
        this.a.getSettings().setJavaScriptEnabled(true);
        a(this.a);
        e.a().a(this.a, this.d);
        for (String next : this.c.keySet()) {
            e.a().a(this.a, this.c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.b = Long.valueOf(d.a());
    }
}
