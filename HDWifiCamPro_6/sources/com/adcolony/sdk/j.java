package com.adcolony.sdk;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adcolony.sdk.c1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class j extends c1 {
    public static final f F = new f((DefaultConstructorMarker) null);

    protected class a extends c1.c {
        public a() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class b extends c1.d {
        public b() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class c extends c1.e {
        public c() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class d extends c1.f {
        public d() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    protected class e extends c1.g {
        public e() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            new g().a();
        }
    }

    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final j a(Context context, h0 h0Var) {
            j jVar;
            int e = a.b().r().e();
            if (Intrinsics.areEqual((Object) c0.h(h0Var.a(), "type"), (Object) "aurora")) {
                jVar = new e(context, e, h0Var);
            } else {
                jVar = new j(context, e, h0Var);
            }
            jVar.i();
            return jVar;
        }
    }

    private final class g {
        public g() {
        }

        public final void a() {
            h0 a2;
            if (!(j.this instanceof l)) {
                f1 b = c0.b();
                j jVar = j.this;
                c0.b(b, "success", true);
                c0.b(b, "id", jVar.getAdc3ModuleId());
                h0 message = j.this.getMessage();
                if (message != null && (a2 = message.a(b)) != null) {
                    a2.c();
                }
            }
        }
    }

    protected j(Context context, int i, h0 h0Var) {
        super(context, i, h0Var);
    }

    @JvmStatic
    public static final j a(Context context, h0 h0Var) {
        return F.a(context, h0Var);
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
    public /* synthetic */ void i() {
        h0 message = getMessage();
        f1 a2 = message == null ? null : message.a();
        if (a2 == null) {
            a2 = c0.b();
        }
        setMraidFilepath(c0.h(a2, "mraid_filepath"));
        setBaseUrl(c0.h(a2, "base_url"));
        setIab(c0.f(a2, "iab"));
        setInfo(c0.f(a2, "info"));
        setAdSessionId(c0.h(a2, "ad_session_id"));
        setMUrl(d(a2));
        super.i();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setBounds(h0 h0Var) {
        super.setBounds(h0Var);
        f1 b2 = c0.b();
        c0.b(b2, "success", true);
        c0.b(b2, "id", getAdc3ModuleId());
        h0Var.a(b2).c();
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ void setVisible(h0 h0Var) {
        super.setVisible(h0Var);
        f1 b2 = c0.b();
        c0.b(b2, "success", true);
        c0.b(b2, "id", getAdc3ModuleId());
        h0Var.a(b2).c();
    }
}
