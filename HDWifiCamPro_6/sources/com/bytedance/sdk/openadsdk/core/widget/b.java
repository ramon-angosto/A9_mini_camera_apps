package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: PrivacyProtectDialog */
public class b extends Dialog {
    /* access modifiers changed from: private */
    public Context a;
    private String b;
    private String c;
    /* access modifiers changed from: private */
    public c d;
    /* access modifiers changed from: private */
    public C0051b e;
    /* access modifiers changed from: private */
    public RelativeLayout f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.b$b  reason: collision with other inner class name */
    /* compiled from: PrivacyProtectDialog */
    public interface C0051b {
        void a();
    }

    /* compiled from: PrivacyProtectDialog */
    public interface c {
        void a();
    }

    public b(Context context) {
        super(context, t.g(context, "tt_privacy_dialogTheme"));
        this.a = context;
    }

    public b a(String str, c cVar) {
        this.b = str;
        this.d = cVar;
        return this;
    }

    public b a(String str, C0051b bVar) {
        this.c = str;
        this.e = bVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_privacy_dialog"), (ViewGroup) null);
        setContentView(inflate);
        final TTCornersWebView tTCornersWebView = (TTCornersWebView) inflate.findViewById(t.e(this.a, "tt_privacy_webview"));
        Button button = (Button) inflate.findViewById(t.e(this.a, "tt_privacy_accept_btn"));
        TextView textView = (TextView) inflate.findViewById(t.e(this.a, "tt_privacy_reject_btn"));
        this.f = (RelativeLayout) inflate.findViewById(t.e(this.a, "tt_privacy_back_layout"));
        z.a((View) this.f, 8);
        textView.getPaint().setFlags(8);
        a(tTCornersWebView);
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
            button.setText(this.b);
            textView.setText(this.c);
        }
        button.setOnClickListener(new a());
        textView.setOnClickListener(new a());
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTCornersWebView tTCornersWebView = tTCornersWebView;
                if (tTCornersWebView != null && tTCornersWebView.canGoBack()) {
                    tTCornersWebView.goBack();
                    if (!tTCornersWebView.canGoBack()) {
                        z.a((View) b.this.f, 8);
                    }
                }
            }
        });
    }

    private void a(final TTCornersWebView tTCornersWebView) {
        String C = m.d().C();
        if (C != null) {
            try {
                tTCornersWebView.getSettings().setJavaScriptEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                tTCornersWebView.getSettings().setMixedContentMode(0);
            }
            try {
                WebSettings settings = tTCornersWebView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
                settings.setLoadWithOverviewMode(true);
                settings.setUseWideViewPort(true);
                settings.setDomStorageEnabled(true);
                settings.setAllowFileAccess(false);
                settings.setBlockNetworkImage(false);
                settings.setSavePassword(false);
                tTCornersWebView.setLayerType(1, (Paint) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            q.a(tTCornersWebView);
            tTCornersWebView.setWebViewClient(new SSWebView.a() {
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (webView == null || webResourceRequest == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        webView.loadUrl(webResourceRequest.getUrl().toString());
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.toString());
                    return true;
                }

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    TTCornersWebView tTCornersWebView = tTCornersWebView;
                    if (tTCornersWebView != null && tTCornersWebView.canGoBack()) {
                        z.a((View) b.this.f, 0);
                    }
                }
            });
            tTCornersWebView.loadUrl(C);
        }
    }

    private void b() {
        WindowManager.LayoutParams attributes;
        setCancelable(false);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.dimAmount = 0.5f;
            attributes.width = (int) (((double) this.a.getResources().getDisplayMetrics().widthPixels) * 0.8d);
            window.setAttributes(attributes);
        }
    }

    /* compiled from: PrivacyProtectDialog */
    private class a implements View.OnClickListener {
        private a() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == t.e(b.this.a, "tt_privacy_accept_btn")) {
                if (b.this.d != null) {
                    b.this.d.a();
                }
                b.this.dismiss();
            } else if (id == t.e(b.this.a, "tt_privacy_reject_btn")) {
                if (b.this.e != null) {
                    b.this.e.a();
                }
                b.this.dismiss();
            }
        }
    }
}
