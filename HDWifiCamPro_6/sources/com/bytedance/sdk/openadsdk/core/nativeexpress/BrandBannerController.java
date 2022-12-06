package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.a.a.a.a.b.g;
import com.bytedance.sdk.component.adexpress.b.f;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.l.z;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class BrandBannerController {
    public static final Set<String> b = new HashSet<String>() {
        {
            add(".jpeg");
            add(".png");
            add(".bmp");
            add(".gif");
            add(".jpg");
            add(".webp");
        }
    };
    n a;
    private final Context c;
    /* access modifiers changed from: private */
    public b d;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.component.adexpress.b.n e;
    /* access modifiers changed from: private */
    public NativeExpressView f;
    private int g;
    private int h;
    private ScheduledFuture<?> i;

    interface d {
        void a(int i, int i2);

        void b(String str);

        void c(String str);

        void f();
    }

    public BrandBannerController(Context context, NativeExpressView nativeExpressView, n nVar) {
        this.a = nVar;
        this.c = context;
        this.f = nativeExpressView;
        a(nativeExpressView);
        this.d = new b(context, nVar, this.g, this.h);
    }

    private void a(NativeExpressView nativeExpressView) {
        n nVar = this.a;
        if (nVar == null || !nVar.ba()) {
            j a2 = BannerExpressBackupView.a(nativeExpressView.getExpectExpressWidth(), nativeExpressView.getExpectExpressHeight());
            if (nativeExpressView.getExpectExpressWidth() <= 0 || nativeExpressView.getExpectExpressHeight() <= 0) {
                this.g = z.c(this.c);
                this.h = Float.valueOf(((float) this.g) / a2.b).intValue();
            } else {
                this.g = (int) z.b(this.c, (float) nativeExpressView.getExpectExpressWidth());
                this.h = (int) z.b(this.c, (float) nativeExpressView.getExpectExpressHeight());
            }
            int i2 = this.g;
            if (i2 > 0 && i2 > z.c(this.c)) {
                float c2 = ((float) z.c(this.c)) / ((float) this.g);
                this.g = z.c(this.c);
                this.h = Float.valueOf(((float) this.h) * c2).intValue();
                return;
            }
            return;
        }
        this.g = -1;
        this.h = -1;
    }

    public void a(com.bytedance.sdk.component.adexpress.b.n nVar) {
        this.e = nVar;
    }

    public void a() {
        n nVar = this.a;
        if (nVar != null && nVar.ba()) {
            this.i = e.d().schedule(new c(this.d), (long) m.d().t(), TimeUnit.MILLISECONDS);
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.a((f) new f() {
                public void a(View view, com.bytedance.sdk.component.adexpress.b.m mVar) {
                    if (BrandBannerController.this.f != null && view != null) {
                        BrandBannerController.this.f.removeView(view);
                        if (view.getParent() != null) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        BrandBannerController.this.f.addView(view, new ViewGroup.LayoutParams(-1, -1));
                        if (BrandBannerController.this.e != null) {
                            BrandBannerController.this.e.a(BrandBannerController.this.d, mVar);
                        }
                    } else if (BrandBannerController.this.e != null) {
                        BrandBannerController.this.e.a_(106);
                    }
                    BrandBannerController.this.c();
                }

                public void a(int i) {
                    if (BrandBannerController.this.e != null) {
                        BrandBannerController.this.e.a_(106);
                    }
                    BrandBannerController.this.c();
                }
            });
            return;
        }
        com.bytedance.sdk.component.adexpress.b.n nVar2 = this.e;
        if (nVar2 != null) {
            nVar2.a_(106);
        }
    }

    public void b() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
            this.d = null;
        }
        c();
        this.e = null;
        this.f = null;
    }

    public void a(TTAdDislike tTAdDislike) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(tTAdDislike);
        }
    }

    public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(tTDislikeDialogAbstract);
        }
    }

    public void a(String str) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public static class b implements com.bytedance.sdk.component.adexpress.b.d<View>, d {
        AtomicBoolean a = new AtomicBoolean(false);
        AtomicBoolean b = new AtomicBoolean(false);
        AtomicBoolean c = new AtomicBoolean(false);
        WeakReference<View> d;
        private com.bytedance.sdk.openadsdk.dislike.c e;
        private TTDislikeDialogAbstract f;
        private String g;
        /* access modifiers changed from: private */
        public final Context h;
        private final int i;
        private final int j;
        private FrameLayout k;
        /* access modifiers changed from: private */
        public n l;
        /* access modifiers changed from: private */
        public m m;
        private int n;
        /* access modifiers changed from: private */
        public String o = "banner_ad";
        private BrandWebView p;
        private f q;
        /* access modifiers changed from: private */
        public int r = 0;
        /* access modifiers changed from: private */
        public List<String> s;

        public int c() {
            return 5;
        }

        public b(Context context, n nVar, int i2, int i3) {
            if (nVar != null && nVar.ba()) {
                this.o = "fullscreen_interstitial_ad";
            }
            this.h = context;
            this.i = i2;
            this.j = i3;
            this.l = nVar;
            this.n = (int) z.b(context, 3.0f);
            this.m = new m(context);
            g();
        }

        private void g() {
            this.k = new FrameLayout(this.h);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.i, this.j);
            }
            layoutParams.width = this.i;
            layoutParams.height = this.j;
            layoutParams.gravity = 17;
            this.k.setLayoutParams(layoutParams);
            BrandWebView j2 = j();
            this.k.addView(j2);
            View h2 = h();
            this.k.addView(h2);
            n nVar = this.l;
            if (nVar == null || !nVar.ba()) {
                ImageView i2 = i();
                this.k.addView(i2);
                this.d = new WeakReference<>(i2);
                j2.a(i2, g.CLOSE_AD);
            } else {
                j2.setBackgroundColor(-16777216);
                Context context = this.h;
                this.d = new WeakReference<>(((Activity) context).findViewById(t.e(context, "tt_top_dislike")));
                Context context2 = this.h;
                j2.a(((Activity) context2).findViewById(t.e(context2, "tt_real_top_layout_proxy")), g.OTHER);
            }
            j2.a(h2, g.OTHER);
        }

        public void a(f fVar) {
            n nVar;
            if (!this.a.get()) {
                this.b.set(false);
                if (this.h == null || (nVar = this.l) == null) {
                    fVar.a(106);
                    return;
                }
                String az = nVar.az();
                if (az.isEmpty()) {
                    fVar.a(106);
                    return;
                }
                String a2 = com.bytedance.sdk.openadsdk.core.f.e.a(az);
                String str = TextUtils.isEmpty(a2) ? az : a2;
                this.r = 0;
                this.q = fVar;
                this.p.a((String) null, str, "text/html", "UTF-8", (String) null);
            }
        }

        private View h() {
            View inflate = LayoutInflater.from(this.h).inflate(t.f(this.h, "tt_backup_ad1"), (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            n nVar = this.l;
            if (nVar == null || !nVar.ba()) {
                int i2 = this.n;
                layoutParams.topMargin = i2;
                layoutParams.leftMargin = i2;
            } else {
                layoutParams.leftMargin = (int) z.b(this.h, 20.0f);
                layoutParams.bottomMargin = (int) z.b(this.h, 20.0f);
                layoutParams.gravity = 83;
            }
            inflate.setLayoutParams(layoutParams);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(b.this.h, b.this.l, b.this.o);
                }
            });
            return inflate;
        }

        private ImageView i() {
            ImageView imageView = new ImageView(this.h);
            imageView.setImageDrawable(this.h.getResources().getDrawable(t.d(this.h, "tt_dislike_icon2")));
            int b2 = (int) z.b(this.h, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.gravity = GravityCompat.END;
            int i2 = this.n;
            layoutParams.rightMargin = i2;
            layoutParams.topMargin = i2;
            imageView.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.b();
                }
            });
            return imageView;
        }

        private BrandWebView j() {
            this.p = b.a().b();
            if (this.p == null) {
                this.p = new BrandWebView(this.h);
            }
            this.p.o();
            b.a().c(this.p);
            this.p.setWebViewClient(new a(this.m, this));
            this.p.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView webView, int i) {
                    if (!b.this.b.get()) {
                        super.onProgressChanged(webView, i);
                        if (b.this.r == 0 && i >= 75) {
                            b.this.d();
                        }
                        if (i == 100 && b.this.s != null) {
                            b.this.k();
                        }
                    }
                }
            });
            this.p.getWebView().setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    b.this.m.onTouchEvent(motionEvent);
                    return false;
                }
            });
            this.p.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this.p;
        }

        /* access modifiers changed from: private */
        public void k() {
            if (this.s != null) {
                com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.component.g.g) new com.bytedance.sdk.component.g.g("dsp_html_error_url") {
                    public void run() {
                        try {
                            if (b.this.s != null && b.this.c.compareAndSet(false, true)) {
                                JSONObject jSONObject = new JSONObject();
                                JSONArray jSONArray = new JSONArray();
                                for (String put : b.this.s) {
                                    jSONArray.put(put);
                                }
                                jSONObject.put("error_url", jSONArray);
                                com.bytedance.sdk.openadsdk.c.c.b(b.this.h, b.this.l, b.this.o, "dsp_html_error_url", jSONObject);
                                List unused = b.this.s = null;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                });
            }
        }

        public View e() {
            return this.k;
        }

        public void a() {
            this.k = null;
            this.e = null;
            this.f = null;
            this.q = null;
            this.l = null;
            this.m = null;
            BrandWebView brandWebView = this.p;
            if (brandWebView != null) {
                brandWebView.r();
                b.a().a(this.p);
            }
            this.a.set(true);
            this.b.set(false);
        }

        public void a(TTAdDislike tTAdDislike) {
            if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.c) {
                this.e = (com.bytedance.sdk.openadsdk.dislike.c) tTAdDislike;
            }
        }

        public void a(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
            n nVar;
            if (!(tTDislikeDialogAbstract == null || (nVar = this.l) == null)) {
                tTDislikeDialogAbstract.setMaterialMeta(nVar.ac(), this.l.ae());
            }
            this.f = tTDislikeDialogAbstract;
        }

        public void b() {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.c cVar = this.e;
            if (cVar != null) {
                cVar.showDislikeDialog();
            } else {
                TTDelegateActivity.a(this.l, this.g);
            }
        }

        public void a(String str) {
            this.g = str;
        }

        public void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                boolean z = false;
                if (str.contains("play.google.com/store/apps/details?id=")) {
                    z = com.com.bytedance.overseas.sdk.a.b.b(this.h, str.substring(str.indexOf("?id=") + 4));
                }
                if (!z) {
                    w.a(this.h, this.l, -1, (PAGNativeAd) null, (PangleAd) null, "", true, str);
                }
                if (this.m != null) {
                    View view = null;
                    WeakReference<View> weakReference = this.d;
                    if (weakReference != null) {
                        view = (View) weakReference.get();
                    }
                    com.bytedance.sdk.openadsdk.core.model.g a2 = this.m.a(this.h, (View) this.k.getParent(), view);
                    HashMap hashMap = new HashMap();
                    int i2 = 1;
                    hashMap.put("click_scence", 1);
                    Context context = this.h;
                    n nVar = this.l;
                    String str2 = this.o;
                    if (!this.m.b()) {
                        i2 = 2;
                    }
                    com.bytedance.sdk.openadsdk.c.c.a(context, CampaignEx.JSON_NATIVE_VIDEO_CLICK, nVar, a2, str2, true, (Map<String, Object>) hashMap, i2);
                }
                m mVar = this.m;
                if (mVar != null) {
                    mVar.a();
                }
            }
        }

        public void d() {
            if (this.b.compareAndSet(false, true)) {
                if (this.q != null) {
                    com.bytedance.sdk.component.adexpress.b.m mVar = new com.bytedance.sdk.component.adexpress.b.m();
                    mVar.a(true);
                    mVar.a((double) z.c(this.h, (float) this.i));
                    mVar.b((double) z.c(this.h, (float) this.j));
                    this.q.a(this.k, mVar);
                }
                BrandWebView brandWebView = this.p;
                if (brandWebView != null) {
                    brandWebView.s();
                }
            }
        }

        public void a(int i2, int i3) {
            this.r = i3;
            f fVar = this.q;
            if (fVar != null) {
                fVar.a(i2);
            }
            com.bytedance.sdk.openadsdk.c.c.a(this.h, this.l, this.o, "render_html_fail");
        }

        public void c(String str) {
            if (this.s == null) {
                this.s = new ArrayList();
            }
            this.s.add(str);
        }

        public void f() {
            k();
            d();
        }
    }

    static class a extends SSWebView.a {
        m a;
        d b;

        public a(m mVar, d dVar) {
            this.a = mVar;
            this.b = dVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d dVar;
            m mVar = this.a;
            if (mVar == null || !mVar.b() || (dVar = this.b) == null) {
                return false;
            }
            dVar.b(str);
            return true;
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest != null && webResourceResponse != null && Build.VERSION.SDK_INT >= 21 && webResourceRequest.getUrl() != null) {
                if (webResourceRequest.isForMainFrame()) {
                    a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
                }
                a(webResourceRequest.getUrl().toString());
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (Build.VERSION.SDK_INT < 21) {
                a(str2, i, str);
                a(str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 21 && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                a(webResourceRequest.getUrl().toString());
            }
        }

        private void a(String str) {
            int lastIndexOf;
            d dVar;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) > 0) {
                if (BrandBannerController.b.contains(str.substring(lastIndexOf).toLowerCase()) && (dVar = this.b) != null) {
                    dVar.c(str);
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d dVar = this.b;
            if (dVar != null) {
                dVar.f();
            }
        }

        private void a(String str, int i, String str2) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(106, i);
            }
        }
    }

    private static class c implements Runnable {
        d a;

        public c(d dVar) {
            this.a = dVar;
        }

        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(106, 107);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            if (this.i != null && !this.i.isCancelled()) {
                this.i.cancel(false);
                this.i = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static class BrandWebView extends SSWebView {
        protected int a = 0;
        protected boolean b = false;
        protected boolean c = false;
        private com.bytedance.sdk.openadsdk.core.f.f d;

        public BrandWebView(Context context) {
            super(context);
        }

        public void l() {
            super.l();
            this.d = null;
        }

        public void o() {
            this.a = 0;
            this.d = com.bytedance.sdk.openadsdk.core.f.f.a();
        }

        public void p() {
            if (this.a == 0 && this.b) {
                if (this.d == null) {
                    this.d = com.bytedance.sdk.openadsdk.core.f.f.a();
                }
                this.d.a(getWebView());
                this.d.b();
                this.a = 1;
            }
        }

        public void a(View view, g gVar) {
            com.bytedance.sdk.openadsdk.core.f.f fVar = this.d;
            if (fVar != null) {
                fVar.a(view, gVar);
            }
        }

        public void q() {
            com.bytedance.sdk.openadsdk.core.f.f fVar;
            if (this.a == 1 && this.c && (fVar = this.d) != null) {
                fVar.c();
                this.a = 3;
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.b) {
                p();
            }
        }

        /* access modifiers changed from: protected */
        public void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            this.c = i == 0;
            q();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            r();
        }

        public void r() {
            com.bytedance.sdk.openadsdk.core.f.f fVar;
            int i = this.a;
            if (!(i == 0 || i == 4 || (fVar = this.d) == null)) {
                fVar.d();
            }
            this.a = 4;
            this.d = null;
        }

        public void s() {
            this.b = true;
            p();
            q();
        }
    }
}
