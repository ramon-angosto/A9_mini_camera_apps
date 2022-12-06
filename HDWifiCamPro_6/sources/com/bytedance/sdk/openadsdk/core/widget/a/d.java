package com.bytedance.sdk.openadsdk.core.widget.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.l.j;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTWebViewClient */
public class d extends SSWebView.a {
    private static final HashSet<String> i = new HashSet<>();
    private boolean a = false;
    private AtomicBoolean b = new AtomicBoolean(false);
    protected final u c;
    protected final Context d;
    protected final String e;
    protected h f;
    protected boolean g = true;
    protected boolean h = true;

    public d(Context context, u uVar, String str, h hVar, boolean z) {
        this.d = context;
        this.c = uVar;
        this.e = str;
        this.f = hVar;
        this.a = z;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        l.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                j.a(parse, this.c);
                return true;
            } else if (a(str)) {
                return true;
            } else {
                if (!o.a(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(268435456);
                    this.d.startActivity(intent);
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        } catch (Throwable th) {
            l.b("WebChromeClient", "shouldOverrideUrlLoading", th);
            u uVar = this.c;
            if (uVar != null && uVar.d()) {
                return true;
            }
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (l.a()) {
            l.a("WebChromeClient", "onPageFinished " + str);
        }
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(webView, str, this.a);
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(webView, str, bitmap);
        }
        if (this.h) {
            b.a(this.d).a(Build.VERSION.SDK_INT >= 19).b(webView.getSettings().getBuiltInZoomControls()).a(webView);
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        h hVar = this.f;
        if (hVar != null) {
            hVar.a(webView, i2, str, str2, b(str2));
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.f != null && webResourceError != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.f.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.f != null && webResourceResponse != null) {
            Uri url = webResourceRequest.getUrl();
            String str = "";
            String uri = url != null ? url.toString() : str;
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders.containsKey("accept")) {
                str = requestHeaders.get("accept");
            }
            this.f.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.f != null) {
            int i2 = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i2 = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str3 = str2;
            this.f.a(webView, i2, str, str3, b(str3));
        }
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if ("play.google.com".equals(parse.getHost())) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.setPackage("com.android.vending");
                this.d.startActivity(intent);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static {
        i.add("png");
        i.add("ico");
        i.add("jpg");
        i.add("gif");
        i.add("svg");
        i.add("jpeg");
    }

    protected static String b(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !i.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + substring;
    }
}
