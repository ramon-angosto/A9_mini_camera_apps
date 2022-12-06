package com.mbridge.msdk.reward.player;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.k;
import java.util.List;

public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private boolean A;
    private com.mbridge.msdk.video.dynview.d.a B = new com.mbridge.msdk.video.dynview.d.a() {
        public final void a(CampaignEx campaignEx) {
            if (campaignEx != null) {
                if (MBRewardVideoActivity.this.v != null) {
                    new b().b((View) MBRewardVideoActivity.this.v, 500);
                }
                q.a("RewardMVVideoAdapter", "offer 被点击： " + campaignEx.getId() + "  " + campaignEx.getAppName());
                CampaignEx unused = MBRewardVideoActivity.this.r = campaignEx;
                if (MBRewardVideoActivity.this.s != null && MBRewardVideoActivity.this.s.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a aVar : MBRewardVideoActivity.this.s) {
                        CampaignEx g = aVar.g();
                        if (g != null && TextUtils.equals(g.getId(), campaignEx.getId()) && TextUtils.equals(g.getRequestId(), campaignEx.getRequestId())) {
                            com.mbridge.msdk.videocommon.download.a unused2 = MBRewardVideoActivity.this.q = aVar;
                        }
                    }
                }
                boolean unused3 = MBRewardVideoActivity.this.k = true;
                MBRewardVideoActivity.this.a();
                return;
            }
            MBRewardVideoActivity.this.a("campaign is null");
        }

        public final void a() {
            if (MBRewardVideoActivity.this.v != null) {
                new b().b((View) MBRewardVideoActivity.this.v, 500);
            }
            boolean unused = MBRewardVideoActivity.this.k = true;
            MBRewardVideoActivity.this.a();
        }
    };
    /* access modifiers changed from: private */
    public String a;
    private String b;
    private String c;
    private c d;
    private int e = 2;
    private boolean f = false;
    private boolean g = false;
    private int h;
    private int i;
    private int j;
    /* access modifiers changed from: private */
    public boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public h m;
    private com.mbridge.msdk.videocommon.d.c n;
    private boolean o = false;
    private boolean p = false;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.videocommon.download.a q;
    /* access modifiers changed from: private */
    public CampaignEx r;
    /* access modifiers changed from: private */
    public List<com.mbridge.msdk.videocommon.download.a> s;
    private List<CampaignEx> t;
    private MBTempContainer u;
    /* access modifiers changed from: private */
    public MBridgeBTContainer v;
    private WindVaneWebView w;
    private com.mbridge.msdk.video.bt.module.a.a x;
    private String y;
    private String z;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:78|(1:84)|85|(5:87|(1:89)|90|(1:92)|93)|94|(1:96)|97|(1:103)|104|105|106|107|108|(2:136|143)(4:114|(2:118|(2:120|(2:122|(2:124|(1:126)(1:127))(1:128))(1:129)))|130|(2:135|142)(2:134|141))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x02c6 */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02e0 A[Catch:{ Exception -> 0x015a, all -> 0x0347 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x033a A[Catch:{ Exception -> 0x015a, all -> 0x0347 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.lang.String r2 = "_"
            java.lang.String r3 = ""
            java.lang.String r4 = "anim"
            java.lang.String r5 = "DynamicViewCampaignResourceDownloader"
            super.onCreate(r22)
            r6 = 1
            com.mbridge.msdk.MBridgeConstans.isRewardActivityShowing = r6
            com.mbridge.msdk.foundation.controller.a r7 = com.mbridge.msdk.foundation.controller.a.e()
            r7.a((android.content.Context) r1)
            java.lang.String r7 = "mbridge_more_offer_activity"
            int r7 = r1.findLayout(r7)     // Catch:{ all -> 0x0347 }
            if (r7 >= 0) goto L_0x0027
            java.lang.String r0 = "no mbridge_more_offer_activity layout"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0347 }
            return
        L_0x0027:
            r1.setContentView(r7)     // Catch:{ all -> 0x0347 }
            android.content.Intent r7 = r21.getIntent()     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_UNITID     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r7.getStringExtra(r8)     // Catch:{ all -> 0x0347 }
            r1.a = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r1.a     // Catch:{ all -> 0x0347 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0347 }
            java.lang.String r9 = "data empty error"
            if (r8 == 0) goto L_0x0044
            r1.a((java.lang.String) r9)     // Catch:{ all -> 0x0347 }
            return
        L_0x0044:
            java.util.Map<java.lang.String, com.mbridge.msdk.reward.a.a$d> r8 = com.mbridge.msdk.reward.a.a.b     // Catch:{ all -> 0x0347 }
            java.lang.String r10 = r1.a     // Catch:{ all -> 0x0347 }
            java.lang.Object r8 = r8.get(r10)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.video.bt.module.b.h r8 = (com.mbridge.msdk.video.bt.module.b.h) r8     // Catch:{ all -> 0x0347 }
            r1.m = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r7.getStringExtra(r8)     // Catch:{ all -> 0x0347 }
            r1.b = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_REWARD     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r7.getStringExtra(r8)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.b.c r8 = com.mbridge.msdk.videocommon.b.c.b(r8)     // Catch:{ all -> 0x0347 }
            r1.d = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_USERID     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r7.getStringExtra(r8)     // Catch:{ all -> 0x0347 }
            r1.c = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_MUTE     // Catch:{ all -> 0x0347 }
            r10 = 2
            int r8 = r7.getIntExtra(r8, r10)     // Catch:{ all -> 0x0347 }
            r1.e = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_ISIV     // Catch:{ all -> 0x0347 }
            r11 = 0
            boolean r8 = r7.getBooleanExtra(r8, r11)     // Catch:{ all -> 0x0347 }
            r1.f = r8     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.controller.a r8 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0347 }
            boolean r12 = r1.f     // Catch:{ all -> 0x0347 }
            r14 = 94
            if (r12 == 0) goto L_0x008b
            r12 = 287(0x11f, float:4.02E-43)
            goto L_0x008c
        L_0x008b:
            r12 = r14
        L_0x008c:
            r8.a((int) r12)     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_ISBID     // Catch:{ all -> 0x0347 }
            boolean r8 = r7.getBooleanExtra(r8, r11)     // Catch:{ all -> 0x0347 }
            r1.g = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_EXTRADATA     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = r7.getStringExtra(r8)     // Catch:{ all -> 0x0347 }
            r1.z = r8     // Catch:{ all -> 0x0347 }
            boolean r8 = r1.f     // Catch:{ all -> 0x0347 }
            if (r8 == 0) goto L_0x00bb
            java.lang.String r8 = INTENT_IVREWARD_MODETYPE     // Catch:{ all -> 0x0347 }
            int r8 = r7.getIntExtra(r8, r11)     // Catch:{ all -> 0x0347 }
            r1.h = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_IVREWARD_VALUETYPE     // Catch:{ all -> 0x0347 }
            int r8 = r7.getIntExtra(r8, r11)     // Catch:{ all -> 0x0347 }
            r1.i = r8     // Catch:{ all -> 0x0347 }
            java.lang.String r8 = INTENT_IVREWARD_VALUE     // Catch:{ all -> 0x0347 }
            int r8 = r7.getIntExtra(r8, r11)     // Catch:{ all -> 0x0347 }
            r1.j = r8     // Catch:{ all -> 0x0347 }
        L_0x00bb:
            com.mbridge.msdk.video.signal.factory.b r8 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x0347 }
            r8.<init>(r1)     // Catch:{ all -> 0x0347 }
            r1.jsFactory = r8     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.video.signal.factory.IJSFactory r8 = r1.jsFactory     // Catch:{ all -> 0x0347 }
            r1.registerJsFactory(r8)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.video.bt.module.b.h r8 = r1.m     // Catch:{ all -> 0x0347 }
            if (r8 != 0) goto L_0x00d1
            java.lang.String r0 = "showRewardListener is null"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0347 }
            return
        L_0x00d1:
            com.mbridge.msdk.reward.adapter.RewardUnitCacheManager r8 = com.mbridge.msdk.reward.adapter.RewardUnitCacheManager.getInstance()     // Catch:{ all -> 0x0347 }
            java.lang.String r12 = r1.b     // Catch:{ all -> 0x0347 }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r8 = r8.get(r12, r15)     // Catch:{ all -> 0x0347 }
            r1.n = r8     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r8 = r1.n     // Catch:{ all -> 0x0347 }
            if (r8 != 0) goto L_0x0111
            com.mbridge.msdk.videocommon.d.b r8 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.controller.a r12 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0347 }
            java.lang.String r12 = r12.h()     // Catch:{ all -> 0x0347 }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r8 = r8.a(r12, r15)     // Catch:{ all -> 0x0347 }
            r1.n = r8     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r8 = r1.n     // Catch:{ all -> 0x0347 }
            if (r8 != 0) goto L_0x0111
            com.mbridge.msdk.videocommon.d.b r8 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.controller.a r12 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0347 }
            java.lang.String r12 = r12.h()     // Catch:{ all -> 0x0347 }
            java.lang.String r15 = r1.a     // Catch:{ all -> 0x0347 }
            boolean r13 = r1.f     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r8 = r8.a((java.lang.String) r12, (java.lang.String) r15, (boolean) r13)     // Catch:{ all -> 0x0347 }
            r1.n = r8     // Catch:{ all -> 0x0347 }
        L_0x0111:
            com.mbridge.msdk.videocommon.d.c r8 = r1.n     // Catch:{ all -> 0x0347 }
            if (r8 == 0) goto L_0x012b
            com.mbridge.msdk.videocommon.b.c r8 = r1.d     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r12 = r1.n     // Catch:{ all -> 0x0347 }
            int r12 = r12.k()     // Catch:{ all -> 0x0347 }
            r8.a((int) r12)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.b.c r8 = r1.d     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.d.c r12 = r1.n     // Catch:{ all -> 0x0347 }
            java.lang.String r12 = r12.l()     // Catch:{ all -> 0x0347 }
            r8.a((java.lang.String) r12)     // Catch:{ all -> 0x0347 }
        L_0x012b:
            com.mbridge.msdk.videocommon.b.c r8 = r1.d     // Catch:{ all -> 0x0347 }
            if (r8 == 0) goto L_0x013c
            com.mbridge.msdk.videocommon.b.c r8 = r1.d     // Catch:{ all -> 0x0347 }
            int r8 = r8.b()     // Catch:{ all -> 0x0347 }
            if (r8 > 0) goto L_0x013c
            com.mbridge.msdk.videocommon.b.c r8 = r1.d     // Catch:{ all -> 0x0347 }
            r8.a((int) r6)     // Catch:{ all -> 0x0347 }
        L_0x013c:
            java.lang.String r8 = "mbridge_reward_activity_open"
            int r8 = com.mbridge.msdk.foundation.tools.k.a(r1, r8, r4)     // Catch:{ all -> 0x0347 }
            java.lang.String r12 = "mbridge_reward_activity_stay"
            int r4 = com.mbridge.msdk.foundation.tools.k.a(r1, r12, r4)     // Catch:{ all -> 0x0347 }
            if (r8 <= r6) goto L_0x014f
            if (r4 <= r6) goto L_0x014f
            r1.overridePendingTransition(r8, r4)     // Catch:{ all -> 0x0347 }
        L_0x014f:
            if (r0 == 0) goto L_0x015e
            java.lang.String r4 = SAVE_STATE_KEY_REPORT     // Catch:{ Exception -> 0x015a }
            boolean r0 = r0.getBoolean(r4)     // Catch:{ Exception -> 0x015a }
            r1.p = r0     // Catch:{ Exception -> 0x015a }
            goto L_0x015e
        L_0x015a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0347 }
        L_0x015e:
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x0347 }
            java.util.List r0 = r0.b((java.lang.String) r4)     // Catch:{ all -> 0x0347 }
            r1.s = r0     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = INTENT_ISBIG_OFFER     // Catch:{ all -> 0x0347 }
            boolean r0 = r7.getBooleanExtra(r0, r11)     // Catch:{ all -> 0x0347 }
            r1.k = r0     // Catch:{ all -> 0x0347 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0347 }
            r0.<init>()     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = "进入 show，大模板 "
            r0.append(r4)     // Catch:{ all -> 0x0347 }
            boolean r4 = r1.k     // Catch:{ all -> 0x0347 }
            r0.append(r4)     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.tools.q.a(r5, r0)     // Catch:{ all -> 0x0347 }
            boolean r0 = r1.k     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x01de
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x01a2
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            int r0 = r0.size()     // Catch:{ all -> 0x0347 }
            if (r0 <= 0) goto L_0x01a2
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = (com.mbridge.msdk.videocommon.download.a) r0     // Catch:{ all -> 0x0347 }
            r1.q = r0     // Catch:{ all -> 0x0347 }
        L_0x01a2:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x01cb
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.g()     // Catch:{ all -> 0x0347 }
            r1.r = r0     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            r0.a((boolean) r6)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            r0.b((boolean) r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x01cb
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x0347 }
            int r0 = r0.getMaitve()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ all -> 0x0347 }
            java.lang.String r2 = r2.getMaitve_src()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.click.b.a((android.content.Context) r1, (int) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0347 }
        L_0x01cb:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x01d7
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x01d7
            com.mbridge.msdk.videocommon.b.c r0 = r1.d     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x01da
        L_0x01d7:
            r1.a((java.lang.String) r9)     // Catch:{ all -> 0x0347 }
        L_0x01da:
            r21.a()     // Catch:{ all -> 0x0347 }
            return
        L_0x01de:
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x0347 }
            java.util.List r0 = r0.a((java.lang.String) r4)     // Catch:{ all -> 0x0347 }
            r1.t = r0     // Catch:{ all -> 0x0347 }
            r1.y = r3     // Catch:{ all -> 0x0347 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x0215
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            int r0 = r0.size()     // Catch:{ all -> 0x0347 }
            if (r0 <= 0) goto L_0x0215
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0347 }
            java.lang.String r3 = r0.getCMPTEntryUrl()     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r0.getRequestId()     // Catch:{ all -> 0x0347 }
            r1.y = r4     // Catch:{ all -> 0x0347 }
            int r4 = r0.getMaitve()     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = r0.getMaitve_src()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.click.b.a((android.content.Context) r1, (int) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0347 }
        L_0x0215:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0347 }
            r0.<init>()     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x0347 }
            r0.append(r4)     // Catch:{ all -> 0x0347 }
            r0.append(r2)     // Catch:{ all -> 0x0347 }
            java.lang.String r4 = r1.y     // Catch:{ all -> 0x0347 }
            r0.append(r4)     // Catch:{ all -> 0x0347 }
            r0.append(r2)     // Catch:{ all -> 0x0347 }
            r0.append(r3)     // Catch:{ all -> 0x0347 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.a$a r0 = com.mbridge.msdk.videocommon.a.a(r0)     // Catch:{ all -> 0x0347 }
            r2 = 0
            if (r0 == 0) goto L_0x023d
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r0.a()     // Catch:{ all -> 0x0347 }
            goto L_0x023e
        L_0x023d:
            r0 = r2
        L_0x023e:
            r1.w = r0     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r1.w     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x0343
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x025e
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x025e
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            int r0 = r0.size()     // Catch:{ all -> 0x0347 }
            if (r0 <= 0) goto L_0x025e
            java.util.List<com.mbridge.msdk.videocommon.download.a> r0 = r1.s     // Catch:{ all -> 0x0347 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = (com.mbridge.msdk.videocommon.download.a) r0     // Catch:{ all -> 0x0347 }
            r1.q = r0     // Catch:{ all -> 0x0347 }
        L_0x025e:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x027c
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ all -> 0x0347 }
            boolean r3 = r1.f     // Catch:{ all -> 0x0347 }
            if (r3 == 0) goto L_0x026c
            r14 = 287(0x11f, float:4.02E-43)
        L_0x026c:
            java.lang.String r3 = r1.a     // Catch:{ all -> 0x0347 }
            boolean r4 = r1.g     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.k r0 = r0.c(r3)     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x027a
            com.mbridge.msdk.videocommon.download.a r2 = r0.b((int) r14, (boolean) r4)     // Catch:{ all -> 0x0347 }
        L_0x027a:
            r1.q = r2     // Catch:{ all -> 0x0347 }
        L_0x027c:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x0292
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.g()     // Catch:{ all -> 0x0347 }
            r1.r = r0     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            r0.a((boolean) r6)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            r0.b((boolean) r11)     // Catch:{ all -> 0x0347 }
        L_0x0292:
            com.mbridge.msdk.videocommon.download.a r0 = r1.q     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x029e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.r     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x029e
            com.mbridge.msdk.videocommon.b.c r0 = r1.d     // Catch:{ all -> 0x0347 }
            if (r0 != 0) goto L_0x02a1
        L_0x029e:
            r1.a((java.lang.String) r9)     // Catch:{ all -> 0x0347 }
        L_0x02a1:
            r1.k = r11     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r1.r     // Catch:{ Exception -> 0x02c6 }
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x02c6 }
            android.content.Context r13 = r0.g()     // Catch:{ Exception -> 0x02c6 }
            java.lang.String r14 = "showMoreOffer showBTOld"
            java.lang.String r15 = r1.a     // Catch:{ Exception -> 0x02c6 }
            boolean r0 = r1.g     // Catch:{ Exception -> 0x02c6 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ Exception -> 0x02c6 }
            java.lang.String r17 = r2.getRequestId()     // Catch:{ Exception -> 0x02c6 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.r     // Catch:{ Exception -> 0x02c6 }
            java.lang.String r18 = r2.getRequestIdNotice()     // Catch:{ Exception -> 0x02c6 }
            r19 = 0
            r16 = r0
            com.mbridge.msdk.reward.b.a.a(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x02c6 }
        L_0x02c6:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x033a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            int r0 = r0.size()     // Catch:{ all -> 0x0347 }
            if (r0 <= 0) goto L_0x033a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0347 }
            boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x033a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.t     // Catch:{ all -> 0x0347 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x0319
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r0.getRewardTemplateMode()     // Catch:{ all -> 0x0347 }
            if (r2 == 0) goto L_0x0319
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ all -> 0x0347 }
            int r0 = r0.c()     // Catch:{ all -> 0x0347 }
            boolean r2 = r21.isFinishing()     // Catch:{ all -> 0x0347 }
            if (r2 != 0) goto L_0x0319
            r2 = 7
            if (r0 == r6) goto L_0x0316
            r3 = 6
            if (r0 == r10) goto L_0x0312
            boolean r0 = com.mbridge.msdk.video.dynview.i.b.a(r21)     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x030e
            r1.setRequestedOrientation(r3)     // Catch:{ all -> 0x0347 }
            goto L_0x0319
        L_0x030e:
            r1.setRequestedOrientation(r2)     // Catch:{ all -> 0x0347 }
            goto L_0x0319
        L_0x0312:
            r1.setRequestedOrientation(r3)     // Catch:{ all -> 0x0347 }
            goto L_0x0319
        L_0x0316:
            r1.setRequestedOrientation(r2)     // Catch:{ all -> 0x0347 }
        L_0x0319:
            java.lang.String r0 = "展示新业务"
            com.mbridge.msdk.foundation.tools.q.a(r5, r0)     // Catch:{ all -> 0x0347 }
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ all -> 0x0347 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r1.t     // Catch:{ all -> 0x0347 }
            java.util.List r0 = r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ all -> 0x0347 }
            if (r0 == 0) goto L_0x0334
            int r0 = r0.size()     // Catch:{ all -> 0x0347 }
            if (r0 < r10) goto L_0x0334
            r21.b()     // Catch:{ all -> 0x0347 }
            goto L_0x035c
        L_0x0334:
            java.lang.String r0 = "no available campaign,timeout"
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0347 }
            goto L_0x035c
        L_0x033a:
            java.lang.String r0 = "展示老业务"
            com.mbridge.msdk.foundation.tools.q.a(r5, r0)     // Catch:{ all -> 0x0347 }
            r21.a()     // Catch:{ all -> 0x0347 }
            goto L_0x035c
        L_0x0343:
            r21.b()     // Catch:{ all -> 0x0347 }
            goto L_0x035c
        L_0x0347:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onCreate error"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.a((java.lang.String) r0)
        L_0x035c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.player.MBRewardVideoActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        q.d("MBRewardVideoActivity", str);
        h hVar = this.m;
        if (hVar != null) {
            hVar.a(str);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void a() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        int findID = findID("mbridge_temp_container");
        if (findID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        this.u = (MBTempContainer) findViewById(findID);
        if (this.u == null) {
            a("env error");
        }
        List<CampaignEx> list2 = this.t;
        if (list2 == null || list2.size() <= 0 || !this.t.get(0).isDynamicView()) {
            this.u.setVisibility(0);
        } else {
            new b().c((View) this.u, 500);
        }
        changeHalfScreenPadding(-1);
        this.u.setActivity(this);
        this.u.setBidCampaign(this.g);
        this.u.setBigOffer(this.k);
        this.u.setCampaign(this.r);
        this.u.setCampaignDownLoadTask(this.q);
        this.u.setIV(this.f);
        CampaignEx campaignEx = this.r;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
            this.u.setIVRewardEnable(this.h, this.i, this.j);
        } else {
            this.u.setIVRewardEnable(0, 0, 0);
        }
        this.u.setMute(this.e);
        CampaignEx campaignEx2 = this.r;
        if (!((campaignEx2 == null || (rewardPlus = campaignEx2.getRewardPlus()) == null) && ((list = this.t) == null || list.size() <= 0 || this.t.get(0) == null || (rewardPlus = this.t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.d = cVar;
        }
        this.u.setReward(this.d);
        this.u.setRewardUnitSetting(this.n);
        this.u.setUnitId(this.a);
        this.u.setPlacementId(this.b);
        this.u.setUserId(this.c);
        this.u.setShowRewardListener(this.m);
        this.u.setDeveloperExtraData(this.z);
        this.u.init(this);
        this.u.onCreate();
        try {
            com.mbridge.msdk.reward.b.a.a(this.r, com.mbridge.msdk.foundation.controller.a.e().g(), "showBTOld", this.a, this.g, "", "", 0);
        } catch (Exception unused) {
        }
    }

    private void b() {
        RewardPlus rewardPlus;
        int findID = findID("mbridge_bt_container");
        if (findID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        this.v = (MBridgeBTContainer) findViewById(findID);
        if (this.v == null) {
            a("env error");
        }
        this.v.setVisibility(0);
        this.x = c();
        this.v.setBTContainerCallback(this.x);
        this.v.setShowRewardVideoListener(this.m);
        this.v.setChoiceOneCallback(this.B);
        this.v.setCampaigns(this.t);
        this.v.setCampaignDownLoadTasks(this.s);
        this.v.setRewardUnitSetting(this.n);
        this.v.setUnitId(this.a);
        this.v.setPlacementId(this.b);
        this.v.setUserId(this.c);
        this.v.setActivity(this);
        CampaignEx campaignEx = this.r;
        if (!((campaignEx == null || (rewardPlus = campaignEx.getRewardPlus()) == null) && (this.t.get(0) == null || (rewardPlus = this.t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.d = cVar;
        }
        this.v.setReward(this.d);
        this.v.setIVRewardEnable(this.h, this.i, this.j);
        this.v.setIV(this.f);
        this.v.setMute(this.e);
        this.v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.v.setDeveloperExtraData(this.z);
        this.v.init(this);
        this.v.onCreate();
        List<com.mbridge.msdk.videocommon.download.a> list = this.s;
        if (list != null && list.size() > 0) {
            try {
                com.mbridge.msdk.reward.b.a.a(this.s.get(0).g(), com.mbridge.msdk.foundation.controller.a.e().g(), "showMoreOffer", this.a, this.g, "", "", 0);
            } catch (Exception unused) {
            }
        }
    }

    private com.mbridge.msdk.video.bt.module.a.a c() {
        if (this.x == null) {
            this.x = new com.mbridge.msdk.video.bt.module.a.a() {
                public final void a() {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a();
                    }
                }

                public final void a(boolean z, c cVar) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, cVar);
                    }
                }

                public final void a(boolean z, int i) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, i);
                    }
                }

                public final void a(String str) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(str);
                    }
                }

                public final void a(boolean z, String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(z, str, str2);
                    }
                }

                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(str, str2);
                    }
                }

                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.b(str, str2);
                    }
                }

                public final void a(int i, String str, String str2) {
                    if (MBRewardVideoActivity.this.m != null) {
                        MBRewardVideoActivity.this.m.a(i, str, str2);
                    }
                }
            };
        }
        return this.x;
    }

    public void onResume() {
        super.onResume();
        if (!com.mbridge.msdk.foundation.b.b.c) {
            com.mbridge.msdk.foundation.controller.a.e().a((Context) this);
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    if (MBRewardVideoActivity.this.s != null && MBRewardVideoActivity.this.s.size() > 0) {
                        for (com.mbridge.msdk.videocommon.download.a aVar : MBRewardVideoActivity.this.s) {
                            if (!(aVar == null || aVar.g() == null)) {
                                com.mbridge.msdk.videocommon.a.a.a().a(aVar.g(), MBRewardVideoActivity.this.a);
                            }
                        }
                    }
                }
            });
            MBTempContainer mBTempContainer = this.u;
            if (mBTempContainer != null) {
                mBTempContainer.onResume();
            }
            MBridgeBTContainer mBridgeBTContainer = this.v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onResume();
            }
        }
    }

    public void onPause() {
        super.onPause();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.mbridge.msdk.video.module.b.a.a(this.a);
        try {
            if (this.t != null && this.t.size() > 0) {
                for (CampaignEx a2 : this.t) {
                    a(a2);
                }
            }
            if (this.r != null) {
                a(this.r);
            }
        } catch (Throwable th) {
            q.d("MBRewardVideoActivity", th.getMessage());
        }
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.v = null;
        }
        com.mbridge.msdk.foundation.b.b a3 = com.mbridge.msdk.foundation.b.b.a();
        a3.b(this.a + "_" + 1);
        com.mbridge.msdk.foundation.b.b a4 = com.mbridge.msdk.foundation.b.b.a();
        a4.b(this.a + "_" + 2);
        com.mbridge.msdk.foundation.same.f.b.a().execute(new a(this.s, this.a, this.y));
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!com.mbridge.msdk.foundation.b.b.c) {
            new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    MBRewardVideoActivity.this.onPause();
                }

                public final void b() {
                    MBRewardVideoActivity.this.onResume();
                }

                public final void a(String str) {
                    MBRewardVideoActivity.this.onResume();
                }
            };
            MBTempContainer mBTempContainer = this.u;
            if (mBTempContainer != null) {
                mBTempContainer.onStart();
                com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
                a2.a(this.a + "_" + 1, this.r);
            }
            MBridgeBTContainer mBridgeBTContainer = this.v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onStart();
                List<CampaignEx> list = this.t;
                if (list != null && list.size() > 0) {
                    com.mbridge.msdk.foundation.b.b a3 = com.mbridge.msdk.foundation.b.b.a();
                    a3.a(this.a + "_" + 1, this.t.get(0));
                }
            }
            if (!this.A) {
                com.mbridge.msdk.foundation.b.b a4 = com.mbridge.msdk.foundation.b.b.a();
                a4.c(this.a + "_" + 1, 1);
                com.mbridge.msdk.foundation.b.b a5 = com.mbridge.msdk.foundation.b.b.a();
                a5.b(this.a + "_" + 2);
                this.A = true;
            }
        }
    }

    private static final class a implements Runnable {
        private final List<com.mbridge.msdk.videocommon.download.a> a;
        private final String b;
        private final String c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.a = list;
            this.b = str;
            this.c = str2;
        }

        public final void run() {
            try {
                if (this.a != null && this.a.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.a) {
                        if (!(next == null || next.g() == null)) {
                            CampaignEx g = next.g();
                            String str = g.getRequestId() + g.getId() + g.getVideoUrlEncode();
                            k c2 = com.mbridge.msdk.videocommon.download.c.getInstance().c(this.b);
                            if (c2 != null) {
                                try {
                                    c2.b(str);
                                } catch (Exception unused) {
                                }
                            }
                            if (g != null) {
                                if (g.getRewardTemplateMode() != null) {
                                    if (!TextUtils.isEmpty(g.getRewardTemplateMode().e())) {
                                        com.mbridge.msdk.videocommon.a.b(this.b + "_" + g.getId() + "_" + this.c + "_" + g.getRewardTemplateMode().e());
                                        com.mbridge.msdk.videocommon.a.b(g.getAdType(), g);
                                    }
                                    if (!TextUtils.isEmpty(g.getCMPTEntryUrl())) {
                                        com.mbridge.msdk.videocommon.a.b(this.b + "_" + this.c + "_" + g.getCMPTEntryUrl());
                                    }
                                    com.mbridge.msdk.videocommon.a.a.a().a(g);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                q.a("MBRewardVideoActivity", e.getMessage());
            }
        }
    }

    public void finish() {
        super.finish();
        com.mbridge.msdk.foundation.controller.a.e().a(0);
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.v = null;
        }
        com.mbridge.msdk.foundation.b.b.a().b(this.a);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.p);
        super.onSaveInstanceState(bundle);
    }

    public void setTopControllerPadding(int i2, int i3, int i4, int i5, int i6) {
        MBTempContainer mBTempContainer = this.u;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        MBridgeBTContainer mBridgeBTContainer = this.v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.mbridge.msdk.video.dynview.a.a.e = i2;
        com.mbridge.msdk.video.dynview.a.a.a = i3;
        com.mbridge.msdk.video.dynview.a.a.b = i4;
        com.mbridge.msdk.video.dynview.a.a.c = i5;
        com.mbridge.msdk.video.dynview.a.a.d = i6;
    }

    public int findID(String str) {
        return com.mbridge.msdk.foundation.tools.k.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return com.mbridge.msdk.foundation.tools.k.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public void changeHalfScreenPadding(int i2) {
        try {
            if (this.r != null && this.r.getAdSpaceT() == 2) {
                getWindow().getDecorView().setBackground(new ColorDrawable(0));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
                int b2 = u.b((Context) this, 58.0f);
                int b3 = u.b((Context) this, 104.0f);
                if (this.r.getRewardTemplateMode().c() == 0) {
                    if (i2 == 2) {
                        layoutParams.setMargins(b3, b2, b3, b2);
                    } else {
                        layoutParams.setMargins(b2, b3, b2, b3);
                    }
                } else if (this.r.getRewardTemplateMode().c() == 2) {
                    layoutParams.setMargins(b3, b2, b3, b2);
                } else {
                    layoutParams.setMargins(b2, b3, b2, b3);
                }
                this.u.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            q.d("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(campaignEx.getImageUrl());
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(campaignEx.getIconUrl());
            }
        }
    }

    public void setTheme(int i2) {
        super.setTheme(com.mbridge.msdk.foundation.tools.k.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }
}
