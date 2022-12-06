package com.adcolony.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import com.adcolony.sdk.c1;
import com.iab.omid.library.adcolony.adsession.FriendlyObstructionPurpose;
import java.io.File;
import kotlin.Unit;
import kotlin.text.Regex;
import kotlin.text.Typography;

public final class l0 extends c1 {
    private final int F;
    private ImageView G;
    private String H = "";
    /* access modifiers changed from: private */
    public String I = "";
    private int J;
    private int K;
    private boolean L;
    private boolean M;

    private final class a extends c1.c {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class b extends c1.d {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class c extends c1.e {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class d extends c1.f {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class e extends c1.g {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new f().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class f {
        public f() {
        }

        public final void a() {
            if (!l0.this.getModuleInitialized()) {
                float s = a.b().n().s();
                f1 info = l0.this.getInfo();
                l0 l0Var = l0.this;
                c0.b(info, "app_orientation", z0.d(z0.f()));
                c0.b(info, "x", z0.a((View) l0Var));
                c0.b(info, "y", z0.b((View) l0Var));
                c0.b(info, "width", (int) (((float) l0Var.getCurrentWidth()) / s));
                c0.b(info, "height", (int) (((float) l0Var.getCurrentHeight()) / s));
                c0.a(info, "ad_session_id", l0Var.getAdSessionId());
            }
        }
    }

    static final class g implements View.OnClickListener {
        final /* synthetic */ l0 a;

        g(l0 l0Var) {
            this.a = l0Var;
        }

        public final void onClick(View view) {
            z0.a(new Intent("android.intent.action.VIEW", Uri.parse(this.a.I)));
            a.b().A().c(this.a.getAdSessionId());
        }
    }

    public l0(Context context, int i, h0 h0Var, int i2) {
        super(context, i, h0Var);
        this.F = i2;
    }

    private final void q() {
        Context a2 = a.a();
        if (a2 != null && getParentContainer() != null && !this.M) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            ImageView imageView = new ImageView(a2);
            imageView.setImageURI(Uri.fromFile(new File(this.H)));
            imageView.setBackground(gradientDrawable);
            imageView.setOnClickListener(new g(this));
            Unit unit = Unit.INSTANCE;
            this.G = imageView;
            r();
            addView(this.G);
        }
    }

    private final void r() {
        ImageView imageView = this.G;
        if (imageView != null) {
            Rect w = a.b().n().w();
            int currentX = this.L ? getCurrentX() + getCurrentWidth() : w.width();
            int currentY = this.L ? getCurrentY() + getCurrentHeight() : w.height();
            float s = a.b().n().s();
            int i = (int) (((float) this.J) * s);
            int i2 = (int) (((float) this.K) * s);
            imageView.setLayoutParams(new AbsoluteLayout.LayoutParams(i, i2, currentX - i, currentY - i2));
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void e() {
        super.e();
        boolean z = true;
        if (this.H.length() > 0) {
            if (this.I.length() <= 0) {
                z = false;
            }
            if (z) {
                q();
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ int getAdc3ModuleId() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void k() {
        if (getMraidFilepath().length() > 0) {
            Regex regex = new Regex("script\\s*src\\s*=\\s*\"mraid.js\"");
            setMUrl(a(regex.replaceFirst(getMUrl(), "script src=\"file://" + getMraidFilepath() + Typography.quote), c0.h(c0.f(getInfo(), "device_info"), "iab_filepath")));
        }
    }

    public final void p() {
        c parentContainer;
        ImageView imageView = this.G;
        if (imageView != null && (parentContainer = getParentContainer()) != null) {
            parentContainer.a((View) imageView, FriendlyObstructionPurpose.OTHER);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setBounds(h0 h0Var) {
        super.setBounds(h0Var);
        r();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void a(h0 h0Var, int i, c cVar) {
        f1 a2 = h0Var.a();
        this.H = c0.h(a2, "ad_choices_filepath");
        this.I = c0.h(a2, "ad_choices_url");
        this.J = c0.d(a2, "ad_choices_width");
        this.K = c0.d(a2, "ad_choices_height");
        this.L = c0.b(a2, "ad_choices_snap_to_webview");
        this.M = c0.b(a2, "disable_ad_choices");
        super.a(h0Var, i, cVar);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean a(f1 f1Var, String str) {
        if (super.a(f1Var, str)) {
            return true;
        }
        setEnableMessages(false);
        return true;
    }
}
