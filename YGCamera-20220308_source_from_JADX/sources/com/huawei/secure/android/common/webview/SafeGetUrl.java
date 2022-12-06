package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.C0953b;
import com.huawei.secure.android.common.util.C0954c;
import java.util.concurrent.CountDownLatch;

public class SafeGetUrl {

    /* renamed from: D */
    private static final long f1284D = 200;
    private static final String TAG = "SafeGetUrl";

    /* renamed from: E */
    private String f1285E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public WebView f1286F;

    public SafeGetUrl() {
    }

    public SafeGetUrl(WebView webView) {
        this.f1286F = webView;
    }

    public String getUrlMethod() {
        if (this.f1286F == null) {
            return "";
        }
        if (C0953b.isMainThread()) {
            return this.f1286F.getUrl();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C0954c.m1662a(new Runnable() {
            public void run() {
                SafeGetUrl safeGetUrl = SafeGetUrl.this;
                safeGetUrl.setUrl(safeGetUrl.f1286F.getUrl());
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(TAG, "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.f1285E;
    }

    public void setWebView(WebView webView) {
        this.f1286F = webView;
    }

    public WebView getWebView() {
        return this.f1286F;
    }

    public void setUrl(String str) {
        this.f1285E = str;
    }
}
