package com.adcolony.sdk;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.j;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class l extends j {
    public static final f G = new f((DefaultConstructorMarker) null);
    public static boolean H;

    private final class a extends j.a {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class b extends j.b {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class c extends j.c {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class d extends j.d {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    private final class e extends j.e {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            new g().a();
            super.onPageFinished(webView, str);
        }
    }

    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final l a(Context context, h0 h0Var) {
            l lVar = new l(context, h0Var, (DefaultConstructorMarker) null);
            lVar.i();
            return lVar;
        }
    }

    private final class g {
        public g() {
        }

        public final void a() {
            if (!l.this.getModuleInitialized()) {
                e1 e1Var = new e1();
                for (AdColonyInterstitial adColonyInterstitial : a.b().c().g()) {
                    f1 f1Var = new f1();
                    c0.a(f1Var, "ad_session_id", adColonyInterstitial.b());
                    c0.a(f1Var, "ad_id", adColonyInterstitial.a());
                    c0.a(f1Var, AdColonyAdapterUtils.KEY_ZONE_ID, adColonyInterstitial.getZoneID());
                    c0.a(f1Var, "ad_request_id", adColonyInterstitial.g());
                    e1Var.a(f1Var);
                }
                c0.a(l.this.getInfo(), "ads_to_restore", e1Var);
            }
        }
    }

    private l(Context context, h0 h0Var) {
        super(context, 1, h0Var);
    }

    public /* synthetic */ l(Context context, h0 h0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, h0Var);
    }

    @JvmStatic
    public static final l b(Context context, h0 h0Var) {
        return G.a(context, h0Var);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ boolean a(f1 f1Var, String str) {
        if (super.a(f1Var, str)) {
            return true;
        }
        new e0.a().a("Unable to communicate with controller, disabling AdColony.").a(e0.h);
        AdColony.disable();
        return true;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ String c(f1 f1Var) {
        if (H) {
            return "android_asset/ADCController.js";
        }
        return super.c(f1Var);
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
}
