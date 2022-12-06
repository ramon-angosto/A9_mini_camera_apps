package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.d.d;
import com.mbridge.msdk.splash.signal.b;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SplashShowManager */
public final class c {
    public Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2 && c.this.c != null && c.this.c.isActiveOm() && c.this.d != null) {
                    c.this.d.getSplashWebview();
                }
            } else if (c.this.m > 0) {
                c.c(c.this);
                c cVar = c.this;
                c.b(cVar, cVar.m);
                c.this.a.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000);
            } else {
                c.this.b(2);
            }
        }
    };
    /* access modifiers changed from: private */
    public String b = "SplashShowManager";
    /* access modifiers changed from: private */
    public CampaignEx c;
    /* access modifiers changed from: private */
    public MBSplashView d;
    /* access modifiers changed from: private */
    public d e;
    private a f;
    /* access modifiers changed from: private */
    public boolean g;
    private TextView h;
    private View i;
    /* access modifiers changed from: private */
    public String j;
    private String k;
    /* access modifiers changed from: private */
    public MBridgeIds l;
    /* access modifiers changed from: private */
    public int m = 5;
    private String n = "点击跳过|";
    private String o = "点击跳过|";
    private String p = "秒";
    private String q = "秒后自动关闭";
    private View.OnClickListener r = new View.OnClickListener() {
        public final void onClick(View view) {
            if (c.this.g) {
                c.this.b(1);
                c.b(c.this, -1);
            }
        }
    };
    private com.mbridge.msdk.splash.d.a s = new com.mbridge.msdk.splash.d.a() {
        public final void a(int i) {
            if (c.this.d != null) {
                c.this.d.changeCloseBtnState(i);
            }
        }

        public final void a(Object obj, String str) {
            c.this.b(1);
        }

        public final void a(CampaignEx campaignEx) {
            c.this.a(campaignEx);
        }

        public final void b(int i) {
            String g = c.this.b;
            q.d(g, "resetCountdown" + i);
            int unused = c.this.m = i;
            c.this.a.removeMessages(1);
            c.this.a.sendEmptyMessageDelayed(1, 1000);
        }

        public final void a() {
            c.this.b(1);
        }

        public final void a(boolean z) {
            if (z) {
                c.this.a.removeMessages(1);
            }
        }

        public final void a(boolean z, String str) {
            try {
                if (c.this.e == null) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    c.this.e.b(c.this.l);
                    return;
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(c.this.c));
                parseCampaignWithBackData.setClickURL(str);
                if (z) {
                    String f = c.this.j;
                    if (parseCampaignWithBackData != null) {
                        try {
                            if (!TextUtils.isEmpty(str) && parseCampaignWithBackData.isMraid()) {
                                new com.mbridge.msdk.foundation.same.report.c(com.mbridge.msdk.foundation.controller.a.e().g()).b(parseCampaignWithBackData.getRequestId(), parseCampaignWithBackData.getRequestIdNotice(), parseCampaignWithBackData.getId(), f, str, parseCampaignWithBackData.isBidCampaign());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                c.this.a(parseCampaignWithBackData);
            } catch (Exception e2) {
                q.d(c.this.b, e2.getMessage());
            }
        }
    };

    static /* synthetic */ int c(c cVar) {
        int i2 = cVar.m;
        cVar.m = i2 - 1;
        return i2;
    }

    public c(Context context, String str, String str2) {
        this.j = str2;
        this.k = str;
        this.l = new MBridgeIds(str, str2);
        if (this.h == null) {
            this.h = new TextView(context);
            this.h.setGravity(1);
            this.h.setTextIsSelectable(false);
            this.h.setPadding(u.b(context, 5.0f), u.b(context, 5.0f), u.b(context, 5.0f), u.b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            this.h.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(u.b(context, 100.0f), u.b(context, 50.0f)) : layoutParams);
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            String b2 = com.mbridge.msdk.foundation.controller.a.e().b();
            int identifier = g2.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", b2);
            int identifier2 = g2.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", b2);
            int identifier3 = g2.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", b2);
            this.o = g2.getResources().getString(identifier);
            String string = g2.getResources().getString(identifier2);
            this.q = string;
            this.n = string;
            this.p = g2.getResources().getString(identifier3);
            this.h.setBackgroundResource(g2.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
            this.h.setTextColor(g2.getResources().getColor(g2.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", TtmlNode.ATTR_TTS_COLOR, b2)));
        }
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    public final void a(int i2) {
        this.m = i2;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.r);
        }
        this.i = viewGroup;
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.s;
    }

    public final void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        a(this.g);
        this.c = campaignEx;
        this.d = mBSplashView;
        b splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new b(mBSplashView.getContext(), this.k, this.j);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a((List<CampaignEx>) arrayList);
        }
        splashSignalCommunicationImpl.b(this.m);
        splashSignalCommunicationImpl.a(this.g ? 1 : 0);
        splashSignalCommunicationImpl.a(this.s);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean isHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.i;
        if (view == null) {
            if (isHasMBTplMark) {
                this.h.setVisibility(8);
            }
            f();
            a((View) this.h);
            mBSplashView.setCloseView(this.h);
        } else {
            if (isHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.i);
            mBSplashView.setCloseView(this.i);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.c;
        if (!(campaignEx2 == null || !campaignEx2.isActiveOm() || mBSplashView == null)) {
            mBSplashView.getSplashWebview();
        }
        if (!this.c.isReport()) {
            final CampaignEx campaignEx3 = this.c;
            boolean z = false;
            if (!campaignEx3.isHasMBTplMark()) {
                final Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                String str = this.j;
                com.mbridge.msdk.foundation.controller.a.e().a(g2);
                if (!TextUtils.isEmpty(campaignEx3.getImpressionURL())) {
                    new Thread(new Runnable() {
                        public final void run() {
                            try {
                                j.a((f) g.a(g2)).b(campaignEx3.getId());
                            } catch (Exception unused) {
                                q.d(c.this.b, "campain can't insert db");
                            }
                        }
                    }).start();
                    a.a(g2, campaignEx3, str, campaignEx3.getImpressionURL(), false, true);
                }
                if (!(TextUtils.isEmpty(str) || campaignEx3.getNativeVideoTracking() == null || campaignEx3.getNativeVideoTracking().i() == null)) {
                    a.a(g2, campaignEx3, str, campaignEx3.getNativeVideoTracking().i(), false, false);
                }
                campaignEx3.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx3, "splash");
                z = true;
            }
            if (z) {
                Context g3 = com.mbridge.msdk.foundation.controller.a.e().g();
                String str2 = this.j;
                if (campaignEx3 != null) {
                    try {
                        if (!TextUtils.isEmpty(campaignEx3.getOnlyImpressionURL())) {
                            a.a(g3, campaignEx3, str2, campaignEx3.getOnlyImpressionURL(), false, true);
                        }
                    } catch (Throwable th) {
                        q.d(this.b, th.getMessage());
                    }
                }
                a(campaignEx3, com.mbridge.msdk.foundation.controller.a.e().g(), this.j);
            }
            Context g4 = com.mbridge.msdk.foundation.controller.a.e().g();
            CampaignEx campaignEx4 = this.c;
            String str3 = this.j;
            if (campaignEx4 != null) {
                try {
                    if (campaignEx4.isMraid()) {
                        m mVar = new m();
                        mVar.k(campaignEx4.getRequestId());
                        mVar.l(campaignEx4.getRequestIdNotice());
                        mVar.n(campaignEx4.getId());
                        mVar.a(campaignEx4.isMraid() ? m.a : m.b);
                        com.mbridge.msdk.foundation.same.report.b.a(mVar, g4.getApplicationContext(), str3);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(this.l);
        }
        a.a(this.j);
        this.a.removeMessages(1);
        this.a.sendEmptyMessageDelayed(1, 1000);
        this.a.sendEmptyMessageDelayed(2, 1000);
        if (com.mbridge.msdk.foundation.b.b.a().b()) {
            com.mbridge.msdk.foundation.b.b.a().a(this.j, (com.mbridge.msdk.foundation.b.a) new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    String str;
                    c.this.e();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.this.b, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) c.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    c.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.this.b, th.getMessage(), th);
                        str = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) c.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    c.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.this.b, th.getMessage(), th);
                        str2 = "";
                    }
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) c.this.d.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            FeedBackButton a2 = com.mbridge.msdk.foundation.b.b.a().a(this.j);
            if (a2 != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.b.b.a, com.mbridge.msdk.foundation.b.b.b);
                }
                layoutParams.topMargin = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 10.0f);
                layoutParams.leftMargin = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 10.0f);
                ViewGroup viewGroup = (ViewGroup) a2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(a2);
                }
                this.d.addView(a2, layoutParams);
            }
            com.mbridge.msdk.foundation.b.b.a().a(this.j, this.c);
        }
        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.c.getMaitve(), this.c.getMaitve_src());
    }

    public final String b() {
        CampaignEx campaignEx = this.c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.c.getRequestId();
    }

    public final void a(boolean z) {
        this.g = z;
        if (z) {
            this.n = this.o;
        } else {
            this.n = this.q;
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (this.f == null) {
            this.f = new a(com.mbridge.msdk.foundation.controller.a.e().g(), this.j);
        }
        campaignEx.setCampaignUnitId(this.j);
        this.f.a(campaignEx);
        if (!this.c.isReportClick()) {
            this.c.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx);
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(this.l);
            b(3);
        }
    }

    private void f() {
        String str;
        if (this.g) {
            str = this.o + this.m + this.p;
        } else {
            str = this.m + this.q;
        }
        this.h.setText(str);
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.r);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        com.mbridge.msdk.splash.a.b bVar;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(this.l, i2);
            this.e = null;
            com.mbridge.msdk.splash.e.a.a(this.j, this.c);
        }
        if (this.c != null) {
            bVar = com.mbridge.msdk.splash.a.b.a().b(this.j).d(this.c.getRequestId()).g(this.c.getRequestIdNotice()).c(this.c.getId()).e(this.c.getCreativeId() + "").a(this.c.isBidCampaign());
        } else {
            bVar = null;
        }
        com.mbridge.msdk.splash.e.a.a(bVar, this.j, i2);
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
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
        if (this.s != null) {
            this.s = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        MBSplashView mBSplashView = this.d;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.b.b.a().b(this.j);
    }

    public final void d() {
        MBSplashWebview splashWebview;
        Handler handler;
        if (!com.mbridge.msdk.foundation.b.b.c) {
            if (this.m > 0 && (handler = this.a) != null) {
                handler.removeMessages(1);
                this.a.sendEmptyMessageDelayed(1, 1000);
            }
            MBSplashView mBSplashView = this.d;
            if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null && !splashWebview.isDestoryed()) {
                com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
            }
        }
    }

    public final void e() {
        MBSplashWebview splashWebview;
        Handler handler;
        if (this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.d;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null && !splashWebview.isDestoryed()) {
            com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
        }
    }

    static /* synthetic */ void b(c cVar, int i2) {
        MBSplashView mBSplashView = cVar.d;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i2);
        }
        if (i2 < 0) {
            cVar.m = i2;
            return;
        }
        d dVar = cVar.e;
        if (dVar != null) {
            dVar.a(cVar.l, (long) (i2 * 1000));
        }
        if (cVar.i == null) {
            cVar.f();
        }
    }
}
