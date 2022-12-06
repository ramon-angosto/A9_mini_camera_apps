package com.mbridge.msdk.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.base.b;
import java.util.List;

/* compiled from: BannerWebViewClient */
public final class a extends b {
    String a;
    List<CampaignEx> b;
    com.mbridge.msdk.mbbanner.common.b.a c;
    private final String d = "BannerWebViewClient";

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        this.a = str;
        this.b = list;
        this.c = aVar;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(com.mbridge.msdk.b.b.a.a().b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        String str = (String) obj;
                    }
                });
            }
        } catch (Throwable th) {
            q.a("BannerWebViewClient", "onPageStarted", th);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = null;
        try {
            if (this.b.size() > 1) {
                com.mbridge.msdk.foundation.controller.a.e().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                str2 = str;
            }
            if (this.c != null) {
                this.c.a(false, str2);
            }
            return true;
        } catch (Throwable th) {
            q.a("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
