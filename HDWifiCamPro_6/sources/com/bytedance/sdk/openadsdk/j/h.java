package com.bytedance.sdk.openadsdk.j;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: PlayableWebSettings */
public class h {
    private static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            f.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            f.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.webkit.WebView r7) {
        /*
            java.lang.String r0 = "WebViewSettings"
            b(r7)
            android.webkit.WebSettings r1 = r7.getSettings()
            a((android.webkit.WebSettings) r1)
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            r2 = 1
            r1.setJavaScriptEnabled(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x001a
        L_0x0014:
            r3 = move-exception
            java.lang.String r4 = "setJavaScriptEnabled error"
            com.bytedance.sdk.openadsdk.j.f.a(r0, r4, r3)
        L_0x001a:
            r3 = 0
            r1.setSupportZoom(r3)     // Catch:{ all -> 0x001f }
            goto L_0x0025
        L_0x001f:
            r4 = move-exception
            java.lang.String r5 = "setSupportZoom error"
            com.bytedance.sdk.openadsdk.j.f.a(r0, r5, r4)
        L_0x0025:
            r1.setLoadWithOverviewMode(r2)
            r1.setUseWideViewPort(r2)
            r1.setDomStorageEnabled(r2)
            r1.setAllowFileAccess(r3)
            r1.setBlockNetworkImage(r3)
            r1.setDisplayZoomControls(r3)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 16
            if (r4 < r5) goto L_0x0043
            r1.setAllowFileAccessFromFileURLs(r3)
            r1.setAllowUniversalAccessFromFileURLs(r3)
        L_0x0043:
            r1.setSavePassword(r3)
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r1 < r4) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r2 = r3
        L_0x004e:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0066 }
            r4 = 11
            r6 = 0
            if (r1 < r4) goto L_0x005b
            if (r2 != 0) goto L_0x005b
            r7.setLayerType(r3, r6)     // Catch:{ all -> 0x0066 }
            goto L_0x006c
        L_0x005b:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0066 }
            if (r1 < r5) goto L_0x006c
            if (r2 == 0) goto L_0x006c
            r1 = 2
            r7.setLayerType(r1, r6)     // Catch:{ all -> 0x0066 }
            goto L_0x006c
        L_0x0066:
            r1 = move-exception
            java.lang.String r2 = "setLayerType error"
            com.bytedance.sdk.openadsdk.j.f.a(r0, r2, r1)
        L_0x006c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x0079
            android.webkit.WebSettings r7 = r7.getSettings()
            r7.setMixedContentMode(r3)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.j.h.a(android.webkit.WebView):void");
    }
}
