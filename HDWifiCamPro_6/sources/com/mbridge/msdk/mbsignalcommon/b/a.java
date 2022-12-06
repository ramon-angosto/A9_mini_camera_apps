package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.b;

/* compiled from: DefaultRVWebViewListener */
public class a implements b {
    public void a(Object obj) {
        q.a("RVWindVaneWebView", "getEndScreenInfo");
    }

    public void a(WebView webView, String str, String str2, int i, int i2) {
        q.a("RVWindVaneWebView", "loadAds");
    }

    public void a(Object obj, String str) {
        q.a("RVWindVaneWebView", "operateComponent");
    }

    public final void a(WebView webView, String str, Bitmap bitmap) {
        q.a("RVWindVaneWebView", "onPageStarted");
    }

    public final boolean b(WebView webView, String str) {
        q.a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    public void a(WebView webView, int i, String str, String str2) {
        q.a("RVWindVaneWebView", "onReceivedError");
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        q.a("RVWindVaneWebView", "onReceivedSslError");
    }

    public void a(WebView webView, String str) {
        q.a("RVWindVaneWebView", "onPageFinished");
    }

    public final void b(WebView webView, int i) {
        q.a("RVWindVaneWebView", "onProgressChanged");
    }

    public void a(WebView webView, int i) {
        q.a("RVWindVaneWebView", "readyState");
    }

    public final void c(WebView webView, int i) {
        q.a("RVWindVaneWebView", "loadingResourceStatus");
    }
}
