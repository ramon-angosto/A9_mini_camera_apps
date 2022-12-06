package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.bytedance.sdk.component.adexpress.a.c.b;
import com.bytedance.sdk.component.adexpress.b.f;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.d.a;
import com.bytedance.sdk.component.adexpress.d.e;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.l.v;
import com.bytedance.sdk.openadsdk.l.y;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebViewRender */
public class n extends a {
    com.bytedance.sdk.openadsdk.l.a f;
    private Context g;
    private String h;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.model.n i;
    private JSONObject j;
    private m k;
    private String l;
    private h m;
    private final Map<String, c> n = Collections.synchronizedMap(new HashMap());
    private u o;
    /* access modifiers changed from: private */
    public f p;
    private n.a q;
    private final Runnable r = new Runnable() {
        public void run() {
            if (!n.this.e.get()) {
                if (!(n.this.i == null || n.this.i.G() == null)) {
                    n nVar = n.this;
                    b unused = nVar.d = com.bytedance.sdk.component.adexpress.a.b.a.c(nVar.i.G().b());
                }
                k.d().post(n.this.s);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable s = new Runnable() {
        public void run() {
            if (!n.this.e.get() && n.this.p != null) {
                n nVar = n.this;
                n.super.a(nVar.p);
            }
        }
    };
    private int t = 8;

    public n(Context context, l lVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, m mVar, com.bytedance.sdk.openadsdk.core.model.n nVar) {
        super(context, lVar, themeStatusBroadcastReceiver);
        if (this.b != null && this.b.getWebView() != null) {
            this.g = context;
            this.h = lVar.b();
            this.i = nVar;
            this.k = mVar;
            this.j = lVar.a();
            this.l = com.bytedance.sdk.component.adexpress.a.b.a.e();
            a(v.a(this.l));
            themeStatusBroadcastReceiver.a(this);
            n();
            m();
            o();
        }
    }

    public void m() {
        if (this.b != null && this.b.getWebView() != null) {
            this.o = new u(this.g);
            this.o.b(this.b).a(this.i).d(this.i.Y()).e(this.i.ac()).b(y.a(this.h)).f(this.i.aY()).a((j) this).a(this.j).a(this.b).a(this.k);
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.core.model.n nVar = this.i;
        if (nVar != null && nVar.G() != null) {
            this.q = this.i.G();
        }
    }

    public void o() {
        if (this.b != null && this.b.getWebView() != null) {
            this.b.setBackgroundColor(0);
            this.b.setBackgroundResource(17170445);
            a(this.b);
            if (a() != null) {
                this.m = new h(this.g, this.i, a().getWebView()).a(false);
            }
            this.m.a(this.k);
            this.b.setWebViewClient(new f(this.g, this.o, this.i, this.m));
            this.b.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.o, this.m));
            if (Build.VERSION.SDK_INT >= 17) {
                e.a().a(this.b, (com.bytedance.sdk.component.adexpress.d.b) this.o);
            }
        }
    }

    public void a(f fVar) {
        this.p = fVar;
        com.bytedance.sdk.component.g.e.a().execute(this.r);
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            try {
                com.bytedance.sdk.openadsdk.core.widget.a.b.a(this.g).a(false).a(sSWebView.getWebView());
                sSWebView.setVerticalScrollBarEnabled(false);
                sSWebView.setHorizontalScrollBarEnabled(false);
                sSWebView.a(true);
                sSWebView.j();
                sSWebView.setUserAgentString(com.bytedance.sdk.openadsdk.l.j.a(sSWebView.getWebView(), (int) BuildConfig.VERSION_CODE));
                if (Build.VERSION.SDK_INT >= 21) {
                    sSWebView.setMixedContentMode(0);
                }
                sSWebView.setJavaScriptEnabled(true);
                sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
                sSWebView.setDomStorageEnabled(true);
                sSWebView.setDatabaseEnabled(true);
                sSWebView.setAppCacheEnabled(true);
                sSWebView.setAllowFileAccess(false);
                sSWebView.setSupportZoom(true);
                sSWebView.setBuiltInZoomControls(true);
                sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
                sSWebView.setUseWideViewPort(true);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.l.e("WebViewRender", e.toString());
            }
        }
    }

    public SSWebView a() {
        return this.b;
    }

    public void d() {
        if (!this.e.get()) {
            u uVar = this.o;
            if (uVar != null) {
                uVar.b();
                this.o = null;
            }
            super.d();
            k.d().removeCallbacks(this.s);
            this.n.clear();
        }
    }

    public void f() {
        if (a() != null) {
            try {
                a().getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public void j() {
        super.j();
        if (this.o != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("expressShow", true);
                this.o.a("expressShow", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f = com.bytedance.sdk.openadsdk.core.h.d().c();
        com.bytedance.sdk.openadsdk.l.a aVar = this.f;
        if (aVar != null) {
            aVar.a((com.bytedance.sdk.component.adexpress.a) this);
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        super.l();
        com.bytedance.sdk.openadsdk.l.a aVar = this.f;
        if (aVar != null) {
            aVar.b((com.bytedance.sdk.component.adexpress.a) this);
        }
    }

    public void g() {
        u uVar = this.o;
        if (uVar != null) {
            uVar.a("expressWebviewRecycle", (JSONObject) null);
        }
    }

    public void a(int i2) {
        if (i2 != this.t) {
            this.t = i2;
            b(i2 == 0);
        }
    }

    private void b(boolean z) {
        if (this.o != null && this.b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adVisible", z);
                this.o.a("expressAdShow", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public u p() {
        return this.o;
    }

    public void b(int i2) {
        if (this.o != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.o.a("themeChange", jSONObject);
        }
    }

    public static boolean b(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }
}
