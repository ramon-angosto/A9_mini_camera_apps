package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.widget.FeedBackButton;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBridgeH5EndCardView extends MBridgeBaseView implements com.mbridge.msdk.mbsignalcommon.mraid.b, g {
    private int A = 1;
    private int B = 1;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public boolean D = false;
    /* access modifiers changed from: private */
    public int E = 1;
    /* access modifiers changed from: private */
    public long F = 0;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public boolean H = false;
    private boolean I = false;
    private boolean J = false;
    /* access modifiers changed from: private */
    public boolean K = false;
    /* access modifiers changed from: private */
    public boolean L = false;
    /* access modifiers changed from: private */
    public boolean M = false;
    private boolean N = false;
    /* access modifiers changed from: private */
    public String O = "";
    private boolean P = false;
    private boolean Q = false;
    protected View m;
    protected RelativeLayout n;
    protected ImageView o;
    protected WindVaneWebView p;
    protected Handler q = new Handler();
    protected String r;
    protected boolean s = false;
    protected boolean t = false;
    protected String u;
    Handler v = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                if (MBridgeH5EndCardView.this.G) {
                    MBridgeH5EndCardView.this.e.a(122, "");
                }
                MBridgeH5EndCardView.this.e.a(103, "");
            }
        }
    };
    boolean w = false;
    /* access modifiers changed from: private */
    public FeedBackButton x;
    private boolean y = false;
    private boolean z = false;

    public void expand(String str, boolean z2) {
    }

    public void install(CampaignEx campaignEx) {
    }

    public void readyStatus(int i) {
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_h5");
        if (findLayout >= 0) {
            this.m = this.c.inflate(findLayout, (ViewGroup) null);
            View view = this.m;
            this.o = (ImageView) view.findViewById(findID("mbridge_windwv_close"));
            this.n = (RelativeLayout) view.findViewById(findID("mbridge_windwv_content_rl"));
            this.p = new WindVaneWebView(getContext());
            this.p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.n.addView(this.p);
            this.f = isNotNULL(this.o, this.p);
            addView(this.m, b());
            c();
            e();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.p != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.p, "onSystemDestory", "");
                new Thread(new a(this)).start();
                return;
            }
            this.e.a(103, "");
            this.e.a(119, "webview is null when closing webview");
        } catch (Exception e2) {
            this.e.a(103, "");
            com.mbridge.msdk.video.module.a.a aVar = this.e;
            aVar.a(119, "close webview exception" + e2.getMessage());
            q.a(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    private class a implements Runnable {
        private MBridgeH5EndCardView b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                q.d("CloseRunnable", e.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.v != null) {
                this.b.v.sendEmptyMessage(100);
            }
        }
    }

    public void setError(boolean z2) {
        this.t = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe A[Catch:{ all -> 0x0102 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r10) {
        /*
            r9 = this;
            java.lang.String r0 = "wfr=1"
            java.lang.String r1 = "="
            java.lang.String r3 = r9.a()
            boolean r2 = r9.f
            r8 = 0
            if (r2 == 0) goto L_0x0149
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r9.b
            if (r2 == 0) goto L_0x0149
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0149
            long r4 = java.lang.System.currentTimeMillis()
            r9.F = r4
            java.lang.String r2 = "start"
            r9.reportRenderResult(r2, r8)     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            com.mbridge.msdk.foundation.webview.BrowserView$MBDownloadListener r2 = new com.mbridge.msdk.foundation.webview.BrowserView$MBDownloadListener
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r9.b
            r2.<init>(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r9.b
            java.lang.String r4 = r4.getAppName()
            r2.setTitle(r4)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.p
            r4.setDownloadListener(r2)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r9.p
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r9.b
            java.lang.String r4 = r4.getId()
            r2.setCampaignId(r4)
            r2 = 8
            r9.setCloseVisible(r2)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r9.p
            r2.setApiManagerJSFactory(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.b
            boolean r10 = r10.isMraid()
            if (r10 == 0) goto L_0x0059
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r10 = r9.p
            r10.setMraidObject(r9)
        L_0x0059:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r10 = r9.p
            com.mbridge.msdk.video.module.MBridgeH5EndCardView$3 r2 = new com.mbridge.msdk.video.module.MBridgeH5EndCardView$3
            r2.<init>()
            r10.setWebViewListener(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.b
            java.lang.String r10 = r10.getMraid()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r2 = "MBridgeBaseView"
            if (r10 == 0) goto L_0x010a
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0102 }
            r9.F = r4     // Catch:{ all -> 0x0102 }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.b     // Catch:{ all -> 0x0102 }
            java.lang.String r10 = r10.getendcard_url()     // Catch:{ all -> 0x0102 }
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0102 }
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = r5.h()     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = r9.u     // Catch:{ all -> 0x0102 }
            com.mbridge.msdk.videocommon.d.c r4 = r4.a(r5, r6)     // Catch:{ all -> 0x0102 }
            boolean r5 = r9.z     // Catch:{ all -> 0x0102 }
            if (r5 == 0) goto L_0x010a
            boolean r5 = com.mbridge.msdk.foundation.tools.x.b(r10)     // Catch:{ all -> 0x0102 }
            if (r5 == 0) goto L_0x010a
            boolean r5 = r10.contains(r0)     // Catch:{ all -> 0x0102 }
            if (r5 != 0) goto L_0x00a7
            if (r4 == 0) goto L_0x010a
            int r5 = r4.m()     // Catch:{ all -> 0x0102 }
            if (r5 <= 0) goto L_0x010a
        L_0x00a7:
            boolean r0 = r10.contains(r0)     // Catch:{ all -> 0x0102 }
            r5 = 20
            if (r0 == 0) goto L_0x00ea
            java.lang.String r0 = "&"
            java.lang.String[] r10 = r10.split(r0)     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x00f7
            int r0 = r10.length     // Catch:{ all -> 0x0102 }
            if (r0 <= 0) goto L_0x00f7
            int r0 = r10.length     // Catch:{ all -> 0x0102 }
            r4 = r8
        L_0x00bc:
            if (r4 >= r0) goto L_0x00f7
            r6 = r10[r4]     // Catch:{ all -> 0x0102 }
            boolean r7 = com.mbridge.msdk.foundation.tools.x.b(r6)     // Catch:{ all -> 0x0102 }
            if (r7 == 0) goto L_0x00e7
            java.lang.String r7 = "to"
            boolean r7 = r6.contains(r7)     // Catch:{ all -> 0x0102 }
            if (r7 == 0) goto L_0x00e7
            java.lang.String[] r7 = r6.split(r1)     // Catch:{ all -> 0x0102 }
            if (r7 == 0) goto L_0x00e7
            java.lang.String[] r7 = r6.split(r1)     // Catch:{ all -> 0x0102 }
            int r7 = r7.length     // Catch:{ all -> 0x0102 }
            if (r7 <= 0) goto L_0x00e7
            java.lang.String[] r10 = r6.split(r1)     // Catch:{ all -> 0x0102 }
            r0 = 1
            r10 = r10[r0]     // Catch:{ all -> 0x0102 }
            int r10 = com.mbridge.msdk.foundation.tools.u.a((java.lang.Object) r10)     // Catch:{ all -> 0x0102 }
            goto L_0x00f8
        L_0x00e7:
            int r4 = r4 + 1
            goto L_0x00bc
        L_0x00ea:
            if (r4 == 0) goto L_0x00f7
            int r10 = r4.m()     // Catch:{ all -> 0x0102 }
            if (r10 <= 0) goto L_0x00f7
            int r10 = r4.m()     // Catch:{ all -> 0x0102 }
            goto L_0x00f8
        L_0x00f7:
            r10 = r5
        L_0x00f8:
            if (r10 < 0) goto L_0x00fe
            r9.excuteEndCardShowTask(r10)     // Catch:{ all -> 0x0102 }
            goto L_0x010a
        L_0x00fe:
            r9.excuteEndCardShowTask(r5)     // Catch:{ all -> 0x0102 }
            goto L_0x010a
        L_0x0102:
            r10 = move-exception
            java.lang.String r0 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r2, r0, r10)
        L_0x010a:
            com.mbridge.msdk.videocommon.download.h r10 = com.mbridge.msdk.videocommon.download.h.a()
            java.lang.String r10 = r10.b(r3)
            r9.setHtmlSource(r10)
            java.lang.String r10 = r9.r
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0137
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "load url:"
            r10.append(r0)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.mbridge.msdk.foundation.tools.q.a(r2, r10)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r10 = r9.p
            r10.loadUrl(r3)
            goto L_0x015f
        L_0x0137:
            java.lang.String r10 = "load html..."
            com.mbridge.msdk.foundation.tools.q.a(r2, r10)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r9.p
            java.lang.String r4 = r9.r
            r7 = 0
            java.lang.String r5 = "text/html"
            java.lang.String r6 = "UTF-8"
            r2.loadDataWithBaseURL(r3, r4, r5, r6, r7)
            goto L_0x015f
        L_0x0149:
            r10 = 3
            java.lang.String r0 = "PL URL IS NULL"
            r9.reportRenderResult(r0, r10)
            com.mbridge.msdk.video.module.a.a r10 = r9.e
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r1 = ""
            r10.a(r0, r1)
            com.mbridge.msdk.video.module.a.a r10 = r9.e
            r0 = 129(0x81, float:1.81E-43)
            r10.a(r0, r1)
        L_0x015f:
            r9.w = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void reportRenderResult(String str, int i) {
        if (this.b != null && !this.t) {
            m mVar = new m();
            mVar.k(this.b.getRequestId());
            mVar.l(this.b.getRequestIdNotice());
            mVar.n(this.b.getId());
            mVar.d(i);
            mVar.q(String.valueOf(System.currentTimeMillis() - this.F));
            mVar.p(str);
            String str2 = "2";
            if (this.b.getAdType() == 287) {
                mVar.h(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            } else if (this.b.getAdType() == 94) {
                mVar.h("1");
            } else if (this.b.getAdType() == 42) {
                mVar.h(str2);
            }
            if (this.b.isMraid()) {
                mVar.a(m.a);
            } else {
                mVar.f(this.b.getendcard_url());
                if (x.b(this.b.getendcard_url()) && this.b.getendcard_url().contains(".zip")) {
                    str2 = "1";
                }
                mVar.g(str2);
                mVar.a(m.b);
            }
            com.mbridge.msdk.foundation.same.report.b.b(mVar, this.u);
        }
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.b.getendcard_url();
            int i = 15;
            if (x.b(str) && str.contains("wfl=1")) {
                String[] split = str.split("&");
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (x.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            i = u.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(i);
            }
        } catch (Throwable th) {
            q.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.I = true;
        } else if (i == 1) {
            this.J = true;
        }
    }

    public void toggleCloseBtn(int i) {
        int visibility = this.o.getVisibility();
        if (i == 1) {
            this.H = true;
            visibility = 0;
        } else if (i == 2) {
            this.H = false;
            visibility = 8;
            if (this.w) {
                if (!this.Q && !this.I) {
                    this.Q = true;
                    int i2 = this.B;
                    if (i2 == 0) {
                        this.L = true;
                    } else {
                        this.L = false;
                        if (i2 > -1) {
                            this.q.postDelayed(new e(this), (long) (this.B * 1000));
                        }
                    }
                }
            } else if (!this.P && !this.I) {
                this.P = true;
                int i3 = this.A;
                if (i3 == 0) {
                    this.K = true;
                } else {
                    this.K = false;
                    if (i3 > -1) {
                        this.q.postDelayed(new d(this), (long) (this.A * 1000));
                    }
                }
            }
        }
        setCloseVisible(visibility);
    }

    private class d implements Runnable {
        private MBridgeH5EndCardView b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.K = true;
            }
        }
    }

    private class e implements Runnable {
        private MBridgeH5EndCardView b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.L = true;
            }
        }
    }

    public void handlerPlayableException(String str) {
        if (!this.t) {
            this.t = true;
            this.s = false;
            if (this.b != null) {
                m mVar = new m();
                mVar.k(this.b.getRequestId());
                mVar.l(this.b.getRequestIdNotice());
                mVar.n(this.b.getId());
                mVar.p(str);
                com.mbridge.msdk.foundation.same.report.b.d(mVar, this.a.getApplicationContext(), this.u);
            }
        }
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        q.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.p.getLocationOnScreen(iArr);
                            q.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                            if (g != null) {
                                jSONObject.put("startX", u.a(g, (float) iArr[0]));
                                jSONObject.put("startY", u.a(g, (float) iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.j, (double) u.d(g));
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            q.a(MBridgeBaseView.TAG, th.getMessage(), th);
                            str = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.e.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.p, "oncutoutfetched", Base64.encodeToString(MBridgeH5EndCardView.this.O.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.o;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean isLoadSuccess() {
        return this.s;
    }

    public void setUnitId(String str) {
        this.u = str;
    }

    public void setCloseDelayShowTime(int i) {
        this.A = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.B = i;
    }

    public void setHtmlSource(String str) {
        this.r = str;
    }

    public void setCloseVisible(int i) {
        if (this.f) {
            this.o.setVisibility(i);
        }
    }

    public void setCloseVisibleForMraid(int i) {
        if (this.f) {
            this.M = true;
            if (i == 4) {
                this.o.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.o.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.o.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.f) {
            setMatchParent();
        }
    }

    /* access modifiers changed from: protected */
    public String a() {
        if (this.b != null) {
            this.G = true;
            if (this.b.isMraid()) {
                this.z = false;
                String mraid = this.b.getMraid();
                if (TextUtils.isEmpty(mraid)) {
                    return this.b.getEndScreenUrl();
                }
                File file = new File(mraid);
                try {
                    if (!file.exists() || !file.isFile() || !file.canRead()) {
                        return this.b.getEndScreenUrl();
                    }
                    return "file:////" + mraid;
                } catch (Throwable th) {
                    if (!MBridgeConstans.DEBUG) {
                        return mraid;
                    }
                    th.printStackTrace();
                    return mraid;
                }
            } else {
                String str = this.b.getendcard_url();
                if (!x.a(str)) {
                    this.z = true;
                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(str);
                    if (TextUtils.isEmpty(b2)) {
                        try {
                            String path = Uri.parse(str).getPath();
                            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                                String endScreenUrl = this.b.getEndScreenUrl();
                                if (TextUtils.isEmpty(endScreenUrl)) {
                                    return null;
                                }
                                this.z = false;
                                excuteTask();
                                return endScreenUrl;
                            }
                        } catch (Throwable th2) {
                            q.d(MBridgeBaseView.TAG, th2.getMessage());
                        }
                        return str + "&native_adtype=" + this.b.getAdType();
                    }
                    return b2 + "&native_adtype=" + this.b.getAdType();
                }
                this.z = false;
                return this.b.getEndScreenUrl();
            }
        } else {
            this.G = false;
            return null;
        }
    }

    private class f implements Runnable {
        private MBridgeH5EndCardView b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.M) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                boolean unused = this.b.H = true;
            }
        }
    }

    public void excuteTask() {
        if (!this.z && this.A > -1) {
            this.q.postDelayed(new f(this), (long) (this.A * 1000));
        }
    }

    private class b implements Runnable {
        private MBridgeH5EndCardView b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.b;
            if (mBridgeH5EndCardView != null && !mBridgeH5EndCardView.D) {
                boolean unused = this.b.D = true;
                this.b.s = false;
                MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
                this.b.e.a(127, "");
                q.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
            }
        }
    }

    public void executeEndCardShow(int i) {
        this.q.postDelayed(new b(this), (long) (i * 1000));
    }

    public void excuteEndCardShowTask(int i) {
        this.q.postDelayed(new c(this, i), (long) (i * 1000));
    }

    private static class c implements Runnable {
        private MBridgeH5EndCardView a;
        private int b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i) {
            this.a = mBridgeH5EndCardView;
            this.b = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0084 A[Catch:{ Exception -> 0x00aa, all -> 0x00dd }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x008a A[Catch:{ Exception -> 0x00aa, all -> 0x00dd }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                java.lang.String r0 = "MBridgeBaseView"
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a
                if (r1 == 0) goto L_0x00e5
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b
                if (r1 == 0) goto L_0x00e5
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00dd }
                boolean r1 = r1.C     // Catch:{ all -> 0x00dd }
                if (r1 == 0) goto L_0x0018
                java.lang.String r1 = "insertEndCardReadyState hasInsertLoadEndCardReport true return"
                com.mbridge.msdk.foundation.tools.q.b(r0, r1)     // Catch:{ all -> 0x00dd }
                return
            L_0x0018:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00dd }
                r2 = 1
                boolean unused = r1.C = r2     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b     // Catch:{ all -> 0x00dd }
                java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x00dd }
                boolean r1 = com.mbridge.msdk.foundation.tools.x.b(r1)     // Catch:{ all -> 0x00dd }
                java.lang.String r2 = "1"
                java.lang.String r3 = "2"
                if (r1 == 0) goto L_0x0042
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.b     // Catch:{ all -> 0x00dd }
                java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x00dd }
                java.lang.String r4 = ".zip"
                boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x00dd }
                if (r1 == 0) goto L_0x0042
                r12 = r2
                goto L_0x0043
            L_0x0042:
                r12 = r3
            L_0x0043:
                r6 = 12
                java.lang.String r11 = "ready timeout"
                com.mbridge.msdk.foundation.entity.m r1 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x00dd }
                java.lang.String r5 = "2000043"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
                r4.<init>()     // Catch:{ all -> 0x00dd }
                int r7 = r13.b     // Catch:{ all -> 0x00dd }
                int r7 = r7 * 1000
                r4.append(r7)     // Catch:{ all -> 0x00dd }
                java.lang.String r7 = ""
                r4.append(r7)     // Catch:{ all -> 0x00dd }
                java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ all -> 0x00dd }
                java.lang.String r8 = r4.getendcard_url()     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ all -> 0x00dd }
                java.lang.String r9 = r4.getId()     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ all -> 0x00dd }
                java.lang.String r10 = r4.u     // Catch:{ all -> 0x00dd }
                r4 = r1
                r4.<init>((java.lang.String) r5, (int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00aa }
                int r4 = r4.getAdType()     // Catch:{ Exception -> 0x00aa }
                r5 = 287(0x11f, float:4.02E-43)
                if (r4 != r5) goto L_0x008a
                java.lang.String r2 = "3"
                r1.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x008a:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r4 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.b     // Catch:{ Exception -> 0x00aa }
                int r4 = r4.getAdType()     // Catch:{ Exception -> 0x00aa }
                r5 = 94
                if (r4 != r5) goto L_0x009a
                r1.h((java.lang.String) r2)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x009a:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ Exception -> 0x00aa }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ Exception -> 0x00aa }
                int r2 = r2.getAdType()     // Catch:{ Exception -> 0x00aa }
                r4 = 42
                if (r2 != r4) goto L_0x00ae
                r1.h((java.lang.String) r3)     // Catch:{ Exception -> 0x00aa }
                goto L_0x00ae
            L_0x00aa:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x00dd }
            L_0x00ae:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00dd }
                java.lang.String r2 = r2.getRequestId()     // Catch:{ all -> 0x00dd }
                r1.k(r2)     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00dd }
                java.lang.String r2 = r2.getRequestIdNotice()     // Catch:{ all -> 0x00dd }
                r1.l(r2)     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.b     // Catch:{ all -> 0x00dd }
                int r2 = r2.getAdSpaceT()     // Catch:{ all -> 0x00dd }
                r1.b((int) r2)     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r2 = r13.a     // Catch:{ all -> 0x00dd }
                java.lang.String r2 = r2.u     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.foundation.same.report.b.a(r1, r2)     // Catch:{ all -> 0x00dd }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r13.a     // Catch:{ all -> 0x00dd }
                boolean r0 = r1.isLoadSuccess()     // Catch:{ all -> 0x00dd }
                goto L_0x00e5
            L_0x00dd:
                r1 = move-exception
                java.lang.String r2 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.q.a(r0, r2, r1)
            L_0x00e5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.c.run():void");
        }
    }

    public boolean isPlayable() {
        return this.z;
    }

    public void onBackPress() {
        if (this.H || ((this.I && this.J) || ((!this.I && this.K && !this.w) || (!this.I && this.L && this.w)))) {
            onCloseViewClick();
        }
    }

    public void setLoadPlayable(boolean z2) {
        this.w = z2;
    }

    public void release() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.q = null;
        }
        Handler handler2 = this.v;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.v = null;
        }
        this.n.removeAllViews();
        this.p.release();
        this.p = null;
    }

    public void volumeChange(double d2) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) this.p, d2);
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.b != null && this.b.isMraid()) {
            if (z2) {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.p, "true");
            } else {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.p, "false");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && !this.N) {
            this.N = true;
            setFocusableInTouchMode(true);
            requestFocus();
            requestFocusFromTouch();
        }
    }

    public void open(String str) {
        try {
            String clickURL = this.b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.b.setClickURL(str);
                CampaignEx mraidCampaign = getMraidCampaign();
                if (mraidCampaign != null) {
                    new com.mbridge.msdk.foundation.same.report.c(getContext()).b(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.u, str, this.b.isBidCampaign());
                }
            }
            new com.mbridge.msdk.click.a(getContext(), this.u).a(this.b);
            this.b.setClickURL(clickURL);
            this.e.a(126, "");
        } catch (Exception e2) {
            q.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e2) {
            q.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void unload() {
        close();
    }

    public CampaignEx getMraidCampaign() {
        return this.b;
    }

    public void useCustomClose(boolean z2) {
        try {
            setCloseVisibleForMraid(z2 ? 4 : 0);
        } catch (Exception e2) {
            q.d(MBridgeBaseView.TAG, e2.getMessage());
        }
    }

    public void setNotchValue(String str, int i, int i2, int i3, int i4) {
        this.O = str;
        if (this.b != null && this.b.getAdSpaceT() != 2) {
            q.d(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            int b2 = u.b(getContext(), 20.0f);
            layoutParams.setMargins(i + b2, i3 + b2, i2 + b2, i4 + b2);
            this.o.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ NullPointerException -> 0x00ab, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[Catch:{ NullPointerException -> 0x00ab, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[Catch:{ NullPointerException -> 0x00ab, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f A[Catch:{ NullPointerException -> 0x00ab, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8 A[Catch:{ NullPointerException -> 0x00ab, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeH5EndCardView r17, long r18, boolean r20) {
        /*
            r1 = r17
            boolean r0 = r1.C     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0008
            goto L_0x011f
        L_0x0008:
            r2 = 1
            r1.C = r2     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0115 }
            boolean r0 = com.mbridge.msdk.foundation.tools.x.b(r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r3 = "1"
            java.lang.String r4 = "2"
            if (r0 == 0) goto L_0x002b
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = ".zip"
            boolean r0 = r0.contains(r5)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x002b
            r14 = r3
            goto L_0x002c
        L_0x002b:
            r14 = r4
        L_0x002c:
            r0 = 10
            java.lang.String r5 = "ready yes"
            r6 = 2
            if (r20 == 0) goto L_0x003b
            r0 = 12
            java.lang.String r5 = "ready timeout"
            r7 = r0
            r15 = r5
            r13 = r6
            goto L_0x004b
        L_0x003b:
            int r7 = r1.E     // Catch:{ all -> 0x0115 }
            if (r7 != r6) goto L_0x0048
            r0 = 3
            r5 = 11
            java.lang.String r6 = "ready no"
            r13 = r0
            r7 = r5
            r15 = r6
            goto L_0x004b
        L_0x0048:
            r7 = r0
            r13 = r2
            r15 = r5
        L_0x004b:
            com.mbridge.msdk.foundation.entity.m r12 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x0115 }
            java.lang.String r6 = "2000043"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r0.<init>()     // Catch:{ all -> 0x0115 }
            r10 = r18
            r0.append(r10)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = ""
            r0.append(r5)     // Catch:{ all -> 0x0115 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r9 = r0.getendcard_url()     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r1.u     // Catch:{ all -> 0x0115 }
            r16 = r5
            r5 = r12
            r10 = r0
            r11 = r16
            r2 = r12
            r12 = r15
            r20 = r15
            r15 = r13
            r13 = r14
            r5.<init>((java.lang.String) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ab }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ab }
            r5 = 287(0x11f, float:4.02E-43)
            if (r0 != r5) goto L_0x008f
            java.lang.String r0 = "3"
            r2.h((java.lang.String) r0)     // Catch:{ NullPointerException -> 0x00ab }
            goto L_0x00af
        L_0x008f:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ab }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ab }
            r5 = 94
            if (r0 != r5) goto L_0x009d
            r2.h((java.lang.String) r3)     // Catch:{ NullPointerException -> 0x00ab }
            goto L_0x00af
        L_0x009d:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ NullPointerException -> 0x00ab }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x00ab }
            r3 = 42
            if (r0 != r3) goto L_0x00af
            r2.h((java.lang.String) r4)     // Catch:{ NullPointerException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0115 }
        L_0x00af:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getRequestId()     // Catch:{ all -> 0x0115 }
            r2.k(r0)     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0115 }
            r2.l(r0)     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            int r0 = r0.getAdSpaceT()     // Catch:{ all -> 0x0115 }
            r2.b((int) r0)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r1.u     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.same.report.b.a(r2, r0)     // Catch:{ all -> 0x0115 }
            boolean r0 = r17.isLoadSuccess()     // Catch:{ all -> 0x0115 }
            if (r0 != 0) goto L_0x011f
            r3 = 1
            if (r15 != r3) goto L_0x011f
            r2.d((int) r15)     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x0115 }
            r2.q(r0)     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x0115 }
            r2.n(r0)     // Catch:{ all -> 0x0115 }
            r5 = r20
            r2.p(r5)     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            boolean r0 = r0.isMraid()     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x00fe
            int r0 = com.mbridge.msdk.foundation.entity.m.a     // Catch:{ all -> 0x0115 }
            r2.a((int) r0)     // Catch:{ all -> 0x0115 }
            goto L_0x010f
        L_0x00fe:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.b     // Catch:{ all -> 0x0115 }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0115 }
            r2.f((java.lang.String) r0)     // Catch:{ all -> 0x0115 }
            r2.g((java.lang.String) r14)     // Catch:{ all -> 0x0115 }
            int r0 = com.mbridge.msdk.foundation.entity.m.b     // Catch:{ all -> 0x0115 }
            r2.a((int) r0)     // Catch:{ all -> 0x0115 }
        L_0x010f:
            java.lang.String r0 = r1.u     // Catch:{ all -> 0x0115 }
            com.mbridge.msdk.foundation.same.report.b.b(r2, r0)     // Catch:{ all -> 0x0115 }
            goto L_0x011f
        L_0x0115:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.q.a(r2, r1, r0)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.a(com.mbridge.msdk.video.module.MBridgeH5EndCardView, long, boolean):void");
    }

    static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) {
        MBridgeH5EndCardView mBridgeH5EndCardView2 = mBridgeH5EndCardView;
        if (mBridgeH5EndCardView2.b != null && mBridgeH5EndCardView2.b.isMraid()) {
            int i = mBridgeH5EndCardView.getResources().getConfiguration().orientation;
            String str = AdError.UNDEFINED_DOMAIN;
            if (i != 0) {
                if (i == 1) {
                    str = "portrait";
                } else if (i == 2) {
                    str = "landscape";
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("orientation", str);
                jSONObject.put("locked", "true");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", IronSourceConstants.INTERSTITIAL_AD_UNIT);
            hashMap.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            if (mBridgeH5EndCardView.getContext() instanceof Activity) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) mBridgeH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView2.p, (float) com.mbridge.msdk.foundation.tools.m.h(mBridgeH5EndCardView.getContext()), (float) com.mbridge.msdk.foundation.tools.m.i(mBridgeH5EndCardView.getContext()));
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView2.p, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
            }
            com.mbridge.msdk.mbsignalcommon.mraid.a a2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = mBridgeH5EndCardView2.p;
            a2.a(windVaneWebView, (float) windVaneWebView.getLeft(), (float) mBridgeH5EndCardView2.p.getTop(), (float) mBridgeH5EndCardView2.p.getWidth(), (float) mBridgeH5EndCardView2.p.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a a3 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = mBridgeH5EndCardView2.p;
            a3.b(windVaneWebView2, (float) windVaneWebView2.getLeft(), (float) mBridgeH5EndCardView2.p.getTop(), (float) mBridgeH5EndCardView2.p.getWidth(), (float) mBridgeH5EndCardView2.p.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.p, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.p, com.mbridge.msdk.mbsignalcommon.mraid.d.a);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView2.p);
        }
    }

    static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        RelativeLayout.LayoutParams layoutParams;
        if (com.mbridge.msdk.foundation.b.b.a().b()) {
            com.mbridge.msdk.foundation.b.b.a().b(mBridgeH5EndCardView.u + "_" + 1);
            com.mbridge.msdk.foundation.b.b.a().a(mBridgeH5EndCardView.u + "_" + 2, mBridgeH5EndCardView.b);
            com.mbridge.msdk.foundation.b.b.a().a(mBridgeH5EndCardView.u + "_" + 2, (com.mbridge.msdk.foundation.b.a) new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    String str;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBridgeBaseView.TAG, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBridgeBaseView.TAG, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBridgeBaseView.TAG, th.getMessage(), th);
                        str2 = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeH5EndCardView.this.p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            mBridgeH5EndCardView.x = com.mbridge.msdk.foundation.b.b.a().a(mBridgeH5EndCardView.u + "_" + 2);
            FeedBackButton feedBackButton = mBridgeH5EndCardView.x;
            if (feedBackButton != null) {
                try {
                    layoutParams = (RelativeLayout.LayoutParams) feedBackButton.getLayoutParams();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.b.b.a, com.mbridge.msdk.foundation.b.b.b);
                }
                layoutParams.addRule(9);
                ViewGroup viewGroup = (ViewGroup) mBridgeH5EndCardView.x.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(mBridgeH5EndCardView.x);
                }
                mBridgeH5EndCardView.n.addView(mBridgeH5EndCardView.x, layoutParams);
                mBridgeH5EndCardView.n.postDelayed(new Runnable() {
                    public final void run() {
                        MBridgeH5EndCardView.this.x.setVisibility(0);
                    }
                }, 200);
            }
        }
    }
}
