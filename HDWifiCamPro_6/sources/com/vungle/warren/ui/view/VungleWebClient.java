package com.vungle.warren.ui.view;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.omsdk.WebViewObserver;
import com.vungle.warren.ui.view.WebViewAPI;
import java.util.concurrent.ExecutorService;

public class VungleWebClient extends WebViewClient implements WebViewAPI {
    public static final String TAG = VungleWebClient.class.getSimpleName();
    /* access modifiers changed from: private */
    public WebViewAPI.MRAIDDelegate MRAIDDelegate;
    private Advertisement advertisement;
    private boolean collectConsent;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private ExecutorService offloadExecutor;
    private Placement placement;
    private boolean ready;
    private WebViewObserver webViewObserver;

    public VungleWebClient(Advertisement advertisement2, Placement placement2, ExecutorService executorService) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.offloadExecutor = executorService;
    }

    public void setConsentStatus(boolean z, String str, String str2, String str3, String str4) {
        this.collectConsent = z;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    public void setMRAIDDelegate(WebViewAPI.MRAIDDelegate mRAIDDelegate) {
        this.MRAIDDelegate = mRAIDDelegate;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = TAG;
        Log.d(str2, "MRAID Command " + str);
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() != null) {
            String scheme = parse.getScheme();
            if (scheme.equals(CampaignEx.JSON_KEY_MRAID)) {
                final String host = parse.getHost();
                if (host == null) {
                    return false;
                }
                if ("propertiesChangeCompleted".equals(host) && !this.ready) {
                    JsonObject createMRAIDArgs = this.advertisement.createMRAIDArgs();
                    runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyReadyEvent(" + createMRAIDArgs + ")");
                    this.ready = true;
                } else if (this.MRAIDDelegate != null) {
                    final JsonObject jsonObject = new JsonObject();
                    for (String next : parse.getQueryParameterNames()) {
                        jsonObject.addProperty(next, parse.getQueryParameter(next));
                    }
                    final Handler handler = new Handler();
                    final WebView webView2 = webView;
                    this.offloadExecutor.submit(new Runnable() {
                        public void run() {
                            if (VungleWebClient.this.MRAIDDelegate.processCommand(host, jsonObject)) {
                                handler.post(new Runnable() {
                                    public void run() {
                                        VungleWebClient.this.runJavascriptOnWebView(webView2, "window.vungle.mraidBridge.notifyCommandComplete()");
                                    }
                                });
                            }
                        }
                    });
                }
                return true;
            } else if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                String str3 = TAG;
                Log.d(str3, "Open URL" + str);
                if (this.MRAIDDelegate != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("url", str);
                    this.MRAIDDelegate.processCommand("openNonMraid", jsonObject2);
                }
                return true;
            }
        }
        return false;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        int adType = this.advertisement.getAdType();
        if (adType == 0) {
            runJavascriptOnWebView(webView, "function actionClicked(action){Android.performAction(action);};");
        } else if (adType == 1) {
            this.loadedWebView = webView;
            this.loadedWebView.setVisibility(0);
            notifyPropertiesChange(true);
        } else {
            throw new IllegalArgumentException("Unknown Client Type!");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
        }
        WebViewObserver webViewObserver2 = this.webViewObserver;
        if (webViewObserver2 != null) {
            webViewObserver2.onPageFinished(webView);
        }
    }

    public void notifyPropertiesChange(boolean z) {
        if (this.loadedWebView != null) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject2.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("x", (Number) 0);
            jsonObject3.addProperty("y", (Number) 0);
            jsonObject3.addProperty("width", (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            jsonObject3.addProperty("height", (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("sms", (Boolean) false);
            jsonObject4.addProperty("tel", (Boolean) false);
            jsonObject4.addProperty("calendar", (Boolean) false);
            jsonObject4.addProperty("storePicture", (Boolean) false);
            jsonObject4.addProperty("inlineVideo", (Boolean) false);
            jsonObject.add("maxSize", jsonObject2);
            jsonObject.add("screenSize", jsonObject2);
            jsonObject.add("defaultPosition", jsonObject3);
            jsonObject.add("currentPosition", jsonObject3);
            jsonObject.add("supports", jsonObject4);
            jsonObject.addProperty("placementType", this.advertisement.getTemplateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                jsonObject.addProperty("isViewable", bool);
            }
            jsonObject.addProperty("os", "android");
            jsonObject.addProperty("osVersion", Integer.toString(Build.VERSION.SDK_INT));
            jsonObject.addProperty("incentivized", Boolean.valueOf(this.placement.isIncentivized()));
            jsonObject.addProperty("enableBackImmediately", Boolean.valueOf(this.advertisement.getShowCloseDelay(this.placement.isIncentivized()) == 0));
            jsonObject.addProperty("version", "1.0");
            if (this.collectConsent) {
                jsonObject.addProperty("consentRequired", (Boolean) true);
                jsonObject.addProperty("consentTitleText", this.gdprTitle);
                jsonObject.addProperty("consentBodyText", this.gdprBody);
                jsonObject.addProperty("consentAcceptButtonText", this.gdprAccept);
                jsonObject.addProperty("consentDenyButtonText", this.gdprDeny);
            } else {
                jsonObject.addProperty("consentRequired", (Boolean) false);
            }
            jsonObject.addProperty("sdkVersion", "6.12.0");
            String str = TAG;
            Log.d(str, "loadJsjavascript:window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")");
            runJavascriptOnWebView(this.loadedWebView, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObject + "," + z + ")");
        }
    }

    public void setAdVisibility(boolean z) {
        this.isViewable = Boolean.valueOf(z);
        notifyPropertiesChange(false);
    }

    public void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public void setWebViewObserver(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            String str3 = TAG;
            Log.e(str3, "Error desc " + str);
            String str4 = TAG;
            Log.e(str4, "Error for URL " + str2);
            handleWebViewError(str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT >= 21) {
            String str = TAG;
            Log.e(str, "Error desc " + webResourceResponse.getStatusCode());
            String str2 = TAG;
            Log.e(str2, "Error for URL " + webResourceRequest.getUrl().toString());
            handleWebViewError(String.valueOf(webResourceResponse.getStatusCode()), webResourceRequest.getUrl().toString());
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            String str = TAG;
            Log.e(str, "Error desc " + webResourceError.getDescription().toString());
            String str2 = TAG;
            Log.e(str2, "Error for URL " + webResourceRequest.getUrl().toString());
            handleWebViewError(webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    private void handleWebViewError(String str, String str2) {
        boolean isCriticalAsset = isCriticalAsset(str2);
        String str3 = str2 + " " + str;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(str3, isCriticalAsset);
        }
    }

    private boolean isCriticalAsset(String str) {
        Advertisement advertisement2;
        if (TextUtils.isEmpty(str) || (advertisement2 = this.advertisement) == null) {
            return false;
        }
        return advertisement2.getDownloadableUrls().containsValue(str);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str = TAG;
        Log.w(str, "onRenderProcessGone url: " + webView.getUrl() + ",  did crash: " + renderProcessGoneDetail.didCrash());
        this.loadedWebView = null;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            return webClientErrorHandler.onWebRenderingProcessGone(webView, renderProcessGoneDetail.didCrash());
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* access modifiers changed from: private */
    public void runJavascriptOnWebView(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return;
        }
        webView.loadUrl("javascript:" + str);
    }

    static class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        WebViewAPI.WebClientErrorHandler errorHandler;

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            String str = VungleWebClient.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            sb.append(webViewRenderProcess != null);
            Log.w(str, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }
}
