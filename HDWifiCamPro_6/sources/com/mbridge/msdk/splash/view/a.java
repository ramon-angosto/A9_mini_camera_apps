package com.mbridge.msdk.splash.view;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.base.b;

/* compiled from: SplashWebViewClient */
public final class a extends b {
    String a;
    com.mbridge.msdk.splash.d.a b;
    private final String c = "SplashWebViewClient";

    public a(String str, com.mbridge.msdk.splash.d.a aVar) {
        this.a = str;
        this.b = aVar;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(com.mbridge.msdk.b.b.a.a().b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        String str = (String) obj;
                    }
                });
            }
        } catch (Throwable th) {
            q.a("SplashWebViewClient", "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (this.b == null) {
                return true;
            }
            this.b.a(false, str);
            return true;
        } catch (Throwable th) {
            q.a("SplashWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
