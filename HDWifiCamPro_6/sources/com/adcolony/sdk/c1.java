package com.adcolony.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.b1;
import com.adcolony.sdk.e0;
import com.iab.omid.library.adcolony.ScriptInjector;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

public class c1 extends b1 implements k0 {
    private i A;
    private boolean B = true;
    private f1 C = c0.b();
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public final Object x = new Object();
    /* access modifiers changed from: private */
    public e1 y = c0.a();
    /* access modifiers changed from: private */
    public String z = "";

    private class a {
        public a() {
        }

        @JavascriptInterface
        public final void dispatch_messages(String str, String str2) {
            if (Intrinsics.areEqual((Object) str2, (Object) c1.this.z)) {
                c1.this.c(str);
            }
        }

        @JavascriptInterface
        public final void enable_reverse_messaging(String str) {
            if (Intrinsics.areEqual((Object) str, (Object) c1.this.z)) {
                c1.this.v = true;
            }
        }

        @JavascriptInterface
        public final String pull_messages(String str) {
            if (!Intrinsics.areEqual((Object) str, (Object) c1.this.z)) {
                return "[]";
            }
            String str2 = "[]";
            Object d = c1.this.x;
            c1 c1Var = c1.this;
            synchronized (d) {
                if (c1Var.y.b() > 0) {
                    if (c1Var.getEnableMessages()) {
                        str2 = c1Var.y.toString();
                    }
                    c1Var.y = c0.a();
                }
                Unit unit = Unit.INSTANCE;
            }
            return str2;
        }

        @JavascriptInterface
        public final void push_messages(String str, String str2) {
            if (Intrinsics.areEqual((Object) str2, (Object) c1.this.z)) {
                c1.this.c(str);
            }
        }
    }

    private final class b extends a {
        public b() {
            super();
        }

        @JavascriptInterface
        public final void enable_event_messaging(String str) {
            if (Intrinsics.areEqual((Object) str, (Object) c1.this.z)) {
                c1.this.w = true;
            }
        }
    }

    protected class c extends b1.b {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new l().a();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().b();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().a(str);
        }
    }

    protected class d extends b1.c {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new l().a();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().b();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().a(str);
        }
    }

    protected class e extends b1.d {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().b();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return new l().a(str);
        }
    }

    protected class f extends b1.e {
        public f() {
            super(c1.this);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().b();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return new k().a(webResourceRequest);
        }
    }

    protected class g extends b1.f {
        public g() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new j().a(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            new l().b();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return new k().a(webResourceRequest);
        }
    }

    public static final class h {
        private h() {
        }

        public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class i {
        private final WebMessagePort[] a;

        public i(WebMessagePort[] webMessagePortArr) {
            this.a = webMessagePortArr;
        }

        public final WebMessagePort a() {
            return (WebMessagePort) ArraysKt.getOrNull((T[]) this.a, 1);
        }

        public final WebMessagePort b() {
            return (WebMessagePort) ArraysKt.getOrNull((T[]) this.a, 0);
        }
    }

    private final class j {
        public j() {
        }

        public final void a(String str) {
            new l().a();
            if (str != null) {
                c1.this.d(str);
            } else {
                new e0.a().a("ADCWebViewModule: initializeEventMessaging failed due to url = null").a(e0.g);
            }
        }
    }

    private final class k {
        public k() {
        }

        public final boolean a(WebResourceRequest webResourceRequest) {
            int i = 0;
            if (c1.this.getModuleInitialized()) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    String a2 = c1.this.getClickOverride();
                    Uri parse = a2 == null ? null : Uri.parse(a2);
                    if (parse == null) {
                        parse = webResourceRequest.getUrl();
                    }
                    if (parse != null) {
                        z0.a(new Intent("android.intent.action.VIEW", parse));
                        f1 b = c0.b();
                        c1 c1Var = c1.this;
                        c0.a(b, "url", parse.toString());
                        c0.a(b, "ad_session_id", c1Var.getAdSessionId());
                        c parentContainer = c1.this.getParentContainer();
                        if (parentContainer != null) {
                            i = parentContainer.k();
                        }
                        new h0("WebView.redirect_detected", i, b).c();
                        x0 A = a.b().A();
                        c1 c1Var2 = c1.this;
                        A.a(c1Var2.getAdSessionId());
                        A.c(c1Var2.getAdSessionId());
                    } else {
                        new e0.a().a(Intrinsics.stringPlus("shouldOverrideUrlLoading called with null request url, with ad id: ", c1.this.h())).a(e0.i);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static final class m extends WebMessagePort.WebMessageCallback {
        final /* synthetic */ c1 a;

        m(c1 c1Var) {
            this.a = c1Var;
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            String data;
            if (webMessage != null && (data = webMessage.getData()) != null) {
                c1 c1Var = this.a;
                List<String> split = new Regex(":").split(data, 2);
                if (split.size() == 2 && Intrinsics.areEqual((Object) split.get(0), (Object) c1Var.z)) {
                    c1Var.b(split.get(1));
                }
            }
        }
    }

    static final class n implements Runnable {
        final /* synthetic */ c1 a;

        n(c1 c1Var) {
            this.a = c1Var;
        }

        public final void run() {
            this.a.removeJavascriptInterface("NativeLayer");
        }
    }

    static final class o implements Runnable {
        final /* synthetic */ c1 a;
        final /* synthetic */ String b;

        o(c1 c1Var, String str) {
            this.a = c1Var;
            this.b = str;
        }

        public final void run() {
            if (this.a.getEnableMessages()) {
                c1 c1Var = this.a;
                c1Var.a("NativeLayer.dispatch_messages(ADC3_update(" + this.b + "), '" + this.a.z + "');");
            }
        }
    }

    static {
        new h((DefaultConstructorMarker) null);
    }

    public c1(Context context, int i2, h0 h0Var) {
        super(context, i2, h0Var);
    }

    private final void e(f1 f1Var) {
        WebMessagePort webMessagePort;
        if (this.B) {
            i iVar = this.A;
            if (iVar == null || (webMessagePort = iVar.b()) == null) {
                webMessagePort = null;
            } else {
                e1 a2 = c0.a();
                a2.a(f1Var);
                webMessagePort.postMessage(new WebMessage(a2.toString()));
            }
            if (webMessagePort == null) {
                new e0.a().a("Sending message before event messaging is initialized").a(e0.g);
            }
        }
    }

    /* access modifiers changed from: private */
    public final String getClickOverride() {
        AdColonyInterstitial interstitial = getInterstitial();
        String c2 = interstitial == null ? null : interstitial.c();
        if (c2 != null) {
            return c2;
        }
        AdColonyAdView adView = getAdView();
        if (adView == null) {
            return null;
        }
        return adView.getClickOverride();
    }

    private final a m() {
        if (Build.VERSION.SDK_INT >= 23) {
            return new b();
        }
        return new a();
    }

    public int getAdcModuleId() {
        return getAdc3ModuleId();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getEnableMessages() {
        return this.B;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ f1 getIab() {
        return this.C;
    }

    /* renamed from: getModuleId */
    public int getAdc3ModuleId() {
        return getWebViewModuleId();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean getModuleInitialized() {
        return this.D;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi21() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi23() {
        return new e();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi24() {
        return new f();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientApi26() {
        return new g();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ WebViewClient getWebViewClientDefault() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void i() {
        addJavascriptInterface(m(), "NativeLayer");
        a.b().r().a((k0) this);
        super.i();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean n() {
        return this.E;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setEnableMessages(boolean z2) {
        this.B = z2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void setIab(f1 f1Var) {
        this.C = f1Var;
    }

    private final void o() {
        String str;
        synchronized (this.x) {
            str = "";
            if (this.y.b() > 0) {
                if (getEnableMessages()) {
                    str = this.y.toString();
                }
                this.y = c0.a();
            }
            Unit unit = Unit.INSTANCE;
        }
        z0.b((Runnable) new o(this, str));
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String d(f1 f1Var) {
        return Intrinsics.stringPlus("file:///", c(f1Var));
    }

    /* access modifiers changed from: private */
    public final void d(String str) {
        if (this.A == null) {
            i iVar = new i(createWebMessageChannel());
            WebMessagePort b2 = iVar.b();
            if (b2 != null) {
                b2.setWebMessageCallback(new m(this));
            }
            postWebMessage(new WebMessage("", new WebMessagePort[]{iVar.a()}), Uri.parse(str));
            Unit unit = Unit.INSTANCE;
            this.A = iVar;
        }
    }

    public void b() {
        if (a.c() && this.D && !this.v && !this.w) {
            o();
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String c(f1 f1Var) {
        return c0.h(f1Var, "filepath");
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void a(h0 h0Var, int i2, c cVar) {
        f1 a2 = h0Var.a();
        this.B = c0.b(a2, "enable_messages");
        if (this.C.b()) {
            this.C = c0.f(a2, "iab");
        }
        super.a(h0Var, i2, cVar);
    }

    public void c() {
        if (!getDestroyed()) {
            l();
            z0.b((Runnable) new n(this));
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        b(c0.b(str));
    }

    private final class l {
        public l() {
        }

        public final void a() {
            if (c1.this.getEnableMessages() && !c1.this.getModuleInitialized()) {
                c1.this.z = z0.a();
                f1 a2 = c0.a(c0.b(), c1.this.getInfo());
                c0.a(a2, "message_key", c1.this.z);
                c1 c1Var = c1.this;
                c1Var.a("ADC3_init(" + c1.this.getAdcModuleId() + ',' + a2 + ");");
                c1.this.D = true;
            }
        }

        public final void b() {
            c1.this.D = false;
        }

        public final boolean a(String str) {
            int i = 0;
            if (!c1.this.getModuleInitialized()) {
                return false;
            }
            String a2 = c1.this.getClickOverride();
            if (a2 != null) {
                str = a2;
            }
            if (str != null) {
                z0.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                f1 b = c0.b();
                c1 c1Var = c1.this;
                c0.a(b, "url", str);
                c0.a(b, "ad_session_id", c1Var.getAdSessionId());
                c parentContainer = c1.this.getParentContainer();
                if (parentContainer != null) {
                    i = parentContainer.k();
                }
                new h0("WebView.redirect_detected", i, b).c();
                x0 A = a.b().A();
                c1 c1Var2 = c1.this;
                A.a(c1Var2.getAdSessionId());
                A.c(c1Var2.getAdSessionId());
                return true;
            }
            new e0.a().a(Intrinsics.stringPlus("shouldOverrideUrlLoading called with null request url, with ad id: ", c1.this.h())).a(e0.i);
            return true;
        }
    }

    private final void b(f1 f1Var) {
        a.b().r().c(f1Var);
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        for (f1 b2 : c0.a(str).c()) {
            b(b2);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void b(Exception exc) {
        new e0.a().a(exc.getClass().toString()).a(" during metadata injection w/ metadata = ").a(c0.h(getInfo(), TtmlNode.TAG_METADATA)).a(e0.i);
    }

    public void a(f1 f1Var) {
        synchronized (this.x) {
            if (this.w) {
                e(f1Var);
                Unit unit = Unit.INSTANCE;
            } else {
                this.y.a(f1Var);
            }
        }
    }

    public boolean a() {
        return !this.v && !this.w;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ String a(String str, String str2) {
        p0 p0Var;
        if (!this.C.b()) {
            AdColonyInterstitial interstitial = getInterstitial();
            p0 p0Var2 = null;
            if (interstitial != null && !Intrinsics.areEqual((Object) c0.h(getIab(), "ad_type"), (Object) "video")) {
                interstitial.a(getIab());
                p0Var = interstitial.e();
            } else {
                p0Var = null;
            }
            if (p0Var == null) {
                AdColonyAdViewListener adColonyAdViewListener = a.b().c().e().get(getAdSessionId());
                if (adColonyAdViewListener != null) {
                    adColonyAdViewListener.a(new p0(getIab(), getAdSessionId()));
                    p0Var2 = adColonyAdViewListener.c;
                }
            } else {
                p0Var2 = p0Var;
            }
            if (p0Var2 != null && p0Var2.d() == 2) {
                boolean z2 = true;
                this.E = true;
                if (str2.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    try {
                        return ScriptInjector.injectScriptContentIntoHtml(a.b().p().a(str2, false).toString(), str);
                    } catch (IOException e2) {
                        b((Exception) e2);
                    }
                }
            }
        }
        return str;
    }
}
