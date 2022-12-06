package com.iab.omid.library.bigosg.g;

import android.webkit.WebView;

public final class b extends a {
    public b(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
