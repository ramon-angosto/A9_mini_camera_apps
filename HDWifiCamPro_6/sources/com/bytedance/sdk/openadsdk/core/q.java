package com.bytedance.sdk.openadsdk.core;

import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;

/* compiled from: SSWebSettings */
public class q {
    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                l.d(th.toString());
            }
        }
    }
}
