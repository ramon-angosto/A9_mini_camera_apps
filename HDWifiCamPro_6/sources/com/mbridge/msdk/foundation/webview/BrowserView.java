package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;

public class BrowserView extends LinearLayout {
    /* access modifiers changed from: private */
    public String a;
    /* access modifiers changed from: private */
    public ProgressBar b;
    /* access modifiers changed from: private */
    public WebView c;
    /* access modifiers changed from: private */
    public ToolBar d;
    /* access modifiers changed from: private */
    public a e;
    private CampaignEx f;

    public interface a {
        void a();

        void a(WebView webView, String str, Bitmap bitmap);

        boolean a(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f = campaignEx;
        init();
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setListener(a aVar) {
        this.e = aVar;
    }

    public void loadUrl(String str) {
        WebView webView = this.c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setWebView(WebView webView) {
        this.c = webView;
    }

    public void init() {
        WebChromeClient webChromeClient;
        setOrientation(1);
        setGravity(17);
        this.b = new ProgressBar(getContext());
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.c == null) {
                WebView webView = new WebView(getContext());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setCacheMode(-1);
                webView.setDownloadListener(new MBDownloadListener(this.f));
                webView.setWebViewClient(new WebViewClient() {
                    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        q.b("BrowserView", "开始! = " + str);
                        String unused = BrowserView.this.a = str;
                        if (BrowserView.this.e != null) {
                            BrowserView.this.e.a(webView, str, bitmap);
                        }
                        BrowserView.this.b.setVisible(true);
                        BrowserView.this.b.setProgressState(5);
                    }

                    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        q.b("BrowserView", "js大跳! = " + str);
                        BrowserView.this.d.getItem("backward").setEnabled(true);
                        BrowserView.this.d.getItem("forward").setEnabled(false);
                        if (BrowserView.this.e != null) {
                            BrowserView.this.e.a(webView, str);
                        }
                        return false;
                    }
                });
                if (m.g() <= 10) {
                    webChromeClient = new WebChromeClient() {
                        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                            return true;
                        }

                        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                            return true;
                        }

                        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                            return true;
                        }

                        public final void onProgressChanged(WebView webView, int i) {
                            if (i == 100) {
                                BrowserView.this.b.setProgressState(7);
                                new Handler().postDelayed(new Runnable() {
                                    public final void run() {
                                        BrowserView.this.b.setVisible(false);
                                    }
                                }, 200);
                            }
                        }
                    };
                } else {
                    webChromeClient = new WebChromeClient() {
                        public final void onProgressChanged(WebView webView, int i) {
                            if (i == 100) {
                                BrowserView.this.b.setProgressState(7);
                                new Handler().postDelayed(new Runnable() {
                                    public final void run() {
                                        BrowserView.this.b.setVisible(false);
                                    }
                                }, 200);
                            }
                        }
                    };
                }
                webView.setWebChromeClient(webChromeClient);
                this.c = webView;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.c.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            q.a("BrowserView", "webview is error", th);
        }
        this.d = new ToolBar(getContext());
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, u.b(getContext(), 40.0f)));
        this.d.setBackgroundColor(-1);
        addView(this.b);
        WebView webView2 = this.c;
        if (webView2 != null) {
            addView(webView2);
        }
        addView(this.d);
        this.b.initResource(true);
        this.d.getItem("backward").setEnabled(false);
        this.d.getItem("forward").setEnabled(false);
        this.d.setOnItemClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (BrowserView.this.c != null) {
                    BrowserView.this.c.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z = false;
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.d.getItem("forward").setEnabled(true);
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoBack()) {
                        BrowserView.this.c.goBack();
                    }
                    View item = BrowserView.this.d.getItem("backward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoBack()) {
                        z = true;
                    }
                    item.setEnabled(z);
                } else if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.d.getItem("backward").setEnabled(true);
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        BrowserView.this.c.goForward();
                    }
                    View item2 = BrowserView.this.d.getItem("forward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        z = true;
                    }
                    item2.setEnabled(z);
                } else if (TextUtils.equals(str, "refresh")) {
                    BrowserView.this.d.getItem("backward").setEnabled(BrowserView.this.c != null && BrowserView.this.c.canGoBack());
                    View item3 = BrowserView.this.d.getItem("forward");
                    if (BrowserView.this.c != null && BrowserView.this.c.canGoForward()) {
                        z = true;
                    }
                    item3.setEnabled(z);
                    if (BrowserView.this.c != null) {
                        BrowserView.this.c.loadUrl(BrowserView.this.a);
                    }
                } else if (TextUtils.equals(str, "exits") && BrowserView.this.e != null) {
                    BrowserView.this.e.a();
                }
            }
        });
    }

    public static final class MBDownloadListener implements DownloadListener {
        private CampaignEx campaignEx;
        private String title;

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public MBDownloadListener(CampaignEx campaignEx2) {
            this.campaignEx = campaignEx2;
        }

        public MBDownloadListener() {
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    public void destroy() {
        WebView webView = this.c;
        if (webView != null) {
            webView.stopLoading();
            this.c.setWebViewClient((WebViewClient) null);
            this.c.destroy();
            removeAllViews();
        }
    }
}
