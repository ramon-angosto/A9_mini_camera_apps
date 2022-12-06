package com.ironsource.sdk.b;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.sdk.c.e;
import com.ironsource.sdk.utils.Logger;

public class c extends WebViewClient {
    private static final String b = c.class.getSimpleName();
    private final e.a a;

    public c(e.a aVar) {
        this.a = aVar;
    }

    private static String a(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " Status code: " + str2;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            this.a.a(a("onReceivedError", String.valueOf(i)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                str = String.valueOf(webResourceResponse.getStatusCode());
            }
            this.a.a(a("onReceivedHttpError", str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            String str = b;
            Logger.e(str, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            this.a.b(renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
