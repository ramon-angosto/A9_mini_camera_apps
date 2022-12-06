package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: LoadUrlUtils */
public class k {
    private static final a a;

    /* compiled from: LoadUrlUtils */
    private static class a {
        private a() {
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                try {
                    webView.loadUrl(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: LoadUrlUtils */
    private static class b extends a {
        private b() {
            super();
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                boolean z = false;
                if (str != null && str.startsWith("javascript:")) {
                    try {
                        webView.evaluateJavascript(str, (ValueCallback) null);
                        z = true;
                    } catch (Throwable th) {
                        boolean z2 = th instanceof IllegalStateException;
                    }
                }
                if (!z) {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        a.a(webView, str);
    }
}
