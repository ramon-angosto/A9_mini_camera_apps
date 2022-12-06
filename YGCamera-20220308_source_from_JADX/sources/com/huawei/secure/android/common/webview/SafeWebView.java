package com.huawei.secure.android.common.webview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import java.util.Arrays;
import java.util.Map;

public class SafeWebView extends WebView {
    private static final String TAG = "SafeWebView";

    /* renamed from: I */
    private String f1289I;

    /* renamed from: J */
    private String[] f1290J;

    /* renamed from: K */
    private String[] f1291K;

    /* renamed from: L */
    private String[] f1292L;

    /* renamed from: M */
    private WebViewLoadCallBack f1293M;

    public SafeWebView(Context context) {
        super(context);
        m1664h();
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1664h();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1664h();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1664h();
    }

    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f1290J;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.f1290J = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistWithPath() {
        String[] strArr = this.f1292L;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistWithPath(String[] strArr) {
        this.f1292L = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f1291K;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        this.f1291K = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String getDefaultErrorPage() {
        return this.f1289I;
    }

    public void setDefaultErrorPage(String str) {
        this.f1289I = str;
    }

    public void loadUrl(String str) {
        if (isHttpUrl(str)) {
            Log.e(TAG, "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f1289I)) {
                super.loadUrl(this.f1289I);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(TAG, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str);
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (isHttpUrl(str)) {
            Log.e(TAG, "postUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f1289I)) {
                super.postUrl(this.f1289I, bArr);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(TAG, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.postUrl(str, bArr);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (isHttpUrl(str)) {
            Log.e(TAG, "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.f1289I)) {
                super.loadUrl(this.f1289I, map);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(TAG, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str, map);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isHttpUrl(str)) {
            Log.e(TAG, "loadDataWithBaseURL: http url , not safe");
            if (!TextUtils.isEmpty(this.f1289I)) {
                super.loadDataWithBaseURL(this.f1289I, str2, str3, str4, str5);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e(TAG, "WebViewLoadCallBack");
                getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    private boolean isHttpUrl(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new C0960c(webViewClient, true));
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z) {
        super.setWebViewClient(new C0960c(webViewClient, z));
    }

    /* renamed from: h */
    private void m1664h() {
        SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient((WebViewClient) null);
    }

    public boolean isWhiteListUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.m1614e(TAG, "url is null");
            return false;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return true;
        } else {
            String[] whitelistWithPath = getWhitelistWithPath();
            String[] whitelistNotMathcSubDomain = getWhitelistNotMathcSubDomain();
            String[] whitelist = getWhitelist();
            if (whitelistWithPath != null && whitelistWithPath.length != 0) {
                return UriUtil.isUrlHostAndPathInWhitelist(str, whitelistWithPath);
            }
            if (whitelistNotMathcSubDomain == null || whitelistNotMathcSubDomain.length == 0) {
                return UriUtil.isUrlHostInWhitelist(str, whitelist);
            }
            return UriUtil.isUrlHostSameWhitelist(str, whitelistNotMathcSubDomain);
        }
    }

    public final void onCheckError(WebView webView, String str) {
        LogsUtil.m1615e(TAG, "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e(TAG, "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack().onCheckError(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    /* access modifiers changed from: protected */
    public final void showNoticeWhenSSLErrorOccurred(String str, String str2, String str3, String str4, SslErrorHandler sslErrorHandler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        C0959b bVar = new C0959b(sslErrorHandler);
        C0958a aVar = new C0958a(sslErrorHandler);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, bVar);
        builder.setNegativeButton(str4, aVar);
        builder.create().show();
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f1293M;
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f1293M = webViewLoadCallBack;
    }

    /* renamed from: com.huawei.secure.android.common.webview.SafeWebView$b */
    private static class C0959b implements DialogInterface.OnClickListener {

        /* renamed from: N */
        private final SslErrorHandler f1295N;

        C0959b(SslErrorHandler sslErrorHandler) {
            this.f1295N = sslErrorHandler;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1295N.proceed();
        }
    }

    /* renamed from: com.huawei.secure.android.common.webview.SafeWebView$a */
    private static class C0958a implements DialogInterface.OnClickListener {

        /* renamed from: N */
        private final SslErrorHandler f1294N;

        C0958a(SslErrorHandler sslErrorHandler) {
            this.f1294N = sslErrorHandler;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f1294N.cancel();
        }
    }

    /* renamed from: com.huawei.secure.android.common.webview.SafeWebView$c */
    private final class C0960c extends WebViewClient {

        /* renamed from: O */
        private WebViewClient f1296O;

        /* renamed from: P */
        private boolean f1297P;

        private C0960c(WebViewClient webViewClient, boolean z) {
            this.f1296O = webViewClient;
            this.f1297P = z;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null && !this.f1297P) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (!SafeWebView.this.isWhiteListUrl(str)) {
                SafeWebView.this.onCheckError(webView, str);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            }
        }

        public void onScaleChanged(WebView webView, float f, float f2) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f1296O;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }
}
