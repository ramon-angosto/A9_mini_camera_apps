package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CallMraidJS */
public final class a {

    /* renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a  reason: collision with other inner class name */
    /* compiled from: CallMraidJS */
    private static class C0071a {
        /* access modifiers changed from: private */
        public static final a a = new a();
    }

    public static a a() {
        return C0071a.a;
    }

    public final void a(WebView webView) {
        c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public final void a(WebView webView, Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", new Object[]{jSONObject.toString()}));
        }
    }

    public final void a(WebView webView, String str, String str2) {
        c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", new Object[]{str2, str}));
    }

    public final void a(WebView webView, float f, float f2) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public final void a(WebView webView, double d) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", new Object[]{Double.valueOf(d)}));
    }

    public final void b(WebView webView, float f, float f2) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public final void c(WebView webView, float f, float f2) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public final void a(WebView webView, float f, float f2, float f3, float f4) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}));
    }

    public final void b(WebView webView, float f, float f2, float f3, float f4) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}));
    }

    public final void a(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", new Object[]{str}));
    }

    public final void b(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", new Object[]{str}));
    }

    private void c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
