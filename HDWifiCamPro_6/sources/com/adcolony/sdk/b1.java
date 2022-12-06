package com.adcolony.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.adcolony.sdk.e0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

public class b1 extends WebView {
    public static final g u = new g((DefaultConstructorMarker) null);
    private final int a;
    private final h0 b;
    /* access modifiers changed from: private */
    public int c;
    private String d = "";
    /* access modifiers changed from: private */
    public String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private f1 j = c0.b();
    private boolean k;
    private c l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;

    private final class a extends WebChromeClient {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
            if (r3 != false) goto L_0x0064;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0056 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onConsoleMessage(android.webkit.ConsoleMessage r9) {
            /*
                r8 = this;
                r0 = 0
                if (r9 != 0) goto L_0x0005
                r1 = r0
                goto L_0x0009
            L_0x0005:
                android.webkit.ConsoleMessage$MessageLevel r1 = r9.messageLevel()
            L_0x0009:
                if (r9 != 0) goto L_0x000d
                r9 = r0
                goto L_0x0011
            L_0x000d:
                java.lang.String r9 = r9.message()
            L_0x0011:
                r2 = 2
                r3 = 0
                r4 = 1
                if (r9 != 0) goto L_0x0017
                goto L_0x0021
            L_0x0017:
                java.lang.String r5 = "Viewport target-densitydpi is not supported."
                boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r5, (boolean) r3, (int) r2, (java.lang.Object) r0)
                if (r5 != r4) goto L_0x0021
                r5 = r4
                goto L_0x0022
            L_0x0021:
                r5 = r3
            L_0x0022:
                if (r5 != 0) goto L_0x0037
                if (r9 != 0) goto L_0x0027
                goto L_0x0031
            L_0x0027:
                java.lang.String r5 = "Viewport argument key \"shrink-to-fit\" not recognized and ignored"
                boolean r5 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r5, (boolean) r3, (int) r2, (java.lang.Object) r0)
                if (r5 != r4) goto L_0x0031
                r5 = r4
                goto L_0x0032
            L_0x0031:
                r5 = r3
            L_0x0032:
                if (r5 == 0) goto L_0x0035
                goto L_0x0037
            L_0x0035:
                r5 = r3
                goto L_0x0038
            L_0x0037:
                r5 = r4
            L_0x0038:
                android.webkit.ConsoleMessage$MessageLevel r6 = android.webkit.ConsoleMessage.MessageLevel.ERROR
                if (r1 != r6) goto L_0x003e
                r6 = r4
                goto L_0x003f
            L_0x003e:
                r6 = r3
            L_0x003f:
                android.webkit.ConsoleMessage$MessageLevel r7 = android.webkit.ConsoleMessage.MessageLevel.WARNING
                if (r1 != r7) goto L_0x0045
                r1 = r4
                goto L_0x0046
            L_0x0045:
                r1 = r3
            L_0x0046:
                if (r9 != 0) goto L_0x0049
                goto L_0x0053
            L_0x0049:
                java.lang.String r7 = "ADC3_update is not defined"
                boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r7, (boolean) r3, (int) r2, (java.lang.Object) r0)
                if (r7 != r4) goto L_0x0053
                r7 = r4
                goto L_0x0054
            L_0x0053:
                r7 = r3
            L_0x0054:
                if (r7 != 0) goto L_0x0064
                if (r9 != 0) goto L_0x0059
                goto L_0x0062
            L_0x0059:
                java.lang.String r7 = "NativeLayer.dispatch_messages is not a function"
                boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r7, (boolean) r3, (int) r2, (java.lang.Object) r0)
                if (r2 != r4) goto L_0x0062
                r3 = r4
            L_0x0062:
                if (r3 == 0) goto L_0x007d
            L_0x0064:
                com.adcolony.sdk.b1 r2 = com.adcolony.sdk.b1.this
                com.adcolony.sdk.h0 r3 = r2.getMessage()
                if (r3 != 0) goto L_0x006d
                goto L_0x0071
            L_0x006d:
                com.adcolony.sdk.f1 r0 = r3.a()
            L_0x0071:
                if (r0 != 0) goto L_0x0078
                com.adcolony.sdk.f1 r0 = new com.adcolony.sdk.f1
                r0.<init>()
            L_0x0078:
                java.lang.String r3 = "Unable to communicate with AdColony. Please ensure that you have added an exception for our Javascript interface in your ProGuard configuration and that you do not have a faulty proxy enabled on your device."
                r2.a((com.adcolony.sdk.f1) r0, (java.lang.String) r3)
            L_0x007d:
                if (r5 != 0) goto L_0x00c0
                if (r1 != 0) goto L_0x0083
                if (r6 == 0) goto L_0x00c0
            L_0x0083:
                com.adcolony.sdk.b1 r0 = com.adcolony.sdk.b1.this
                com.adcolony.sdk.AdColonyInterstitial r0 = r0.getInterstitial()
                if (r0 != 0) goto L_0x008c
                goto L_0x0092
            L_0x008c:
                java.lang.String r0 = r0.a()
                if (r0 != 0) goto L_0x0094
            L_0x0092:
                java.lang.String r0 = "unknown"
            L_0x0094:
                com.adcolony.sdk.e0$a r1 = new com.adcolony.sdk.e0$a
                r1.<init>()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "onConsoleMessage: "
                r2.append(r3)
                r2.append(r9)
                java.lang.String r9 = " with ad id: "
                r2.append(r9)
                r2.append(r0)
                java.lang.String r9 = r2.toString()
                com.adcolony.sdk.e0$a r9 = r1.a((java.lang.String) r9)
                if (r6 == 0) goto L_0x00bb
                com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.i
                goto L_0x00bd
            L_0x00bb:
                com.adcolony.sdk.e0 r0 = com.adcolony.sdk.e0.g
            L_0x00bd:
                r9.a((com.adcolony.sdk.e0) r0)
            L_0x00c0:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.b1.a.onConsoleMessage(android.webkit.ConsoleMessage):boolean");
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (jsResult == null) {
                return true;
            }
            jsResult.confirm();
            return true;
        }
    }

    protected class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            Unit unit;
            f1 b = c0.b();
            c0.b(b, "id", b1.this.c);
            c0.a(b, "url", str);
            c parentContainer = b1.this.getParentContainer();
            if (parentContainer == null) {
                unit = null;
            } else {
                c0.a(b, "ad_session_id", b1.this.getAdSessionId());
                c0.b(b, "container_id", parentContainer.c());
                new h0("WebView.on_load", parentContainer.k(), b).c();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                new h0("WebView.on_load", b1.this.getWebViewModuleId(), b).c();
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            b1.this.a(i, str, str2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z = true;
            if (str == null || !StringsKt.endsWith$default(str, "mraid.js", false, 2, (Object) null)) {
                z = false;
            }
            if (!z) {
                return null;
            }
            String a2 = b1.this.e;
            Charset charset = h.a;
            if (a2 != null) {
                return new WebResourceResponse("text/javascript", charset.name(), new ByteArrayInputStream(a2.getBytes(charset)));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    protected class c extends b {
        public c() {
            super();
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            boolean z = true;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null || !StringsKt.endsWith$default(uri, "mraid.js", false, 2, (Object) null)) {
                z = false;
            }
            if (!z) {
                return null;
            }
            String a = b1.this.e;
            Charset charset = h.a;
            if (a != null) {
                return new WebResourceResponse("text/javascript", charset.name(), new ByteArrayInputStream(a.getBytes(charset)));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return null;
        }
    }

    protected class d extends c {
        public d() {
            super();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            r3 = r3.getUrl();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceivedError(android.webkit.WebView r2, android.webkit.WebResourceRequest r3, android.webkit.WebResourceError r4) {
            /*
                r1 = this;
                if (r4 != 0) goto L_0x0003
                return
            L_0x0003:
                com.adcolony.sdk.b1 r2 = com.adcolony.sdk.b1.this
                int r0 = r4.getErrorCode()
                java.lang.CharSequence r4 = r4.getDescription()
                java.lang.String r4 = r4.toString()
                if (r3 != 0) goto L_0x0014
                goto L_0x001a
            L_0x0014:
                android.net.Uri r3 = r3.getUrl()
                if (r3 != 0) goto L_0x001c
            L_0x001a:
                r3 = 0
                goto L_0x0020
            L_0x001c:
                java.lang.String r3 = r3.toString()
            L_0x0020:
                r2.a((int) r0, (java.lang.String) r4, (java.lang.String) r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.b1.d.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
        }
    }

    protected class e extends d {
        public e(b1 b1Var) {
            super();
        }
    }

    protected class f extends e {
        public f() {
            super(b1.this);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) {
                b1.this.a(c0.b(), "An error occurred while rendering the ad. Ad closing.");
            }
            return true;
        }
    }

    public static final class g {
        private g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final b1 a(Context context, h0 h0Var, int i, c cVar) {
            b1 b1Var;
            int e = a.b().r().e();
            f1 a = h0Var.a();
            if (c0.b(a, "use_mraid_module")) {
                b1Var = new l0(context, e, h0Var, a.b().r().e());
            } else if (c0.b(a, "enable_messages")) {
                b1Var = new c1(context, e, h0Var);
            } else {
                b1Var = new b1(context, e, h0Var);
            }
            b1Var.a(h0Var, i, cVar);
            b1Var.i();
            return b1Var;
        }
    }

    public static final class h implements j0 {
        final /* synthetic */ b1 a;

        static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ b1 a;
            final /* synthetic */ h0 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.a = b1Var;
                this.b = h0Var;
            }

            public final void a() {
                this.a.a(c0.h(this.b.a(), "custom_js"));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        h(b1 b1Var) {
            this.a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.a;
            b1Var.a(h0Var, (Function0<Unit>) new a(b1Var, h0Var));
        }
    }

    public static final class i implements j0 {
        final /* synthetic */ b1 a;

        static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ b1 a;
            final /* synthetic */ h0 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.a = b1Var;
                this.b = h0Var;
            }

            public final void a() {
                this.a.setVisible(this.b);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        i(b1 b1Var) {
            this.a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.a;
            b1Var.a(h0Var, (Function0<Unit>) new a(b1Var, h0Var));
        }
    }

    public static final class j implements j0 {
        final /* synthetic */ b1 a;

        static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ b1 a;
            final /* synthetic */ h0 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.a = b1Var;
                this.b = h0Var;
            }

            public final void a() {
                this.a.setBounds(this.b);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        j(b1 b1Var) {
            this.a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.a;
            b1Var.a(h0Var, (Function0<Unit>) new a(b1Var, h0Var));
        }
    }

    public static final class k implements j0 {
        final /* synthetic */ b1 a;

        static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ b1 a;
            final /* synthetic */ h0 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b1 b1Var, h0 h0Var) {
                super(0);
                this.a = b1Var;
                this.b = h0Var;
            }

            public final void a() {
                this.a.setTransparent(c0.b(this.b.a(), "transparent"));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        k(b1 b1Var) {
            this.a = b1Var;
        }

        public void a(h0 h0Var) {
            b1 b1Var = this.a;
            b1Var.a(h0Var, (Function0<Unit>) new a(b1Var, h0Var));
        }
    }

    static final class l implements Runnable {
        private final /* synthetic */ Function0 a;

        l(Function0 function0) {
            this.a = function0;
        }

        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    static final class m implements Runnable {
        final /* synthetic */ b1 a;

        public static final class a extends WebViewClient {
            final /* synthetic */ b1 a;

            a(b1 b1Var) {
                this.a = b1Var;
            }

            public void onPageFinished(WebView webView, String str) {
                this.a.destroy();
            }
        }

        m(b1 b1Var) {
            this.a = b1Var;
        }

        public final void run() {
            this.a.setWebChromeClient((WebChromeClient) null);
            b1 b1Var = this.a;
            b1Var.setWebViewClient(new a(b1Var));
            this.a.clearCache(true);
            this.a.removeAllViews();
            this.a.loadUrl("about:blank");
        }
    }

    protected b1(Context context, int i2, h0 h0Var) {
        super(context);
        this.a = i2;
        this.b = h0Var;
    }

    @JvmStatic
    public static final b1 a(Context context, h0 h0Var, int i2, c cVar) {
        return u.a(context, h0Var, i2, cVar);
    }

    private final void d() {
        ArrayList<String> j2;
        ArrayList<j0> i2;
        c cVar = this.l;
        if (!(cVar == null || (i2 = cVar.i()) == null)) {
            i2.add(a.a("WebView.execute_js", (j0) new h(this), true));
            i2.add(a.a("WebView.set_visible", (j0) new i(this), true));
            i2.add(a.a("WebView.set_bounds", (j0) new j(this), true));
            i2.add(a.a("WebView.set_transparent", (j0) new k(this), true));
        }
        c cVar2 = this.l;
        if (cVar2 != null && (j2 = cVar2.j()) != null) {
            j2.add("WebView.execute_js");
            j2.add("WebView.set_visible");
            j2.add("WebView.set_bounds");
            j2.add("WebView.set_transparent");
        }
    }

    private final WebViewClient g() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return getWebViewClientApi26();
        }
        if (i2 >= 24) {
            return getWebViewClientApi24();
        }
        if (i2 >= 23) {
            return getWebViewClientApi23();
        }
        if (i2 >= 21) {
            return getWebViewClientApi21();
        }
        return getWebViewClientDefault();
    }

    /* access modifiers changed from: private */
    public final void setTransparent(boolean z) {
        setBackgroundColor(z ? 0 : -1);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void e() {
        d();
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.o, this.p);
        layoutParams.setMargins(getCurrentX(), getCurrentY(), 0, 0);
        layoutParams.gravity = 0;
        c cVar = this.l;
        if (cVar != null) {
            cVar.addView(this, layoutParams);
        }
    }

    public final void f() {
        a.b().c().a(this, this.h, this.l);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getAdSessionId() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AdColonyAdView getAdView() {
        return a.b().c().d().get(this.h);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getBaseUrl() {
        return this.g;
    }

    public final int getCurrentHeight() {
        return this.p;
    }

    public final int getCurrentWidth() {
        return this.o;
    }

    public final int getCurrentX() {
        return this.m;
    }

    public final int getCurrentY() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getDestroyed() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ f1 getInfo() {
        return this.j;
    }

    public final int getInitialHeight() {
        return this.t;
    }

    public final int getInitialWidth() {
        return this.s;
    }

    public final int getInitialX() {
        return this.q;
    }

    public final int getInitialY() {
        return this.r;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ AdColonyInterstitial getInterstitial() {
        return a.b().c().f().get(this.h);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getMUrl() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ h0 getMessage() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String getMraidFilepath() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ c getParentContainer() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new e(this);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new f();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new b();
    }

    public final int getWebViewModuleId() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String h() {
        AdColonyInterstitial interstitial = getInterstitial();
        if (interstitial != null) {
            String str = interstitial.a() + " : " + interstitial.getZoneID();
            return str == null ? "unknown" : str;
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i() {
        boolean z = true;
        setFocusable(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        setWebChromeClient(new a());
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setGeolocationEnabled(true);
        if (i2 >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
            settings.setAllowFileAccess(true);
        }
        setWebViewClient(g());
        j();
        if (!(this instanceof j)) {
            e();
        }
        if (this.d.length() <= 0) {
            z = false;
        }
        if (z) {
            a(this.d);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void j() {
        if (!StringsKt.startsWith$default(this.f, "http", false, 2, (Object) null) && !StringsKt.startsWith$default(this.f, "file", false, 2, (Object) null)) {
            loadDataWithBaseURL(this.g, this.f, "text/html", (String) null, (String) null);
        } else if (StringsKt.contains$default((CharSequence) this.f, (CharSequence) ".html", false, 2, (Object) null) || !StringsKt.startsWith$default(this.f, "file", false, 2, (Object) null)) {
            loadUrl(this.f);
        } else {
            String str = this.f;
            loadDataWithBaseURL(str, "<html><script src=\"" + this.f + "\"></script></html>", "text/html", (String) null, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void k() {
        if (this.i.length() > 0) {
            try {
                this.e = a.b().p().a(this.i, false).toString();
                Regex regex = new Regex("bridge.os_name\\s*=\\s*\"\"\\s*;");
                this.e = regex.replaceFirst(this.e, "bridge.os_name = \"\";\nvar ADC_DEVICE_INFO = " + this.j + ";\n");
            } catch (IOException e2) {
                a((Exception) e2);
            } catch (IllegalArgumentException e3) {
                a((Exception) e3);
            } catch (IndexOutOfBoundsException e4) {
                a((Exception) e4);
            }
        }
    }

    public final void l() {
        if (!this.k) {
            this.k = true;
            z0.b((Runnable) new m(this));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            AdColonyAdView adView = getAdView();
            if (adView != null && !adView.c()) {
                f1 b2 = c0.b();
                c0.a(b2, "ad_session_id", getAdSessionId());
                new h0("WebView.on_first_click", 1, b2).c();
                adView.setUserInteraction(true);
            }
            AdColonyInterstitial interstitial = getInterstitial();
            if (interstitial != null) {
                interstitial.b(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setAdSessionId(String str) {
        this.h = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setBaseUrl(String str) {
        this.g = str;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setBounds(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.m = c0.d(a2, "x");
        this.n = c0.d(a2, "y");
        this.o = c0.d(a2, "width");
        this.p = c0.d(a2, "height");
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(getCurrentX(), getCurrentY(), 0, 0);
            layoutParams2.width = getCurrentWidth();
            layoutParams2.height = getCurrentHeight();
            Unit unit = Unit.INSTANCE;
            setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setInfo(f1 f1Var) {
        this.j = f1Var;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setMUrl(String str) {
        this.f = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setMraidFilepath(String str) {
        this.i = str;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setVisible(h0 h0Var) {
        setVisibility(c0.b(h0Var.a(), "visible") ? 0 : 4);
    }

    public final void b(h0 h0Var, int i2, c cVar) {
        a(h0Var, i2, cVar);
        e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void a(h0 h0Var, int i2, c cVar) {
        this.c = i2;
        this.l = cVar;
        f1 a2 = h0Var.a();
        String i3 = c0.i(a2, "url");
        if (i3 == null) {
            i3 = c0.h(a2, DataSchemeDataSource.SCHEME_DATA);
        }
        this.f = i3;
        this.g = c0.h(a2, "base_url");
        this.d = c0.h(a2, "custom_js");
        this.h = c0.h(a2, "ad_session_id");
        this.j = c0.f(a2, "info");
        this.i = c0.h(a2, "mraid_filepath");
        this.o = c0.d(a2, "width");
        this.p = c0.d(a2, "height");
        this.m = c0.d(a2, "x");
        int d2 = c0.d(a2, "y");
        this.n = d2;
        this.s = this.o;
        this.t = this.p;
        this.q = this.m;
        this.r = d2;
        k();
        f();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(String str) {
        if (this.k) {
            new e0.a().a("Ignoring call to execute_js as WebView has been destroyed.").a(e0.c);
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                evaluateJavascript(str, (ValueCallback) null);
            } catch (IllegalStateException unused) {
                new e0.a().a("Device reporting incorrect OS version, evaluateJavascript ").a("is not available. Disabling AdColony.").a(e0.h);
                AdColony.disable();
            }
        } else {
            loadUrl(Intrinsics.stringPlus("javascript:", str));
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean a(f1 f1Var, String str) {
        Context a2 = a.a();
        b bVar = a2 instanceof b ? (b) a2 : null;
        if (bVar == null) {
            return false;
        }
        a.b().c().a((Context) bVar, f1Var, str);
        return true;
    }

    private final void a(Exception exc) {
        new e0.a().a(exc.getClass().toString()).a(" during metadata injection w/ metadata = ").a(c0.h(this.j, TtmlNode.TAG_METADATA)).a(e0.i);
        c cVar = this.l;
        if (cVar != null) {
            f1 b2 = c0.b();
            c0.a(b2, "id", getAdSessionId());
            new h0("AdSession.on_error", cVar.k(), b2).c();
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, String str, String str2) {
        c cVar = this.l;
        if (cVar != null) {
            f1 b2 = c0.b();
            c0.b(b2, "id", this.c);
            c0.a(b2, "ad_session_id", getAdSessionId());
            c0.b(b2, "container_id", cVar.c());
            c0.b(b2, "code", i2);
            c0.a(b2, CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            c0.a(b2, "url", str2);
            new h0("WebView.on_error", cVar.k(), b2).c();
        }
        e0.a a2 = new e0.a().a("onReceivedError: ");
        if (str == null) {
            str = "WebViewErrorMessage: null description";
        }
        a2.a(str).a(e0.i);
    }

    /* access modifiers changed from: private */
    public final void a(h0 h0Var, Function0<Unit> function0) {
        f1 a2 = h0Var.a();
        if (c0.d(a2, "id") == this.c) {
            int d2 = c0.d(a2, "container_id");
            c cVar = this.l;
            if (cVar != null && d2 == cVar.c()) {
                String h2 = c0.h(a2, "ad_session_id");
                c cVar2 = this.l;
                if (Intrinsics.areEqual((Object) h2, (Object) cVar2 == null ? null : cVar2.a())) {
                    z0.b((Runnable) new l(function0));
                }
            }
        }
    }

    public final void a(h0 h0Var) {
        setBounds(h0Var);
    }
}
