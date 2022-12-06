package sg.bigo.ads.core.h;

import android.app.Activity;
import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class c extends WebChromeClient {
    private static boolean a(WebView webView, JsResult jsResult) {
        if (webView.getContext() instanceof Activity) {
            return false;
        }
        jsResult.confirm();
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(WebView webView, String str, String str2) {
    }

    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : defaultVideoPoster;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(webView, jsResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(webView, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(webView, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(webView, jsPromptResult);
    }
}
