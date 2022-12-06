package com.mbridge.msdk.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.c.c;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;

/* compiled from: NativeAdvancedWebViewClient */
public final class a extends b {
    String a;
    com.mbridge.msdk.advanced.c.a b;
    private final String c = "NativeAdvancedWebViewClient";
    private c d;

    public a(String str, com.mbridge.msdk.advanced.c.a aVar, c cVar) {
        this.a = str;
        this.b = aVar;
        this.d = cVar;
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
            q.a("NativeAdvancedWebViewClient", "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            q.d("NativeAdvancedWebViewClient", "Use html to open url.");
            if (this.b == null) {
                return true;
            }
            this.b.a(false, str);
            return true;
        } catch (Throwable th) {
            q.a("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webView, Build.VERSION.SDK_INT >= 21 ? webResourceRequest.getUrl().toString() : "");
    }

    private WebResourceResponse a(WebView webView, String str) {
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && "mb-h5".equals(parse.getScheme())) {
            z = true;
        }
        if (!z || this.d == null) {
            return null;
        }
        String d2 = this.d.d(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
        try {
            if (TextUtils.isEmpty(d2)) {
                return null;
            }
            q.a("webviewclient", "relace url" + d2);
            if (d2.contains("127.0.0.1") || d2.startsWith("http")) {
                return null;
            }
            return new WebResourceResponse(MimeTypes.VIDEO_MP4, "utf-8", new FileInputStream(d2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a() {
        if (this.d != null) {
            this.d = null;
        }
    }
}
