package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.a.b.a;
import com.bytedance.sdk.component.adexpress.c.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.b;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.widget.a.d;
import java.io.InputStream;
import java.util.Iterator;

/* compiled from: ExpressClient */
public class f extends d {
    private n a;

    public f(Context context, u uVar, n nVar, h hVar) {
        super(context, uVar, nVar.Y(), hVar, false);
        this.a = nVar;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            l.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse a2 = a(webView, str);
            a(currentTimeMillis, System.currentTimeMillis(), str, a2 != null ? 1 : 2);
            if (a2 != null) {
                return a2;
            }
        } catch (Throwable th) {
            l.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onPageFinished(WebView webView, String str) {
        this.g = false;
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.h = false;
        super.onPageStarted(webView, str, bitmap);
    }

    private WebResourceResponse a(WebView webView, String str) {
        k kVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c.a a2 = c.a(str);
        if (a2 != c.a.IMAGE) {
            Iterator<k> it = this.a.P().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String a3 = next.a();
                    if (a3.startsWith("https")) {
                        a3 = a3.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(a3)) {
                        kVar = next;
                        break;
                    }
                }
            }
        }
        if (a2 == c.a.IMAGE || kVar != null) {
            return a(str, b.a(this.a, str));
        }
        return a.a(str, a2, "");
    }

    private WebResourceResponse a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream a2 = com.bytedance.sdk.openadsdk.e.a.a(str, str2);
            if (a2 != null) {
                return new WebResourceResponse(c.a.IMAGE.a(), "utf-8", a2);
            }
            return null;
        } catch (Throwable th) {
            l.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j, long j2, String str, int i) {
        if (this.f != null && this.f.b() != null) {
            c.a a2 = c.a(str);
            if (a2 == c.a.HTML) {
                this.f.b().a(str, j, j2, i);
            } else if (a2 == c.a.JS) {
                this.f.b().b(str, j, j2, i);
            }
        }
    }
}
