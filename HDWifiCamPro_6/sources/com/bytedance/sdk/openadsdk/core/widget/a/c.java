package com.bytedance.sdk.openadsdk.core.widget.a;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.l.j;

/* compiled from: TTWebChromeClient */
public class c extends WebChromeClient {
    private static final String a = WebChromeClient.class.getSimpleName();
    private final u b;
    private h c;

    public c(u uVar, h hVar) {
        this.b = uVar;
        this.c = hVar;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (!"bytedance".equals(parse.getScheme().toLowerCase())) {
                return false;
            }
            j.a(parse, this.b);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(webView, i);
        }
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}
