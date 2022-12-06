package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.g;
import com.bytedance.sdk.openadsdk.common.i;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.l.j;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.com.bytedance.overseas.sdk.a.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class TTLandingPageActivity extends Activity implements d {
    private static final String f = TTLandingPageActivity.class.getSimpleName();
    private JSONArray A = null;
    private String B;
    private int C = 0;
    private int D = 0;
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public i F;
    /* access modifiers changed from: private */
    public g G;
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout H;
    private boolean I;
    private String J = "ダウンロード";
    h a;
    TTAdDislikeDialog b;
    TTAdDislikeToast c;
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public SSWebView g;
    private ImageView h;
    /* access modifiers changed from: private */
    public ImageView i;
    private TextView j;
    private Context k;
    private int l;
    private ViewStub m;
    private ViewStub n;
    private ViewStub o;
    /* access modifiers changed from: private */
    public Button p;
    /* access modifiers changed from: private */
    public ProgressBar q;
    private String r;
    private String s;
    private u t;
    private int u;
    private String v;
    private n w;
    /* access modifiers changed from: private */
    public c x;
    private String y;
    private AtomicBoolean z = new AtomicBoolean(true);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a(3);
        super.onCreate(bundle);
        if (!TTAdSdk.isInitSuccess()) {
            finish();
        }
        try {
            m.a(this);
        } catch (Throwable unused) {
        }
        setContentView(t.f(this, "tt_activity_ttlandingpage"));
        Intent intent = getIntent();
        this.l = intent.getIntExtra("sdk_version", 1);
        this.r = intent.getStringExtra("adid");
        this.s = intent.getStringExtra("log_extra");
        this.u = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        this.y = stringExtra;
        b(4);
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra(CampaignEx.JSON_KEY_ICON_URL);
        this.v = intent.getStringExtra("event_tag");
        this.B = intent.getStringExtra("gecko_id");
        if (b.c()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.w = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra3));
                } catch (Exception e2) {
                    l.c(f, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", (Throwable) e2);
                }
            }
        } else {
            this.w = r.a().c();
            r.a().h();
        }
        if (this.w == null) {
            finish();
            return;
        }
        this.E = m.d().n();
        d();
        this.k = this;
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.widget.a.b.a(this.k).a(false).b(false).a(this.g.getWebView());
        }
        SSWebView sSWebView = this.g;
        if (!(sSWebView == null || sSWebView.getWebView() == null)) {
            this.a = new h(this, this.w, this.g.getWebView()).a(true);
        }
        e();
        this.g.setLandingPage(true);
        this.g.setTag("landingpage");
        this.g.setMaterialMeta(this.w.aK());
        this.g.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.k, this.t, this.r, this.a, true) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTLandingPageActivity.this.q != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.q.setVisibility(8);
                    }
                } catch (Throwable unused) {
                }
                if (TTLandingPageActivity.this.H != null) {
                    TTLandingPageActivity.this.H.b();
                }
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }
        });
        SSWebView sSWebView2 = this.g;
        if (sSWebView2 != null) {
            sSWebView2.setUserAgentString(j.a(sSWebView2.getWebView(), this.l));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.g.setMixedContentMode(0);
        }
        com.bytedance.sdk.openadsdk.c.c.a(this.k, this.w);
        com.bytedance.sdk.openadsdk.l.l.a(this.g, stringExtra);
        this.g.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.t, this.a) {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTLandingPageActivity.this.E) {
                    if (TTLandingPageActivity.this.F != null) {
                        TTLandingPageActivity.this.F.a(webView, i);
                    }
                    if (TTLandingPageActivity.this.G != null && i == 100) {
                        TTLandingPageActivity.this.G.a(webView);
                        return;
                    }
                    return;
                }
                if (TTLandingPageActivity.this.q != null && !TTLandingPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTLandingPageActivity.this.q.isShown()) {
                        TTLandingPageActivity.this.q.setProgress(i);
                    } else {
                        TTLandingPageActivity.this.q.setVisibility(8);
                    }
                }
                if (TTLandingPageActivity.this.H != null) {
                    TTLandingPageActivity.this.H.a(i);
                }
            }
        });
        if (this.E) {
            this.g.getWebView().setOnTouchListener(new View.OnTouchListener() {
                float a = 0.0f;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.a = motionEvent.getY();
                    }
                    if (motionEvent.getAction() == 2) {
                        float y = motionEvent.getY();
                        float f = this.a;
                        if (y - f > 8.0f) {
                            if (TTLandingPageActivity.this.F != null) {
                                TTLandingPageActivity.this.F.a();
                            }
                            if (TTLandingPageActivity.this.G != null) {
                                TTLandingPageActivity.this.G.a();
                            }
                            return false;
                        } else if (y - f < -8.0f) {
                            if (TTLandingPageActivity.this.F != null) {
                                TTLandingPageActivity.this.F.b();
                            }
                            if (TTLandingPageActivity.this.G != null) {
                                TTLandingPageActivity.this.G.b();
                            }
                        }
                    }
                    return false;
                }
            });
        }
        this.g.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTLandingPageActivity.this.x != null) {
                    TTLandingPageActivity.this.x.d();
                }
            }
        });
        TextView textView = this.j;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = t.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        b();
    }

    private void a(int i2) {
        if (i2 != 1 && Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
            } else {
                setRequestedOrientation(i2);
            }
        }
    }

    private void b() {
        n nVar = this.w;
        if (nVar != null && nVar.L() == 4) {
            ViewStub viewStub = this.o;
            if (viewStub != null) {
                viewStub.setVisibility(0);
            }
            this.p = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
            if (this.p != null) {
                a(c());
                if (this.x == null) {
                    this.x = com.com.bytedance.overseas.sdk.a.d.a(this, this.w, TextUtils.isEmpty(this.v) ? y.a(this.u) : this.v);
                }
                a aVar = new a(this, this.w, this.v, this.u);
                aVar.a(false);
                this.p.setOnClickListener(aVar);
                this.p.setOnTouchListener(aVar);
                aVar.c(true);
                aVar.a(this.x);
            }
        }
    }

    private String c() {
        n nVar = this.w;
        if (nVar != null && !TextUtils.isEmpty(nVar.W())) {
            this.J = this.w.W();
        }
        return this.J;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.p) != null) {
            button.post(new Runnable() {
                public void run() {
                    if (TTLandingPageActivity.this.p != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.p.setText(str);
                    }
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    private void d() {
        ViewStub viewStub;
        this.g = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.o = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
        this.m = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_view_stub"));
        this.n = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_dark_view_stub"));
        if (this.E) {
            ((ViewStub) findViewById(t.e(this, "tt_browser_new_title_bar_view_stub"))).setVisibility(0);
            ((ViewStub) findViewById(t.e(this, "tt_browser_new_bottom_bar_view_stub"))).setVisibility(0);
            this.F = new i(this, (RelativeLayout) findViewById(t.e(this, "tt_title_bar")), this.w);
            this.i = this.F.c();
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
            this.G = new g(this, (LinearLayout) findViewById(t.e(this, "tt_bottom_bar")), this.g, this.w, "landingpage");
            return;
        }
        int o2 = com.bytedance.sdk.openadsdk.core.h.d().o();
        if (o2 == 0) {
            ViewStub viewStub2 = this.m;
            if (viewStub2 != null) {
                viewStub2.setVisibility(0);
            }
        } else if (o2 == 1 && (viewStub = this.n) != null) {
            viewStub.setVisibility(0);
        }
        this.h = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.g == null) {
                        return;
                    }
                    if (TTLandingPageActivity.this.g.e()) {
                        TTLandingPageActivity.this.g.f();
                    } else if (TTLandingPageActivity.this.f()) {
                        TTLandingPageActivity.this.onBackPressed();
                    } else {
                        TTLandingPageActivity.this.finish();
                    }
                }
            });
        }
        this.i = (ImageView) findViewById(t.e(this, "tt_titlebar_close"));
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.j = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
        this.q = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
        this.q.setVisibility(0);
        TextView textView = (TextView) findViewById(t.e(this, "tt_titlebar_dislike"));
        textView.setText(t.a(m.a(), "tt_reward_feedback"));
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTLandingPageActivity.this.a();
            }
        });
        this.H = (LandingPageLoadingLayout) findViewById(t.e(this, "tt_landing_page_loading_layout"));
        LandingPageLoadingLayout landingPageLoadingLayout = this.H;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.w, this.v, true);
            this.H.a();
        }
    }

    private void e() {
        this.t = new u(this);
        this.t.b(this.g).d(this.r).e(this.s).a(this.w).b(this.u).a(this.w.F()).f(this.w.aY()).a(this.g).c("landingpage").a((d) this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u uVar = this.t;
        if (uVar != null) {
            uVar.k();
        }
        h hVar = this.a;
        if (hVar != null) {
            hVar.d();
        }
        if (!this.I) {
            this.I = true;
            a(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        h hVar = this.a;
        if (hVar != null) {
            hVar.e();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        r.a().b(true);
        u uVar = this.t;
        if (uVar != null) {
            uVar.l();
        }
    }

    public void onBackPressed() {
        if (!f() || this.z.getAndSet(true)) {
            try {
                super.onBackPressed();
            } catch (Throwable th) {
                l.c(f, "onBackPressed: ", th.getMessage());
            }
        } else {
            a(true);
            b(0);
        }
    }

    /* access modifiers changed from: private */
    public boolean f() {
        return !TextUtils.isEmpty(this.y) && this.y.contains("__luban_sdk");
    }

    private void b(final int i2) {
        if (this.i != null && f()) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    z.a((View) TTLandingPageActivity.this.i, i2);
                }
            });
        }
    }

    private void a(boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z2);
            this.t.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        SSWebView sSWebView;
        super.onDestroy();
        h hVar = this.a;
        if (!(hVar == null || (sSWebView = this.g) == null)) {
            hVar.a(sSWebView);
        }
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView2 = this.g;
        if (sSWebView2 != null) {
            x.a(this.k, sSWebView2.getWebView());
            x.a(this.g.getWebView());
        }
        this.g = null;
        u uVar = this.t;
        if (uVar != null) {
            uVar.m();
        }
        h hVar2 = this.a;
        if (hVar2 != null) {
            hVar2.f();
        }
    }

    public void a(boolean z2, JSONArray jSONArray) {
        if (z2 && jSONArray != null && jSONArray.length() > 0) {
            this.A = jSONArray;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (!isFinishing()) {
            if (this.e.get()) {
                h();
                return;
            }
            if (this.b == null) {
                g();
            }
            this.b.a();
        }
    }

    private void g() {
        try {
            if (this.b == null) {
                this.b = new TTAdDislikeDialog(this.k, this.w);
                this.b.setCallback(new TTAdDislikeDialog.a() {
                    public void c(View view) {
                    }

                    public void a(View view) {
                        TTLandingPageActivity.this.d.set(true);
                    }

                    public void b(View view) {
                        TTLandingPageActivity.this.d.set(false);
                    }

                    public void a(int i, FilterWord filterWord) {
                        if (!TTLandingPageActivity.this.e.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                            TTLandingPageActivity.this.e.set(true);
                            TTLandingPageActivity.this.i();
                        }
                    }
                });
            }
            ((FrameLayout) findViewById(16908290)).addView(this.b);
            if (this.c == null) {
                this.c = new TTAdDislikeToast(this.k);
                ((FrameLayout) findViewById(16908290)).addView(this.c);
            }
        } catch (Throwable unused) {
        }
    }

    private void h() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(com.bytedance.sdk.openadsdk.core.settings.j.d);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        TTAdDislikeToast tTAdDislikeToast;
        if (!isFinishing() && (tTAdDislikeToast = this.c) != null) {
            tTAdDislikeToast.a(com.bytedance.sdk.openadsdk.core.settings.j.e);
        }
    }
}
