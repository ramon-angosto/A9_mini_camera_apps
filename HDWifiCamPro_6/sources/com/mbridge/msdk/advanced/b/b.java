package com.mbridge.msdk.advanced.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.advanced.c.c;
import com.mbridge.msdk.advanced.c.d;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: NativeAdvancedShowManager */
public final class b {
    public Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2 && b.this.c != null && b.this.c.isActiveOm() && b.this.d != null) {
                b.this.d.getAdvancedNativeWebview();
            }
        }
    };
    /* access modifiers changed from: private */
    public String b = "NativeAdvancedShowManager";
    /* access modifiers changed from: private */
    public CampaignEx c;
    /* access modifiers changed from: private */
    public MBNativeAdvancedView d;
    /* access modifiers changed from: private */
    public d e;
    private a f;
    private c g;
    /* access modifiers changed from: private */
    public boolean h;
    private ImageView i;
    /* access modifiers changed from: private */
    public String j;
    private String k;
    /* access modifiers changed from: private */
    public MBridgeIds l;
    /* access modifiers changed from: private */
    public boolean m;
    private View.OnClickListener n = new View.OnClickListener() {
        public final void onClick(View view) {
            if (b.this.h) {
                b.a(b.this, 1);
            }
        }
    };
    private com.mbridge.msdk.advanced.c.a o = new com.mbridge.msdk.advanced.c.a() {
        public final void a(int i) {
            if (b.this.d != null) {
                b.this.d.changeCloseBtnState(i);
            }
        }

        public final void a(Object obj, String str) {
            if (b.this.d != null) {
                b.this.d.setVisibility(8);
            }
            b.a(b.this, 1);
        }

        public final void a(CampaignEx campaignEx) {
            b.this.a(campaignEx);
        }

        public final void b(int i) {
            String e = b.this.b;
            q.d(e, "resetCountdown" + i);
        }

        public final void a() {
            b.a(b.this, 1);
        }

        public final void a(boolean z) {
            if (b.this.e != null) {
                boolean unused = b.this.m = z;
                if (z) {
                    b.this.e.e(b.this.l);
                } else {
                    b.this.e.f(b.this.l);
                }
            }
        }

        public final void a(boolean z, String str) {
            try {
                if (b.this.e == null) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    b.this.e.b(b.this.l);
                    b.this.e.d(b.this.l);
                    return;
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.c));
                parseCampaignWithBackData.setClickURL(str);
                if (z) {
                    String d = b.this.j;
                    if (parseCampaignWithBackData != null) {
                        try {
                            if (!TextUtils.isEmpty(str) && parseCampaignWithBackData.isMraid()) {
                                new com.mbridge.msdk.foundation.same.report.c(com.mbridge.msdk.foundation.controller.a.e().g()).b(parseCampaignWithBackData.getRequestId(), parseCampaignWithBackData.getRequestIdNotice(), parseCampaignWithBackData.getId(), d, str, parseCampaignWithBackData.isBidCampaign());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                b.this.a(parseCampaignWithBackData);
            } catch (Exception e2) {
                q.d(b.this.b, e2.getMessage());
            }
        }
    };

    public final String a() {
        CampaignEx campaignEx = this.c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.c.getRequestId();
    }

    public b(Context context, String str, String str2) {
        this.j = str2;
        this.k = str;
        this.l = new MBridgeIds(str, str2);
        if (this.i == null) {
            this.i = new ImageView(context);
            this.i.setPadding(u.b(context, 2.0f), u.b(context, 2.0f), u.b(context, 2.0f), u.b(context, 2.0f));
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            this.i.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            this.i.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(u.b(g2, 29.0f), u.b(g2, 16.0f)) : layoutParams);
            this.i.setImageResource(g2.getResources().getIdentifier("mbridge_native_advanced_close_icon", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        }
    }

    public final void a(c cVar) {
        this.g = cVar;
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final com.mbridge.msdk.advanced.c.a b() {
        return this.o;
    }

    public final void a(final CampaignEx campaignEx, final MBNativeAdvancedView mBNativeAdvancedView, boolean z) {
        FeedBackButton a2;
        if (mBNativeAdvancedView != null) {
            com.mbridge.msdk.foundation.b.b.a().a(this.j, (com.mbridge.msdk.foundation.b.a) new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    String str;
                    b.this.e();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(b.this.b, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    b.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(b.this.b, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    b.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(b.this.b, th.getMessage(), th);
                        str2 = "";
                    }
                    g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            if (campaignEx.isMraid() && com.mbridge.msdk.foundation.b.b.a().b() && (a2 = com.mbridge.msdk.foundation.b.b.a().a(this.j)) != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.b.b.a, com.mbridge.msdk.foundation.b.b.b);
                }
                layoutParams.addRule(12);
                ViewGroup viewGroup = (ViewGroup) a2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(a2);
                }
                mBNativeAdvancedView.addView(a2, layoutParams);
            }
            this.h = this.h;
            this.c = campaignEx;
            this.d = mBNativeAdvancedView;
            com.mbridge.msdk.advanced.js.b advancedNativeSignalCommunicationImpl = mBNativeAdvancedView.getAdvancedNativeSignalCommunicationImpl();
            if (advancedNativeSignalCommunicationImpl == null) {
                advancedNativeSignalCommunicationImpl = new com.mbridge.msdk.advanced.js.b(mBNativeAdvancedView.getContext(), this.k, this.j);
                ArrayList arrayList = new ArrayList();
                arrayList.add(campaignEx);
                advancedNativeSignalCommunicationImpl.a((List<CampaignEx>) arrayList);
            }
            advancedNativeSignalCommunicationImpl.a(this.h ? 1 : 0);
            advancedNativeSignalCommunicationImpl.a(this.o);
            mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(advancedNativeSignalCommunicationImpl);
            if (campaignEx.isHasMBTplMark() || !this.h) {
                this.i.setVisibility(8);
            }
            ImageView imageView = this.i;
            if (imageView != null) {
                imageView.setOnClickListener(this.n);
            }
            mBNativeAdvancedView.setCloseView(this.i);
            if (mBNativeAdvancedView.getVisibility() != 0) {
                mBNativeAdvancedView.setVisibility(0);
            }
            boolean a3 = z.a(mBNativeAdvancedView.getAdvancedNativeWebview());
            c cVar = this.g;
            if (cVar != null && !a3 && cVar.b() != null && this.g.b().getAlpha() >= 0.5f && this.g.b().getVisibility() == 0 && !this.m) {
                mBNativeAdvancedView.show();
                com.mbridge.msdk.foundation.controller.a.e().a(mBNativeAdvancedView.getContext());
                com.mbridge.msdk.foundation.b.b.a().a(this.j, campaignEx);
                CampaignEx campaignEx2 = this.c;
                if (!(campaignEx2 == null || !campaignEx2.isActiveOm() || mBNativeAdvancedView == null)) {
                    mBNativeAdvancedView.getAdvancedNativeWebview();
                    try {
                        com.mbridge.msdk.advanced.common.b.b(campaignEx.getRequestId());
                    } catch (Throwable th) {
                        q.a("OMSDK", th.getMessage());
                        CampaignEx campaignEx3 = this.c;
                        if (campaignEx3 != null) {
                            String requestId = campaignEx3.getRequestId();
                            String requestIdNotice = this.c.getRequestIdNotice();
                            String id = this.c.getId();
                            new com.mbridge.msdk.foundation.same.report.c(com.mbridge.msdk.foundation.controller.a.e().g()).a(requestId, requestIdNotice, id, this.j, "fetch OM failed, exception" + th.getMessage());
                        }
                    }
                }
                if (!this.c.isReport()) {
                    final CampaignEx campaignEx4 = this.c;
                    boolean z2 = true;
                    if (!campaignEx4.isHasMBTplMark()) {
                        final Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                        String str = this.j;
                        com.mbridge.msdk.foundation.controller.a.e().a(g2);
                        if (!TextUtils.isEmpty(campaignEx4.getImpressionURL())) {
                            new Thread(new Runnable() {
                                public final void run() {
                                    try {
                                        j.a((f) com.mbridge.msdk.foundation.db.g.a(g2)).b(campaignEx4.getId());
                                    } catch (Exception unused) {
                                        q.d(b.this.b, "campain can't insert db");
                                    }
                                }
                            }).start();
                            a.a(g2, campaignEx4, str, campaignEx4.getImpressionURL(), false, true);
                        }
                        if (!(TextUtils.isEmpty(str) || campaignEx4.getNativeVideoTracking() == null || campaignEx4.getNativeVideoTracking().i() == null)) {
                            a.a(g2, campaignEx4, str, campaignEx4.getNativeVideoTracking().i(), false, false);
                        }
                        campaignEx4.setReport(true);
                        com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx4, "h5_native");
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        Context g3 = com.mbridge.msdk.foundation.controller.a.e().g();
                        String str2 = this.j;
                        if (campaignEx4 != null) {
                            try {
                                if (!TextUtils.isEmpty(campaignEx4.getOnlyImpressionURL())) {
                                    a.a(g3, campaignEx4, str2, campaignEx4.getOnlyImpressionURL(), false, true);
                                }
                            } catch (Throwable th2) {
                                q.d(this.b, th2.getMessage());
                            }
                        }
                        a(campaignEx4, com.mbridge.msdk.foundation.controller.a.e().g(), this.j);
                    }
                    Context g4 = com.mbridge.msdk.foundation.controller.a.e().g();
                    CampaignEx campaignEx5 = this.c;
                    String str3 = this.j;
                    if (campaignEx5 != null) {
                        try {
                            if (campaignEx5.isMraid()) {
                                m mVar = new m();
                                mVar.k(campaignEx5.getRequestId());
                                mVar.l(campaignEx5.getRequestIdNotice());
                                mVar.n(campaignEx5.getId());
                                mVar.a(campaignEx5.isMraid() ? m.a : m.b);
                                com.mbridge.msdk.foundation.same.report.b.a(mVar, g4.getApplicationContext(), str3);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    d dVar = this.e;
                    if (dVar != null) {
                        dVar.a(this.l);
                    }
                }
                c.a(this.j);
                this.a.sendEmptyMessageDelayed(2, 1000);
                com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.c.getMaitve(), this.c.getMaitve_src());
            } else if (z) {
                mBNativeAdvancedView.postDelayed(new Runnable() {
                    public final void run() {
                        b.this.a(campaignEx, mBNativeAdvancedView, false);
                    }
                }, 200);
            }
        }
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void a(CampaignEx campaignEx) {
        if (this.f == null) {
            this.f = new a(com.mbridge.msdk.foundation.controller.a.e().g(), this.j);
        }
        this.f.a((NativeListener.NativeTrackingListener) new NativeListener.TrackingExListener() {
            public final void onDismissLoading(Campaign campaign) {
            }

            public final void onDownloadFinish(Campaign campaign) {
            }

            public final void onDownloadProgress(int i) {
            }

            public final void onDownloadStart(Campaign campaign) {
            }

            public final void onFinishRedirection(Campaign campaign, String str) {
            }

            public final boolean onInterceptDefaultLoadingDialog() {
                return false;
            }

            public final void onRedirectionFailed(Campaign campaign, String str) {
            }

            public final void onShowLoading(Campaign campaign) {
            }

            public final void onStartRedirection(Campaign campaign, String str) {
            }

            public final void onLeaveApp() {
                if (b.this.e != null) {
                    b.this.e.d(b.this.l);
                }
            }
        });
        campaignEx.setCampaignUnitId(this.j);
        this.f.a(campaignEx);
        if (!this.c.isReportClick()) {
            this.c.setReportClick(true);
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            if (!(campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().e() == null)) {
                a.a(g2, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
            }
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(this.l);
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        a.a(context, campaignEx, str, a2, false, true);
                    }
                }
            } catch (Throwable th) {
                q.d(this.b, th.getMessage());
            }
        }
    }

    public final void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.d;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        com.mbridge.msdk.foundation.b.b.a().b(this.j);
    }

    public final void d() {
        MBNativeAdvancedWebview advancedNativeWebview;
        if (this.d != null && !com.mbridge.msdk.foundation.b.b.c && (advancedNativeWebview = this.d.getAdvancedNativeWebview()) != null && !advancedNativeWebview.isDestoryed()) {
            com.mbridge.msdk.advanced.js.a.a(advancedNativeWebview, "onViewAppeared", "");
        }
    }

    public final void e() {
        MBNativeAdvancedWebview advancedNativeWebview;
        MBNativeAdvancedView mBNativeAdvancedView = this.d;
        if (mBNativeAdvancedView != null && (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) != null && !advancedNativeWebview.isDestoryed()) {
            g.a().a((WebView) advancedNativeWebview, "onViewDisappeared", "");
        }
    }

    static /* synthetic */ void a(b bVar, int i2) {
        com.mbridge.msdk.advanced.common.c cVar;
        d dVar = bVar.e;
        if (dVar != null) {
            dVar.c(bVar.l);
            bVar.e = null;
            String str = bVar.j;
            CampaignEx campaignEx = bVar.c;
            if (campaignEx != null && campaignEx.isMraid()) {
                m mVar = new m("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
                mVar.a(m.a);
                com.mbridge.msdk.foundation.same.report.b.b(mVar, com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
        if (bVar.c != null) {
            cVar = com.mbridge.msdk.advanced.common.c.a().b(bVar.j).d(bVar.c.getRequestId()).g(bVar.c.getRequestIdNotice()).c(bVar.c.getId()).e(bVar.c.getCreativeId() + "").a(bVar.c.isBidCampaign());
        } else {
            cVar = null;
        }
        String str2 = bVar.j;
        if (cVar != null) {
            cVar.a("2000069");
            cVar.a(i2);
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(cVar.b());
            } else {
                com.mbridge.msdk.foundation.same.report.b.a(cVar.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str2);
            }
        }
        MBNativeAdvancedView mBNativeAdvancedView = bVar.d;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.setVisibility(8);
            bVar.e();
        }
        Handler handler = bVar.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }
}
