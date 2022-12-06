package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.graphics.Paint;
import android.os.Build;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BrandBannerController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BrandBannerWebViewPool */
public class b {
    private static int b;
    private static volatile b c;
    private final List<BrandBannerController.BrandWebView> a = new ArrayList();

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public BrandBannerController.BrandWebView b() {
        BrandBannerController.BrandWebView remove;
        if (c() > 0 && (remove = this.a.remove(0)) != null) {
            return remove;
        }
        return null;
    }

    public void a(BrandBannerController.BrandWebView brandWebView) {
        if (brandWebView != null) {
            b(brandWebView);
        }
    }

    public void b(BrandBannerController.BrandWebView brandWebView) {
        if (brandWebView == null) {
            return;
        }
        if (this.a.size() >= b) {
            brandWebView.l();
        } else if (!this.a.contains(brandWebView)) {
            c(brandWebView);
            this.a.add(brandWebView);
        }
    }

    public int c() {
        return this.a.size();
    }

    public void c(BrandBannerController.BrandWebView brandWebView) {
        if (brandWebView != null && brandWebView.getWebView() != null) {
            if (brandWebView.getParent() != null) {
                ((ViewGroup) brandWebView.getParent()).removeView(brandWebView);
            }
            try {
                brandWebView.removeAllViews();
                brandWebView.c();
                brandWebView.setWebChromeClient((WebChromeClient) null);
                brandWebView.setWebViewClient((WebViewClient) null);
                brandWebView.setDownloadListener((DownloadListener) null);
                brandWebView.setDefaultTextEncodingName("UTF-8");
                brandWebView.setJavaScriptEnabled(true);
                brandWebView.setDomStorageEnabled(true);
                brandWebView.setAppCacheEnabled(true);
                brandWebView.setDomStorageEnabled(true);
                brandWebView.setDatabaseEnabled(true);
                brandWebView.setSupportZoom(false);
                brandWebView.getWebView().setLayerType(0, (Paint) null);
                brandWebView.setBackgroundColor(0);
                brandWebView.getWebView().setHorizontalScrollBarEnabled(false);
                brandWebView.getWebView().setHorizontalScrollbarOverlay(false);
                brandWebView.getWebView().setVerticalScrollBarEnabled(false);
                brandWebView.getWebView().setVerticalScrollbarOverlay(false);
                brandWebView.a(true);
                brandWebView.j();
                if (Build.VERSION.SDK_INT >= 21) {
                    brandWebView.setMixedContentMode(0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
