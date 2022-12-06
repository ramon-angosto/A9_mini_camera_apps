package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.f;
import com.mbridge.msdk.video.module.a.a.m;
import com.mbridge.msdk.video.module.a.a.n;
import com.mbridge.msdk.video.signal.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.videocommon.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBTempContainer extends AbstractJSContainer {
    /* access modifiers changed from: private */
    public static final String y = MBTempContainer.class.getSimpleName();
    /* access modifiers changed from: private */
    public CampaignEx A;
    private com.mbridge.msdk.videocommon.download.a B;
    /* access modifiers changed from: private */
    public h C;
    private com.mbridge.msdk.video.bt.module.a.b D;
    private String E = "";
    private com.mbridge.msdk.video.signal.factory.b F;
    /* access modifiers changed from: private */
    public int G = com.mbridge.msdk.foundation.same.a.r;
    /* access modifiers changed from: private */
    public int H;
    private boolean I = false;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private String O = "";
    private String P;
    private LayoutInflater Q;
    /* access modifiers changed from: private */
    public int R = 0;
    private int S = 0;
    /* access modifiers changed from: private */
    public View T;
    private boolean U = false;
    /* access modifiers changed from: private */
    public boolean V = false;
    private boolean W = false;
    protected boolean a = false;
    private boolean aa;
    private boolean ab = false;
    /* access modifiers changed from: private */
    public boolean ac = false;
    /* access modifiers changed from: private */
    public boolean ad = false;
    /* access modifiers changed from: private */
    public boolean ae = false;
    /* access modifiers changed from: private */
    public boolean af = false;
    private boolean ag = false;
    private com.mbridge.msdk.mbsignalcommon.mraid.d ah;
    /* access modifiers changed from: private */
    public Runnable ai = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.T != null) {
                MBTempContainer.this.T.setVisibility(8);
            }
        }
    };
    protected boolean b = false;
    protected a c = new a.C0102a();
    protected WindVaneWebView d;
    protected MBridgeVideoView e;
    protected MBridgeContainerView f;
    protected Handler g = new Handler();
    protected Runnable h = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
            } else {
                int unused = MBTempContainer.this.R = -3;
            }
        }
    };
    protected Runnable i = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
            } else {
                int unused = MBTempContainer.this.R = -4;
            }
        }
    };
    private View z;

    public void preload() {
    }

    public void setMediaPlayerUrl(String str) {
    }

    public MBTempContainer(Context context) {
        super(context);
        init(context);
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.Q = LayoutInflater.from(context);
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void registerErrorListener(a aVar) {
        this.c = aVar;
    }

    public int findID(String str) {
        return k.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return k.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public interface a {
        void a(String str);

        void a(boolean z);

        /* renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a  reason: collision with other inner class name */
        public static class C0102a implements a {
            private boolean a = false;

            public void a(String str) {
                q.d("ActivityErrorListener", str);
                this.a = true;
            }

            public final void a(boolean z) {
                this.a = z;
            }
        }
    }

    public boolean isLoadSuccess() {
        return this.b;
    }

    private int c() {
        j b2 = b(this.A);
        if (b2 != null) {
            return b2.j();
        }
        return 0;
    }

    private boolean d() {
        j b2 = b(this.A);
        if (b2 != null) {
            return b2.m();
        }
        return false;
    }

    private boolean e() {
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.isShowingAlertView();
        }
        return false;
    }

    public void superDefaultLoad(int i2, String str) {
        this.g.removeCallbacks(this.h);
        this.g.removeCallbacks(this.i);
        this.c.a(true);
        WindVaneWebView windVaneWebView = this.d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public void onPause() {
        super.onPause();
        this.W = true;
        try {
            getJSVideoModule().videoOperate(2);
        } catch (Throwable th) {
            q.a(y, th.getMessage(), th);
        }
    }

    public void onResume() {
        Runnable runnable;
        super.onResume();
        int i2 = this.R;
        if (i2 == -3) {
            runnable = this.h;
        } else {
            runnable = i2 == -4 ? this.i : null;
        }
        if (runnable != null) {
            runnable.run();
            this.R = 0;
        }
        try {
            if (this.e != null && !e() && !this.e.isMiniCardShowing() && !com.mbridge.msdk.foundation.b.b.c) {
                this.e.setCover(false);
            }
            if (this.W && !e() && !com.mbridge.msdk.foundation.b.b.c) {
                getJSVideoModule().videoOperate(1);
            }
            if (this.j != null) {
                u.a(this.j.getWindow().getDecorView());
            }
            if (this.ab && this.ac && this.j != null) {
                this.j.finish();
            }
        } catch (Throwable th) {
            q.a(y, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
        }
    }

    public void onDestroy() {
        if (!this.I) {
            boolean z2 = true;
            this.I = true;
            super.onDestroy();
            try {
                if (this.e != null) {
                    this.e.releasePlayer();
                }
                if (this.d != null) {
                    ViewGroup viewGroup = (ViewGroup) this.d.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.d.clearWebView();
                    this.d.release();
                }
                if (this.D != null) {
                    this.D = null;
                }
                this.g.removeCallbacks(this.h);
                this.g.removeCallbacks(this.i);
                getJSCommon().e();
                if (this.r) {
                    com.mbridge.msdk.b.b.a().e(this.k);
                }
                if (!this.U) {
                    this.U = true;
                    if (this.A != null && this.A.getPlayable_ads_without_video() == 2) {
                        this.V = true;
                    }
                    if (this.C != null) {
                        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.n || this.t == com.mbridge.msdk.foundation.same.a.o)) {
                            h hVar = this.C;
                            if (this.H != 1) {
                                z2 = false;
                            }
                            hVar.a(z2, this.G);
                        }
                        if (!this.V) {
                            this.o.a(0);
                        }
                        this.C.a(this.V, this.o);
                    }
                    this.g.removeCallbacks(this.ai);
                    if (((!this.r && !this.w) || (this.A != null && this.A.isDynamicView())) && this.V) {
                        q.a(y, "sendToServerRewardInfo");
                        com.mbridge.msdk.video.module.b.a.a(this.A, this.o, this.k, this.n, this.P);
                    }
                    if (!this.w) {
                        if (this.r) {
                            com.mbridge.msdk.videocommon.a.b(287, this.A);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, this.A);
                        }
                    }
                    if (this.f != null) {
                        this.f.release();
                    }
                }
            } catch (Throwable th) {
                q.a(y, th.getMessage());
                return;
            }
            if (!this.aa) {
                f();
            }
            if (this.ah != null) {
                this.ah.d();
            }
            if (!this.w) {
                if (isLoadSuccess()) {
                    this.g.postDelayed(new Runnable() {
                        public final void run() {
                            if (MBTempContainer.this.j != null) {
                                MBTempContainer.this.j.finish();
                            }
                        }
                    }, 100);
                } else if (this.j != null) {
                    this.j.finish();
                }
            }
            if (!this.aa) {
                f();
            }
            com.mbridge.msdk.video.bt.a.c.a().e(this.E);
        }
    }

    private void f() {
        com.mbridge.msdk.foundation.same.report.c cVar = new com.mbridge.msdk.foundation.same.report.c(getContext());
        CampaignEx campaignEx = this.A;
        if (campaignEx != null) {
            cVar.a(campaignEx.getRequestId(), this.A.getRequestIdNotice(), this.A.getId(), this.k, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.A.getId()), this.A.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.A.getId());
            this.aa = true;
        }
    }

    public void setShowingTransparent() {
        int a2;
        this.ab = d();
        if (!this.ab && (a2 = k.a(getContext(), "mbridge_reward_theme", TtmlNode.TAG_STYLE)) > 1 && this.j != null) {
            this.j.setTheme(a2);
        }
    }

    public void receiveSuccess() {
        q.a(y, "receiveSuccess ,start hybrid");
        this.g.removeCallbacks(this.i);
        this.g.postDelayed(this.ai, 250);
    }

    public void defaultLoad(int i2, String str) {
        int i3;
        int i4;
        superDefaultLoad(i2, str);
        if (!isLoadSuccess()) {
            a(i2, str);
            if (this.j != null) {
                this.j.finish();
            }
        } else if (this.A.getPlayable_ads_without_video() == 2) {
            this.f.setCampaign(this.A);
            this.f.setUnitID(this.k);
            if (this.A.getCbd() > -2) {
                i4 = this.A.getCbd();
            } else {
                i4 = this.m.n();
            }
            this.f.setCloseDelayTime(i4);
            this.f.setPlayCloseBtnTm(this.m.h());
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new c(), this.m.x(), this.w));
            this.f.preLoadData(this.F);
            this.f.showPlayableView();
        } else {
            a(i2, str);
            this.T.setVisibility(8);
            loadModuleDatas();
            int f2 = this.m.f();
            int c2 = c();
            int i5 = c2 != 0 ? c2 : f2;
            CampaignEx campaignEx = this.A;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                this.e.setContainerViewOnNotifyListener(new b(this.j, this.A));
            }
            CampaignEx campaignEx2 = this.A;
            if (campaignEx2 == null || campaignEx2.getVst() <= -2) {
                i3 = this.m.e();
            } else {
                i3 = this.A.getVst();
            }
            int i6 = i3;
            this.e.setVideoSkipTime(i6);
            MBridgeVideoView mBridgeVideoView = this.e;
            mBridgeVideoView.setNotifyListener(new m(mBridgeVideoView, this.f, this.A, this.o, this.B, b(), this.k, i5, i6, new e(), this.m.x(), this.w, this.m.B()));
            this.e.defaultShow();
            MBridgeContainerView mBridgeContainerView = this.f;
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.e, mBridgeContainerView, this.A, this.o, this.B, b(), this.k, new b(this.j, this.A), this.m.x(), this.w));
            this.f.defaultShow();
        }
    }

    public int getLayoutID() {
        return findLayout(this.ab ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public WindVaneWebView findWindVaneWebView() {
        a.C0105a aVar;
        try {
            if (!this.w) {
                if (this.r) {
                    aVar = com.mbridge.msdk.videocommon.a.a(287, this.A);
                } else {
                    aVar = com.mbridge.msdk.videocommon.a.a(94, this.A);
                }
                if (aVar == null || !aVar.c()) {
                    return null;
                }
                if (this.r) {
                    com.mbridge.msdk.videocommon.a.b(287, this.A);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.A);
                }
                WindVaneWebView a2 = aVar.a();
                if (this.ab) {
                    a2.setWebViewTransparent();
                }
                return a2;
            } else if (this.A == null || this.A.getRewardTemplateMode() == null) {
                return null;
            } else {
                a.C0105a a3 = com.mbridge.msdk.videocommon.a.a(this.k + "_" + this.A.getId() + "_" + this.A.getRequestId() + "_" + this.A.getRewardTemplateMode().e());
                if (a3 != null) {
                    return a3.a();
                }
                return null;
            }
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public boolean initViews() {
        this.T = findViewById(findID("mbridge_video_templete_progressbar"));
        return this.T != null;
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.f;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.ab && (mBridgeVideoView2 = this.e) != null) {
            mBridgeVideoView2.notifyVideoClose();
        } else if (!this.ad || (mBridgeVideoView = this.e) == null) {
            if (!this.af || (mBridgeContainerView2 = this.f) == null) {
                if (this.ae && (mBridgeContainerView = this.f) != null) {
                    mBridgeContainerView.onEndcardBackPress();
                }
                if (getJSCommon().b()) {
                    if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                        getActivityProxy().g();
                    }
                } else if (!canBackPress()) {
                    q.a(y, "onBackPressed can't excute");
                } else if (this.j != null && !this.w && !this.ag) {
                    this.ag = true;
                    this.j.onBackPressed();
                }
            } else {
                mBridgeContainerView2.onPlayableBackPress();
            }
        } else if (mBridgeVideoView.isMiniCardShowing()) {
            MBridgeContainerView mBridgeContainerView3 = this.f;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
            }
        } else {
            this.e.onBackPress();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c A[Catch:{ all -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            com.mbridge.msdk.foundation.entity.m r0 = new com.mbridge.msdk.foundation.entity.m     // Catch:{ all -> 0x00a7 }
            r0.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = "2000037"
            r0.o(r1)     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r1.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "code="
            r1.append(r2)     // Catch:{ all -> 0x00a7 }
            r1.append(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = ",desc="
            r1.append(r4)     // Catch:{ all -> 0x00a7 }
            r1.append(r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00a7 }
            r0.j(r4)     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.e()     // Catch:{ all -> 0x00a7 }
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            r0.i(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r3.k     // Catch:{ all -> 0x00a7 }
            r0.m(r4)     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x0052
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = r4.getId()     // Catch:{ all -> 0x00a7 }
        L_0x0052:
            r0.n(r5)     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x006e
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x006e
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x00a7 }
            r0.k(r4)     // Catch:{ all -> 0x00a7 }
        L_0x006e:
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x0087
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x0087
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.A     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x00a7 }
            r0.l(r4)     // Catch:{ all -> 0x00a7 }
        L_0x0087:
            android.content.Context r4 = r3.getContext()     // Catch:{ all -> 0x00a7 }
            int r4 = com.mbridge.msdk.foundation.tools.m.n(r4)     // Catch:{ all -> 0x00a7 }
            r0.c((int) r4)     // Catch:{ all -> 0x00a7 }
            android.content.Context r5 = r3.getContext()     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.m.a((android.content.Context) r5, (int) r4)     // Catch:{ all -> 0x00a7 }
            r0.r(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = com.mbridge.msdk.foundation.entity.m.e((com.mbridge.msdk.foundation.entity.m) r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = r3.k     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.video.module.b.a.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00a7 }
            goto L_0x00b1
        L_0x00a7:
            r4 = move-exception
            java.lang.String r5 = y
            java.lang.String r0 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r5, r0, r4)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.a(int, java.lang.String):void");
    }

    private int g() {
        try {
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b2 == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b2 != null) {
                return (int) b2.f();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private final class e extends f {
        private e() {
        }

        public final void a(int i, Object obj) {
            super.a(i, obj);
            if (MBTempContainer.this.r) {
                try {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            int unused = MBTempContainer.this.G = jSONObject.getInt("Alert_window_status");
                            int unused2 = MBTempContainer.this.H = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (Exception e) {
                    q.d("NotifyListener", e.getMessage());
                }
            }
            boolean z = false;
            if (i != 2) {
                if (i == 121) {
                    boolean unused3 = MBTempContainer.this.V = true;
                    MBTempContainer.this.C.a(MBTempContainer.this.l, MBTempContainer.this.k);
                    boolean unused4 = MBTempContainer.this.ad = false;
                    return;
                } else if (i == 16) {
                    MBTempContainer.this.getJSCommon().d();
                    return;
                } else if (i != 17) {
                    switch (i) {
                        case 10:
                            boolean unused5 = MBTempContainer.this.ad = true;
                            if (MBTempContainer.this.A != null) {
                                z = MBTempContainer.this.A.isDynamicView();
                            }
                            if (!z) {
                                MBTempContainer.this.C.a();
                            } else if (!MBTempContainer.this.w) {
                                MBTempContainer.this.C.a();
                            }
                            com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.A, MBTempContainer.this.k);
                            return;
                        case 11:
                        case 12:
                            break;
                        default:
                            return;
                    }
                } else {
                    boolean unused6 = MBTempContainer.this.V = true;
                    return;
                }
            }
            if (i == 12) {
                String str2 = "Play error but has no message.";
                try {
                    if (obj instanceof String) {
                        str2 = obj.toString();
                    }
                } catch (Throwable th) {
                    q.d("NotifyListener", th.getMessage());
                }
                com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.A, MBTempContainer.this.k, str2);
                if (!MBTempContainer.this.ad) {
                    if (MBTempContainer.this.m.B() == 0) {
                        MBTempContainer.this.C.a("play error");
                        boolean unused7 = MBTempContainer.this.ad = false;
                        MBTempContainer.l(MBTempContainer.this);
                        return;
                    }
                    MBTempContainer.this.C.a();
                }
            }
            MBTempContainer.this.getJSVideoModule().videoOperate(3);
            boolean unused8 = MBTempContainer.this.ad = false;
        }
    }

    private final class b extends com.mbridge.msdk.video.module.a.a.a {
        public b(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        public final void a(int i, Object obj) {
            String str = "";
            if (i != 108) {
                if (i != 113) {
                    if (i != 117) {
                        if (i != 126 && i != 128) {
                            switch (i) {
                                case 103:
                                case 104:
                                    MBTempContainer.l(MBTempContainer.this);
                                    break;
                                case 105:
                                    com.mbridge.msdk.video.signal.c jSCommon = MBTempContainer.this.getJSCommon();
                                    if (obj != null) {
                                        str = obj.toString();
                                    }
                                    jSCommon.click(1, str);
                                    break;
                                case 106:
                                    break;
                            }
                        } else {
                            MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
                        }
                    } else {
                        if (MBTempContainer.this.e != null) {
                            MBTempContainer.this.e.setVisible(4);
                        }
                        boolean unused = MBTempContainer.this.ae = true;
                        MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
                    }
                }
                MBTempContainer.this.C.a(true, MBTempContainer.this.l, MBTempContainer.this.k);
            } else {
                MBTempContainer.this.getJSCommon().a((c.a) new c.b(MBTempContainer.this.getJSCommon(), new d()));
                com.mbridge.msdk.video.signal.c jSCommon2 = MBTempContainer.this.getJSCommon();
                if (obj != null) {
                    str = obj.toString();
                }
                jSCommon2.click(1, str);
            }
            super.a(i, obj);
        }
    }

    private final class c extends f {
        private c() {
        }

        public final void a(int i, Object obj) {
            String str;
            super.a(i, obj);
            try {
                if (obj instanceof JSONObject) {
                    str = obj.toString();
                } else {
                    str = (String) obj;
                }
                if (MBTempContainer.this.r && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("type");
                    int i3 = jSONObject.getInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (i2 == 2) {
                        int unused = MBTempContainer.this.G = com.mbridge.msdk.foundation.same.a.t;
                    } else if (i2 != 3) {
                        int unused2 = MBTempContainer.this.G = com.mbridge.msdk.foundation.same.a.r;
                    } else {
                        int unused3 = MBTempContainer.this.G = com.mbridge.msdk.foundation.same.a.s;
                    }
                    int unused4 = MBTempContainer.this.H = i3;
                }
            } catch (Exception unused5) {
                q.d("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i == 120) {
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i == 126) {
                MBTempContainer.this.C.a(false, MBTempContainer.this.l, MBTempContainer.this.k);
            } else if (i != 127) {
                switch (i) {
                    case 100:
                        boolean unused6 = MBTempContainer.this.af = true;
                        MBTempContainer.this.g.postDelayed(MBTempContainer.this.ai, 250);
                        MBTempContainer.this.C.a();
                        return;
                    case 101:
                    case 102:
                        MBTempContainer.this.getJSCommon().d();
                        return;
                    case 103:
                        boolean unused7 = MBTempContainer.this.V = true;
                        if (MBTempContainer.this.A.isMraid()) {
                            MBTempContainer.l(MBTempContainer.this);
                            return;
                        } else {
                            MBTempContainer.this.getJSCommon().d();
                            return;
                        }
                    case 104:
                        MBTempContainer.l(MBTempContainer.this);
                        return;
                    case 105:
                        MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        return;
                    default:
                        return;
                }
            } else {
                boolean unused8 = MBTempContainer.this.V = true;
                MBTempContainer.this.C.a();
                MBTempContainer.this.C.b(MBTempContainer.this.l, MBTempContainer.this.k);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
            }
        }
    }

    private class d extends c.a {
        private d() {
        }

        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.C(MBTempContainer.this);
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            boolean unused = MBTempContainer.this.ac = true;
            MBTempContainer.D(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals("1.0") && MBTempContainer.this.j != null) {
                        if (MBTempContainer.this.w) {
                            MBTempContainer.l(MBTempContainer.this);
                        } else {
                            MBTempContainer.this.j.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.D(MBTempContainer.this);
            boolean unused = MBTempContainer.this.ac = true;
        }

        public final void a(boolean z) {
            super.a(z);
            MBTempContainer.this.C.a(z, MBTempContainer.this.l, MBTempContainer.this.k);
        }

        public final void a(int i, String str) {
            super.a(i, str);
            MBTempContainer.this.defaultLoad(i, str);
        }

        public final void b() {
            super.b();
            if (MBTempContainer.this.g != null) {
                MBTempContainer.this.g.removeCallbacks(MBTempContainer.this.h);
            }
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.A = campaignEx;
        com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
        a2.a(this.k + "_" + 1, campaignEx);
    }

    public CampaignEx getCampaign() {
        return this.A;
    }

    public void setCampaignExpired(boolean z2) {
        try {
            if (this.A == null) {
                return;
            }
            if (z2) {
                this.A.setSpareOfferFlag(1);
                if (this.m == null) {
                    return;
                }
                if (this.m.x() == 1) {
                    this.A.setCbt(1);
                } else {
                    this.A.setCbt(0);
                }
            } else {
                this.A.setSpareOfferFlag(0);
                this.A.setCbt(0);
            }
        } catch (Exception e2) {
            q.d(y, e2.getMessage());
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.B = aVar;
    }

    public void setShowRewardListener(h hVar) {
        this.C = hVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.D = bVar;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.F = bVar;
    }

    public void setInstanceId(String str) {
        this.E = str;
    }

    public String getInstanceId() {
        return this.E;
    }

    public void setWebViewFront(int i2) {
        this.S = i2;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        this.J = i2;
        this.K = i3;
        this.L = i4;
        this.M = i5;
        this.N = i6;
        this.O = com.mbridge.msdk.foundation.tools.h.a(i2, i3, i4, i5, i6);
        q.d(y, this.O);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.O)) {
            getJSCommon().b(this.O);
            if (this.d != null && !TextUtils.isEmpty(this.O)) {
                g.a().a((WebView) this.d, "oncutoutfetched", Base64.encodeToString(this.O.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.e;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i3, i4, i5, i6);
        }
        MBridgeContainerView mBridgeContainerView = this.f;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i2, i3, i4, i5, i6);
        }
    }

    public void setDeveloperExtraData(String str) {
        this.P = str;
    }

    public void onCreate() {
        ViewGroup viewGroup;
        int i2;
        int i3;
        if (this.m == null) {
            this.m = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.k, this.r);
        }
        this.ag = false;
        try {
            if (!this.w) {
                this.C = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.r, this.m, this.A, this.C, b(), this.k);
            } else if (this.A == null || !this.A.isDynamicView()) {
                this.C = new com.mbridge.msdk.video.bt.module.b.c(this.D, this.E);
            } else {
                this.C = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.r, this.m, this.A, this.C, b(), this.k);
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.b.e(this.C));
            a(this.m, this.A);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            this.z = this.Q.inflate(layoutID, (ViewGroup) null);
            addView(this.z, new RelativeLayout.LayoutParams(-1, -1));
            if (this.a) {
                setMatchParent();
            }
            this.d = findWindVaneWebView();
            this.e = findMBridgeVideoView();
            this.e.setVideoLayout(this.A);
            this.e.setIsIV(this.r);
            this.e.setUnitId(this.k);
            if (this.w) {
                this.e.setNotchPadding(this.K, this.L, this.M, this.N);
            }
            this.f = findMBridgeContainerView();
            if (this.w) {
                this.f.setNotchPadding(this.J, this.K, this.L, this.M, this.N);
            }
            if (!((this.e == null || this.f == null || !initViews()) ? false : true)) {
                this.c.a("not found View IDS");
                if (this.j != null) {
                    this.j.finish();
                    return;
                }
                return;
            }
            this.b = true;
            WindVaneWebView windVaneWebView = this.d;
            this.F = new com.mbridge.msdk.video.signal.factory.b(this.j, windVaneWebView, this.e, this.f, this.A, new d());
            registerJsFactory(this.F);
            com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
            a2.a(this.k + "_" + 1, (com.mbridge.msdk.foundation.b.a) new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    String str;
                    MBTempContainer.this.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBTempContainer.y, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBTempContainer.y, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(MBTempContainer.y, th.getMessage(), th);
                        str2 = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            if (windVaneWebView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.z.findViewById(k.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
                windVaneWebView.setApiManagerJSFactory(this.F);
                if (windVaneWebView.getParent() != null) {
                    defaultLoad(0, "preload template webview is null or load error");
                    return;
                }
                if (windVaneWebView.getObject() instanceof j) {
                    this.F.a((j) windVaneWebView.getObject());
                    getJSCommon().a(this.q);
                    getJSCommon().a(this.k);
                    getJSCommon().a(this.m);
                    getJSCommon().a((c.a) new d());
                    if (this.A != null && (this.A.isMraid() || this.A.isActiveOm())) {
                        this.ah = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                        this.ah.c();
                        this.ah.a();
                        this.ah.a(new d.b() {
                            public final void a(double d) {
                                String a2 = MBTempContainer.y;
                                q.d(a2, "volume is : " + d);
                                try {
                                    if (MBTempContainer.this.A.isMraid() && MBTempContainer.this.f != null && MBTempContainer.this.f.getH5EndCardView() != null) {
                                        MBTempContainer.this.f.getH5EndCardView().volumeChange(d);
                                    }
                                } catch (Exception e) {
                                    q.d(MBTempContainer.y, e.getMessage());
                                }
                            }
                        });
                    }
                    getJSContainerModule().readyStatus(((j) windVaneWebView.getObject()).o());
                    if (this.d != null) {
                        int i4 = getResources().getConfiguration().orientation;
                        if (d()) {
                            i3 = u.i(getContext());
                            i2 = u.j(getContext());
                            if (u.a(getContext())) {
                                int k = u.k(getContext());
                                if (i4 == 2) {
                                    i3 += k;
                                } else {
                                    i2 += k;
                                }
                            }
                        } else {
                            i3 = u.h(getContext());
                            i2 = u.g(getContext());
                        }
                        int c2 = this.A.getRewardTemplateMode().c();
                        if (c(this.A) == 1) {
                            c2 = i4;
                        }
                        getJSNotifyProxy().a(i4, c2, i3, i2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.j, (double) u.d(getContext()));
                        try {
                            if (this.o != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", this.o.a());
                                jSONObject2.put(RewardPlus.AMOUNT, this.o.b());
                                jSONObject2.put("id", this.p);
                                jSONObject.put("userId", this.n);
                                jSONObject.put("reward", jSONObject2);
                                jSONObject.put("playVideoMute", this.q);
                                jSONObject.put("extra", this.P);
                            }
                        } catch (JSONException e2) {
                            q.a(y, e2.getMessage());
                        } catch (Exception e3) {
                            q.a(y, e3.getMessage());
                        }
                        getJSNotifyProxy().a((Object) jSONObject.toString());
                        g.a().a((WebView) this.d, "oncutoutfetched", Base64.encodeToString(this.O.getBytes(), 0));
                        getJSCommon().b(true);
                        loadModuleDatas();
                        this.g.postDelayed(this.h, 2000);
                    }
                    ((j) windVaneWebView.getObject()).l.a();
                    if (this.w) {
                        getJSCommon().e(this.S);
                    }
                }
                if (getJSCommon().a() == 1 && (viewGroup = (ViewGroup) this.z.findViewById(k.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
                    ((ViewGroup) this.z).removeView(viewGroup);
                    ((ViewGroup) this.z).addView(viewGroup, 1);
                }
                viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            defaultLoad(0, "preload template webview is null or load error");
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        } catch (Throwable th) {
            a("onCreate error" + th);
        }
    }

    public void loadModuleDatas() {
        int i2;
        int i3;
        int i4;
        j b2 = b(this.A);
        if (b2 != null) {
            i2 = b2.k();
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            this.q = i2;
        }
        int f2 = this.m.f();
        int c2 = c();
        int i5 = c2 != 0 ? c2 : f2;
        this.e.setSoundState(this.q);
        this.e.setCampaign(this.A);
        this.e.setPlayURL(this.B.n());
        CampaignEx campaignEx = this.A;
        if (campaignEx == null || campaignEx.getVst() <= -2) {
            i3 = this.m.e();
        } else {
            i3 = this.A.getVst();
        }
        this.e.setVideoSkipTime(i3);
        this.e.setCloseAlert(this.m.i());
        this.e.setBufferTimeout(g());
        MBridgeVideoView mBridgeVideoView = this.e;
        n nVar = r3;
        int i6 = i3;
        n nVar2 = new n(this.F, this.A, this.o, this.B, b(), this.k, i5, i3, new e(), this.m.x(), this.w, this.m.B());
        mBridgeVideoView.setNotifyListener(nVar);
        this.e.setShowingTransparent(this.ab);
        if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.n || this.t == com.mbridge.msdk.foundation.same.a.o)) {
            this.e.setIVRewardEnable(this.t, this.u, this.v);
            this.e.setDialogRole(getJSCommon() != null ? getJSCommon().h() : 1);
        }
        this.f.setCampaign(this.A);
        this.f.setUnitID(this.k);
        if (this.A.getCbd() > -2) {
            i4 = this.A.getCbd();
        } else {
            i4 = this.m.n();
        }
        this.f.setCloseDelayTime(i4);
        this.f.setPlayCloseBtnTm(this.m.h());
        this.f.setVideoInteractiveType(this.m.g());
        this.f.setEndscreenType(this.m.o());
        this.f.setVideoSkipTime(i6);
        this.f.setShowingTransparent(this.ab);
        this.f.setJSFactory(this.F);
        if (this.A.getPlayable_ads_without_video() == 2) {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.A, this.B, this.o, b(), this.k, new c(), this.m.x(), this.w));
            this.f.preLoadData(this.F);
            this.f.showPlayableView();
        } else {
            this.f.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.F, this.A, this.o, this.B, b(), this.k, new b(this.j, this.A), this.m.x(), this.w));
            this.f.preLoadData(this.F);
            this.e.preLoadData(this.F);
        }
        if (this.ab) {
            this.f.setMBridgeClickMiniCardViewTransparent();
        }
    }

    static /* synthetic */ void l(MBTempContainer mBTempContainer) {
        try {
            if (mBTempContainer.D != null) {
                if (mBTempContainer.r && (mBTempContainer.t == com.mbridge.msdk.foundation.same.a.n || mBTempContainer.t == com.mbridge.msdk.foundation.same.a.o)) {
                    com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.D;
                    boolean z2 = true;
                    if (mBTempContainer.H != 1) {
                        z2 = false;
                    }
                    bVar.a(z2, mBTempContainer.G);
                }
                mBTempContainer.D.a(mBTempContainer.E, mBTempContainer.V, mBTempContainer.o);
            } else if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        } catch (Exception unused) {
            if (mBTempContainer.j != null) {
                mBTempContainer.j.finish();
            }
        }
    }

    static /* synthetic */ void C(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.T.setBackgroundColor(0);
                    MBTempContainer.this.T.setVisibility(0);
                    MBTempContainer.this.T.bringToFront();
                }
            });
        }
    }

    static /* synthetic */ void D(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.j.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.T.setVisibility(8);
                }
            });
        }
    }
}
