package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.d;

/* compiled from: DefaultWebViewListener */
public class b implements d {
    public final void a(WebView webView, String str, Bitmap bitmap) {
        q.a("WindVaneWebView", "onPageStarted");
    }

    public final boolean b(WebView webView, String str) {
        q.a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    public void a(WebView webView, int i, String str, String str2) {
        q.a("WindVaneWebView", "onReceivedError");
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        q.a("WindVaneWebView", "onReceivedSslError");
    }

    public void a(WebView webView, String str) {
        q.a("WindVaneWebView", "onPageFinished");
    }

    public final void b(WebView webView, int i) {
        q.a("WindVaneWebView", "onProgressChanged");
    }

    public void a(WebView webView, int i) {
        q.a("WindVaneWebView", "readyState");
    }

    public void c(WebView webView, int i) {
        q.a("WindVaneWebView", "loadingResourceStatus");
    }
}
