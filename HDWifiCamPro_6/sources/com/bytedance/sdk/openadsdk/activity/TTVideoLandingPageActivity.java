package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class TTVideoLandingPageActivity extends Activity implements d {
    protected ViewStub A;
    protected Button B;
    protected ProgressBar C;
    protected c D;
    protected boolean E = false;
    protected String F;
    protected boolean G = false;
    protected boolean H = true;
    protected boolean I = false;
    protected String J = null;
    protected int K;
    protected com.bytedance.sdk.openadsdk.multipro.b.a L;
    protected h M;
    protected AtomicBoolean N = new AtomicBoolean(true);
    protected JSONArray O = null;
    protected String P;
    protected com.bytedance.sdk.openadsdk.core.b.a Q = null;
    private final c.b R = new c.b() {
        public void a(boolean z) {
            TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
            tTVideoLandingPageActivity.E = z;
            if (tTVideoLandingPageActivity.isFinishing()) {
                return;
            }
            if (z) {
                z.a((View) TTVideoLandingPageActivity.this.a, 8);
                z.a((View) TTVideoLandingPageActivity.this.k, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
                TTVideoLandingPageActivity.this.r = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.q = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.s = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.t = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams);
                return;
            }
            z.a((View) TTVideoLandingPageActivity.this.a, 0);
            z.a((View) TTVideoLandingPageActivity.this.k, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.s;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.t;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.r;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.q;
            TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean S = false;
    private final v.a T = new v.a() {
        public void a(Context context, Intent intent, boolean z) {
            intent.getAction();
            int i = 0;
            if (z) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null) {
                    int type = networkInfo.getType();
                    if (type == 1) {
                        i = 4;
                    } else if (type == 0) {
                        i = 1;
                    }
                } else {
                    i = o.c(context);
                }
            }
            if (!(TTVideoLandingPageActivity.this.K != 0 || i == 0 || TTVideoLandingPageActivity.this.a == null || TTVideoLandingPageActivity.this.J == null)) {
                TTVideoLandingPageActivity.this.a.a(TTVideoLandingPageActivity.this.J);
            }
            if (!(TTVideoLandingPageActivity.this.n == null || TTVideoLandingPageActivity.this.n.getNativeVideoController() == null || TTVideoLandingPageActivity.this.G || TTVideoLandingPageActivity.this.K == i)) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) TTVideoLandingPageActivity.this.n.getNativeVideoController()).a(context, i);
            }
            TTVideoLandingPageActivity.this.K = i;
        }
    };
    protected SSWebView a;
    protected ImageView b;
    protected ImageView c;
    protected TextView d;
    protected Context e;
    protected int f;
    protected String g;
    protected String h;
    protected u i;
    protected int j;
    protected RelativeLayout k;
    protected FrameLayout l;
    protected int m = -1;
    protected NativeVideoTsView n;
    protected long o;
    protected n p;
    protected int q = 0;
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected String u = "ダウンロード";
    protected RelativeLayout v;
    protected TextView w;
    protected CornerIV x;
    protected TextView y;
    protected TextView z;

    /* access modifiers changed from: protected */
    public String a() {
        return "tt_activity_videolandingpage";
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "tt_titlebar_close";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
            r12 = this;
            super.onCreate(r13)
            boolean r0 = com.bytedance.sdk.openadsdk.TTAdSdk.isInitSuccess()
            if (r0 != 0) goto L_0x000c
            r12.finish()
        L_0x000c:
            android.view.Window r0 = r12.getWindow()     // Catch:{ all -> 0x0015 }
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0.addFlags(r1)     // Catch:{ all -> 0x0015 }
        L_0x0015:
            com.bytedance.sdk.openadsdk.core.m.a(r12)     // Catch:{ all -> 0x0018 }
        L_0x0018:
            android.content.Context r0 = r12.getApplicationContext()
            int r0 = com.bytedance.sdk.component.utils.o.c(r0)
            r12.K = r0
            java.lang.String r0 = r12.a()
            int r0 = com.bytedance.sdk.component.utils.t.f(r12, r0)
            r12.setContentView(r0)
            r12.e = r12
            android.content.Intent r0 = r12.getIntent()
            r1 = 1
            java.lang.String r2 = "sdk_version"
            int r2 = r0.getIntExtra(r2, r1)
            r12.f = r2
            java.lang.String r2 = "adid"
            java.lang.String r2 = r0.getStringExtra(r2)
            r12.g = r2
            java.lang.String r2 = "log_extra"
            java.lang.String r2 = r0.getStringExtra(r2)
            r12.h = r2
            r2 = -1
            java.lang.String r3 = "source"
            int r2 = r0.getIntExtra(r3, r2)
            r12.j = r2
            java.lang.String r2 = "url"
            java.lang.String r2 = r0.getStringExtra(r2)
            r12.J = r2
            java.lang.String r2 = "web_title"
            java.lang.String r2 = r0.getStringExtra(r2)
            java.lang.String r3 = "event_tag"
            java.lang.String r3 = r0.getStringExtra(r3)
            r12.F = r3
            java.lang.String r3 = "gecko_id"
            java.lang.String r3 = r0.getStringExtra(r3)
            r12.P = r3
            java.lang.String r3 = "video_is_auto_play"
            boolean r3 = r0.getBooleanExtra(r3, r1)
            r12.I = r3
            r3 = 0
            java.lang.String r5 = "video_play_position"
            if (r13 == 0) goto L_0x008f
            long r6 = r13.getLong(r5)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x008f
            long r6 = r13.getLong(r5, r3)
            r12.o = r6
        L_0x008f:
            java.lang.String r6 = "multi_process_data"
            java.lang.String r6 = r0.getStringExtra(r6)
            boolean r7 = com.bytedance.sdk.openadsdk.multipro.b.c()
            if (r7 == 0) goto L_0x00b9
            java.lang.String r7 = "multi_process_materialmeta"
            java.lang.String r0 = r0.getStringExtra(r7)
            if (r0 == 0) goto L_0x00ae
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ae }
            r7.<init>(r0)     // Catch:{ Exception -> 0x00ae }
            com.bytedance.sdk.openadsdk.core.model.n r0 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r7)     // Catch:{ Exception -> 0x00ae }
            r12.p = r0     // Catch:{ Exception -> 0x00ae }
        L_0x00ae:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.ad()
            r12.m = r0
            goto L_0x00d4
        L_0x00b9:
            com.bytedance.sdk.openadsdk.core.r r0 = com.bytedance.sdk.openadsdk.core.r.a()
            com.bytedance.sdk.openadsdk.core.model.n r0 = r0.c()
            r12.p = r0
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            if (r0 == 0) goto L_0x00cd
            int r0 = r0.ad()
            r12.m = r0
        L_0x00cd:
            com.bytedance.sdk.openadsdk.core.r r0 = com.bytedance.sdk.openadsdk.core.r.a()
            r0.h()
        L_0x00d4:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            if (r0 != 0) goto L_0x00dc
            r12.finish()
            return
        L_0x00dc:
            if (r6 == 0) goto L_0x00f1
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e9 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x00e9 }
            com.bytedance.sdk.openadsdk.multipro.b.a r0 = com.bytedance.sdk.openadsdk.multipro.b.a.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x00e9 }
            r12.L = r0     // Catch:{ Exception -> 0x00e9 }
        L_0x00e9:
            com.bytedance.sdk.openadsdk.multipro.b.a r0 = r12.L
            if (r0 == 0) goto L_0x00f1
            long r6 = r0.g
            r12.o = r6
        L_0x00f1:
            if (r13 == 0) goto L_0x0117
            java.lang.String r0 = "material_meta"
            java.lang.String r0 = r13.getString(r0)
            com.bytedance.sdk.openadsdk.core.model.n r6 = r12.p
            if (r6 != 0) goto L_0x0108
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0108 }
            r6.<init>(r0)     // Catch:{ all -> 0x0108 }
            com.bytedance.sdk.openadsdk.core.model.n r0 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r6)     // Catch:{ all -> 0x0108 }
            r12.p = r0     // Catch:{ all -> 0x0108 }
        L_0x0108:
            long r5 = r13.getLong(r5)
            java.lang.String r0 = "is_complete"
            r13.getBoolean(r0)
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0117
            r12.o = r5
        L_0x0117:
            r12.d()
            r12.j()
            r12.n()
            r13 = 4
            r12.a((int) r13)
            int r13 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            r3 = 0
            if (r13 < r0) goto L_0x012d
            r13 = r1
            goto L_0x012e
        L_0x012d:
            r13 = r3
        L_0x012e:
            com.bytedance.sdk.component.widget.SSWebView r0 = r12.a
            java.lang.String r4 = "landingpage_split_screen"
            if (r0 == 0) goto L_0x0163
            android.content.Context r0 = r12.e
            com.bytedance.sdk.openadsdk.core.widget.a.b r0 = com.bytedance.sdk.openadsdk.core.widget.a.b.a((android.content.Context) r0)
            com.bytedance.sdk.openadsdk.core.widget.a.b r13 = r0.a((boolean) r13)
            com.bytedance.sdk.openadsdk.core.widget.a.b r13 = r13.b((boolean) r3)
            com.bytedance.sdk.component.widget.SSWebView r0 = r12.a
            android.webkit.WebView r0 = r0.getWebView()
            r13.a((android.webkit.WebView) r0)
            com.bytedance.sdk.openadsdk.c.h r13 = new com.bytedance.sdk.openadsdk.c.h
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            com.bytedance.sdk.component.widget.SSWebView r5 = r12.a
            android.webkit.WebView r5 = r5.getWebView()
            r13.<init>(r12, r0, r5)
            com.bytedance.sdk.openadsdk.c.h r13 = r13.a((boolean) r1)
            r12.M = r13
            com.bytedance.sdk.openadsdk.c.h r13 = r12.M
            r13.a((java.lang.String) r4)
        L_0x0163:
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            r13.setLandingPage(r1)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            r13.setTag(r4)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            com.bytedance.sdk.component.widget.b.a r0 = r0.aK()
            r13.setMaterialMeta(r0)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$1
            android.content.Context r7 = r12.e
            com.bytedance.sdk.openadsdk.core.u r8 = r12.i
            java.lang.String r9 = r12.g
            com.bytedance.sdk.openadsdk.c.h r10 = r12.M
            r11 = 1
            r5 = r0
            r6 = r12
            r5.<init>(r7, r8, r9, r10, r11)
            r13.setWebViewClient(r0)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            if (r13 == 0) goto L_0x019e
            android.webkit.WebView r0 = r13.getWebView()
            int r1 = r12.f
            java.lang.String r0 = com.bytedance.sdk.openadsdk.l.j.a((android.webkit.WebView) r0, (int) r1)
            r13.setUserAgentString(r0)
        L_0x019e:
            int r13 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r13 < r0) goto L_0x01a9
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            r13.setMixedContentMode(r3)
        L_0x01a9:
            android.content.Context r13 = r12.e
            com.bytedance.sdk.openadsdk.core.model.n r0 = r12.p
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r13, (com.bytedance.sdk.openadsdk.core.model.n) r0, (java.lang.String) r4)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            java.lang.String r0 = r12.J
            com.bytedance.sdk.openadsdk.l.l.a(r13, r0)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$3 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$3
            com.bytedance.sdk.openadsdk.core.u r1 = r12.i
            com.bytedance.sdk.openadsdk.c.h r3 = r12.M
            r0.<init>(r1, r3)
            r13.setWebChromeClient(r0)
            com.bytedance.sdk.component.widget.SSWebView r13 = r12.a
            com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4 r0 = new com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity$4
            r0.<init>()
            r13.setDownloadListener(r0)
            android.widget.TextView r13 = r12.d
            if (r13 == 0) goto L_0x01e2
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x01df
            java.lang.String r0 = "tt_web_title_default"
            java.lang.String r2 = com.bytedance.sdk.component.utils.t.a(r12, r0)
        L_0x01df:
            r13.setText(r2)
        L_0x01e2:
            r12.k()
            r12.e()
            r12.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.onCreate(android.os.Bundle):void");
    }

    private void m() {
        n nVar = this.p;
        if (nVar != null && nVar.L() == 4) {
            this.A.setVisibility(0);
            this.B = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
            if (this.B != null) {
                a(b());
                this.B.setOnClickListener(this.Q);
                this.B.setOnTouchListener(this.Q);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        n nVar = this.p;
        if (nVar != null && !TextUtils.isEmpty(nVar.W())) {
            this.u = this.p.W();
        }
        return this.u;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.B) != null) {
            button.post(new Runnable() {
                public void run() {
                    if (TTVideoLandingPageActivity.this.B != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                        TTVideoLandingPageActivity.this.B.setText(str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.C = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
        this.A = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
        this.a = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.b = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.a == null) {
                        return;
                    }
                    if (TTVideoLandingPageActivity.this.a.e()) {
                        TTVideoLandingPageActivity.this.a.f();
                    } else if (TTVideoLandingPageActivity.this.r()) {
                        TTVideoLandingPageActivity.this.onBackPressed();
                    } else {
                        Map<String, Object> map = null;
                        if (!(TTVideoLandingPageActivity.this.n == null || TTVideoLandingPageActivity.this.n.getNativeVideoController() == null)) {
                            map = y.a(TTVideoLandingPageActivity.this.p, TTVideoLandingPageActivity.this.n.getNativeVideoController().h(), TTVideoLandingPageActivity.this.n.getNativeVideoController().n());
                        }
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.c.a((Context) tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h(), map, (f) null);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setIsAutoPlay(this.I);
        }
        this.c = (ImageView) findViewById(t.e(this, c()));
        ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.n != null) {
                        Map<String, Object> map = null;
                        if (TTVideoLandingPageActivity.this.n.getNativeVideoController() != null) {
                            map = y.a(TTVideoLandingPageActivity.this.p, TTVideoLandingPageActivity.this.n.getNativeVideoController().h(), TTVideoLandingPageActivity.this.n.getNativeVideoController().n());
                        }
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.c.a((Context) tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h(), map, (f) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.d = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
        this.l = (FrameLayout) findViewById(t.e(this, "tt_native_video_container"));
        this.k = (RelativeLayout) findViewById(t.e(this, "tt_native_video_titlebar"));
        this.v = (RelativeLayout) findViewById(t.e(this, "tt_rl_download"));
        this.w = (TextView) findViewById(t.e(this, "tt_video_btn_ad_image_tv"));
        this.y = (TextView) findViewById(t.e(this, "tt_video_ad_name"));
        this.z = (TextView) findViewById(t.e(this, "tt_video_ad_button"));
        this.x = (CornerIV) findViewById(t.e(this, "tt_video_ad_logo_image"));
        i();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m();
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (f()) {
            try {
                this.n = new NativeVideoTsView(this.e, this.p, true, (f) null);
                if (this.n.getNativeVideoController() != null) {
                    this.n.getNativeVideoController().a(false);
                }
                if (this.G) {
                    this.l.setVisibility(0);
                    this.l.removeAllViews();
                    this.l.addView(this.n);
                    this.n.b(true);
                } else {
                    if (!this.I) {
                        this.o = 0;
                    }
                    if (!(this.L == null || this.n.getNativeVideoController() == null)) {
                        this.n.getNativeVideoController().b(this.L.g);
                        this.n.getNativeVideoController().c(this.L.e);
                        this.n.setIsQuiet(m.d().b(String.valueOf(this.p.aW())));
                    }
                    if (this.n.a(this.o, this.H, this.G)) {
                        this.l.setVisibility(0);
                        this.l.removeAllViews();
                        this.l.addView(this.n);
                    }
                    if (this.n.getNativeVideoController() != null) {
                        this.n.getNativeVideoController().a(false);
                        this.n.getNativeVideoController().a(this.R);
                    }
                }
                com.bytedance.sdk.openadsdk.e.a.a().a(this.p.P().get(0).a()).a(com.bytedance.sdk.component.d.u.BITMAP).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.component.d.o<Bitmap>() {
                    public void a(int i, String str, Throwable th) {
                    }

                    public void a(k<Bitmap> kVar) {
                        try {
                            Bitmap b = kVar.b();
                            if (Build.VERSION.SDK_INT >= 17) {
                                new a(b, TTVideoLandingPageActivity.this.n.getNativeVideoController().o()).execute(new Void[0]);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
                this.n.findViewById(t.e(this.e, "tt_root_view")).setOnTouchListener((View.OnTouchListener) null);
                this.n.findViewById(t.e(this.e, "tt_root_view")).setOnClickListener((View.OnClickListener) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.K == 0) {
                try {
                    Toast.makeText(this, t.b(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return this.m == 5;
    }

    /* access modifiers changed from: protected */
    public long g() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.n.getNativeVideoController().j();
    }

    /* access modifiers changed from: protected */
    public int h() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.n.getNativeVideoController().l();
    }

    /* access modifiers changed from: protected */
    public void i() {
        String str;
        n nVar = this.p;
        if (nVar != null && nVar.L() == 4) {
            z.a((View) this.v, 0);
            if (!TextUtils.isEmpty(this.p.U())) {
                str = this.p.U();
            } else if (!TextUtils.isEmpty(this.p.V())) {
                str = this.p.V();
            } else {
                str = !TextUtils.isEmpty(this.p.K()) ? this.p.K() : "";
            }
            if (this.p.M() != null && this.p.M().a() != null) {
                z.a((View) this.x, 0);
                z.a((View) this.w, 4);
                com.bytedance.sdk.openadsdk.i.d.a().a(this.p.M(), (ImageView) this.x);
            } else if (!TextUtils.isEmpty(str)) {
                z.a((View) this.x, 4);
                z.a((View) this.w, 0);
                this.w.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(this.p.W())) {
                this.z.setText(this.p.W());
            }
            if (!TextUtils.isEmpty(str)) {
                this.y.setText(str);
            }
            z.a((View) this.y, 0);
            z.a((View) this.z, 0);
        }
    }

    public void j() {
        n nVar = this.p;
        if (nVar != null) {
            this.D = com.com.bytedance.overseas.sdk.a.d.a(this, nVar, this.F);
            this.Q = new com.bytedance.sdk.openadsdk.core.b.a(this, this.p, this.F, this.j);
            this.Q.a(false);
            this.Q.c(true);
            this.z.setOnClickListener(this.Q);
            this.z.setOnTouchListener(this.Q);
            this.Q.a(this.D);
        }
    }

    private void n() {
        this.i = new u(this);
        this.i.b(this.a).d(this.g).e(this.h).b(this.j).a(this.p).a(this.p.F()).a(this.a).c("landingpage_split_screen").f(this.p.aY());
    }

    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.E && (nativeVideoTsView = this.n) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.d.a) this.n.getNativeVideoController()).e((b) null, (View) null);
            this.E = false;
        } else if (!r() || this.N.getAndSet(true)) {
            super.onBackPressed();
        } else {
            a(true);
            a(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        n nVar = this.p;
        bundle.putString("material_meta", nVar != null ? nVar.ar().toString() : null);
        bundle.putLong("video_play_position", this.o);
        bundle.putBoolean("is_complete", this.G);
        long j2 = this.o;
        NativeVideoTsView nativeVideoTsView = this.n;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            j2 = this.n.getNativeVideoController().g();
        }
        bundle.putLong("video_play_position", j2);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.H) {
            o();
        }
        this.H = false;
        u uVar = this.i;
        if (uVar != null) {
            uVar.k();
        }
        h hVar = this.M;
        if (hVar != null) {
            hVar.d();
        }
    }

    private void o() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !q()) {
            this.n.m();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        u uVar = this.i;
        if (uVar != null) {
            uVar.l();
        }
        p();
        if (this.G || !((nativeVideoTsView2 = this.n) == null || nativeVideoTsView2.getNativeVideoController() == null || !this.n.getNativeVideoController().q())) {
            this.G = true;
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        }
        if (!this.G && (nativeVideoTsView = this.n) != null && nativeVideoTsView.getNativeVideoController() != null) {
            a(this.n.getNativeVideoController());
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        h hVar = this.M;
        if (hVar != null) {
            hVar.e();
        }
    }

    private void a(com.bykv.vk.openvk.component.video.api.d.c cVar) {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.q()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.g()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.j() + cVar.h()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.j()));
    }

    private void p() {
        if (this.n != null && !q()) {
            this.n.m();
        }
    }

    private boolean q() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.n.getNativeVideoController().q();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        l();
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
            this.p.a(false);
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.a;
        if (sSWebView != null) {
            x.a(this.e, sSWebView.getWebView());
            x.a(this.a.getWebView());
        }
        this.a = null;
        u uVar = this.i;
        if (uVar != null) {
            uVar.m();
        }
        NativeVideoTsView nativeVideoTsView = this.n;
        if (!(nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null)) {
            this.n.getNativeVideoController().f();
        }
        this.n = null;
        this.p = null;
        h hVar = this.M;
        if (hVar != null) {
            hVar.f();
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        v.a(this.T, this.e);
    }

    /* access modifiers changed from: protected */
    public void l() {
        try {
            v.a(this.T);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean r() {
        return !TextUtils.isEmpty(this.J) && this.J.contains("__luban_sdk");
    }

    private void a(final int i2) {
        if (this.c != null && r()) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    z.a((View) TTVideoLandingPageActivity.this.c, i2);
                }
            });
        }
    }

    private void a(boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z2);
            this.i.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z2, JSONArray jSONArray) {
        if (z2 && jSONArray != null && jSONArray.length() > 0) {
            this.O = jSONArray;
        }
    }

    private static class a extends AsyncTask<Void, Void, Drawable> {
        private Bitmap a;
        private WeakReference<b> b;

        private a(Bitmap bitmap, b bVar) {
            this.a = bitmap;
            this.b = new WeakReference<>(bVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap a2 = com.bytedance.sdk.component.adexpress.c.a.a(m.a(), this.a, 25);
                if (a2 == null) {
                    return null;
                }
                return new BitmapDrawable(m.a().getResources(), a2);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Drawable drawable) {
            WeakReference<b> weakReference;
            if (drawable != null && (weakReference = this.b) != null && weakReference.get() != null) {
                ((b) this.b.get()).a(drawable);
            }
        }
    }
}
