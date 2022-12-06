package com.bytedance.sdk.component.adexpress.d;

import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.a.z;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.a.a.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WebViewPool */
public class e {
    private static final byte[] d = new byte[0];
    private static int e = 10;
    private static volatile e g;
    private List<SSWebView> a = new ArrayList();
    private Map<Integer, c> b = new HashMap();
    private Map<Integer, d> c = new HashMap();
    private final AtomicBoolean f = new AtomicBoolean(false);

    private e() {
        c c2 = a.a().c();
        if (c2 != null) {
            e = c2.j();
        }
    }

    public static e a() {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e();
                }
            }
        }
        return g;
    }

    public SSWebView b() {
        SSWebView remove;
        if (d() <= 0 || (remove = this.a.remove(0)) == null) {
            return null;
        }
        l.b("WebViewPool", "get WebView from pool; current available count: " + d());
        return remove;
    }

    public void a(SSWebView sSWebView) {
        if (sSWebView != null) {
            e(sSWebView);
            sSWebView.b("SDK_INJECT_GLOBAL");
            d(sSWebView);
            b(sSWebView);
        }
    }

    public void b(SSWebView sSWebView) {
        if (sSWebView != null) {
            if (this.a.size() >= e) {
                l.b("WebViewPool", "WebView pool is full，destroy webview");
                sSWebView.l();
            } else if (!this.a.contains(sSWebView)) {
                this.a.add(sSWebView);
                l.b("WebViewPool", "recycle WebView，current available count: " + d());
            }
        }
    }

    public boolean c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        l.b("WebViewPool", "WebView render fail and abandon");
        sSWebView.l();
        return true;
    }

    public void c() {
        for (SSWebView next : this.a) {
            if (next != null) {
                next.l();
            }
        }
        this.a.clear();
    }

    public int d() {
        return this.a.size();
    }

    public int e() {
        return this.a.size();
    }

    private void e(SSWebView sSWebView) {
        sSWebView.removeAllViews();
        sSWebView.c();
        sSWebView.setWebChromeClient((WebChromeClient) null);
        sSWebView.setWebViewClient((WebViewClient) null);
        sSWebView.setDownloadListener((DownloadListener) null);
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setAppCacheEnabled(false);
        sSWebView.setSupportZoom(false);
        sSWebView.setUseWideViewPort(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setBuiltInZoomControls(false);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.setLoadWithOverviewMode(false);
        sSWebView.setUserAgentString("android_client");
        sSWebView.setDefaultTextEncodingName("UTF-8");
        sSWebView.setDefaultFontSize(16);
    }

    public void a(SSWebView sSWebView, b bVar) {
        if (sSWebView != null && bVar != null) {
            c cVar = this.b.get(Integer.valueOf(sSWebView.hashCode()));
            if (cVar != null) {
                cVar.a(bVar);
            } else {
                cVar = new c(bVar);
                this.b.put(Integer.valueOf(sSWebView.hashCode()), cVar);
            }
            sSWebView.a((Object) cVar, "SDK_INJECT_GLOBAL");
        }
    }

    public void d(SSWebView sSWebView) {
        if (sSWebView != null) {
            c cVar = this.b.get(Integer.valueOf(sSWebView.hashCode()));
            if (cVar != null) {
                cVar.a((b) null);
            }
            sSWebView.b("SDK_INJECT_GLOBAL");
        }
    }

    public void a(WebView webView, z zVar, String str) {
        if (webView != null && zVar != null && !TextUtils.isEmpty(str)) {
            d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
            if (dVar != null) {
                dVar.a(zVar);
            } else {
                dVar = new d(zVar);
                this.c.put(Integer.valueOf(webView.hashCode()), dVar);
            }
            webView.addJavascriptInterface(dVar, str);
        }
    }

    public void a(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            d dVar = this.c.get(Integer.valueOf(webView.hashCode()));
            if (dVar != null) {
                dVar.a((z) null);
            }
            webView.removeJavascriptInterface(str);
        }
    }
}
