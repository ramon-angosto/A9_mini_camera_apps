package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.signal.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeBTContainer extends AbstractJSContainer implements b {
    /* access modifiers changed from: private */
    public static final String a = MBridgeBTContainer.class.getSimpleName();
    private boolean A = false;
    /* access modifiers changed from: private */
    public List<CampaignEx> B;
    private List<com.mbridge.msdk.videocommon.download.a> C;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.bt.module.a.a D;
    /* access modifiers changed from: private */
    public h E;
    /* access modifiers changed from: private */
    public h F;
    private com.mbridge.msdk.video.bt.module.a.b G;
    private String H;
    private String I;
    private String J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public int L;
    private com.mbridge.msdk.video.dynview.d.a M;
    private int b = 0;
    private int c = 1;
    /* access modifiers changed from: private */
    public FrameLayout d;
    private MBridgeBTLayout e;
    /* access modifiers changed from: private */
    public WindVaneWebView f;
    private LayoutInflater g;
    private Context h;
    private boolean i = false;
    /* access modifiers changed from: private */
    public boolean y = true;
    private String z;

    public void click(int i2, String str) {
    }

    public void handlerH5Exception(int i2, String str) {
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        init(context);
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.h = context;
        this.g = LayoutInflater.from(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:44|(5:46|(6:50|51|(1:56)|57|(1:59)|60)|61|(2:62|(2:64|(2:95|66))(1:96))|67)|68|69|70|71|72|73|(1:101)(2:77|102)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x02de */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "_"
            java.lang.String r2 = "mbridge_bt_container"
            int r2 = r9.findLayout(r2)     // Catch:{ all -> 0x034f }
            if (r2 >= 0) goto L_0x0012
            java.lang.String r0 = "mbridge_bt_container layout null"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            return
        L_0x0012:
            android.view.LayoutInflater r3 = r9.g     // Catch:{ all -> 0x034f }
            android.view.View r2 = r3.inflate(r2, r9)     // Catch:{ all -> 0x034f }
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2     // Catch:{ all -> 0x034f }
            r9.d = r2     // Catch:{ all -> 0x034f }
            android.widget.FrameLayout r2 = r9.d     // Catch:{ all -> 0x034f }
            if (r2 != 0) goto L_0x0026
            java.lang.String r0 = "ViewIds null"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            return
        L_0x0026:
            r9.I = r0     // Catch:{ all -> 0x034f }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r9.B     // Catch:{ all -> 0x034f }
            r3 = 0
            if (r2 == 0) goto L_0x0048
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r9.B     // Catch:{ all -> 0x034f }
            int r2 = r2.size()     // Catch:{ all -> 0x034f }
            if (r2 <= 0) goto L_0x0048
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r9.B     // Catch:{ all -> 0x034f }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r2.getCMPTEntryUrl()     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r2.getRequestId()     // Catch:{ all -> 0x034f }
            r9.I = r2     // Catch:{ all -> 0x034f }
            goto L_0x0049
        L_0x0048:
            r4 = r0
        L_0x0049:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r2.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r5 = r9.k     // Catch:{ all -> 0x034f }
            r2.append(r5)     // Catch:{ all -> 0x034f }
            r2.append(r1)     // Catch:{ all -> 0x034f }
            java.lang.String r5 = r9.I     // Catch:{ all -> 0x034f }
            r2.append(r5)     // Catch:{ all -> 0x034f }
            r2.append(r1)     // Catch:{ all -> 0x034f }
            r2.append(r4)     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.videocommon.a$a r2 = com.mbridge.msdk.videocommon.a.a(r2)     // Catch:{ all -> 0x034f }
            r5 = 0
            if (r2 == 0) goto L_0x0092
            java.lang.String r6 = r2.b()     // Catch:{ all -> 0x034f }
            r9.z = r6     // Catch:{ all -> 0x034f }
            java.lang.String r6 = a     // Catch:{ all -> 0x034f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r7.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r8 = "get BT wraper.getTag = "
            r7.append(r8)     // Catch:{ all -> 0x034f }
            java.lang.String r8 = r9.z     // Catch:{ all -> 0x034f }
            r7.append(r8)     // Catch:{ all -> 0x034f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.tools.q.a(r6, r7)     // Catch:{ all -> 0x034f }
            r2.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r2.a()     // Catch:{ all -> 0x034f }
            goto L_0x0093
        L_0x0092:
            r2 = r5
        L_0x0093:
            r9.f = r2     // Catch:{ all -> 0x034f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r2.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r6 = r9.k     // Catch:{ all -> 0x034f }
            r2.append(r6)     // Catch:{ all -> 0x034f }
            r2.append(r1)     // Catch:{ all -> 0x034f }
            java.lang.String r6 = r9.I     // Catch:{ all -> 0x034f }
            r2.append(r6)     // Catch:{ all -> 0x034f }
            r2.append(r1)     // Catch:{ all -> 0x034f }
            r2.append(r4)     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.videocommon.a.b(r2)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r9.f     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x0305
            com.mbridge.msdk.video.signal.factory.b r2 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x034f }
            android.app.Activity r4 = r9.j     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r6 = r9.f     // Catch:{ all -> 0x034f }
            r2.<init>(r4, r9, r6)     // Catch:{ all -> 0x034f }
            r9.registerJsFactory(r2)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.f     // Catch:{ all -> 0x034f }
            r4.setApiManagerJSFactory(r2)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.f     // Catch:{ all -> 0x034f }
            android.view.ViewParent r4 = r4.getParent()     // Catch:{ all -> 0x034f }
            if (r4 == 0) goto L_0x00d7
            java.lang.String r0 = "preload template webview is null or load error"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            return
        L_0x00d7:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.f     // Catch:{ all -> 0x034f }
            java.lang.Object r4 = r4.getObject()     // Catch:{ all -> 0x034f }
            boolean r4 = r4 instanceof com.mbridge.msdk.video.signal.a.j     // Catch:{ all -> 0x034f }
            r6 = 1
            if (r4 == 0) goto L_0x018a
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.f     // Catch:{ all -> 0x034f }
            java.lang.Object r4 = r4.getObject()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.a.j r4 = (com.mbridge.msdk.video.signal.a.j) r4     // Catch:{ all -> 0x034f }
            r2.a(r4)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r9.f     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x017f
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x034f }
            r2.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.j     // Catch:{ all -> 0x034f }
            android.content.Context r7 = r9.getContext()     // Catch:{ all -> 0x034f }
            float r7 = com.mbridge.msdk.foundation.tools.u.d((android.content.Context) r7)     // Catch:{ all -> 0x034f }
            double r7 = (double) r7     // Catch:{ all -> 0x034f }
            r2.put(r4, r7)     // Catch:{ all -> 0x034f }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r4.<init>()     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r7 = "name"
            com.mbridge.msdk.videocommon.b.c r8 = r9.o     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r8 = r8.a()     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r7 = "amount"
            com.mbridge.msdk.videocommon.b.c r8 = r9.o     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            int r8 = r8.b()     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r7 = "id"
            java.lang.String r8 = r9.p     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r4.put(r7, r8)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r7 = "userId"
            java.lang.String r8 = r9.n     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r2.put(r7, r8)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r7 = "reward"
            r2.put(r7, r4)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r4 = "playVideoMute"
            int r7 = r9.q     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r2.put(r4, r7)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            java.lang.String r4 = "extra"
            java.lang.String r7 = r9.J     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            r2.put(r4, r7)     // Catch:{ JSONException -> 0x014c, Exception -> 0x0141 }
            goto L_0x0156
        L_0x0141:
            r4 = move-exception
            java.lang.String r7 = a     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.tools.q.a(r7, r4)     // Catch:{ all -> 0x034f }
            goto L_0x0156
        L_0x014c:
            r4 = move-exception
            java.lang.String r7 = a     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.tools.q.a(r7, r4)     // Catch:{ all -> 0x034f }
        L_0x0156:
            com.mbridge.msdk.video.bt.module.b.c r4 = new com.mbridge.msdk.video.bt.module.b.c     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.a.b r7 = r9.c()     // Catch:{ all -> 0x034f }
            r4.<init>(r7, r0)     // Catch:{ all -> 0x034f }
            r9.F = r4     // Catch:{ all -> 0x034f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.f r2 = r9.getJSNotifyProxy()     // Catch:{ all -> 0x034f }
            r2.a((java.lang.Object) r0)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.c r0 = r9.getJSCommon()     // Catch:{ all -> 0x034f }
            r0.b((boolean) r6)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.c r0 = r9.getJSCommon()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a r2 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a     // Catch:{ all -> 0x034f }
            r2.<init>()     // Catch:{ all -> 0x034f }
            r0.a((com.mbridge.msdk.video.signal.c.a) r2)     // Catch:{ all -> 0x034f }
        L_0x017f:
            com.mbridge.msdk.video.signal.c r0 = r9.getJSCommon()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.a.c r0 = (com.mbridge.msdk.video.signal.a.c) r0     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.signal.c$a r0 = r0.l     // Catch:{ all -> 0x034f }
            r0.a()     // Catch:{ all -> 0x034f }
        L_0x018a:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r9.f     // Catch:{ all -> 0x034f }
            r0.setBackgroundColor(r3)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r9.k     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r9.I     // Catch:{ all -> 0x034f }
            java.util.LinkedHashMap r0 = r0.b((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x02ff
            java.lang.String r2 = r9.z     // Catch:{ all -> 0x034f }
            boolean r2 = r0.containsKey(r2)     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x02ff
            java.lang.String r2 = r9.z     // Catch:{ all -> 0x034f }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x034f }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x034f }
            boolean r4 = r2 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ all -> 0x034f }
            if (r4 == 0) goto L_0x02b0
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r2 = (com.mbridge.msdk.video.bt.module.MBridgeBTLayout) r2     // Catch:{ all -> 0x034f }
            r9.e = r2     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.b.b r2 = com.mbridge.msdk.foundation.b.b.a()     // Catch:{ all -> 0x034f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r4.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r7 = r9.k     // Catch:{ all -> 0x034f }
            r4.append(r7)     // Catch:{ all -> 0x034f }
            r4.append(r1)     // Catch:{ all -> 0x034f }
            r4.append(r6)     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1 r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1     // Catch:{ all -> 0x034f }
            r7.<init>()     // Catch:{ all -> 0x034f }
            r2.a((java.lang.String) r4, (com.mbridge.msdk.foundation.b.a) r7)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r2 = r9.e     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r4 = r9.f     // Catch:{ all -> 0x034f }
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x034f }
            r8 = -1
            r7.<init>(r8, r8)     // Catch:{ all -> 0x034f }
            r2.addView(r4, r3, r7)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.b.b r2 = com.mbridge.msdk.foundation.b.b.a()     // Catch:{ all -> 0x034f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r4.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r7 = r9.k     // Catch:{ all -> 0x034f }
            r4.append(r7)     // Catch:{ all -> 0x034f }
            r4.append(r1)     // Catch:{ all -> 0x034f }
            r7 = 2
            r4.append(r7)     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x034f }
            r2.b(r4)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.b.b r2 = com.mbridge.msdk.foundation.b.b.a()     // Catch:{ all -> 0x034f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            r4.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r7 = r9.k     // Catch:{ all -> 0x034f }
            r4.append(r7)     // Catch:{ all -> 0x034f }
            r4.append(r1)     // Catch:{ all -> 0x034f }
            r4.append(r6)     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.widget.FeedBackButton r1 = r2.a((java.lang.String) r1)     // Catch:{ all -> 0x034f }
            if (r1 == 0) goto L_0x026e
            com.mbridge.msdk.foundation.b.b r2 = com.mbridge.msdk.foundation.b.b.a()     // Catch:{ all -> 0x034f }
            boolean r2 = r2.b()     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x026e
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()     // Catch:{ Exception -> 0x022d }
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2     // Catch:{ Exception -> 0x022d }
            goto L_0x0232
        L_0x022d:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x034f }
            r2 = r5
        L_0x0232:
            if (r2 != 0) goto L_0x023d
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x034f }
            int r4 = com.mbridge.msdk.foundation.b.b.a     // Catch:{ all -> 0x034f }
            int r5 = com.mbridge.msdk.foundation.b.b.b     // Catch:{ all -> 0x034f }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x034f }
        L_0x023d:
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x034f }
            android.content.Context r4 = r4.g()     // Catch:{ all -> 0x034f }
            r5 = 1092616192(0x41200000, float:10.0)
            int r4 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r4, (float) r5)     // Catch:{ all -> 0x034f }
            r2.topMargin = r4     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x034f }
            android.content.Context r4 = r4.g()     // Catch:{ all -> 0x034f }
            int r4 = com.mbridge.msdk.foundation.tools.u.b((android.content.Context) r4, (float) r5)     // Catch:{ all -> 0x034f }
            r2.leftMargin = r4     // Catch:{ all -> 0x034f }
            r1.setLayoutParams(r2)     // Catch:{ all -> 0x034f }
            android.view.ViewParent r2 = r1.getParent()     // Catch:{ all -> 0x034f }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x0269
            r2.removeView(r1)     // Catch:{ all -> 0x034f }
        L_0x0269:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r2 = r9.e     // Catch:{ all -> 0x034f }
            r2.addView(r1)     // Catch:{ all -> 0x034f }
        L_0x026e:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r1 = r9.e     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r9.z     // Catch:{ all -> 0x034f }
            r1.setTag(r2)     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r9.z     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r2 = r9.e     // Catch:{ all -> 0x034f }
            r0.put(r1, r2)     // Catch:{ all -> 0x034f }
            java.util.Collection r1 = r0.values()     // Catch:{ all -> 0x034f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x034f }
        L_0x0284:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x034f }
            if (r2 == 0) goto L_0x02a6
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x034f }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x034f }
            boolean r4 = r2 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ all -> 0x034f }
            if (r4 == 0) goto L_0x0284
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r2 = (com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout) r2     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r2.getInstanceId()     // Catch:{ all -> 0x034f }
            r9.H = r1     // Catch:{ all -> 0x034f }
            android.widget.FrameLayout r1 = r9.d     // Catch:{ all -> 0x034f }
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x034f }
            r4.<init>(r8, r8)     // Catch:{ all -> 0x034f }
            r1.addView(r2, r4)     // Catch:{ all -> 0x034f }
        L_0x02a6:
            java.lang.String r1 = r9.H     // Catch:{ all -> 0x034f }
            r0.remove(r1)     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r9.H     // Catch:{ all -> 0x034f }
            r0.put(r1, r9)     // Catch:{ all -> 0x034f }
        L_0x02b0:
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r9.k     // Catch:{ all -> 0x034f }
            int r2 = r9.q     // Catch:{ all -> 0x034f }
            r0.a((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r9.z     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r9.I     // Catch:{ all -> 0x034f }
            r0.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.a.c r0 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ all -> 0x034f }
            java.lang.String r1 = r9.H     // Catch:{ all -> 0x034f }
            java.lang.String r2 = r9.I     // Catch:{ all -> 0x034f }
            r0.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x034f }
            java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ all -> 0x02de }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2 r1 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2     // Catch:{ all -> 0x02de }
            r1.<init>()     // Catch:{ all -> 0x02de }
            r0.execute(r1)     // Catch:{ all -> 0x02de }
            goto L_0x02e5
        L_0x02de:
            java.lang.String r0 = a     // Catch:{ all -> 0x034f }
            java.lang.String r1 = "remove campaign failed"
            com.mbridge.msdk.foundation.tools.q.a(r0, r1)     // Catch:{ all -> 0x034f }
        L_0x02e5:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.B     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x0364
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.B     // Catch:{ all -> 0x034f }
            int r0 = r0.size()     // Catch:{ all -> 0x034f }
            if (r0 <= 0) goto L_0x0364
            com.mbridge.msdk.videocommon.d.c r0 = r9.m     // Catch:{ all -> 0x034f }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r9.B     // Catch:{ all -> 0x034f }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ all -> 0x034f }
            r9.a((com.mbridge.msdk.videocommon.d.c) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ all -> 0x034f }
            goto L_0x0364
        L_0x02ff:
            java.lang.String r0 = "big template webviewLayout is null"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            return
        L_0x0305:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.B     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x0349
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.B     // Catch:{ all -> 0x034f }
            int r0 = r0.size()     // Catch:{ all -> 0x034f }
            if (r0 <= 0) goto L_0x0349
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.B     // Catch:{ all -> 0x034f }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x0349
            boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x0349
            android.content.Context r0 = r9.h     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.dynview.d.a r1 = r9.M     // Catch:{ all -> 0x034f }
            if (r1 != 0) goto L_0x032d
            java.lang.String r0 = "ChoiceOneCallback is null"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            goto L_0x0348
        L_0x032d:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x034f }
            r1.<init>()     // Catch:{ all -> 0x034f }
            java.lang.String r2 = "choice_one_callback"
            com.mbridge.msdk.video.dynview.d.a r3 = r9.M     // Catch:{ all -> 0x034f }
            r1.put(r2, r3)     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.dynview.a.a()     // Catch:{ all -> 0x034f }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r9.B     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$3 r3 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$3     // Catch:{ all -> 0x034f }
            r3.<init>()     // Catch:{ all -> 0x034f }
            com.mbridge.msdk.video.dynview.h.a r4 = new com.mbridge.msdk.video.dynview.h.a     // Catch:{ all -> 0x034f }
            r4.<init>(r0, r2, r3, r1)     // Catch:{ all -> 0x034f }
        L_0x0348:
            return
        L_0x0349:
            java.lang.String r0 = "big template webview is null"
            r9.a((java.lang.String) r0)     // Catch:{ all -> 0x034f }
            goto L_0x0364
        L_0x034f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onCreate exception "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.a((java.lang.String) r0)
        L_0x0364:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.onCreate():void");
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.E;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    /* access modifiers changed from: protected */
    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        CampaignEx campaignEx2 = campaignEx;
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx2, this.k, a2, false, true);
                    }
                }
            } catch (Throwable th) {
                q.d(a, th.getMessage());
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onConfigurationChanged(configuration);
                    }
                }
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.G == null) {
            this.G = new com.mbridge.msdk.video.bt.module.a.b() {
                public final void a(String str) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.k);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z);
                            jSONObject2.put("convert", z ? 1 : 2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(boolean z, int i) {
                    boolean unused = MBridgeBTContainer.this.K = z;
                    int unused2 = MBridgeBTContainer.this.L = i;
                }

                public final void a(String str, String str2) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.l);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.k);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void b(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void c(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a2 = MBridgeBTContainer.a;
                            q.a(a2, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            q.a(MBridgeBTContainer.a, e.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, int i, String str2, String str3) {
                    if (MBridgeBTContainer.this.E != null) {
                        MBridgeBTContainer.this.E.a(i, str2, str3);
                    }
                }
            };
        }
        return this.G;
    }

    public void onResume() {
        super.onResume();
        if (!com.mbridge.msdk.foundation.b.b.c) {
            try {
                LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
                if (b2 != null && b2.size() > 0) {
                    for (View next : b2.values()) {
                        if (next instanceof MBridgeBTVideoView) {
                            ((MBridgeBTVideoView) next).onResume();
                        }
                    }
                }
            } catch (Throwable th) {
                q.a(a, th.getMessage());
            }
        }
    }

    public void onStop() {
        super.onStop();
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onStop();
                    }
                }
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onBackPressed();
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onBackPressed();
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onBackPressed();
                    }
                }
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    public void onPause() {
        super.onPause();
        try {
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onPause();
                    }
                }
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAdClose() {
        if (this.j != null) {
            this.j.finish();
        }
    }

    public void onDestroy() {
        if (!this.A) {
            this.A = true;
            super.onDestroy();
            try {
                if (this.f != null) {
                    ViewGroup viewGroup = (ViewGroup) this.f.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.f.clearWebView();
                    this.f.release();
                }
                if (this.G != null) {
                    this.G = null;
                }
                if (this.D != null) {
                    this.D = null;
                }
                if (this.h != null) {
                    this.h = null;
                }
                if (this.B != null && this.B.size() > 0) {
                    for (CampaignEx next : this.B) {
                        if (!(next == null || next.getRewardTemplateMode() == null)) {
                            com.mbridge.msdk.videocommon.a.b(this.k + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    }
                }
                c.a().e(this.z);
                c.a().f(this.k);
                c.a().b(this.k, this.I).remove(this.z);
                c.a().b(this.k, this.I).remove(this.H);
                c.a().b(this.k, this.I).clear();
            } catch (Throwable th) {
                q.a(a, th.getMessage());
            }
        }
    }

    public void reactDeveloper(Object obj, String str) {
        if (this.D == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, getUnitId());
            String optString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            CampaignEx campaignEx = this.B.get(0);
            boolean z2 = true;
            if (optInt == 1 && optJSONObject != null) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (optBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            JSONObject jSONObject2 = null;
            switch (optInt) {
                case 1:
                    this.D.a();
                    this.D.a(2, optString2, optString);
                    break;
                case 2:
                    if (optJSONObject != null) {
                        jSONObject2 = optJSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                    }
                    String str2 = "";
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    this.D.a(str2);
                    this.D.a(4, optString2, optString);
                    break;
                case 3:
                    this.D.a(optString2, optString);
                    this.D.a(5, optString2, optString);
                    break;
                case 4:
                    this.D.b(optString2, optString);
                    this.D.a(6, optString2, optString);
                    break;
                case 5:
                    this.D.a(jSONObject.optBoolean("isAutoClick"), optString2, optString);
                    break;
                case 6:
                    if (optJSONObject != null) {
                        if (optJSONObject.optInt("convert") != 1) {
                            z2 = false;
                        }
                        jSONObject2 = optJSONObject.optJSONObject("reward");
                        String optString3 = optJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.J = optString3;
                        }
                    } else {
                        z2 = false;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    com.mbridge.msdk.videocommon.b.c a2 = com.mbridge.msdk.videocommon.b.c.a(jSONObject2);
                    if (a2 == null) {
                        a2 = this.o;
                    }
                    this.D.a(7, optString2, optString);
                    if (this.r && (this.t == com.mbridge.msdk.foundation.same.a.n || this.t == com.mbridge.msdk.foundation.same.a.o)) {
                        this.D.a(this.K, this.L);
                    }
                    if (!z2) {
                        a2.a(0);
                    }
                    this.D.a(z2, a2);
                    q.a(a, "sendToServerRewardInfo");
                    if (!this.r && z2) {
                        if (parseCampaignWithBackData == null) {
                            com.mbridge.msdk.video.module.b.a.a(campaignEx, a2, optString, this.n, this.J);
                            break;
                        } else {
                            com.mbridge.msdk.video.module.b.a.a(parseCampaignWithBackData, a2, optString, this.n, this.J);
                            break;
                        }
                    }
            }
            a(obj);
        } catch (JSONException e2) {
            a(obj, e2.getMessage());
            q.a(a, e2.getMessage());
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                int optInt = jSONObject.optInt(TtmlNode.LEFT, -999);
                int optInt2 = jSONObject.optInt("top", -999);
                int optInt3 = jSONObject.optInt(TtmlNode.RIGHT, -999);
                int optInt4 = jSONObject.optInt("bottom", -999);
                if (!(optInt == -999 || g2 == null)) {
                    layoutParams.leftMargin = u.b(g2, (float) optInt);
                }
                if (!(optInt2 == -999 || g2 == null)) {
                    layoutParams.topMargin = u.b(g2, (float) optInt2);
                }
                if (!(optInt3 == -999 || g2 == null)) {
                    layoutParams.rightMargin = u.b(g2, (float) optInt3);
                }
                if (!(optInt4 == -999 || g2 == null)) {
                    layoutParams.bottomMargin = u.b(g2, (float) optInt4);
                }
                int optInt5 = jSONObject.optInt("width");
                int optInt6 = jSONObject.optInt("height");
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.j);
            mBTempContainer.setMute(this.q);
            mBTempContainer.setBidCampaign(this.i);
            mBTempContainer.setIV(this.r);
            mBTempContainer.setBigOffer(this.y);
            mBTempContainer.setIVRewardEnable(this.t, this.u, this.v);
            mBTempContainer.setShowRewardListener(this.F);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.h);
            mBTempContainer.onCreate();
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.C;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a next : list) {
            if (next.g().getId().equals(campaignEx.getId())) {
                q.a(a, "tempContainer task initSuccess");
                return next;
            }
        }
        return null;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.b);
                jSONObject2.put("id", this.z);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                g.a().a((WebView) this.f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                c.a().a((WebView) this.f, "broadcast", this.z);
            }
        }
    }

    public int findID(String str) {
        return k.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return k.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.D = aVar;
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.B = list;
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.C = list;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.x = bVar;
    }

    public void setShowRewardVideoListener(h hVar) {
        this.E = hVar;
    }

    public void setChoiceOneCallback(com.mbridge.msdk.video.dynview.d.a aVar) {
        this.M = aVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        if (campaignEx.getSpareOfferFlag() != 1) {
            campaignEx.setCbt(0);
        } else if (this.m == null) {
        } else {
            if (this.m.x() == 1) {
                campaignEx.setCbt(1);
            } else {
                campaignEx.setCbt(0);
            }
        }
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5, int i6) {
        try {
            String a2 = com.mbridge.msdk.foundation.tools.h.a(i2, i3, i4, i5, i6);
            q.d(a, a2);
            if (this.f != null) {
                if ((this.f.getObject() instanceof j) && !TextUtils.isEmpty(a2)) {
                    ((j) this.f.getObject()).b(a2);
                    g.a().a((WebView) this.f, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
                }
            }
            c.a().a(i2, i3, i4, i5, i6);
            LinkedHashMap<String, View> b2 = c.a().b(this.k, this.I);
            if (b2 != null && b2.size() > 0) {
                for (View next : b2.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).setNotchPadding(i3, i4, i5, i6);
                    } else {
                        int i7 = i3;
                        int i8 = i4;
                        int i9 = i5;
                        int i10 = i6;
                    }
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).setNotchPadding(i2, i3, i4, i5, i6);
                    }
                    if ((next instanceof WindVaneWebView) && !TextUtils.isEmpty(a2)) {
                        g.a().a((Object) next, "oncutoutfetched", Base64.encodeToString(a2.getBytes(), 0));
                    }
                }
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.J = str;
    }

    private class a extends c.a {
        private a() {
        }

        public final void a() {
            super.a();
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals("1.0") && MBridgeBTContainer.this.j != null) {
                        if (MBridgeBTContainer.this.y) {
                            MBridgeBTContainer.this.onAdClose();
                        } else {
                            MBridgeBTContainer.this.j.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
        }

        public final void a(boolean z) {
            super.a(z);
            MBridgeBTContainer.this.F.a(z, MBridgeBTContainer.this.l, MBridgeBTContainer.this.k);
        }

        public final void a(int i, String str) {
            super.a(i, str);
        }

        public final void b() {
            super.b();
        }
    }

    static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.c> b2 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).b(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                    int d2 = b2.get(0).d();
                    String b3 = b2.get(0).b();
                    if (d2 == 1) {
                        hashMap.put("encrypt_p=", "encrypt_p=" + b3);
                        hashMap.put("irlfa=", "irlfa=" + 1);
                        for (Map.Entry entry : hashMap.entrySet()) {
                            campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
