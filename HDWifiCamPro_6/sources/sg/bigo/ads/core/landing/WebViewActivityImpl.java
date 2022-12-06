package sg.bigo.ads.core.landing;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import sg.bigo.ads.R;
import sg.bigo.ads.api.core.BaseAdActivityImpl;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.h.c;
import sg.bigo.ads.core.h.d;

public class WebViewActivityImpl extends BaseAdActivityImpl implements View.OnClickListener {
    protected TextView a;
    protected ProgressBar b;
    protected WebView c;
    protected String d;
    protected long e = -1;
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public boolean g = false;
    /* access modifiers changed from: private */
    public FileChooser h;

    class CustomWebChromeClient extends c {
        private CustomWebChromeClient() {
        }

        /* synthetic */ CustomWebChromeClient(WebViewActivityImpl webViewActivityImpl, byte b) {
            this();
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (WebViewActivityImpl.this.b != null) {
                WebViewActivityImpl.this.b.setProgress(i);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebViewActivityImpl.this.c(str);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (WebViewActivityImpl.this.h == null) {
                WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
                FileChooser unused = webViewActivityImpl.h = new FileChooser(webViewActivityImpl.q);
            }
            FileChooser g = WebViewActivityImpl.this.h;
            sg.bigo.ads.common.k.a.a(0, 3, "FileChooser", "onShowFileChooser");
            if (g.c != null) {
                g.c.onReceiveValue((Object) null);
            }
            g.c = valueCallback;
            g.a(fileChooserParams.getAcceptTypes());
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (WebViewActivityImpl.this.h == null) {
                WebViewActivityImpl webViewActivityImpl = WebViewActivityImpl.this;
                FileChooser unused = webViewActivityImpl.h = new FileChooser(webViewActivityImpl.q);
            }
            WebViewActivityImpl.this.h.openFileChooser(valueCallback, str, str2);
        }
    }

    class a extends d {
        private a() {
        }

        /* synthetic */ a(WebViewActivityImpl webViewActivityImpl, byte b) {
            this();
        }

        private void a(WebView webView, String str) {
            onPageFinished(webView, str);
            WebViewActivityImpl.this.d(0);
        }

        private boolean a(WebView webView, String str, boolean z) {
            boolean z2;
            if (WebViewActivityImpl.this.f) {
                return true;
            }
            sg.bigo.ads.common.k.a.a(0, 3, "WebView", "shouldOverrideUrlLoading url= ".concat(String.valueOf(str)));
            if (a.a(str)) {
                boolean a2 = a(str);
                if (a2 && z) {
                    a(webView, str);
                }
                return a2;
            }
            if (str.startsWith("intent://")) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    Uri data = parseUri.getData();
                    if (data == null || !WebViewActivityImpl.this.a(data)) {
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent((ComponentName) null);
                        parseUri.setSelector((Intent) null);
                        if (WebViewActivityImpl.this.q.startActivityIfNeeded(parseUri, -1)) {
                            if (z) {
                                a(webView, str);
                            }
                            return true;
                        }
                        sg.bigo.ads.common.k.a.b("WebView", "queryIntentActivities: null");
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            if (a.a(stringExtra)) {
                                z2 = a(stringExtra);
                                if (z2 && z) {
                                    a(webView, stringExtra);
                                }
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                webView.loadUrl(stringExtra);
                            }
                            return true;
                        }
                    } else {
                        if (z) {
                            a(webView, str);
                        }
                        return true;
                    }
                } catch (Exception e) {
                    sg.bigo.ads.common.k.a.a(0, "WebView", "shouldOverrideUrlLoading: " + e.getMessage());
                }
            } else if (!URLUtil.isValidUrl(str)) {
                if (WebViewActivityImpl.this.d(str) && z) {
                    a(webView, str);
                }
                return true;
            }
            String b = WebViewActivityImpl.this.b(str);
            if (str.equals(b)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.loadUrl(b);
            return true;
        }

        private boolean a(String str) {
            e eVar = new e();
            boolean a2 = a.a(Uri.parse(str), (Context) WebViewActivityImpl.this.q, eVar);
            WebViewActivityImpl.this.a(eVar);
            return a2;
        }

        public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD, 10105, "The render process was gone.");
            WebViewActivityImpl.this.d(0);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (WebViewActivityImpl.this.b != null) {
                WebViewActivityImpl.this.b.setAlpha(0.0f);
            }
            sg.bigo.ads.common.k.a.a(0, 3, "WebView", "onPageFinished  ".concat(String.valueOf(str)));
            WebViewActivityImpl.this.a(str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            boolean z = false;
            sg.bigo.ads.common.k.a.a(0, 3, "WebView", "onPageStarted ".concat(String.valueOf(str)));
            if (WebViewActivityImpl.this.b != null) {
                WebViewActivityImpl.this.b.animate().alpha(1.0f).setDuration(100).setListener((Animator.AnimatorListener) null);
                WebViewActivityImpl.this.b.setProgress(0);
            }
            if (WebViewActivityImpl.this.e < 0) {
                z = true;
                WebViewActivityImpl.this.e = SystemClock.elapsedRealtime();
            }
            WebViewActivityImpl.this.a(str, z);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            sg.bigo.ads.common.k.a.b("WebView", "onReceivedError: " + i + " " + str);
            WebViewActivityImpl.this.a(i, str, str2);
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(webView, str, !(WebViewActivityImpl.this.e >= 0 && WebViewActivityImpl.this.g));
        }
    }

    protected WebViewActivityImpl(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: private */
    public boolean a(Uri uri) {
        e eVar = new e();
        boolean a2 = a.a(uri, this.q, eVar, "");
        if ((eVar.b == 0 && eVar.c == 0) ? false : true) {
            a(eVar);
        }
        return a2;
    }

    /* access modifiers changed from: private */
    public void d(int i) {
        this.f = true;
        c(i);
        WebView webView = this.c;
        if (webView != null) {
            webView.stopLoading();
        }
        super.E();
    }

    /* access modifiers changed from: private */
    public boolean d(String str) {
        return a(Uri.parse(str));
    }

    private void f(int i) {
        if (this.c == null || !d()) {
            a(i);
        } else {
            this.c.goBack();
        }
    }

    @Deprecated
    public final void E() {
        a(0);
    }

    /* access modifiers changed from: protected */
    public WebView a() {
        return sg.bigo.ads.core.h.e.a(this.q);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        d(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r0 = r19.getDataString();
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r17, int r18, android.content.Intent r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r16
            sg.bigo.ads.core.landing.FileChooser r3 = r2.h
            if (r3 == 0) goto L_0x009c
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            r6 = 0
            r7 = -1
            r8 = 101(0x65, float:1.42E-43)
            r9 = 0
            if (r4 < r5) goto L_0x003e
            if (r1 != r7) goto L_0x0031
            if (r0 != r8) goto L_0x0031
            if (r19 == 0) goto L_0x0031
            android.net.Uri r0 = r19.getData()
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r19.getDataString()
            if (r0 == 0) goto L_0x0031
            r1 = 1
            android.net.Uri[] r1 = new android.net.Uri[r1]
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1[r6] = r0
            goto L_0x0032
        L_0x0031:
            r1 = r9
        L_0x0032:
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r3.c
            if (r0 == 0) goto L_0x003d
            android.webkit.ValueCallback<android.net.Uri[]> r0 = r3.c
            r0.onReceiveValue(r1)
            r3.c = r9
        L_0x003d:
            return
        L_0x003e:
            if (r0 != r8) goto L_0x0090
            if (r1 != r7) goto L_0x0090
            if (r19 != 0) goto L_0x0046
            r11 = r9
            goto L_0x004b
        L_0x0046:
            android.net.Uri r0 = r19.getData()
            r11 = r0
        L_0x004b:
            if (r11 == 0) goto L_0x0090
            java.lang.String r0 = r11.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x007c
            android.app.Activity r0 = r3.a
            android.content.ContentResolver r10 = r0.getContentResolver()
            java.lang.String r0 = "_data"
            java.lang.String[] r12 = new java.lang.String[]{r0}
            r13 = 0
            r14 = 0
            r15 = 0
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15)
            if (r0 == 0) goto L_0x007a
            r0.moveToFirst()
            java.lang.String r1 = r0.getString(r6)
            r0.close()
            r0 = r1
            goto L_0x0080
        L_0x007a:
            r0 = r9
            goto L_0x0080
        L_0x007c:
            java.lang.String r0 = r11.getPath()
        L_0x0080:
            boolean r1 = sg.bigo.ads.common.utils.o.b(r0)
            if (r1 != 0) goto L_0x0090
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            android.net.Uri r0 = android.net.Uri.fromFile(r1)
            goto L_0x0091
        L_0x0090:
            r0 = r9
        L_0x0091:
            android.webkit.ValueCallback<android.net.Uri> r1 = r3.b
            if (r1 == 0) goto L_0x009c
            android.webkit.ValueCallback<android.net.Uri> r1 = r3.b
            r1.onReceiveValue(r0)
            r3.b = r9
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.landing.WebViewActivityImpl.a(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
    }

    /* access modifiers changed from: protected */
    public void a(String str, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
    }

    public final void a(boolean z) {
    }

    /* access modifiers changed from: protected */
    public String b(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
        WebView webView = this.c;
        if (webView != null) {
            webView.loadUrl(this.d);
        }
    }

    /* access modifiers changed from: protected */
    public void c(int i) {
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        WebView webView = this.c;
        return webView != null && webView.canGoBack();
    }

    public void n() {
        WebView webView = this.c;
        if (webView != null) {
            webView.destroy();
            this.c = null;
        }
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            if (tag.equals(this.q.getString(R.string.bigo_ad_tag_close))) {
                a(3);
            } else if (tag.equals(this.q.getString(R.string.bigo_ad_tag_back))) {
                f(2);
            }
        }
    }

    public void p() {
        b(R.layout.bigo_ad_activity_webview);
        Intent intent = this.q.getIntent();
        if (intent == null) {
            d(0);
            return;
        }
        this.d = intent.getStringExtra("url");
        if (TextUtils.isEmpty(this.d)) {
            sg.bigo.ads.common.k.a.a(0, "WebView", "url is null.");
            d(0);
            return;
        }
        a(intent);
        try {
            this.b = (ProgressBar) e(R.id.webview_progress_bar);
            this.a = (TextView) e(R.id.webview_title);
            View e2 = e(R.id.webview_back);
            View e3 = e(R.id.webview_close);
            if (e2 != null) {
                e2.setOnClickListener(this);
            }
            if (e3 != null) {
                e3.setOnClickListener(this);
            }
            this.c = a();
            if (this.c != null) {
                this.c.setWebViewClient(new a(this, (byte) 0));
                this.c.setWebChromeClient(new CustomWebChromeClient(this, (byte) 0));
                s.a(this.c, (ViewGroup) e(R.id.webview_container), new ViewGroup.LayoutParams(-1, -1), -1);
                this.c.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 1) {
                            return false;
                        }
                        boolean unused = WebViewActivityImpl.this.g = true;
                        return false;
                    }
                });
            }
        } catch (RuntimeException e4) {
            e4.printStackTrace();
        }
        b();
        if (o.b(this.d) || d(this.d)) {
            d(0);
        } else {
            c();
        }
    }

    public final void t() {
        WebView webView = this.c;
        if (webView != null) {
            webView.onResume();
        }
    }

    public final void u() {
        WebView webView = this.c;
        if (webView != null) {
            webView.onResume();
        }
    }

    public final void v() {
        f(1);
    }
}
