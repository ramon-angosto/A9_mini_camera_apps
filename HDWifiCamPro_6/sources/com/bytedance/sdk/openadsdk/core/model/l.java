package com.bytedance.sdk.openadsdk.core.model;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.a.d;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.l.j;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LandingPageModel */
public class l {
    private View A;
    /* access modifiers changed from: private */
    public long B;
    /* access modifiers changed from: private */
    public AtomicBoolean C = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Activity D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public c F;
    private h G;
    private AtomicBoolean H = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean I = false;
    ImageView a;
    FrameLayout b;
    TextView c;
    FrameLayout d;
    TextView e;
    RelativeLayout f;
    n g;
    FrameLayout h;
    ObjectAnimator i;
    ObjectAnimator j;
    ObjectAnimator k;
    ObjectAnimator l;
    c.a m;
    a n;
    b o;
    private View p;
    private TextView q;
    private TextView r;
    private TTRoundRectImageView s;
    private TextView t;
    private u u;
    /* access modifiers changed from: private */
    public SSWebView v;
    /* access modifiers changed from: private */
    public FrameLayout w;
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout x;
    /* access modifiers changed from: private */
    public View y;
    private ImageView z;

    public l(Activity activity, n nVar, String str, FrameLayout frameLayout) {
        this.D = activity;
        this.g = nVar;
        this.E = str;
        if (b(nVar)) {
            this.E = "landingpage_split_screen";
        } else if (c(nVar)) {
            this.E = "landingpage_direct";
        }
        this.n = new a(m.a(), this.g, this.E, y.a(str));
        this.o = new b(m.a(), this.g, this.E, y.a(str), true);
        this.h = frameLayout;
        try {
            if (c(this.g)) {
                this.j = ObjectAnimator.ofInt(this, "timeDown", new int[]{0, (int) (this.g.a().b() * 1000)});
                this.j.setDuration((long) ((((float) this.g.a().b()) / k.e) * 1000.0f));
                this.j.setInterpolator(new LinearInterpolator());
                this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (l.this.m != null && l.this.g.a() != null) {
                            l.this.m.a(((Integer) valueAnimator.getAnimatedValue()).longValue(), l.this.g.a().b() * 1000);
                        }
                    }
                });
                this.j.start();
            }
        } catch (Exception unused) {
        }
    }

    public void a(c.a aVar) {
        this.m = aVar;
    }

    public void a() {
        Activity activity = this.D;
        this.v = (SSWebView) activity.findViewById(t.e(activity, "tt_reward_browser_webview_loading"));
        if (this.v == null || n.a(this.g)) {
            z.a((View) this.v, 8);
        } else {
            this.v.a();
        }
        Activity activity2 = this.D;
        this.w = (FrameLayout) activity2.findViewById(t.e(activity2, "tt_reward_loading_container"));
        Activity activity3 = this.D;
        this.x = (LandingPageLoadingLayout) activity3.findViewById(t.e(activity3, "tt_loading_layout"));
        Activity activity4 = this.D;
        this.y = activity4.findViewById(t.e(activity4, "tt_up_slide"));
        Activity activity5 = this.D;
        this.z = (ImageView) activity5.findViewById(t.e(activity5, "tt_up_slide_image"));
        Activity activity6 = this.D;
        this.A = activity6.findViewById(t.e(activity6, "tt_video_container_root"));
        Activity activity7 = this.D;
        this.b = (FrameLayout) activity7.findViewById(t.e(activity7, "tt_image_reward_container"));
        Activity activity8 = this.D;
        this.a = (ImageView) activity8.findViewById(t.e(activity8, "tt_image_reward"));
        Activity activity9 = this.D;
        this.f = (RelativeLayout) activity9.findViewById(t.e(activity9, "tt_browser_webview_page_loading"));
        Activity activity10 = this.D;
        this.c = (TextView) activity10.findViewById(t.e(activity10, "tt_loading_tip"));
        Activity activity11 = this.D;
        this.d = (FrameLayout) activity11.findViewById(t.e(activity11, "tt_video_container_back"));
        Activity activity12 = this.D;
        this.p = activity12.findViewById(t.e(activity12, "tt_back_container"));
        Activity activity13 = this.D;
        this.q = (TextView) activity13.findViewById(t.e(activity13, "tt_back_container_title"));
        Activity activity14 = this.D;
        this.r = (TextView) activity14.findViewById(t.e(activity14, "tt_back_container_des"));
        Activity activity15 = this.D;
        this.s = (TTRoundRectImageView) activity15.findViewById(t.e(activity15, "tt_back_container_icon"));
        Activity activity16 = this.D;
        this.t = (TextView) activity16.findViewById(t.e(activity16, "tt_back_container_download"));
        if (!(this.c == null || this.g.a() == null)) {
            this.c.setText(this.g.a().c());
        }
        Activity activity17 = this.D;
        this.e = (TextView) activity17.findViewById(t.e(activity17, "tt_ad_loading_logo"));
        if ((c(this.g) || b(this.g)) && this.g.a() != null) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setVisibility(8);
            }
            k.d().postDelayed(new Runnable() {
                public void run() {
                    if (!l.this.C.get()) {
                        com.bytedance.sdk.openadsdk.c.c.a(m.a(), l.this.g, l.this.E, System.currentTimeMillis() - l.this.B, false);
                        l.this.m();
                    }
                }
            }, this.g.a().a() * 1000);
        }
        i();
        if (b(this.g)) {
            o();
            if (!c()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.w.setLayoutParams(layoutParams);
            }
        }
        if (c(this.g)) {
            this.A.setVisibility(8);
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.x;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.g, this.E);
        }
    }

    private void i() {
        LandingPageLoadingLayout landingPageLoadingLayout;
        SSWebView sSWebView = this.v;
        if (!(sSWebView == null || sSWebView.getWebView() == null)) {
            com.bytedance.sdk.openadsdk.core.widget.a.b.a(m.a()).a(false).b(false).a(this.v.getWebView());
            SSWebView sSWebView2 = this.v;
            if (!(sSWebView2 == null || sSWebView2.getWebView() == null)) {
                this.G = new h(m.a(), this.g, this.v.getWebView()).a(true);
                this.G.a(this.E);
            }
            j();
            this.v.setLandingPage(true);
            this.v.setTag(this.E);
            this.v.setMaterialMeta(this.g.aK());
            this.v.setWebViewClient(new d(m.a(), this.u, this.g.Y(), this.G, true) {
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    l.this.k();
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (l.this.D instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) l.this.D).e();
                    }
                    long unused = l.this.B = System.currentTimeMillis();
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    String b = b(str2);
                    if (this.f != null) {
                        this.f.a(webView, i, str, str2, b(str2));
                    }
                    boolean z = true;
                    boolean z2 = b != null && b.startsWith("image");
                    if (b == null || !b.startsWith("mp4")) {
                        z = false;
                    }
                    if (!z2 && !z && !l.this.C.get()) {
                        l.this.m();
                    }
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        l.this.m();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            });
            this.v.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.u, this.G) {
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (l.this.D != null && !l.this.D.isFinishing() && i == 100) {
                        l.this.k();
                    }
                    if (l.this.x != null) {
                        l.this.x.a(i);
                    }
                }
            });
            if (this.F == null) {
                this.F = com.com.bytedance.overseas.sdk.a.d.a(m.a(), this.g, this.E);
            }
            this.v.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (l.this.F != null) {
                        l.this.F.d();
                    }
                }
            });
            SSWebView sSWebView3 = this.v;
            if (sSWebView3 != null) {
                sSWebView3.setUserAgentString(j.a(sSWebView3.getWebView(), (int) BuildConfig.VERSION_CODE));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.v.setMixedContentMode(0);
            }
            this.v.getWebView().setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!l.this.I) {
                        l.this.o.onTouch(view, motionEvent);
                    }
                    if (l.this.I || motionEvent.getAction() != 1) {
                        return false;
                    }
                    l.this.v.getWebView().performClick();
                    boolean unused = l.this.I = true;
                    return false;
                }
            });
            this.v.getWebView().setOnClickListener(this.o);
            com.bytedance.sdk.openadsdk.c.c.a(m.a(), this.g, this.E);
            com.bytedance.sdk.openadsdk.l.l.a(this.v, this.g.O());
        }
        if (this.v != null && (landingPageLoadingLayout = this.x) != null) {
            landingPageLoadingLayout.a();
        }
    }

    private void j() {
        this.u = new u(m.a());
        this.u.b(this.v).d(this.g.Y()).e(this.g.ac()).a(this.g).b(-1).a(this.g.F()).c(this.E).f(this.g.aY()).a(this.v);
    }

    public static boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        return c(nVar) || b(nVar);
    }

    /* access modifiers changed from: private */
    public void k() {
        if (!this.C.get() && !this.H.get()) {
            this.C.set(true);
            com.bytedance.sdk.openadsdk.c.c.a(m.a(), this.g, this.E, System.currentTimeMillis() - this.B, true);
            l();
        }
    }

    private void l() {
        this.f.setVisibility(8);
        if (!c(this.g) && c()) {
            this.l = ObjectAnimator.ofFloat(this, "timeVisible", new float[]{0.0f, 1.0f});
            this.l.setDuration(100);
            this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) l.this.w.getLayoutParams();
                    layoutParams.weight = (float) (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.25d);
                    l.this.a((float) (1.0d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2d)));
                    l.this.w.setLayoutParams(layoutParams);
                }
            });
            this.l.start();
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (!this.C.get()) {
            n();
            this.H.set(true);
            Activity activity = this.D;
            if (activity instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                ((com.bytedance.sdk.openadsdk.core.video.c.c) activity).j();
            }
            LandingPageLoadingLayout landingPageLoadingLayout = this.x;
            if (landingPageLoadingLayout != null) {
                landingPageLoadingLayout.b();
            }
            this.p.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.addRule(10, 0);
            this.p.setLayoutParams(layoutParams);
            if (this.g.M() != null && !TextUtils.isEmpty(this.g.M().a())) {
                com.bytedance.sdk.openadsdk.i.d.a().a(this.g.M().a(), (ImageView) this.s);
            }
            this.q.setText(this.g.K());
            this.r.setText(this.g.V());
            if (this.t != null) {
                b();
                this.t.setClickable(true);
                this.t.setOnClickListener(this.n);
                this.t.setOnTouchListener(this.n);
            }
        }
    }

    private void n() {
        if (c(this.g)) {
            Activity activity = this.D;
            if (activity instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                ((com.bytedance.sdk.openadsdk.core.video.c.c) activity).e();
                ((com.bytedance.sdk.openadsdk.core.video.c.c) this.D).y();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        n nVar = this.g;
        if (nVar != null && !TextUtils.isEmpty(nVar.W())) {
            this.t.setText(this.g.W());
        }
    }

    private void o() {
        if (c()) {
            this.y.setVisibility(0);
            this.i = ObjectAnimator.ofFloat(this.z, "translationY", new float[]{16.0f, 0.0f}).setDuration(500);
            this.i.setRepeatMode(2);
            this.i.setRepeatCount(-1);
            this.i.start();
            this.y.setClickable(true);
            this.y.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!l.this.I) {
                        l.this.o.onTouch(view, motionEvent);
                    }
                    if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    l.this.k = ObjectAnimator.ofFloat(this, "timeSlide", new float[]{0.0f, 1.0f});
                    l.this.k.setDuration(200);
                    l.this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) l.this.w.getLayoutParams();
                            layoutParams.weight = (float) (((double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f)) + 0.25d);
                            l.this.a((float) (0.800000011920929d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.5d)));
                            l.this.w.setLayoutParams(layoutParams);
                        }
                    });
                    l.this.y.performClick();
                    boolean unused = l.this.I = true;
                    l.this.k.start();
                    l.this.y.setVisibility(8);
                    return true;
                }
            });
            this.y.setOnClickListener(this.o);
        }
        if (!p()) {
            this.h.setVisibility(8);
            this.b.setVisibility(0);
            this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.c.c.b(m.a(), l.this.g, l.this.E);
                }
            });
            n nVar = this.g;
            if (!(nVar == null || nVar.P() == null || this.g.P().size() <= 0 || this.g.P().get(0) == null || TextUtils.isEmpty(this.g.P().get(0).a()))) {
                com.bytedance.sdk.openadsdk.i.d.a().a(this.g.P().get(0), this.a);
            }
        }
        try {
            com.bytedance.sdk.openadsdk.e.a.a().a(this.g.P().get(0).a()).a(com.bytedance.sdk.component.d.u.BITMAP).a((com.bytedance.sdk.component.d.h) new com.bytedance.sdk.component.d.h() {
                public Bitmap a(Bitmap bitmap) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        return com.bytedance.sdk.component.adexpress.c.a.a(m.a(), bitmap, 25);
                    }
                    return null;
                }
            }).a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(com.bytedance.sdk.component.d.k<Bitmap> kVar) {
                    try {
                        Bitmap b = kVar.b();
                        if (b == null) {
                            return;
                        }
                        if (kVar.c() != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(m.a().getResources(), b);
                            if (!l.this.p()) {
                                l.this.b.setBackground(bitmapDrawable);
                                return;
                            }
                            l.this.d.setBackground(bitmapDrawable);
                            View view = null;
                            if (l.this.D instanceof com.bytedance.sdk.openadsdk.core.video.c.c) {
                                view = ((com.bytedance.sdk.openadsdk.core.video.c.c) l.this.D).l();
                            }
                            if (view != null && (view.getParent() instanceof View)) {
                                ((View) view.getParent()).setBackground(bitmapDrawable);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean p() {
        return n.c(this.g);
    }

    public boolean c() {
        return this.g.ad() == 15 || this.g.ad() == 16;
    }

    public void a(float f2) {
        try {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) this.D).k();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(n nVar) {
        if (nVar == null || nVar.L() != 3 || nVar.f() != 6 || p.a(nVar) || nVar.am() != 1) {
            return false;
        }
        if (nVar.an() == 0.0f || nVar.an() == 100.0f) {
            return true;
        }
        return false;
    }

    public static boolean c(n nVar) {
        if (nVar == null || nVar.L() != 3 || nVar.f() != 5 || p.a(nVar)) {
            return false;
        }
        if (nVar.an() == 0.0f || nVar.an() == 100.0f) {
            return true;
        }
        return false;
    }

    public static boolean d(n nVar) {
        if (nVar != null && m.d().n() && nVar.E() && !b(nVar) && !c(nVar)) {
            return true;
        }
        return false;
    }

    public void d() {
        FrameLayout frameLayout = this.w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.A.setVisibility(0);
        }
    }

    public void e() {
        SSWebView sSWebView;
        h hVar = this.G;
        if (!(hVar == null || (sSWebView = this.v) == null)) {
            hVar.a(sSWebView);
        }
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.j.cancel();
        }
        ObjectAnimator objectAnimator2 = this.k;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.k.cancel();
        }
        ObjectAnimator objectAnimator3 = this.l;
        if (objectAnimator3 != null) {
            objectAnimator3.removeAllUpdateListeners();
            this.l.cancel();
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.x;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.b();
        }
        ObjectAnimator objectAnimator4 = this.i;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        if (this.v != null) {
            x.a(m.a(), this.v.getWebView());
            x.a(this.v.getWebView());
        }
        this.v = null;
        u uVar = this.u;
        if (uVar != null) {
            uVar.m();
        }
        h hVar2 = this.G;
        if (hVar2 != null) {
            hVar2.f();
        }
    }

    public void f() {
        u uVar = this.u;
        if (uVar != null) {
            uVar.k();
        }
        h hVar = this.G;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void g() {
        h hVar = this.G;
        if (hVar != null) {
            hVar.e();
        }
    }

    public void h() {
        r.a().b(true);
        u uVar = this.u;
        if (uVar != null) {
            uVar.l();
        }
    }
}
