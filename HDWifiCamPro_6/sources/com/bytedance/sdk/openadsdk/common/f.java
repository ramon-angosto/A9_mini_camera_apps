package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: LandingPageNewStyleManager */
public class f {
    private n a;
    private RelativeLayout b;
    private final Context c;
    private SSWebView d;
    private ImageView e;
    private final String f;
    private i g;
    private g h;

    public f(Context context, n nVar, String str) {
        this.c = context;
        this.a = nVar;
        this.f = str;
        f();
    }

    private void f() {
        this.b = (RelativeLayout) LayoutInflater.from(this.c).inflate(t.f(this.c, "tt_activity_endcard_landingpage_newstyle"), (ViewGroup) null, false);
        this.d = (SSWebView) this.b.findViewById(t.e(this.c, "tt_browser_webview"));
        this.g = new i(this.c, (RelativeLayout) this.b.findViewById(t.e(this.c, "tt_title_bar")), this.a);
        this.e = this.g.c();
        this.h = new g(this.c, (LinearLayout) this.b.findViewById(t.e(this.c, "tt_bottom_bar")), this.d, this.a, this.f);
    }

    public void a() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.a();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void b() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.b();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.b();
        }
    }

    public ImageView c() {
        return this.e;
    }

    public SSWebView d() {
        return this.d;
    }

    public View e() {
        return this.b;
    }

    public void a(WebView webView, int i) {
        i iVar = this.g;
        if (iVar != null) {
            iVar.a(webView, i);
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(webView);
        }
    }
}
