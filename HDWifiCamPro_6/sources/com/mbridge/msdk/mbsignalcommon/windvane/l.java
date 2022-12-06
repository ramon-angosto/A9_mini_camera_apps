package com.mbridge.msdk.mbsignalcommon.windvane;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.mbsignalcommon.base.b;

/* compiled from: WindVaneWebViewClient */
public final class l extends b {
    public static boolean b = true;
    protected String a = null;
    private int c = 0;
    private d d;

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a = str;
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(webView, str, bitmap);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse a2 = a(str);
        if (a2 != null) {
            return a2;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private WebResourceResponse a(String str) {
        Bitmap a2;
        try {
            if (TextUtils.isEmpty(str) || !j.d(str) || (a2 = com.mbridge.msdk.foundation.same.c.b.a(a.e().g()).a(str)) == null || a2.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(j.e(str), "utf-8", com.mbridge.msdk.foundation.same.c.a.a(a2));
        } catch (Throwable unused) {
            return null;
        }
    }
}
