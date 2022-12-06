package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.b.a;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.g;

public class MBridgeContainerView extends MBridgeBaseView implements e, g {
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = true;
    private boolean E = false;
    private boolean F = false;
    private int G;
    private boolean H = false;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private String N;
    private b O;
    private boolean P = false;
    private boolean Q = false;
    private MBridgePlayableView m;
    private MBridgeClickCTAView n;
    private MBridgeClickMiniCardView o;
    private MBridgeNativeEndCardView p;
    private MBridgeH5EndCardView q;
    private MBridgeVastEndCardView r;
    private MBridgeLandingPageView s;
    private MBridgeVideoEndCoverView t;
    private MBridgeAlertWebview u;
    /* access modifiers changed from: private */
    public String v;
    private int w;
    private int x = 1;
    private int y = 1;
    private int z = 1;

    public void setJSFactory(b bVar) {
        this.O = bVar;
    }

    public int getVideoSkipTime() {
        return this.G;
    }

    public void setVideoSkipTime(int i) {
        this.G = i;
    }

    public MBridgeContainerView(Context context) {
        super(context);
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        setVisibility(0);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (MBridgeBaseView mBridgeBaseView : new MBridgeBaseView[]{this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t}) {
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.O = bVar;
        if (this.b != null) {
            if (this.b.getPlayable_ads_without_video() == 2) {
                if (this.m == null) {
                    this.m = new MBridgePlayableView(this.a);
                }
                this.m.setCloseDelayShowTime(this.y);
                this.m.setPlayCloseBtnTm(this.z);
                this.m.setCampaign(this.b);
                this.m.setNotifyListener(new i(this.e) {
                    public final void a(int i, Object obj) {
                        super.a(i, obj);
                        if (i == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            m mVar = new m();
                            mVar.k(MBridgeContainerView.this.b.getRequestId());
                            mVar.l(MBridgeContainerView.this.b.getRequestIdNotice());
                            mVar.n(MBridgeContainerView.this.b.getId());
                            mVar.a(MBridgeContainerView.this.b.isMraid() ? m.a : m.b);
                            com.mbridge.msdk.foundation.same.report.b.a(mVar, MBridgeContainerView.this.a, MBridgeContainerView.this.v);
                        }
                    }
                });
                this.m.preLoadData(bVar);
            } else {
                b(this.w);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                        mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.b.getVideo_end_type()));
                    }
                }, (long) getVideoSkipTime());
            }
            g();
        }
    }

    public void showPlayableView() {
        if (this.b != null && !this.F) {
            removeAllViews();
            setMatchParent();
            if (this.m == null) {
                preLoadData(this.O);
            }
            addView(this.m);
            MBridgePlayableView mBridgePlayableView = this.m;
            if (mBridgePlayableView != null) {
                mBridgePlayableView.setUnitId(this.v);
                if (this.b != null && this.b.isMraid() && this.b.getPlayable_ads_without_video() == 2) {
                    this.m.setCloseVisible(0);
                }
            }
            this.Q = true;
            bringToFront();
        }
    }

    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.u;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.Q) {
            removeAllViews();
            bringToFront();
            this.P = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.u == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.u;
        if (!(mBridgeAlertWebview2 == null || mBridgeAlertWebview2.getParent() == null)) {
            removeView(this.u);
        }
        addView(this.u);
        setBackgroundColor(0);
        this.u.webviewshow();
        return true;
    }

    public void showVideoClickView(int i) {
        if (this.b == null) {
            return;
        }
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    MBridgeClickCTAView mBridgeClickCTAView = this.n;
                    if (!(mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null)) {
                        removeView(this.n);
                    }
                    MBridgeAlertWebview mBridgeAlertWebview = this.u;
                    if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
                        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getParent() == null) {
                            try {
                                if (this.b != null && this.b.getPlayable_ads_without_video() == 1) {
                                    setMatchParent();
                                    f();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (miniCardLoaded()) {
                            MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
                            if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.getParent() == null)) {
                                removeView(this.q);
                            }
                            this.e.a(112, "");
                            if (this.b != null && !this.b.isHasReportAdTrackPause()) {
                                this.b.setHasReportAdTrackPause(true);
                                a.f(this.a, this.b);
                            }
                            if (this.C) {
                                this.e.a(115, "");
                            } else {
                                this.Q = true;
                                bringToFront();
                                webviewshow();
                                onConfigurationChanged(getResources().getConfiguration());
                            }
                            this.B = true;
                            return;
                        }
                        h();
                    }
                }
            } else if (!this.A) {
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.q;
                if (!(mBridgeH5EndCardView2 == null || mBridgeH5EndCardView2.getParent() == null)) {
                    removeView(this.q);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.o;
                if (!(mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null)) {
                    removeView(this.o);
                }
                MBridgeClickCTAView mBridgeClickCTAView2 = this.n;
                if (mBridgeClickCTAView2 == null || mBridgeClickCTAView2.getParent() == null) {
                    try {
                        if (this.b != null && this.b.getPlayable_ads_without_video() == 1) {
                            this.Q = true;
                            if (this.n == null) {
                                b(-1);
                            }
                            if (this.n != null) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.n, 0, layoutParams);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                }
            }
        } else if (!isLast() && !endCardShowing()) {
            h();
        }
    }

    public void showEndcard(int i) {
        if (this.b != null) {
            if (i == 1) {
                this.e.a(104, "");
            } else if (i == 100) {
                if (this.b.getPlayable_ads_without_video() == 2) {
                    this.F = true;
                }
                a((View) this.m);
                setMatchParent();
                e();
            } else if (i == 3) {
                removeAllViews();
                setMatchParent();
                if (this.r == null) {
                    a(this.O, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.r, layoutParams);
                this.r.notifyShowListener();
                this.Q = true;
                bringToFront();
            } else if (i == 4) {
                this.e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.s == null) {
                    a(this.O, 4);
                }
                this.s.preLoadData(this.O);
                addView(this.s);
                this.Q = true;
                bringToFront();
            } else if (i != 5) {
                removeAllViews();
                setMatchParent();
                this.Q = true;
                bringToFront();
                a();
                this.e.a(117, "");
            } else {
                this.e.a(106, "");
            }
        }
        this.A = true;
    }

    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.t;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.O;
            this.O = bVar;
            if (mBridgeVideoEndCoverView == null) {
                this.t = new MBridgeVideoEndCoverView(this.a);
                this.t.setCampaign(this.b);
                this.t.setNotifyListener(new i(this.e));
                this.t.preLoadData(bVar);
            }
        }
        addView(this.t);
        onConfigurationChanged(getResources().getConfiguration());
        this.Q = true;
        bringToFront();
    }

    public boolean endCardShowing() {
        return this.A;
    }

    public boolean miniCardShowing() {
        return this.B;
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    public void toggleCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i);
        }
    }

    public void notifyCloseBtn(int i) {
        MBridgePlayableView mBridgePlayableView = this.m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i);
        }
    }

    public void triggerCloseBtn(String str) {
        if (this.b != null) {
            this.e.a(122, "");
            this.e.a(104, "");
        }
    }

    public void readyStatus(int i) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i);
        }
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.H) {
                return;
            }
        }
        a();
    }

    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i, i2, i3, i4);
            this.o.setRadius(i5);
            this.o.setCloseVisible(8);
            this.o.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.Q = true;
            bringToFront();
            f();
            if (!this.E) {
                this.E = true;
                this.e.a(109, "");
                this.e.a(117, "");
            }
        }
    }

    public void resizeMiniCard(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i, i2);
            this.o.setRadius(i3);
            removeAllViews();
            setMatchParent();
            this.Q = true;
            bringToFront();
            f();
        }
    }

    public void configurationChanged(int i, int i2, int i3) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getVisibility() == 0) {
            this.o.resizeMiniCard(i, i2);
        }
    }

    public void webviewshow() {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : new MBridgeH5EndCardView[]{this.m, this.o, this.q, this.u}) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    public void install(CampaignEx campaignEx) {
        this.e.a(105, campaignEx);
    }

    public void orientation(Configuration configuration) {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : new MBridgeH5EndCardView[]{this.m, this.o, this.q, this.u}) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void setNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        super.setNotifyListener(aVar);
        for (MBridgeBaseView mBridgeBaseView : new MBridgeBaseView[]{this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t}) {
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.o, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public void addView(View view) {
        if (view != null) {
            a(view);
            super.addView(view);
            return;
        }
        q.d(MBridgeBaseView.TAG, "view is null");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
            return;
        }
        q.d(MBridgeBaseView.TAG, "view is null");
    }

    public boolean canBackPress() {
        if (this.p != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.s;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.m;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public void setShowingTransparent(boolean z2) {
        this.C = z2;
    }

    public boolean getShowingTransparent() {
        return this.C;
    }

    public String getUnitID() {
        return this.v;
    }

    public void setUnitID(String str) {
        this.v = str;
    }

    public void setVideoInteractiveType(int i) {
        this.w = i;
    }

    public void setEndscreenType(int i) {
        this.x = i;
    }

    public int getVideoInteractiveType() {
        return this.w;
    }

    public void setCloseDelayTime(int i) {
        this.y = i;
    }

    public void setPlayCloseBtnTm(int i) {
        this.z = i;
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                q.a(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void a() {
        if (this.b != null) {
            boolean isDynamicView = this.b.isDynamicView();
            boolean g = u.g(this.b.getendcard_url());
            if (isDynamicView && !g) {
                e();
                return;
            }
        }
        if (this.x != 2 || this.H) {
            e();
        } else {
            b();
        }
    }

    private void b() {
        if (this.q == null) {
            a(this.O, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.q;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.q.setError(true);
            }
        } else {
            this.H = true;
            addView(this.q);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.q.excuteTask();
            this.q.setNotchValue(this.N, this.I, this.J, this.K, this.L);
            m mVar = new m();
            mVar.k(this.b.getRequestId());
            mVar.l(this.b.getRequestIdNotice());
            mVar.n(this.b.getId());
            mVar.a(this.b.isMraid() ? m.a : m.b);
            com.mbridge.msdk.foundation.same.report.b.a(mVar, this.a, this.v);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.q;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.v);
        }
    }

    private void e() {
        this.x = 1;
        if (this.p == null) {
            a(this.O, 2);
        }
        addView(this.p);
        onConfigurationChanged(getResources().getConfiguration());
        this.p.notifyShowListener();
        this.Q = true;
        bringToFront();
    }

    private void f() {
        if (this.o == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.C && this.D) {
            this.D = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.o, layoutParams);
    }

    private void g() {
        if (this.u == null) {
            this.u = new MBridgeAlertWebview(this.a);
            this.u.setUnitId(this.v);
            this.u.setCampaign(this.b);
        }
        this.u.preLoadData(this.O);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mbridge.msdk.video.signal.factory.b r11, java.lang.Integer r12) {
        /*
            r10 = this;
            r10.O = r11
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r10.b
            if (r0 == 0) goto L_0x01a5
            if (r12 != 0) goto L_0x0012
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            int r12 = r12.getVideo_end_type()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
        L_0x0012:
            boolean r0 = r10.isLast()
            if (r0 != 0) goto L_0x001b
            r10.h()
        L_0x001b:
            int r12 = r12.intValue()
            r0 = 1
            if (r12 == r0) goto L_0x01a5
            r1 = 3
            if (r12 == r1) goto L_0x0180
            r1 = 4
            if (r12 == r1) goto L_0x015f
            r1 = 5
            if (r12 == r1) goto L_0x01a5
            int r12 = r10.x
            r1 = 2
            if (r12 != r1) goto L_0x009e
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            boolean r12 = r12.isDynamicView()
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r10.b
            java.lang.String r0 = r0.getendcard_url()
            boolean r0 = com.mbridge.msdk.foundation.tools.u.g((java.lang.String) r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r10.b
            if (r2 == 0) goto L_0x0049
            if (r12 == 0) goto L_0x0049
            if (r0 != 0) goto L_0x0049
            return
        L_0x0049:
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            int r12 = r12.getAdSpaceT()
            if (r12 == r1) goto L_0x01a5
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            if (r12 != 0) goto L_0x005e
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = new com.mbridge.msdk.video.module.MBridgeH5EndCardView
            android.content.Context r0 = r10.a
            r12.<init>(r0)
            r10.q = r12
        L_0x005e:
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r10.b
            r12.setCampaign(r0)
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            int r0 = r10.y
            r12.setCloseDelayShowTime(r0)
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            com.mbridge.msdk.video.module.a.a.i r0 = new com.mbridge.msdk.video.module.a.a.i
            com.mbridge.msdk.video.module.a.a r1 = r10.e
            r0.<init>(r1)
            r12.setNotifyListener(r0)
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            java.lang.String r0 = r10.v
            r12.setUnitId(r0)
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r1 = r10.q
            java.lang.String r2 = r10.N
            int r3 = r10.I
            int r4 = r10.J
            int r5 = r10.K
            int r6 = r10.L
            r1.setNotchValue(r2, r3, r4, r5, r6)
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r12 = r10.q
            r12.preLoadData(r11)
            boolean r11 = r10.C
            if (r11 != 0) goto L_0x01a5
            com.mbridge.msdk.video.module.MBridgeH5EndCardView r11 = r10.q
            r10.addView(r11)
            goto L_0x01a5
        L_0x009e:
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            r2 = 0
            if (r12 == 0) goto L_0x00b7
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            com.mbridge.msdk.foundation.entity.CampaignEx$c r12 = r12.getRewardTemplateMode()
            if (r12 == 0) goto L_0x00b7
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            com.mbridge.msdk.foundation.entity.CampaignEx$c r12 = r12.getRewardTemplateMode()
            int r12 = r12.c()
            r9 = r12
            goto L_0x00b8
        L_0x00b7:
            r9 = r2
        L_0x00b8:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            if (r12 != 0) goto L_0x012b
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            boolean r12 = r12.isDynamicView()
            if (r12 == 0) goto L_0x0113
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            java.lang.String r12 = r12.getendcard_url()
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            r4 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00e8
            java.lang.String r3 = "ecid"
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.y.a(r12, r3)     // Catch:{ all -> 0x00de }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ all -> 0x00de }
            r7 = r12
            goto L_0x00e9
        L_0x00de:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            java.lang.String r3 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.q.d(r3, r12)
        L_0x00e8:
            r7 = r4
        L_0x00e9:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView
            android.content.Context r4 = r10.a
            r5 = 0
            r6 = 1
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r10.b
            int r3 = r3.getAdSpaceT()
            if (r3 != r1) goto L_0x00f9
            r8 = r0
            goto L_0x00fa
        L_0x00f9:
            r8 = r2
        L_0x00fa:
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r10.p = r12
            com.mbridge.msdk.video.dynview.b.a r12 = com.mbridge.msdk.video.dynview.b.a.a()
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = r10.p
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r10.b
            com.mbridge.msdk.video.module.a.a.i r2 = new com.mbridge.msdk.video.module.a.a.i
            com.mbridge.msdk.video.module.a.a r3 = r10.e
            r2.<init>(r3)
            r12.a(r0, r1, r2)
            goto L_0x012b
        L_0x0113:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView
            android.content.Context r4 = r10.a
            r5 = 0
            r6 = 0
            r7 = -1
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r10.b
            int r3 = r3.getAdSpaceT()
            if (r3 != r1) goto L_0x0124
            r8 = r0
            goto L_0x0125
        L_0x0124:
            r8 = r2
        L_0x0125:
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r10.p = r12
        L_0x012b:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r10.b
            r12.setCampaign(r0)
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            java.lang.String r0 = r10.v
            r12.setUnitId(r0)
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            int r0 = r10.y
            r12.setCloseBtnDelay(r0)
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            com.mbridge.msdk.video.module.a.a.i r0 = new com.mbridge.msdk.video.module.a.a.i
            com.mbridge.msdk.video.module.a.a r1 = r10.e
            r0.<init>(r1)
            r12.setNotifyListener(r0)
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r12 = r10.p
            r12.preLoadData(r11)
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r11 = r10.p
            int r12 = r10.I
            int r0 = r10.J
            int r1 = r10.K
            int r2 = r10.L
            r11.setNotchPadding(r12, r0, r1, r2)
            goto L_0x01a5
        L_0x015f:
            com.mbridge.msdk.video.module.MBridgeLandingPageView r11 = r10.s
            if (r11 != 0) goto L_0x016c
            com.mbridge.msdk.video.module.MBridgeLandingPageView r11 = new com.mbridge.msdk.video.module.MBridgeLandingPageView
            android.content.Context r12 = r10.a
            r11.<init>(r12)
            r10.s = r11
        L_0x016c:
            com.mbridge.msdk.video.module.MBridgeLandingPageView r11 = r10.s
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r10.b
            r11.setCampaign(r12)
            com.mbridge.msdk.video.module.MBridgeLandingPageView r11 = r10.s
            com.mbridge.msdk.video.module.a.a.i r12 = new com.mbridge.msdk.video.module.a.a.i
            com.mbridge.msdk.video.module.a.a r0 = r10.e
            r12.<init>(r0)
            r11.setNotifyListener(r12)
            goto L_0x01a5
        L_0x0180:
            com.mbridge.msdk.video.module.MBridgeVastEndCardView r12 = r10.r
            if (r12 != 0) goto L_0x018d
            com.mbridge.msdk.video.module.MBridgeVastEndCardView r12 = new com.mbridge.msdk.video.module.MBridgeVastEndCardView
            android.content.Context r0 = r10.a
            r12.<init>(r0)
            r10.r = r12
        L_0x018d:
            com.mbridge.msdk.video.module.MBridgeVastEndCardView r12 = r10.r
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r10.b
            r12.setCampaign(r0)
            com.mbridge.msdk.video.module.MBridgeVastEndCardView r12 = r10.r
            com.mbridge.msdk.video.module.a.a.l r0 = new com.mbridge.msdk.video.module.a.a.l
            com.mbridge.msdk.video.module.a.a r1 = r10.e
            r0.<init>(r1)
            r12.setNotifyListener(r0)
            com.mbridge.msdk.video.module.MBridgeVastEndCardView r12 = r10.r
            r12.preLoadData(r11)
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeContainerView.a(com.mbridge.msdk.video.signal.factory.b, java.lang.Integer):void");
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup.indexOfChild(this) != 0) {
            return false;
        }
        return true;
    }

    private void h() {
        this.B = false;
        this.Q = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i);
                if (!(childAt instanceof MBridgeContainerView)) {
                    viewGroup.bringChildToFront(childAt);
                } else {
                    i++;
                }
            }
        }
    }

    private void b(int i) {
        if (this.b != null && this.b.isDynamicView()) {
            i = -3;
        }
        if (i == -3) {
            return;
        }
        if (i != -2) {
            if (this.n == null) {
                this.n = new MBridgeClickCTAView(this.a);
            }
            this.n.setCampaign(this.b);
            this.n.setUnitId(this.v);
            this.n.setNotifyListener(new i(this.e));
            this.n.preLoadData(this.O);
        } else if (this.b != null && this.b.getVideo_end_type() == 2) {
            if (this.o == null) {
                this.o = new MBridgeClickMiniCardView(this.a);
            }
            this.o.setCampaign(this.b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(mBridgeClickMiniCardView, this.e));
            this.o.preLoadData(this.O);
            setMatchParent();
            f();
            h();
        }
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.o.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.B) {
            this.e.a(107, "");
        }
    }

    public void onEndcardBackPress() {
        if (this.p != null || this.r != null) {
            this.e.a(104, "");
        } else if (this.s != null) {
            this.e.a(103, "");
        } else {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.onBackPress();
            }
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.q = null;
        }
        MBridgePlayableView mBridgePlayableView = this.m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.s;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
        }
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        return mBridgeH5EndCardView == null ? this.m : mBridgeH5EndCardView;
    }

    public void hideAlertWebview() {
        if (!isLast()) {
            if (this.P && !this.Q) {
                h();
                this.P = false;
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.u;
            if (mBridgeAlertWebview != null && mBridgeAlertWebview.getParent() != null) {
                removeView(this.u);
                MBridgeClickCTAView mBridgeClickCTAView = this.n;
                if (mBridgeClickCTAView != null && mBridgeClickCTAView.getParent() != null) {
                    setWrapContent();
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
                    }
                }
            }
        }
    }

    public void ivRewardAdsWithoutVideo(String str) {
        this.e.a(103, str);
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        q.d(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i)}));
        this.M = i;
        this.I = i2;
        this.J = i3;
        this.K = i4;
        this.L = i5;
        this.N = h.a(i, i2, i3, i4, i5);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i2, i3, i4, i5);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.q;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.p != null) {
            this.q.setNotchValue(this.N, i2, i3, i4, i5);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.q.p, "oncutoutfetched", Base64.encodeToString(this.N.getBytes(), 0));
        }
    }
}
