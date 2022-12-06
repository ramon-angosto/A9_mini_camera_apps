package sg.bigo.ads.core.h;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class d extends WebViewClient {
    public abstract void a(RenderProcessGoneDetail renderProcessGoneDetail);

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView instanceof b) {
            b bVar = (b) webView;
            if (!bVar.b) {
                bVar.b = true;
            }
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if ((webView instanceof b) && Build.VERSION.SDK_INT >= 23) {
            ((b) webView).a(2, webResourceRequest, webResourceError == null ? -1 : webResourceError.getErrorCode(), webResourceError == null ? null : webResourceError.getDescription());
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if ((webView instanceof b) && Build.VERSION.SDK_INT >= 21) {
            ((b) webView).a(1, webResourceRequest, webResourceResponse == null ? -1 : webResourceResponse.getStatusCode(), webResourceResponse == null ? null : webResourceResponse.getReasonPhrase());
        }
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        a(renderProcessGoneDetail);
        return true;
    }
}
