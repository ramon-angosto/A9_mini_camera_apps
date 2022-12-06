package com.bytedance.sdk.openadsdk.core.widget.a;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

/* compiled from: SSWebSettings */
public class b {
    private WeakReference<Context> a;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;

    public static b a(Context context) {
        return new b(context);
    }

    private b(Context context) {
        this.a = new WeakReference<>(context);
    }

    public b a(boolean z) {
        this.h = z;
        return this;
    }

    public b b(boolean z) {
        this.c = z;
        return this;
    }

    public void a(WebView webView) {
        if (webView != null && this.a.get() != null) {
            b(webView);
            WebSettings settings = webView.getSettings();
            a(settings);
            if (settings != null) {
                try {
                    settings.setJavaScriptEnabled(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    if (this.c) {
                        settings.setSupportZoom(true);
                        settings.setBuiltInZoomControls(true);
                    } else {
                        settings.setSupportZoom(false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(this.d);
                settings.setDomStorageEnabled(this.e);
                settings.setAllowFileAccess(this.f);
                settings.setBlockNetworkImage(true ^ this.g);
                settings.setSavePassword(false);
                try {
                    if (Build.VERSION.SDK_INT >= 11 && !this.h) {
                        webView.setLayerType(0, (Paint) null);
                    } else if (Build.VERSION.SDK_INT >= 16 && this.h) {
                        webView.setLayerType(2, (Paint) null);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            l.d(th.toString());
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            l.d(th.toString());
        }
    }
}
