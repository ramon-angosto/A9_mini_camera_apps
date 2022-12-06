package com.huawei.android.pushselfshow.richpush.html;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.android.pushselfshow.utils.d;
import java.io.File;

class e extends WebViewClient {
    final /* synthetic */ HtmlViewer a;

    e(HtmlViewer htmlViewer) {
        this.a = htmlViewer;
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        StringBuilder sb;
        super.onPageFinished(webView, str);
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "onPageFinished:" + str + ",title:" + webView.getTitle());
        String title = webView.getTitle();
        if (title != null && title.endsWith(".html")) {
            this.a.n.setText(this.a.d.getString(d.a(this.a.d, "hwpush_richmedia")));
        }
        try {
            if (this.a.e != null) {
                if (!str.equals(this.a.d.getFilesDir().getPath() + File.separator + "PushService" + File.separator + "richpush" + File.separator + "error.html")) {
                    if ("text/html_local".equals(this.a.g.E)) {
                        sb = new StringBuilder();
                        sb.append(("var newscript = document.createElement(\"script\");" + "newscript.src=\"" + this.a.prepareJS(str) + "\";") + "newscript.onload=function(){ try {onDeviceReady();}catch(err){}};");
                        sb.append("document.body.appendChild(newscript);");
                    } else {
                        sb = new StringBuilder();
                        sb.append(("var newscript = document.createElement(\"script\");" + "newscript.src=\"http://open.hicloud.com/android/push1.0.js\";") + "newscript.onload=function(){ try { onDeviceReady();}catch(err){}};");
                        sb.append("document.body.appendChild(newscript);");
                    }
                    String sb2 = sb.toString();
                    com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "load js " + sb2);
                    this.a.e.loadUrl("javascript:" + sb2);
                }
            }
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "onPageFinished load err " + e.toString(), (Throwable) e);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "onPageStarted:" + str);
        this.a.setProgress(5);
        this.a.n.setText(this.a.d.getString(d.a(this.a.d, "hwpush_richmedia")));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        com.huawei.android.pushagent.c.a.e.d("PushSelfShowLog", "onReceivedSslError");
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (!str.startsWith("mailto:") && !str.startsWith("tel:") && !str.startsWith("smsto:") && !str.startsWith("sms:")) {
                if (!str.startsWith("geo:")) {
                    return false;
                }
            }
            this.a.d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.a("PushSelfShowLog", "", (Throwable) e);
            return true;
        }
    }
}
