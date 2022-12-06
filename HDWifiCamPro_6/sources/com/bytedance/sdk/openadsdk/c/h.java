package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LandingPageLog */
public class h {
    private static final int[] a = {10, 30, 50, 75, 100};
    private int b = 0;
    private long c = -1;
    private int d = 1;
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);
    private int g = -1;
    private String h;
    private String i;
    private final Context j = m.a();
    private final n k;
    private String l = "landingpage";
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private boolean s = false;
    private boolean t = false;
    /* access modifiers changed from: private */
    public AtomicInteger u = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public WebView v;
    private boolean w = false;
    /* access modifiers changed from: private */
    public String x = "";
    private m y;
    private boolean z = false;

    public n a() {
        return this.k;
    }

    public h(Context context, n nVar, WebView webView) {
        this.k = nVar;
        this.v = webView;
        if (webView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.v.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
            }
            if (nVar != null && nVar.aP() != null) {
                this.c = nVar.aP().optLong("page_id", -1);
            }
        }
    }

    public void a(long j2) {
        this.o = j2;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.l = str;
        }
    }

    public m b() {
        return this.y;
    }

    public void a(m mVar) {
        this.y = mVar;
    }

    public h a(boolean z2) {
        this.w = z2;
        return this;
    }

    public boolean c() {
        return this.z;
    }

    public void a(WebView webView, int i2) {
        if (webView != null) {
            l.b("LandingPageLog", "onWebProgress: " + i2);
            if (this.p == 0 && i2 > 0) {
                this.p = System.currentTimeMillis();
            } else if (this.q == 0 && i2 == 100) {
                this.q = System.currentTimeMillis();
            }
            if (this.b == a.length) {
                return;
            }
            if ("landingpage".equals(this.l) || "landingpage_endcard".equals(this.l) || "landingpage_split_screen".equals(this.l) || "landingpage_direct".equals(this.l)) {
                int i3 = this.b;
                while (true) {
                    int[] iArr = a;
                    if (i3 < iArr.length && i2 >= iArr[this.b]) {
                        int i4 = i3 + 1;
                        this.b = i4;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", webView.getUrl());
                            if (this.c != -1) {
                                jSONObject.put("page_id", this.c);
                            }
                            jSONObject.putOpt("render_type", "h5");
                            jSONObject.putOpt("render_type_2", 0);
                            jSONObject.put("pct", a[i3]);
                        } catch (Exception unused) {
                        }
                        a("progress_load_finish", jSONObject);
                        i3 = i4;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        m mVar = this.y;
        if (mVar != null) {
            mVar.e();
        }
        if (this.e.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception unused) {
            }
            a("load_start", jSONObject);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|22|23|24|25|(1:31)|32|40) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0068 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.webkit.WebView r11, java.lang.String r12, boolean r13) {
        /*
            r10 = this;
            com.bytedance.sdk.openadsdk.c.m r12 = r10.y
            if (r12 == 0) goto L_0x0007
            r12.f()
        L_0x0007:
            r12 = 1
            if (r11 == 0) goto L_0x0019
            boolean r0 = r10.s
            if (r0 != 0) goto L_0x0019
            boolean r0 = r10.w
            if (r0 == 0) goto L_0x0019
            r10.s = r12
            java.lang.String r0 = "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});"
            com.bytedance.sdk.component.utils.k.a(r11, r0)
        L_0x0019:
            java.util.concurrent.atomic.AtomicBoolean r11 = r10.f
            r0 = 0
            boolean r11 = r11.compareAndSet(r0, r12)
            if (r11 != 0) goto L_0x0023
            return
        L_0x0023:
            int r11 = r10.d
            r1 = 3
            r2 = 2
            if (r11 == r1) goto L_0x002b
            r10.d = r2
        L_0x002b:
            long r3 = java.lang.System.currentTimeMillis()
            r10.m = r3
            int r11 = r10.d
            if (r11 != r2) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r12 = r0
        L_0x0037:
            java.lang.String r11 = "render_type_2"
            java.lang.String r1 = "h5"
            java.lang.String r2 = "render_type"
            java.lang.String r3 = "error_url"
            java.lang.String r4 = "error_msg"
            java.lang.String r5 = "error_code"
            if (r12 == 0) goto L_0x00b3
            long r6 = r10.q
            long r8 = r10.p
            long r6 = r6 - r8
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            int r8 = r10.g     // Catch:{ Exception -> 0x0068 }
            r12.put(r5, r8)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r5 = r10.h     // Catch:{ Exception -> 0x0068 }
            r12.put(r4, r5)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r4 = r10.i     // Catch:{ Exception -> 0x0068 }
            r12.put(r3, r4)     // Catch:{ Exception -> 0x0068 }
            r12.putOpt(r2, r1)     // Catch:{ Exception -> 0x0068 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0068 }
            r12.putOpt(r11, r0)     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            com.bytedance.sdk.openadsdk.core.settings.j r11 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ all -> 0x00a6 }
            com.bytedance.sdk.openadsdk.core.settings.e r11 = r11.r()     // Catch:{ all -> 0x00a6 }
            if (r13 == 0) goto L_0x00a6
            java.lang.String r13 = r11.b     // Catch:{ all -> 0x00a6 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00a6 }
            if (r13 != 0) goto L_0x00a6
            boolean r13 = r11.c     // Catch:{ all -> 0x00a6 }
            if (r13 == 0) goto L_0x00a6
            java.lang.String r11 = r11.b     // Catch:{ all -> 0x00a6 }
            com.bytedance.sdk.openadsdk.i.d r13 = com.bytedance.sdk.openadsdk.i.d.a()     // Catch:{ all -> 0x00a6 }
            com.bytedance.sdk.component.f.a r13 = r13.b()     // Catch:{ all -> 0x00a6 }
            com.bytedance.sdk.component.f.b.b r13 = r13.c()     // Catch:{ all -> 0x00a6 }
            r13.a((java.lang.String) r11)     // Catch:{ all -> 0x00a6 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x00a6 }
            r11.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "content-type"
            java.lang.String r1 = "application/json; charset=utf-8"
            r11.put(r0, r1)     // Catch:{ all -> 0x00a6 }
            r13.d(r11)     // Catch:{ all -> 0x00a6 }
            com.bytedance.sdk.openadsdk.c.h$1 r11 = new com.bytedance.sdk.openadsdk.c.h$1     // Catch:{ all -> 0x00a6 }
            r11.<init>()     // Catch:{ all -> 0x00a6 }
            r13.a((com.bytedance.sdk.component.f.a.a) r11)     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = 600000(0x927c0, double:2.964394E-318)
            long r0 = java.lang.Math.min(r6, r0)
            java.lang.String r11 = "load_finish"
            r10.a((java.lang.String) r11, (org.json.JSONObject) r12, (long) r0)
            goto L_0x00d6
        L_0x00b3:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            int r13 = r10.g     // Catch:{ Exception -> 0x00d1 }
            r12.put(r5, r13)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r13 = r10.h     // Catch:{ Exception -> 0x00d1 }
            r12.put(r4, r13)     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r13 = r10.i     // Catch:{ Exception -> 0x00d1 }
            r12.put(r3, r13)     // Catch:{ Exception -> 0x00d1 }
            r12.putOpt(r2, r1)     // Catch:{ Exception -> 0x00d1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d1 }
            r12.putOpt(r11, r13)     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            java.lang.String r11 = "load_fail"
            r10.a((java.lang.String) r11, (org.json.JSONObject) r12)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.h.a(android.webkit.WebView, java.lang.String, boolean):void");
    }

    /* access modifiers changed from: private */
    public String b(String str) {
        return "javascript:" + str;
    }

    public void a(WebView webView, int i2, String str, String str2, String str3) {
        m mVar = this.y;
        if (mVar != null) {
            mVar.g();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.d != 2) {
            this.d = 3;
        }
        this.g = i2;
        this.h = str;
        this.i = str2;
    }

    public void d() {
        l.b("LandingPageLog", "onResume");
        if (this.r == 0) {
            this.r = System.currentTimeMillis();
        }
        this.m = System.currentTimeMillis();
    }

    public void e() {
        l.b("LandingPageLog", "onStop");
        if ("landingpage".equals(this.l) || "landingpage_endcard".equals(this.l) || "landingpage_split_screen".equals(this.l) || "landingpage_direct".equals(this.l)) {
            if (!(this.d == 2)) {
                return;
            }
            if (this.o > 0 || !c()) {
                this.n = System.currentTimeMillis();
                long max = this.n - Math.max(this.m, this.o);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.d);
                    jSONObject.put("max_scroll_percent", this.u.get());
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                a("stay_page", jSONObject, Math.min(max, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        }
    }

    public void a(SSWebView sSWebView) {
        int R;
        Bitmap a2;
        n nVar;
        if (("landingpage".equals(this.l) || "landingpage_endcard".equals(this.l) || "landingpage_split_screen".equals(this.l) || "landingpage_direct".equals(this.l)) && (R = m.d().R()) != 0 && new Random().nextInt(100) + 1 <= R && sSWebView != null && sSWebView.getWebView() != null && sSWebView.getVisibility() == 0 && (a2 = z.a(sSWebView)) != null && (nVar = this.k) != null) {
            z.a(nVar, this.l, "landing_page_blank", a2, sSWebView.getUrl(), this.c);
        }
    }

    public void f() {
        l.b("LandingPageLog", "onDestroy");
        this.v = null;
        if (this.f.compareAndSet(false, true)) {
            c.a(this.j, this.k, this.l, System.currentTimeMillis() - this.r);
        }
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        a(str, jSONObject, -1);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[Catch:{ JSONException -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, org.json.JSONObject r8, long r9) {
        /*
            r6 = this;
            boolean r0 = r6.w
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r6.k
            if (r0 == 0) goto L_0x005b
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0010
            goto L_0x005b
        L_0x0010:
            r0 = 0
            if (r8 == 0) goto L_0x0052
            java.lang.String r1 = "is_playable"
            com.bytedance.sdk.openadsdk.core.model.n r2 = r6.k     // Catch:{ JSONException -> 0x0038 }
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.p.a((com.bytedance.sdk.openadsdk.core.model.n) r2)     // Catch:{ JSONException -> 0x0038 }
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0021
            r2 = r3
            goto L_0x0022
        L_0x0021:
            r2 = r4
        L_0x0022:
            r8.put(r1, r2)     // Catch:{ JSONException -> 0x0038 }
            java.lang.String r1 = "usecache"
            com.bytedance.sdk.openadsdk.core.video.b.a r2 = com.bytedance.sdk.openadsdk.core.video.b.a.a()     // Catch:{ JSONException -> 0x0038 }
            com.bytedance.sdk.openadsdk.core.model.n r5 = r6.k     // Catch:{ JSONException -> 0x0038 }
            boolean r2 = r2.a((com.bytedance.sdk.openadsdk.core.model.n) r5)     // Catch:{ JSONException -> 0x0038 }
            if (r2 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r3 = r4
        L_0x0035:
            r8.put(r1, r3)     // Catch:{ JSONException -> 0x0038 }
        L_0x0038:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0052 }
            r1.<init>()     // Catch:{ JSONException -> 0x0052 }
            java.lang.String r0 = "ad_extra_data"
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0051 }
            r1.put(r0, r8)     // Catch:{ JSONException -> 0x0051 }
            r2 = 0
            int r8 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0051
            java.lang.String r8 = "duration"
            r1.put(r8, r9)     // Catch:{ JSONException -> 0x0051 }
        L_0x0051:
            r0 = r1
        L_0x0052:
            android.content.Context r8 = r6.j
            com.bytedance.sdk.openadsdk.core.model.n r9 = r6.k
            java.lang.String r10 = r6.l
            com.bytedance.sdk.openadsdk.c.c.c((android.content.Context) r8, (com.bytedance.sdk.openadsdk.core.model.n) r9, (java.lang.String) r10, (java.lang.String) r7, (org.json.JSONObject) r0)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.h.a(java.lang.String, org.json.JSONObject, long):void");
    }

    /* compiled from: LandingPageLog */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            h.this.u.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return h.this.x;
        }
    }
}
