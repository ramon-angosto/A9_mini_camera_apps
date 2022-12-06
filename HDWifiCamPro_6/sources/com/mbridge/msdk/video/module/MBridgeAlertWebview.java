package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.download.h;

public class MBridgeAlertWebview extends MBridgeH5EndCardView {
    /* access modifiers changed from: private */
    public String x;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        if (TextUtils.isEmpty(this.u)) {
            return "";
        }
        b.a().a(a.e().h(), this.u, false);
        this.x = c.a;
        return !TextUtils.isEmpty(this.x) ? g.a().b(this.x) : "";
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String a = a();
        if (!this.f || this.b == null || TextUtils.isEmpty(a)) {
            this.e.a(101, "");
            return;
        }
        BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.b);
        mBDownloadListener.setTitle(this.b.getAppName());
        this.p.setDownloadListener(mBDownloadListener);
        this.p.setCampaignId(this.b.getId());
        setCloseVisible(8);
        this.p.setApiManagerJSFactory(bVar);
        this.p.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                q.d("MBridgeAlertWebview", "finish+" + str);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView, "onSignalCommunication", "");
            }

            public final void a(WebView webView, int i, String str, String str2) {
                super.a(webView, i, str, str2);
                q.d("MBridgeAlertWebview", "onReceivedError");
                if (!MBridgeAlertWebview.this.t) {
                    q.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                    d.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.b, MBridgeAlertWebview.this.x, MBridgeAlertWebview.this.u, 2, str);
                    MBridgeAlertWebview.this.t = true;
                }
            }

            public final void a(WebView webView, int i) {
                String str;
                super.a(webView, i);
                q.d("MBridgeAlertWebview", "readyState  :  " + i);
                if (!MBridgeAlertWebview.this.t) {
                    MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                    boolean z = true;
                    if (i != 1) {
                        z = false;
                    }
                    mBridgeAlertWebview.s = z;
                    if (MBridgeAlertWebview.this.s) {
                        str = "readyState state is " + i;
                    } else {
                        str = "";
                    }
                    d.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.b, MBridgeAlertWebview.this.x, MBridgeAlertWebview.this.u, i, str);
                }
            }
        });
        setHtmlSource(h.a().b(a));
        this.s = false;
        if (TextUtils.isEmpty(this.r)) {
            q.a(MBridgeBaseView.TAG, "load url:" + a);
            this.p.loadUrl(a);
        } else {
            q.a(MBridgeBaseView.TAG, "load html...");
            this.p.loadDataWithBaseURL(a, this.r, "text/html", "UTF-8", (String) null);
        }
        this.p.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    public void webviewshow() {
        if (this.n != null) {
            this.n.setBackgroundColor(0);
        }
        super.webviewshow();
        d.a(this.a, this.b, this.x, this.u, 2);
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }
}
