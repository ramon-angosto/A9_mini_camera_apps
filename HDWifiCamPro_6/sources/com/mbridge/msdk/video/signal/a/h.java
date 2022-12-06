package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

/* compiled from: JSActivityProxy */
public final class h extends a {
    private WebView a;
    private int b = 0;

    public h(WebView webView) {
        this.a = webView;
    }

    public final void a() {
        super.a();
        this.b = 1;
        g.a().a(this.a, "onSystemPause", "");
    }

    public final void b() {
        super.b();
        this.b = 0;
        g.a().a(this.a, "onSystemResume", "");
    }

    public final void f() {
        super.f();
        g.a().a(this.a, "onSystemDestory", "");
    }

    public final void a(Configuration configuration) {
        super.a(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a(this.a, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void g() {
        super.g();
        g.a().a(this.a, "onSystemBackPressed", "");
    }

    public final void a(int i) {
        super.a(i);
        this.b = i;
    }

    public final int h() {
        return this.b;
    }
}
