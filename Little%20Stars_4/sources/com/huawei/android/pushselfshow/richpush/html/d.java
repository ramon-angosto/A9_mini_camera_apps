package com.huawei.android.pushselfshow.richpush.html;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.huawei.android.pushagent.c.a.e;

class d extends WebChromeClient {
    final /* synthetic */ HtmlViewer a;

    d(HtmlViewer htmlViewer) {
        this.a = htmlViewer;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.a.e != null) {
            if (this.a.e.canGoBack()) {
                this.a.o.b(this.a.j);
            } else {
                this.a.o.a(this.a.j);
            }
            if (this.a.e.canGoForward()) {
                this.a.o.b(this.a.k);
            } else {
                this.a.o.a(this.a.k);
            }
        }
        if (i < 5) {
            i = 5;
        }
        this.a.setProgress(i);
        super.onProgressChanged(webView, i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        e.a("PushSelfShowLog", "onReceivedTitle:" + str);
        if (!TextUtils.isEmpty(str)) {
            this.a.n.setText(str);
        }
    }
}
