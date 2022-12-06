package com.adcolony.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.adcolony.sdk.e0;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.io.File;

public class AdColonyAdView extends FrameLayout {
    /* access modifiers changed from: private */
    public c a;
    private AdColonyAdViewListener b;
    private AdColonyAdSize c;
    /* access modifiers changed from: private */
    public String d;
    private String e;
    private String f;
    private String g;
    private ImageView h;
    private p0 i;
    private h0 j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p = true;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    /* access modifiers changed from: private */
    public c v;

    class a implements Runnable {
        a() {
        }

        public void run() {
            Context a2 = a.a();
            if (a2 instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) a2).b();
            }
            d c = a.b().c();
            c.a(AdColonyAdView.this.d);
            c.a(AdColonyAdView.this.a);
            f1 b = c0.b();
            c0.a(b, "id", AdColonyAdView.this.d);
            new h0("AdSession.on_ad_view_destroyed", 1, b).c();
            if (AdColonyAdView.this.v != null) {
                AdColonyAdView.this.v.a();
            }
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ Context a;

        b(AdColonyAdView adColonyAdView, Context context) {
            this.a = context;
        }

        public void onClick(View view) {
            Context context = this.a;
            if (context instanceof AdColonyAdViewActivity) {
                ((AdColonyAdViewActivity) context).b();
            }
        }
    }

    interface c {
        void a();
    }

    AdColonyAdView(Context context, h0 h0Var, AdColonyAdViewListener adColonyAdViewListener) throws RuntimeException {
        super(context);
        this.b = adColonyAdViewListener;
        this.e = adColonyAdViewListener.c();
        f1 a2 = h0Var.a();
        this.d = c0.h(a2, "id");
        this.f = c0.h(a2, "close_button_filepath");
        this.k = c0.b(a2, "trusted_demand_source");
        this.o = c0.b(a2, "close_button_snap_to_webview");
        this.t = c0.d(a2, "close_button_width");
        this.u = c0.d(a2, "close_button_height");
        c cVar = a.b().c().c().get(this.d);
        this.a = cVar;
        if (cVar != null) {
            this.c = adColonyAdViewListener.a();
            setLayoutParams(new FrameLayout.LayoutParams(this.a.d(), this.a.b()));
            setBackgroundColor(0);
            addView(this.a);
            return;
        }
        throw new RuntimeException("AdColonyAdView container cannot be null");
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.l;
    }

    public boolean destroy() {
        if (this.l) {
            new e0.a().a("Ignoring duplicate call to destroy().").a(e0.f);
            return false;
        }
        this.l = true;
        p0 p0Var = this.i;
        if (!(p0Var == null || p0Var.c() == null)) {
            this.i.b();
        }
        z0.b((Runnable) new a());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        b1 webView = getWebView();
        if (this.i != null && webView != null) {
            webView.f();
        }
    }

    public AdColonyAdSize getAdSize() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String getClickOverride() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public c getContainer() {
        return this.a;
    }

    public AdColonyAdViewListener getListener() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public p0 getOmidManager() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public boolean getTrustedDemandSource() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public b1 getWebView() {
        c cVar = this.a;
        if (cVar == null) {
            return null;
        }
        return cVar.n().get(2);
    }

    public String getZoneId() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.p && !this.l) {
            this.p = false;
            AdColonyAdViewListener adColonyAdViewListener = this.b;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onShow(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setClickOverride(String str) {
        this.g = str;
    }

    /* access modifiers changed from: package-private */
    public void setExpandMessage(h0 h0Var) {
        this.j = h0Var;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHeight(int i2) {
        this.s = (int) (((float) i2) * a.b().n().s());
    }

    /* access modifiers changed from: package-private */
    public void setExpandedWidth(int i2) {
        this.r = (int) (((float) i2) * a.b().n().s());
    }

    public void setListener(AdColonyAdViewListener adColonyAdViewListener) {
        this.b = adColonyAdViewListener;
    }

    /* access modifiers changed from: package-private */
    public void setNoCloseButton(boolean z) {
        this.m = this.k && z;
    }

    /* access modifiers changed from: package-private */
    public void setOmidManager(p0 p0Var) {
        this.i = p0Var;
    }

    /* access modifiers changed from: package-private */
    public void setOnDestroyListenerOrCall(c cVar) {
        if (this.l) {
            cVar.a();
        } else {
            this.v = cVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOrientation(int i2) {
        this.q = i2;
    }

    /* access modifiers changed from: package-private */
    public void setUserInteraction(boolean z) {
        this.n = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.k || this.n) {
            float s2 = a.b().n().s();
            this.a.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) this.c.getWidth()) * s2), (int) (((float) this.c.getHeight()) * s2)));
            b1 webView = getWebView();
            if (webView != null) {
                h0 h0Var = new h0("WebView.set_bounds", 0);
                f1 b2 = c0.b();
                c0.b(b2, "x", webView.getInitialX());
                c0.b(b2, "y", webView.getInitialY());
                c0.b(b2, "width", webView.getInitialWidth());
                c0.b(b2, "height", webView.getInitialHeight());
                h0Var.b(b2);
                webView.a(h0Var);
                f1 b3 = c0.b();
                c0.a(b3, "ad_session_id", this.d);
                new h0("MRAID.on_close", this.a.k(), b3).c();
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                this.a.removeView(imageView);
                this.a.a((View) this.h);
            }
            addView(this.a);
            AdColonyAdViewListener adColonyAdViewListener = this.b;
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onClosed(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int i2;
        if (this.k || this.n) {
            q n2 = a.b().n();
            Rect w = n2.w();
            int i3 = this.r;
            if (i3 <= 0) {
                i3 = w.width();
            }
            int i4 = this.s;
            if (i4 <= 0) {
                i4 = w.height();
            }
            int width = (w.width() - i3) / 2;
            int height = (w.height() - i4) / 2;
            this.a.setLayoutParams(new FrameLayout.LayoutParams(w.width(), w.height()));
            b1 webView = getWebView();
            if (webView != null) {
                h0 h0Var = new h0("WebView.set_bounds", 0);
                f1 b2 = c0.b();
                c0.b(b2, "x", width);
                c0.b(b2, "y", height);
                c0.b(b2, "width", i3);
                c0.b(b2, "height", i4);
                h0Var.b(b2);
                webView.a(h0Var);
                float s2 = n2.s();
                f1 b3 = c0.b();
                c0.b(b3, "app_orientation", z0.d(z0.f()));
                c0.b(b3, "width", (int) (((float) i3) / s2));
                c0.b(b3, "height", (int) (((float) i4) / s2));
                c0.b(b3, "x", z0.a((View) webView));
                c0.b(b3, "y", z0.b((View) webView));
                c0.a(b3, "ad_session_id", this.d);
                new h0("MRAID.on_size_change", this.a.k(), b3).c();
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                this.a.removeView(imageView);
            }
            Context a2 = a.a();
            if (!(a2 == null || this.m || webView == null)) {
                float s3 = a.b().n().s();
                int i5 = (int) (((float) this.t) * s3);
                int i6 = (int) (((float) this.u) * s3);
                if (this.o) {
                    i2 = webView.getCurrentX() + webView.getCurrentWidth();
                } else {
                    i2 = w.width();
                }
                int currentY = this.o ? webView.getCurrentY() : 0;
                ImageView imageView2 = new ImageView(a2.getApplicationContext());
                this.h = imageView2;
                imageView2.setImageURI(Uri.fromFile(new File(this.f)));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
                layoutParams.setMargins(i2 - i5, currentY, 0, 0);
                this.h.setOnClickListener(new b(this, a2));
                this.a.addView(this.h, layoutParams);
                this.a.a((View) this.h, FriendlyObstructionPurpose.CLOSE_AD);
            }
            if (this.j != null) {
                f1 b4 = c0.b();
                c0.b(b4, "success", true);
                this.j.a(b4).c();
                this.j = null;
            }
            return true;
        }
        if (this.j != null) {
            f1 b5 = c0.b();
            c0.b(b5, "success", false);
            this.j.a(b5).c();
            this.j = null;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.n;
    }
}
