package com.bytedance.sdk.openadsdk.l;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.u;

/* compiled from: JsBridgeUtils */
public class j {
    public static void a(Uri uri, u uVar) {
        if (uVar != null && uVar.a(uri)) {
            try {
                uVar.b(uri);
            } catch (Exception e) {
                l.d("WebView", "TTAndroidObj handleUri exception: " + e);
            }
        }
    }

    public static String a(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news" + " open_news_u_s/" + i;
    }
}
