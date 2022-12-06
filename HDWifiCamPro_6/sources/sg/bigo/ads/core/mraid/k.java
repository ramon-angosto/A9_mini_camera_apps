package sg.bigo.ads.core.mraid;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.util.Locale;
import sg.bigo.ads.core.h.d;

public class k extends d {
    private static final String a = ("javascript:" + f.a);

    public void a(RenderProcessGoneDetail renderProcessGoneDetail) {
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return "mraid.js".equals(Uri.parse(str.toLowerCase(Locale.US)).getLastPathSegment()) ? new WebResourceResponse("text/javascript", "UTF-8", new ByteArrayInputStream(a.getBytes())) : super.shouldInterceptRequest(webView, str);
    }
}
