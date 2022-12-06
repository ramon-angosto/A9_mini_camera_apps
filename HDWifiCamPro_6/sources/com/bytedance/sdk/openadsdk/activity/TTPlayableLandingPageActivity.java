package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.b.d;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.j.a;
import com.bytedance.sdk.openadsdk.j.f;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.jslistener.f;
import com.bytedance.sdk.openadsdk.l.j;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.com.bytedance.overseas.sdk.a.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTPlayableLandingPageActivity extends Activity implements x.a, d, f {
    private static final f.a L = new f.a() {
        public void a(String str, String str2) {
            l.b(str, str2);
        }

        public void a(String str, String str2, Throwable th) {
            l.c(str, str2, th);
        }
    };
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private c C;
    private AtomicBoolean D = new AtomicBoolean(false);
    private String E;
    private int F = 0;
    private int G = 0;
    /* access modifiers changed from: private */
    public g H;
    /* access modifiers changed from: private */
    public boolean I = false;
    /* access modifiers changed from: private */
    public m J;
    private h K;
    TTAdDislike a;
    TTAdDislikeToast b;
    final AtomicBoolean c = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.jslistener.g d;
    protected com.bytedance.sdk.openadsdk.jslistener.d e = new com.bytedance.sdk.openadsdk.jslistener.d() {
        public void a() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && p.e(TTPlayableLandingPageActivity.this.y) && p.g(TTPlayableLandingPageActivity.this.y)) {
                TTPlayableLandingPageActivity.this.z.removeMessages(2);
                TTPlayableLandingPageActivity.this.z.sendMessage(TTPlayableLandingPageActivity.this.a(1));
            }
        }

        public void b() {
            if (p.e(TTPlayableLandingPageActivity.this.y) && p.f(TTPlayableLandingPageActivity.this.y)) {
                TTPlayableLandingPageActivity.this.z.sendMessageDelayed(TTPlayableLandingPageActivity.this.a(0), 1000);
            }
        }

        public void a(int i) {
            if (p.e(TTPlayableLandingPageActivity.this.y) && TTPlayableLandingPageActivity.this.p != null) {
                TTPlayableLandingPageActivity.this.p.setProgress(i);
            }
        }
    };
    private SSWebView f;
    private SSWebView g;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = true;
    private RelativeLayout j;
    private View k;
    private ImageView l;
    private Context m;
    private int n;
    /* access modifiers changed from: private */
    public ProgressBar o;
    /* access modifiers changed from: private */
    public PlayableLoadingView p;
    private String q;
    private String r;
    /* access modifiers changed from: private */
    public u s;
    private u t;
    private int u;
    /* access modifiers changed from: private */
    public String v;
    private String w;
    private final String x = "embeded_ad";
    /* access modifiers changed from: private */
    public n y;
    /* access modifiers changed from: private */
    public x z = new x(Looper.getMainLooper(), this);

    /* access modifiers changed from: private */
    public Message a(int i2) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i2;
        return obtain;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!TTAdSdk.isInitSuccess()) {
            finish();
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            com.bytedance.sdk.openadsdk.core.m.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        n nVar = this.y;
        if (nVar != null) {
            int h2 = p.h(nVar);
            if (h2 != 0) {
                if (h2 == 1) {
                    setRequestedOrientation(1);
                } else if (h2 == 2) {
                    setRequestedOrientation(0);
                }
            } else if (Build.VERSION.SDK_INT >= 18) {
                setRequestedOrientation(14);
            } else {
                setRequestedOrientation(1);
            }
            this.m = this;
            setContentView(t.f(this, "tt_activity_ttlandingpage_playable"));
            h();
            e();
            a();
            l();
            f();
            g();
            m mVar = this.J;
            if (mVar != null) {
                mVar.h();
            }
            this.d = new com.bytedance.sdk.openadsdk.jslistener.g(getApplicationContext());
            this.d.a((com.bytedance.sdk.openadsdk.jslistener.f) this);
        }
    }

    private void d() {
        if (this.H == null) {
            if (com.bytedance.sdk.openadsdk.core.h.d().s()) {
                com.bytedance.sdk.openadsdk.j.f.a(L);
            }
            AnonymousClass7 r0 = new a() {
                public void a(JSONObject jSONObject) {
                }

                public void b() {
                }

                public void b(JSONObject jSONObject) {
                }

                /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x006e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.bytedance.sdk.openadsdk.j.d a() {
                    /*
                        r7 = this;
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.common.a.f()
                        int r1 = r0.hashCode()
                        r2 = 1653(0x675, float:2.316E-42)
                        r3 = 4
                        r4 = 3
                        r5 = 2
                        r6 = 1
                        if (r1 == r2) goto L_0x004a
                        r2 = 1684(0x694, float:2.36E-42)
                        if (r1 == r2) goto L_0x0040
                        r2 = 1715(0x6b3, float:2.403E-42)
                        if (r1 == r2) goto L_0x0036
                        r2 = 1746(0x6d2, float:2.447E-42)
                        if (r1 == r2) goto L_0x002c
                        r2 = 3649301(0x37af15, float:5.11376E-39)
                        if (r1 == r2) goto L_0x0022
                        goto L_0x0054
                    L_0x0022:
                        java.lang.String r1 = "wifi"
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0054
                        r0 = r3
                        goto L_0x0055
                    L_0x002c:
                        java.lang.String r1 = "5g"
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0054
                        r0 = r4
                        goto L_0x0055
                    L_0x0036:
                        java.lang.String r1 = "4g"
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0054
                        r0 = r5
                        goto L_0x0055
                    L_0x0040:
                        java.lang.String r1 = "3g"
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0054
                        r0 = r6
                        goto L_0x0055
                    L_0x004a:
                        java.lang.String r1 = "2g"
                        boolean r0 = r0.equals(r1)
                        if (r0 == 0) goto L_0x0054
                        r0 = 0
                        goto L_0x0055
                    L_0x0054:
                        r0 = -1
                    L_0x0055:
                        if (r0 == 0) goto L_0x006e
                        if (r0 == r6) goto L_0x006b
                        if (r0 == r5) goto L_0x0068
                        if (r0 == r4) goto L_0x0065
                        if (r0 == r3) goto L_0x0062
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_UNKNOWN
                        return r0
                    L_0x0062:
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_WIFI
                        return r0
                    L_0x0065:
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_5G
                        return r0
                    L_0x0068:
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_4G
                        return r0
                    L_0x006b:
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_3G
                        return r0
                    L_0x006e:
                        com.bytedance.sdk.openadsdk.j.d r0 = com.bytedance.sdk.openadsdk.j.d.TYPE_2G
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.AnonymousClass7.a():com.bytedance.sdk.openadsdk.j.d");
                }

                public void c(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.c.c.b(TTPlayableLandingPageActivity.this.getApplicationContext(), TTPlayableLandingPageActivity.this.y, "embeded_ad", "playable_track", jSONObject);
                }
            };
            AnonymousClass8 r1 = new com.bytedance.sdk.openadsdk.j.c() {
                public void a(String str, JSONObject jSONObject) {
                    TTPlayableLandingPageActivity.this.s.a(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cid", this.q);
                jSONObject.put("log_extra", this.r);
                this.H = g.a(getApplicationContext(), this.f.getWebView(), r1, r0).f(this.v).e(com.bytedance.sdk.openadsdk.common.a.a(com.bytedance.sdk.openadsdk.core.m.a())).a(com.bytedance.sdk.openadsdk.common.a.a()).a(jSONObject).b(com.bytedance.sdk.openadsdk.common.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.common.a.c()).d(com.bytedance.sdk.openadsdk.common.a.d()).c(false).a(this.I).b(true);
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(p.b(this.y))) {
                this.H.c(p.b(this.y));
            }
            Set<String> j2 = this.H.j();
            final WeakReference weakReference = new WeakReference(this.H);
            for (String next : j2) {
                if (!"subscribe_app_ad".equals(next) && !"adInfo".equals(next) && !"webview_time_track".equals(next) && !"download_app_ad".equals(next)) {
                    this.s.a().a(next, (e<?, ?>) new e<JSONObject, JSONObject>() {
                        public JSONObject a(JSONObject jSONObject, com.bytedance.sdk.component.a.f fVar) throws Exception {
                            try {
                                g gVar = (g) weakReference.get();
                                if (gVar == null) {
                                    return null;
                                }
                                return gVar.c(a(), jSONObject);
                            } catch (Throwable unused) {
                                return null;
                            }
                        }
                    });
                }
            }
        }
    }

    private void e() {
        if (this.y.L() == 4) {
            this.C = com.com.bytedance.overseas.sdk.a.d.a(this.m, this.y, "interaction");
        }
    }

    private void f() {
        int i2 = com.bytedance.sdk.openadsdk.core.m.d().v(String.valueOf(this.y.aW())).p;
        if (i2 >= 0) {
            this.z.sendEmptyMessageDelayed(1, (long) (i2 * 1000));
        } else {
            z.a((View) this.j, 0);
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.n = intent.getIntExtra("sdk_version", 1);
            this.q = intent.getStringExtra("adid");
            this.r = intent.getStringExtra("log_extra");
            this.u = intent.getIntExtra("source", -1);
            this.A = intent.getBooleanExtra("ad_pending_download", false);
            this.v = intent.getStringExtra("url");
            this.E = intent.getStringExtra("gecko_id");
            this.w = intent.getStringExtra("web_title");
            if (b.c()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.y = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        l.c("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", (Throwable) e2);
                    }
                }
            } else {
                this.y = r.a().c();
                r.a().h();
            }
        }
        if (bundle != null) {
            try {
                this.n = bundle.getInt("sdk_version", 1);
                this.q = bundle.getString("adid");
                this.r = bundle.getString("log_extra");
                this.u = bundle.getInt("source", -1);
                this.A = bundle.getBoolean("ad_pending_download", false);
                this.v = bundle.getString("url");
                this.w = bundle.getString("web_title");
                String string = bundle.getString("material_meta", (String) null);
                if (!TextUtils.isEmpty(string)) {
                    this.y = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.y == null) {
            l.e("TTPWPActivity", "material is null, no data to display");
            finish();
            return;
        }
        try {
            this.I = com.bytedance.sdk.openadsdk.core.m.d().n(this.y.x().getCodeId());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void g() {
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            sSWebView.setLandingPage(true);
            this.f.setTag("landingpage");
            this.f.setMaterialMeta(this.y.aK());
            this.K = new h(this, this.y, this.f.getWebView()).a(true);
            this.K.a("embeded_ad");
            this.K.a(this.J);
            this.f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.m, this.s, this.q, this.K, true) {
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (TTPlayableLandingPageActivity.this.H != null) {
                        TTPlayableLandingPageActivity.this.H.g(str);
                    }
                }

                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
                /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[Catch:{ all -> 0x0055 }] */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ all -> 0x0055 }] */
                /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
                    /*
                        r0 = this;
                        super.onPageFinished(r1, r2)
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        boolean r1 = r1.isFinishing()
                        if (r1 == 0) goto L_0x000c
                        return
                    L_0x000c:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        com.bytedance.sdk.openadsdk.j.g r1 = r1.H
                        if (r1 == 0) goto L_0x001d
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this
                        com.bytedance.sdk.openadsdk.j.g r1 = r1.H
                        r1.h((java.lang.String) r2)
                    L_0x001d:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0024 }
                        com.bytedance.sdk.openadsdk.jslistener.d r1 = r1.e     // Catch:{ all -> 0x0024 }
                        r1.b()     // Catch:{ all -> 0x0024 }
                    L_0x0024:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        android.widget.ProgressBar r1 = r1.o     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0037
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        android.widget.ProgressBar r1 = r1.o     // Catch:{ all -> 0x0055 }
                        r2 = 8
                        r1.setVisibility(r2)     // Catch:{ all -> 0x0055 }
                    L_0x0037:
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        boolean r1 = r1.h     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0055
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        r1.i()     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity r1 = com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.this     // Catch:{ all -> 0x0055 }
                        java.lang.String r2 = "py_loading_success"
                        r1.a((java.lang.String) r2)     // Catch:{ all -> 0x0055 }
                        com.bytedance.sdk.openadsdk.core.u r1 = r0.c     // Catch:{ all -> 0x0055 }
                        if (r1 == 0) goto L_0x0055
                        com.bytedance.sdk.openadsdk.core.u r1 = r0.c     // Catch:{ all -> 0x0055 }
                        r2 = 1
                        r1.b((boolean) r2)     // Catch:{ all -> 0x0055 }
                    L_0x0055:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.AnonymousClass10.onPageFinished(android.webkit.WebView, java.lang.String):void");
                }

                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    if (!(TTPlayableLandingPageActivity.this.v == null || webResourceRequest == null || webResourceRequest.getUrl() == null || !TTPlayableLandingPageActivity.this.v.equals(webResourceRequest.getUrl().toString()))) {
                        boolean unused = TTPlayableLandingPageActivity.this.h = false;
                    }
                    if (!(TTPlayableLandingPageActivity.this.H == null || webResourceRequest == null)) {
                        try {
                            TTPlayableLandingPageActivity.this.H.a(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                        } catch (Throwable unused2) {
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    boolean unused = TTPlayableLandingPageActivity.this.h = false;
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    boolean unused = TTPlayableLandingPageActivity.this.h = false;
                    if (TTPlayableLandingPageActivity.this.H != null) {
                        TTPlayableLandingPageActivity.this.H.a(i, str, str2);
                    }
                }

                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TTPlayableLandingPageActivity.this.H != null) {
                            TTPlayableLandingPageActivity.this.H.i(str);
                        }
                    } catch (Exception unused) {
                    }
                    return super.shouldInterceptRequest(webView, str);
                }
            });
            a(this.f);
            a(this.g);
            j();
            com.bytedance.sdk.openadsdk.l.l.a(this.f, this.v);
            this.f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.s, this.K) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (!TTPlayableLandingPageActivity.this.isFinishing()) {
                        try {
                            TTPlayableLandingPageActivity.this.e.a(i);
                        } catch (Throwable unused) {
                        }
                        if (TTPlayableLandingPageActivity.this.o == null) {
                            return;
                        }
                        if (i != 100 || !TTPlayableLandingPageActivity.this.o.isShown()) {
                            TTPlayableLandingPageActivity.this.o.setProgress(i);
                            return;
                        }
                        TTPlayableLandingPageActivity.this.o.setVisibility(8);
                        TTPlayableLandingPageActivity.this.i();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.y != null ? this.y.ar().toString() : null);
            bundle.putInt("sdk_version", this.n);
            bundle.putString("adid", this.q);
            bundle.putString("log_extra", this.r);
            bundle.putInt("source", this.u);
            bundle.putBoolean("ad_pending_download", this.A);
            bundle.putString("url", this.v);
            bundle.putString("web_title", this.w);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void h() {
        this.p = (PlayableLoadingView) findViewById(t.e(this, "tt_playable_loading"));
        this.f = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.g = (SSWebView) findViewById(t.e(this, "tt_browser_webview_loading"));
        this.j = (RelativeLayout) findViewById(t.e(this, "tt_playable_ad_close_layout"));
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTPlayableLandingPageActivity.this.J != null) {
                        TTPlayableLandingPageActivity.this.J.i();
                    }
                    TTPlayableLandingPageActivity.this.a("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        this.o = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
        this.k = findViewById(t.e(this, "tt_playable_ad_dislike"));
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTPlayableLandingPageActivity.this.b();
            }
        });
        this.l = (ImageView) findViewById(t.e(this, "tt_playable_ad_mute"));
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                boolean unused = tTPlayableLandingPageActivity.I = !tTPlayableLandingPageActivity.I;
                TTPlayableLandingPageActivity tTPlayableLandingPageActivity2 = TTPlayableLandingPageActivity.this;
                tTPlayableLandingPageActivity2.b(tTPlayableLandingPageActivity2.I);
                if (TTPlayableLandingPageActivity.this.H != null) {
                    TTPlayableLandingPageActivity.this.H.a(TTPlayableLandingPageActivity.this.I);
                }
            }
        });
        this.f.setBackgroundColor(-16777216);
        this.g.setBackgroundColor(-16777216);
        z.a((View) this.f, 4);
        z.a((View) this.g, 0);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.p != null) {
            n nVar = this.y;
            if (nVar == null || p.e(nVar)) {
                this.p.b();
                if (this.p.getPlayView() != null) {
                    AnonymousClass3 r1 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.y, "embeded_ad", this.u) {
                        public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                            if (this.d == null || this.d.i() != 1 || z) {
                                super.a(view, f, f2, f3, f4, sparseArray, z);
                                boolean unused = TTPlayableLandingPageActivity.this.A = true;
                                boolean unused2 = TTPlayableLandingPageActivity.this.B = true;
                                HashMap hashMap = new HashMap();
                                hashMap.put("playable_url", TTPlayableLandingPageActivity.this.v);
                                TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                                com.bytedance.sdk.openadsdk.c.c.e(tTPlayableLandingPageActivity, tTPlayableLandingPageActivity.y, this.e, "click_playable_download_button_loading", hashMap);
                            }
                        }
                    };
                    r1.a(this.C);
                    this.p.getPlayView().setOnClickListener(r1);
                }
                if (p.g(this.y)) {
                    this.z.sendMessageDelayed(a(2), WorkRequest.MIN_BACKOFF_MILLIS);
                    return;
                }
                return;
            }
            this.p.a();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        SSWebView sSWebView;
        if (!this.D.getAndSet(true) && (sSWebView = this.f) != null && this.g != null) {
            z.a((View) sSWebView, 0);
            z.a((View) this.g, 8);
        }
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.widget.a.b.a(this.m).a(false).b(false).a(sSWebView.getWebView());
            sSWebView.setUserAgentString(j.a(sSWebView.getWebView(), this.n));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.c.c((Context) this, this.y, "embeded_ad", str, (JSONObject) null);
    }

    private void j() {
        if (this.g != null) {
            String k2 = k();
            if (!TextUtils.isEmpty(k2)) {
                this.g.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.m, this.t, this.q, (h) null, false) {
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        if (TTPlayableLandingPageActivity.this.i) {
                            TTPlayableLandingPageActivity.this.a("loading_h5_success");
                        }
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        boolean unused = TTPlayableLandingPageActivity.this.i = false;
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        boolean unused = TTPlayableLandingPageActivity.this.i = false;
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        boolean unused = TTPlayableLandingPageActivity.this.i = false;
                    }
                });
                this.g.a(k2);
            }
        }
    }

    private String k() {
        n nVar;
        String q2 = com.bytedance.sdk.openadsdk.core.m.d().q();
        if (TextUtils.isEmpty(q2) || (nVar = this.y) == null || nVar.aa() == null) {
            return q2;
        }
        String b2 = this.y.aa().b();
        double d2 = this.y.aa().d();
        int e2 = this.y.aa().e();
        String a2 = (this.y.M() == null || TextUtils.isEmpty(this.y.M().a())) ? "" : this.y.M().a();
        String Y = this.y.Y();
        String c2 = this.y.aa().c();
        String a3 = this.y.aa().a();
        String b3 = this.y.aa().b();
        StringBuffer stringBuffer = new StringBuffer(q2);
        stringBuffer.append("?appname=");
        stringBuffer.append(b2);
        stringBuffer.append("&stars=");
        stringBuffer.append(d2);
        stringBuffer.append("&comments=");
        stringBuffer.append(e2);
        stringBuffer.append("&icon=");
        stringBuffer.append(a2);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(Y);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(c2);
        stringBuffer.append("&download_url=");
        stringBuffer.append(a3);
        stringBuffer.append("&name=");
        stringBuffer.append(b3);
        return stringBuffer.toString();
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.y);
        this.J = new m(3, "embeded_ad", this.y);
        this.s = new u(this);
        String aY = this.y.aY();
        this.s.b(this.f).a(this.y).a((List<n>) arrayList).d(this.q).e(this.r).c("embeded_ad").b(this.u).a((d) this).a(this.J).a(this.e).a(this.f).f(aY);
        this.t = new u(this);
        this.t.b(this.g).a(this.y).d(this.q).e(this.r).a((d) this).b(this.u).c(false).a(this.J).a(this.g).f(aY);
        d();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m mVar = this.J;
        if (mVar != null) {
            mVar.k();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u uVar = this.s;
        if (uVar != null) {
            uVar.k();
            SSWebView sSWebView = this.f;
            if (sSWebView != null) {
                this.s.b(sSWebView.getVisibility() == 0);
            }
        }
        u uVar2 = this.t;
        if (uVar2 != null) {
            uVar2.k();
        }
        g gVar = this.H;
        if (gVar != null) {
            gVar.r();
            this.H.b(true);
        }
        h hVar = this.K;
        if (hVar != null) {
            hVar.d();
        }
        com.bytedance.sdk.openadsdk.jslistener.g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.a((com.bytedance.sdk.openadsdk.jslistener.f) this);
            this.d.f();
            if (this.d.g() == 0) {
                this.I = true;
            }
            b(this.I);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        r.a().b(true);
        u uVar = this.s;
        if (uVar != null) {
            uVar.l();
            this.s.b(false);
        }
        u uVar2 = this.t;
        if (uVar2 != null) {
            uVar2.l();
        }
        g gVar = this.H;
        if (gVar != null) {
            gVar.a(true);
            this.H.q();
            this.H.b(false);
        }
        com.bytedance.sdk.openadsdk.jslistener.g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.e();
            this.d.a((com.bytedance.sdk.openadsdk.jslistener.f) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        m mVar = this.J;
        if (mVar != null) {
            mVar.j();
        }
        h hVar = this.K;
        if (hVar != null) {
            hVar.e();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m mVar = this.J;
        if (mVar != null) {
            mVar.i();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        m mVar = this.J;
        if (mVar != null) {
            mVar.a(true);
            this.J.m();
        }
        x xVar = this.z;
        if (xVar != null) {
            xVar.removeCallbacksAndMessages((Object) null);
        }
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.f;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.x.a(this.m, sSWebView.getWebView());
            com.bytedance.sdk.openadsdk.core.x.a(this.f.getWebView());
            this.f.l();
        }
        this.f = null;
        u uVar = this.s;
        if (uVar != null) {
            uVar.m();
        }
        u uVar2 = this.t;
        if (uVar2 != null) {
            uVar2.m();
        }
        g gVar = this.H;
        if (gVar != null) {
            gVar.v();
        }
        h hVar = this.K;
        if (hVar != null) {
            hVar.f();
        }
        this.d = null;
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            z.a((View) this.j, 0);
        } else if (i2 == 2) {
            l.b("playable hidden loading , type:" + message.arg1);
            HashMap hashMap = new HashMap();
            hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            hashMap.put("playable_url", this.v);
            com.bytedance.sdk.openadsdk.c.c.e(this, this.y, "embeded_ad", "remove_loading_page", hashMap);
            this.z.removeMessages(2);
            PlayableLoadingView playableLoadingView = this.p;
            if (playableLoadingView != null) {
                playableLoadingView.a();
            }
        }
    }

    public void a(boolean z2) {
        com.com.bytedance.overseas.sdk.a.c cVar;
        this.A = true;
        this.B = z2;
        if (!z2) {
            try {
                Toast.makeText(this.m, t.a(com.bytedance.sdk.openadsdk.core.m.a(), "tt_toast_later_download"), 0).show();
            } catch (Throwable unused) {
            }
        }
        if (this.B && (cVar = this.C) != null) {
            cVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.y != null && !isFinishing()) {
            if (this.c.get()) {
                m();
                return;
            }
            if (this.a == null) {
                c();
            }
            this.a.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() {
                public void onCancel() {
                }

                public void onRefuse() {
                }

                public void onSelected(int i, String str) {
                    if (!TTPlayableLandingPageActivity.this.c.get() && !TextUtils.isEmpty(str)) {
                        TTPlayableLandingPageActivity.this.c.set(true);
                        TTPlayableLandingPageActivity.this.n();
                    }
                }
            });
            TTAdDislike tTAdDislike = this.a;
            if (tTAdDislike != null) {
                tTAdDislike.showDislikeDialog();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        n nVar = this.y;
        if (nVar != null) {
            this.a = new com.bytedance.sdk.openadsdk.dislike.c(this, nVar.ac(), this.y.ae());
        }
        if (this.b == null) {
            this.b = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.b);
        }
    }

    private void m() {
        TTAdDislikeToast tTAdDislikeToast = this.b;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(com.bytedance.sdk.openadsdk.core.settings.j.d);
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        TTAdDislikeToast tTAdDislikeToast = this.b;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.a(com.bytedance.sdk.openadsdk.core.settings.j.e);
        }
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        int i2;
        try {
            this.I = z2;
            if (z2) {
                i2 = t.d(this.m, "tt_mute");
            } else {
                i2 = t.d(this.m, "tt_unmute");
            }
            this.l.setImageResource(i2);
            if (this.H != null) {
                this.H.a(z2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(int i2) {
        b(i2 <= 0);
    }
}
