package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.u;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

public class SSWebView extends FrameLayout {
    private com.bytedance.sdk.component.widget.b.a a;
    private String b;
    private JSONObject c;
    private boolean d;
    private float e;
    private float f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private WebView k;
    private float l;
    private float m;
    private float n;
    private int o;
    private b p;
    private u q;
    private AttributeSet r;
    private Context s;
    private c t;

    public interface b {
    }

    public interface c {
        void a(boolean z);
    }

    public SSWebView(Context context) {
        super(a(context));
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.l = 20.0f;
        this.n = 50.0f;
        try {
            this.k = new WebView(a(context));
            b();
        } catch (Throwable unused) {
        }
        b(a(context));
    }

    public SSWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        boolean z = false;
        this.j = false;
        this.l = 20.0f;
        this.n = 50.0f;
        try {
            if (com.bytedance.sdk.component.widget.a.a.a().b() != null && com.bytedance.sdk.component.widget.a.a.a().b().a()) {
                int h2 = t.h(context, "tt_delay_init");
                int i2 = 0;
                boolean z2 = false;
                while (i2 < attributeSet.getAttributeCount()) {
                    try {
                        if (attributeSet.getAttributeNameResource(i2) == h2) {
                            z2 = attributeSet.getAttributeBooleanValue(i2, false);
                        }
                        i2++;
                    } catch (Throwable unused) {
                    }
                }
                z = z2;
            }
        } catch (Throwable unused2) {
        }
        this.s = context;
        if (!z) {
            this.r = attributeSet;
            a();
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.l = 20.0f;
        this.n = 50.0f;
        try {
            this.k = new WebView(a(context), attributeSet, i2);
            b();
        } catch (Throwable unused) {
        }
        b(a(context));
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    private void a(MotionEvent motionEvent) {
        if (this.d && this.a != null) {
            if ((this.b != null || this.c != null) && motionEvent != null) {
                try {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        this.e = motionEvent.getRawX();
                        this.f = motionEvent.getRawY();
                        this.g = System.currentTimeMillis();
                        this.c = new JSONObject();
                        if (this.k != null) {
                            this.k.setTag(t.e(getContext(), "tt_id_click_begin"), Long.valueOf(this.g));
                        }
                    } else if (action == 1 || action == 3) {
                        this.c.put("start_x", String.valueOf(this.e));
                        this.c.put("start_y", String.valueOf(this.f));
                        this.c.put("offset_x", String.valueOf(motionEvent.getRawX() - this.e));
                        this.c.put("offset_y", String.valueOf(motionEvent.getRawY() - this.f));
                        this.c.put("url", String.valueOf(getUrl()));
                        this.c.put("tag", "");
                        this.h = System.currentTimeMillis();
                        if (this.k != null) {
                            this.k.setTag(t.e(getContext(), "tt_id_click_end"), Long.valueOf(this.h));
                        }
                        this.c.put("down_time", this.g);
                        this.c.put("up_time", this.h);
                        if (com.bytedance.sdk.component.widget.a.a.a().b() != null && this.i != this.g) {
                            this.i = this.g;
                            com.bytedance.sdk.component.widget.a.a.a().b().a(this.a, this.b, "in_web_click", this.c, this.h - this.g);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private void b(Context context) {
        c(context);
        p();
        o();
    }

    private static boolean b(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass != null && loadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return loadClass2 != null && loadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static void c(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager == null) {
                    return;
                }
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, new Object[]{0});
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean c(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass != null && loadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return loadClass2 != null && loadClass2.isInstance(view);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private void o() {
        try {
            this.k.removeJavascriptInterface("searchBoxJavaBridge_");
            this.k.removeJavascriptInterface("accessibility");
            this.k.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    private void p() {
        try {
            WebSettings settings = this.k.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (!TextUtils.isEmpty(str) && (settings = this.k.getSettings()) != null) {
                settings.setJavaScriptEnabled(!Uri.parse(str).getScheme().equals("file"));
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public ViewParent a(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (b(view2) || c(view2)) ? parent : a(view2);
    }

    public void a() {
        try {
            this.k = this.r == null ? new WebView(a(this.s)) : new WebView(a(this.s), this.r);
            b();
            b(a(this.s));
        } catch (Throwable unused) {
        }
    }

    public void a(Object obj, String str) {
        try {
            this.k.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.k.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        try {
            this.k.clearCache(z);
        } catch (Throwable unused) {
        }
    }

    public void b() {
        if (this.k != null) {
            removeAllViews();
            setBackground((Drawable) null);
            try {
                this.k.setId(t.e(getContext(), "tt_id_root_web_view"));
            } catch (Throwable unused) {
            }
            addView(this.k, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void b(String str) {
        try {
            this.k.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.k.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void computeScroll() {
        try {
            this.k.computeScroll();
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            this.k.reload();
        } catch (Throwable unused) {
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        c cVar = this.t;
        if (cVar != null) {
            cVar.a(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean e() {
        try {
            return this.k.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void f() {
        try {
            this.k.goBack();
        } catch (Throwable unused) {
        }
    }

    public boolean g() {
        try {
            return this.k.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public int getContentHeight() {
        try {
            return this.k.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public com.bytedance.sdk.component.widget.b.a getMaterialMeta() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r1 = r3.k.getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getOriginalUrl() {
        /*
            r3 = this;
            android.webkit.WebView r0 = r3.k     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r0.getOriginalUrl()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0021
            java.lang.String r1 = "data:text/html"
            boolean r1 = r0.startsWith(r1)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0021
            android.webkit.WebView r1 = r3.k     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = r1.getUrl()     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0021
            java.lang.String r2 = "file://"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x0021
            r0 = r1
        L_0x0021:
            return r0
        L_0x0022:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.SSWebView.getOriginalUrl():java.lang.String");
    }

    public int getProgress() {
        try {
            return this.k.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getTag() {
        return this.b;
    }

    public String getUrl() {
        try {
            return this.k.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        try {
            return this.k.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.k;
    }

    public void h() {
        try {
            this.k.goForward();
        } catch (Throwable unused) {
        }
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void i() {
        WebView webView = this.k;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void j() {
        try {
            this.k.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public void k() {
        try {
            this.k.onPause();
            if (this.t != null) {
                this.t.a(false);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        try {
            this.k.destroy();
        } catch (Throwable unused) {
        }
    }

    public void m() {
        try {
            this.k.clearView();
        } catch (Throwable unused) {
        }
    }

    public void n() {
        try {
            this.k.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.q;
        if (uVar != null) {
            uVar.b();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent a2;
        try {
            a(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.j && (a2 = a((View) this)) != null) {
                a2.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        u uVar = this.q;
        if (uVar == null) {
            return;
        }
        if (z) {
            uVar.a();
        } else {
            uVar.b();
        }
    }

    public void removeAllViews() {
        try {
            this.k.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.k.getSettings().setAllowFileAccess(z);
        } catch (Throwable unused) {
        }
    }

    public void setAlpha(float f2) {
        try {
            super.setAlpha(f2);
            this.k.setAlpha(f2);
        } catch (Throwable unused) {
        }
    }

    public void setAppCacheEnabled(boolean z) {
        try {
            this.k.getSettings().setAppCacheEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setBackgroundColor(int i2) {
        try {
            this.k.setBackgroundColor(i2);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.k.getSettings().setBuiltInZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i2) {
        try {
            this.k.getSettings().setCacheMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i2) {
        this.o = i2;
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.k.getSettings().setDatabaseEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f2) {
        this.m = f2;
    }

    public void setDefaultFontSize(int i2) {
        try {
            this.k.getSettings().setDefaultFontSize(i2);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.k.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z) {
        try {
            this.k.getSettings().setDisplayZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.k.getSettings().setDomStorageEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.k.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.j = z;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.k.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.k.getSettings().setJavaScriptEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z) {
        this.d = z;
    }

    public void setLayerType(int i2, Paint paint) {
        try {
            this.k.setLayerType(i2, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.k.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.k.getSettings().setLoadWithOverviewMode(z);
        } catch (Throwable unused) {
        }
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.b.a aVar) {
        this.a = aVar;
    }

    public void setMixedContentMode(int i2) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                this.k.getSettings().setMixedContentMode(i2);
            }
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.k.setNetworkAvailable(z);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(b bVar) {
        this.p = bVar;
    }

    public void setOverScrollMode(int i2) {
        try {
            this.k.setOverScrollMode(i2);
            super.setOverScrollMode(i2);
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f2) {
        this.l = f2;
    }

    public void setSupportZoom(boolean z) {
        try {
            this.k.getSettings().setSupportZoom(z);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.b = str;
    }

    public void setTouchStateListener(c cVar) {
        this.t = cVar;
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.k.getSettings().setUseWideViewPort(z);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.k.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    public void setVisibility(int i2) {
        try {
            super.setVisibility(i2);
            this.k.setVisibility(i2);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.k.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof c) {
                setTouchStateListener((c) webViewClient);
            } else {
                setTouchStateListener((c) null);
            }
            if (webViewClient == null) {
                webViewClient = new a();
            }
            this.k.setWebViewClient(webViewClient);
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f2) {
        this.n = f2;
    }

    public static class a extends WebViewClient {
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (!renderProcessGoneDetail.didCrash()) {
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    webView.destroy();
                }
                return true;
            }
            if (webView != null) {
                ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(webView);
                }
                webView.destroy();
            }
            return true;
        }
    }
}
