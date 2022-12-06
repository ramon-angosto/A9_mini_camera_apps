package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.work.WorkRequest;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static final String U = t.a(m.a(), "tt_reward_msg");
    private static final String V = t.a(m.a(), "tt_msgPlayable");
    private static final String W = t.a(m.a(), "tt_negtiveBtnBtnText");
    private static final String X = t.a(m.a(), "tt_postiveBtnText");
    private static final String Y = t.a(m.a(), "tt_postiveBtnTextPlayable");
    private static b ad;
    protected int R;
    protected int S;
    protected b T;
    /* access modifiers changed from: private */
    public String Z;
    /* access modifiers changed from: private */
    public int aa;
    private String ab;
    private String ac;
    private AtomicBoolean ae = new AtomicBoolean(false);
    private int af = -1;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0066, code lost:
        if (r3.g.get() == false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.c.c.b.o$a r0 = new com.bytedance.sdk.openadsdk.c.c.b.o$a
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            long r1 = r1.s()
            r0.a((long) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            long r1 = r1.u()
            r0.c((long) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            long r1 = r1.j()
            r0.b((long) r1)
            r1 = 3
            r0.e(r1)
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            int r1 = r1.r()
            r0.f(r1)
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            com.bykv.vk.openvk.component.video.api.b.a r1 = r1.c()
            com.bytedance.sdk.openadsdk.component.reward.a.e r2 = r3.m
            com.bytedance.sdk.openadsdk.c.f r2 = r2.a()
            com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) r1, (com.bytedance.sdk.openadsdk.c.c.b.o.a) r0, (com.bytedance.sdk.openadsdk.c.f) r2)
            com.bytedance.sdk.openadsdk.component.reward.a.e r0 = r3.m
            r0.m()
            int r0 = r3.t
            com.bytedance.sdk.openadsdk.core.p.c((int) r0)
            com.bytedance.sdk.openadsdk.component.reward.a.e r0 = r3.m
            java.lang.String r1 = "skip"
            r2 = 0
            r0.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r2)
            boolean r0 = r3.h()
            if (r0 == 0) goto L_0x0068
            r0 = 1
            r3.a((boolean) r0)
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.l.a((com.bytedance.sdk.openadsdk.core.model.n) r0)
            if (r0 == 0) goto L_0x006b
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.g
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x006b
        L_0x0068:
            r3.finish()
        L_0x006b:
            boolean r0 = com.bytedance.sdk.openadsdk.multipro.b.c()
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = "onSkippedVideo"
            r3.c((java.lang.String) r0)
            goto L_0x007e
        L_0x0077:
            com.bytedance.sdk.openadsdk.a.e.b r0 = r3.T
            if (r0 == 0) goto L_0x007e
            r0.f()
        L_0x007e:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            if (r0 == 0) goto L_0x00b4
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            if (r0 == 0) goto L_0x00b4
            com.bytedance.sdk.openadsdk.component.reward.a.e r0 = r3.m
            if (r0 == 0) goto L_0x00b4
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.d r0 = r0.a()
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            long r1 = r1.s()
            r0.f((long) r1)
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            com.bytedance.sdk.openadsdk.core.f.a r0 = r0.ax()
            com.bytedance.sdk.openadsdk.core.f.d r0 = r0.a()
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r3.m
            long r1 = r1.s()
            r0.e((long) r1)
        L_0x00b4:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.c
            r1 = 5
            com.bytedance.sdk.openadsdk.k.a.e.a((com.bytedance.sdk.openadsdk.core.model.n) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.O():void");
    }

    private JSONObject P() {
        JSONObject jSONObject = new JSONObject();
        int v = (int) this.m.v();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.Z);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.aa);
            jSONObject.put("network", o.c(this.b));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int F = this.c.F();
            String str = "unKnow";
            if (F == 2) {
                str = y.b();
            } else if (F == 1) {
                str = y.c();
            }
            jSONObject.put("user_agent", str);
            jSONObject.put("extra", this.c.aP());
            jSONObject.put("media_extra", this.ab);
            jSONObject.put("video_duration", this.c.J().f());
            jSONObject.put("play_start_ts", this.R);
            jSONObject.put("play_end_ts", this.S);
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, v);
            jSONObject.put(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, this.ac);
            jSONObject.put("trans_id", com.bytedance.sdk.openadsdk.l.o.a().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void Q() {
        if (!this.G) {
            this.G = true;
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                c("onAdClose");
                return;
            }
            b bVar = this.T;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z, int i, String str2, int i2, String str3) {
        final String str4 = str;
        final boolean z2 = z;
        final int i3 = i;
        final String str5 = str2;
        final int i4 = i2;
        final String str6 = str3;
        e.c(new g("Reward_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTRewardVideoActivity.this.a(0).executeRewardVideoCallback(TTRewardVideoActivity.this.d, str4, z2, i3, str5, i4, str6);
                } catch (Throwable th) {
                    l.b("TTRewardVideoActivity", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    public void b(final boolean z, final boolean z2) {
        String str;
        a aVar;
        if (!m.d().f(String.valueOf(this.t))) {
            if (z) {
                if (!z2) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                        c("onSkippedVideo");
                    } else {
                        b bVar = this.T;
                        if (bVar != null) {
                            bVar.f();
                        }
                    }
                }
                finish();
                return;
            }
            O();
        } else if (!this.ae.get()) {
            this.A.set(true);
            this.m.o();
            if (z) {
                x();
            }
            final a aVar2 = new a(this);
            this.B = aVar2;
            a aVar3 = this.B;
            if (z) {
                aVar = aVar3.a(V);
                str = Y;
            } else {
                aVar = aVar3.a(U);
                str = X;
            }
            aVar.b(str).c(W);
            this.B.a((a.C0050a) new a.C0050a() {
                public void a() {
                    TTRewardVideoActivity.this.m.n();
                    if (z) {
                        TTRewardVideoActivity.this.z();
                    }
                    aVar2.dismiss();
                    TTRewardVideoActivity.this.A.set(false);
                }

                public void b() {
                    aVar2.dismiss();
                    TTRewardVideoActivity.this.A.set(false);
                    TTRewardVideoActivity.this.p.d(Integer.MAX_VALUE);
                    if (z) {
                        TTRewardVideoActivity.this.r();
                        if (!z2) {
                            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                                TTRewardVideoActivity.this.c("onSkippedVideo");
                            } else if (TTRewardVideoActivity.this.T != null) {
                                TTRewardVideoActivity.this.T.f();
                            }
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    TTRewardVideoActivity.this.O();
                }
            }).show();
        } else if (z) {
            if (!z2) {
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    c("onSkippedVideo");
                } else {
                    b bVar2 = this.T;
                    if (bVar2 != null) {
                        bVar2.f();
                    }
                }
            }
            finish();
        } else {
            O();
        }
    }

    private boolean b(Bundle bundle) {
        String stringExtra;
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            Intent intent = getIntent();
            if (!(intent == null || (stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA)) == null)) {
                try {
                    this.c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                } catch (Exception e) {
                    l.b("TTRewardVideoActivity", "rewarded_video", "TTRewardVideoActivity MultiGlobalInfo throw ", e);
                }
            }
        } else {
            this.c = r.a().c();
            this.T = r.a().d();
        }
        if (!com.bytedance.sdk.openadsdk.multipro.b.c()) {
            r.a().h();
        }
        if (bundle != null) {
            if (this.T == null) {
                this.T = ad;
                ad = null;
            }
            try {
                this.c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(bundle.getString("material_meta")));
                this.w.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.w.get()) {
                    this.k.d(true);
                    this.k.a((String) null, (CharSequence) j.c);
                    this.k.e(true);
                }
            } catch (Throwable unused) {
            }
        }
        if (this.c == null) {
            l.c("TTRewardVideoActivity", "rewarded_video", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return false;
        }
        this.n.a(this.c, this.a);
        this.n.a();
        this.c.a(this.c.g(), 7);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006a, code lost:
        if (r12.o.e().e() != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002d, code lost:
        if (((1.0d - (((double) r12.s) / r12.m.C())) * 100.0d) >= ((double) r0)) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A() {
        /*
            r12 = this;
            com.bytedance.sdk.openadsdk.core.settings.j r0 = com.bytedance.sdk.openadsdk.core.m.d()
            int r1 = r12.t
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.a r0 = r0.v(r1)
            int r0 = r0.f
            com.bytedance.sdk.openadsdk.core.model.n r1 = r12.c
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.p.j(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0031
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.bytedance.sdk.openadsdk.component.reward.a.e r1 = r12.m
            double r8 = r1.C()
            int r1 = r12.s
            double r10 = (double) r1
            double r10 = r10 / r8
            double r6 = r6 - r10
            double r6 = r6 * r4
            double r0 = (double) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0070
        L_0x002f:
            r3 = r2
            goto L_0x0070
        L_0x0031:
            r1 = 1120403456(0x42c80000, float:100.0)
            r4 = 1065353216(0x3f800000, float:1.0)
            com.bytedance.sdk.openadsdk.core.model.n r5 = r12.c
            int r5 = r5.at()
            float r5 = (float) r5
            com.bytedance.sdk.openadsdk.component.reward.a.b r6 = r12.p
            int r6 = r6.k()
            float r6 = (float) r6
            float r6 = r6 / r5
            float r4 = r4 - r6
            float r4 = r4 * r1
            float r0 = (float) r0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x004d
            r0 = r2
            goto L_0x004e
        L_0x004d:
            r0 = r3
        L_0x004e:
            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.m.d()
            int r4 = r12.t
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.a((java.lang.String) r4)
            if (r1 != 0) goto L_0x006d
            if (r0 == 0) goto L_0x0070
            com.bytedance.sdk.openadsdk.component.reward.a.f r0 = r12.o
            com.bytedance.sdk.openadsdk.core.u r0 = r0.e()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0070
            goto L_0x002f
        L_0x006d:
            if (r1 != r2) goto L_0x0070
            r3 = r0
        L_0x0070:
            if (r3 == 0) goto L_0x0077
            r0 = 10000(0x2710, float:1.4013E-41)
            r12.f(r0)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.A():void");
    }

    /* access modifiers changed from: protected */
    public void H() {
        View k = this.i.k();
        if (k != null) {
            k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTRewardVideoActivity.this.o.s();
                    TTRewardVideoActivity.this.r();
                    if (p.i(TTRewardVideoActivity.this.c)) {
                        TTRewardVideoActivity.this.b(true, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            });
        }
        this.k.a((com.bytedance.sdk.openadsdk.component.reward.top.b) new com.bytedance.sdk.openadsdk.component.reward.top.b() {
            public void a(View view) {
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.b(p.i(tTRewardVideoActivity.c), false);
            }

            public void b(View view) {
                if (!(TTRewardVideoActivity.this.L == null || TTRewardVideoActivity.this.L.a() == null)) {
                    TTRewardVideoActivity.this.L.a().a(TTRewardVideoActivity.this.r);
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.r = !tTRewardVideoActivity.r;
                l.a("TTRewardVideoActivity", "rewarded_video", "will set is Mute " + TTRewardVideoActivity.this.r + " mLastVolume=" + TTRewardVideoActivity.this.E.b());
                TTRewardVideoActivity.this.m.b(TTRewardVideoActivity.this.r);
                if (!p.j(TTRewardVideoActivity.this.c) || TTRewardVideoActivity.this.v.get()) {
                    if (p.a(TTRewardVideoActivity.this.c)) {
                        TTRewardVideoActivity.this.E.a(TTRewardVideoActivity.this.r, true);
                    }
                    TTRewardVideoActivity.this.o.d(TTRewardVideoActivity.this.r);
                    if (TTRewardVideoActivity.this.c != null && TTRewardVideoActivity.this.c.ax() != null && TTRewardVideoActivity.this.c.ax().a() != null && TTRewardVideoActivity.this.m != null) {
                        if (TTRewardVideoActivity.this.r) {
                            TTRewardVideoActivity.this.c.ax().a().h(TTRewardVideoActivity.this.m.s());
                        } else {
                            TTRewardVideoActivity.this.c.ax().a().i(TTRewardVideoActivity.this.m.s());
                        }
                    }
                }
            }

            public void c(View view) {
                TTRewardVideoActivity.this.G();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        return true;
    }

    public void K() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            c("onAdShow");
            return;
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void L() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            c("onAdVideoBarClick");
            return;
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void M() {
        if (!this.ae.get()) {
            this.ae.set(true);
            if (!m.d().m(String.valueOf(this.t))) {
                m.c().a(P(), (n.b) new n.b() {
                    public void a(int i, String str) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                            TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i, str);
                        } else if (TTRewardVideoActivity.this.T != null) {
                            TTRewardVideoActivity.this.T.a(false, 0, "", i, str);
                        }
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
                        if ((((17 + 1) * 17) % 2) == 0) goto L_0x0025;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
                        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x0054;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
                        if (((((29 - 1) * 29) * ((29 * 2) - 1)) % 6) != 0) goto L_0x0061;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
                        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x001e;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:24:0x001e, code lost:
                        continue;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
                        switch(31) {
                            case 29: goto L_0x001e;
                            case 30: goto L_0x002b;
                            case 31: goto L_0x007b;
                            default: goto L_0x002a;
                        };
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
                        switch(39) {
                            case 57: goto L_0x002f;
                            case 58: goto L_0x003b;
                            case 59: goto L_0x0044;
                            default: goto L_0x002e;
                        };
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
                        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x0025;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void a(final com.bytedance.sdk.openadsdk.core.o.b r9) {
                        /*
                            r8 = this;
                            com.bytedance.sdk.openadsdk.core.model.s r0 = r9.c
                            int r4 = r0.a()
                            com.bytedance.sdk.openadsdk.core.model.s r0 = r9.c
                            java.lang.String r5 = r0.b()
                            boolean r0 = com.bytedance.sdk.openadsdk.multipro.b.c()
                            if (r0 == 0) goto L_0x006f
                            com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r1 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                            boolean r3 = r9.b
                            r6 = 0
                            java.lang.String r2 = "onRewardVerify"
                            java.lang.String r7 = ""
                            r1.a(r2, r3, r4, r5, r6, r7)
                        L_0x001e:
                            r9 = 39
                            r0 = 1
                            switch(r9) {
                                case 39: goto L_0x0025;
                                case 40: goto L_0x0054;
                                case 41: goto L_0x0061;
                                default: goto L_0x0024;
                            }
                        L_0x0024:
                            goto L_0x001e
                        L_0x0025:
                            r1 = 31
                            switch(r1) {
                                case 29: goto L_0x001e;
                                case 30: goto L_0x002b;
                                case 31: goto L_0x007b;
                                default: goto L_0x002a;
                            }
                        L_0x002a:
                            goto L_0x0025
                        L_0x002b:
                            switch(r9) {
                                case 57: goto L_0x002f;
                                case 58: goto L_0x003b;
                                case 59: goto L_0x0044;
                                default: goto L_0x002e;
                            }
                        L_0x002e:
                            goto L_0x007b
                        L_0x002f:
                            r1 = 7
                            int r2 = 7 - r0
                            int r2 = r2 * r1
                            int r1 = r1 * 2
                            int r1 = r1 - r0
                            int r2 = r2 * r1
                            int r2 = r2 % 6
                            if (r2 == 0) goto L_0x0025
                        L_0x003b:
                            r1 = 17
                            int r1 = r1 + r0
                            int r1 = r1 * 17
                            int r1 = r1 % 2
                            if (r1 == 0) goto L_0x0025
                        L_0x0044:
                            r1 = 12
                            r2 = 37
                            int r3 = r1 * r1
                            int r4 = r2 * r2
                            int r3 = r3 + r4
                            int r1 = r1 * r2
                            int r1 = r1 * 2
                            int r3 = r3 - r1
                            if (r3 >= 0) goto L_0x0054
                            goto L_0x0025
                        L_0x0054:
                            r1 = 29
                            int r2 = 29 - r0
                            int r2 = r2 * r1
                            int r1 = r1 * 2
                            int r1 = r1 - r0
                            int r2 = r2 * r1
                            int r2 = r2 % 6
                            if (r2 == 0) goto L_0x0025
                        L_0x0061:
                            r1 = 38
                            int r2 = 38 - r0
                            int r2 = r2 * r1
                            int r1 = r1 * 2
                            int r1 = r1 - r0
                            int r2 = r2 * r1
                            int r2 = r2 % 6
                            if (r2 == 0) goto L_0x001e
                            goto L_0x002f
                        L_0x006f:
                            com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r0 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                            com.bytedance.sdk.component.utils.x r0 = r0.q
                            com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity$7$1 r1 = new com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity$7$1
                            r1.<init>(r9, r4, r5)
                            r0.post(r1)
                        L_0x007b:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass7.a(com.bytedance.sdk.openadsdk.core.o$b):void");
                    }
                });
            } else if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                a("onRewardVerify", true, this.aa, this.Z, 0, "");
            } else {
                this.q.post(new Runnable() {
                    public void run() {
                        if (TTRewardVideoActivity.this.T != null) {
                            TTRewardVideoActivity.this.T.a(true, TTRewardVideoActivity.this.aa, TTRewardVideoActivity.this.Z, 0, "");
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void N() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            c("onVideoComplete");
            return;
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j, long j2) {
        long j3 = j + (((long) this.O) * 1000);
        if (this.af == -1) {
            this.af = m.d().v(String.valueOf(this.t)).f;
        }
        if (j2 > 0) {
            if (j2 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS && j3 >= 27000) {
                M();
            } else if (((float) (j3 * 100)) / ((float) j2) >= ((float) this.af)) {
                M();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            this.Z = intent.getStringExtra(CampaignEx.JSON_KEY_REWARD_NAME);
            this.aa = intent.getIntExtra(CampaignEx.JSON_KEY_REWARD_AMOUNT, 0);
            this.ab = intent.getStringExtra("media_extra");
            this.ac = intent.getStringExtra(ReportDBAdapter.ReportColumns.COLUMN_USER_ID);
        }
    }

    public boolean a(long j, boolean z) {
        HashMap hashMap;
        f fVar = new f();
        fVar.a(System.currentTimeMillis(), 1.0f);
        this.m.a(this.i.h(), this.c, this.a, I(), fVar);
        if (!TextUtils.isEmpty(this.D)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.D);
        } else {
            hashMap = null;
        }
        this.m.a((Map<String, Object>) hashMap);
        AnonymousClass5 r1 = new c.a() {
            public void a(long j, int i) {
                TTRewardVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTRewardVideoActivity.this.E();
                TTRewardVideoActivity.this.N();
                TTRewardVideoActivity.this.N.set(true);
                if (TTRewardVideoActivity.this.h()) {
                    TTRewardVideoActivity.this.a(false);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.S = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.M();
            }

            public void b(long j, int i) {
                TTRewardVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    TTRewardVideoActivity.this.c("onVideoError");
                } else if (TTRewardVideoActivity.this.T != null) {
                    TTRewardVideoActivity.this.T.e();
                }
                TTRewardVideoActivity.this.D();
                if (!TTRewardVideoActivity.this.m.b()) {
                    TTRewardVideoActivity.this.E();
                    TTRewardVideoActivity.this.m.m();
                    TTRewardVideoActivity.this.M();
                    if (TTRewardVideoActivity.this.h()) {
                        TTRewardVideoActivity.this.a(false, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                    TTRewardVideoActivity.this.m.a(true ^ TTRewardVideoActivity.this.m.B() ? 1 : 0, 2);
                }
            }

            public void a() {
                TTRewardVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTRewardVideoActivity.this.E();
                if (TTRewardVideoActivity.this.h()) {
                    TTRewardVideoActivity.this.a(false, true);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.m.a(TTRewardVideoActivity.this.m.B() ^ true ? 1 : 0, true ^ TTRewardVideoActivity.this.m.B() ? 1 : 0);
                TTRewardVideoActivity.this.m.m();
            }

            public void a(long j, long j2) {
                if (!TTRewardVideoActivity.this.H && TTRewardVideoActivity.this.m.b()) {
                    TTRewardVideoActivity.this.m.o();
                }
                if (!TTRewardVideoActivity.this.v.get()) {
                    TTRewardVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                    if (j != TTRewardVideoActivity.this.m.f()) {
                        TTRewardVideoActivity.this.E();
                    }
                    TTRewardVideoActivity.this.m.a(j);
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    long j3 = j / 1000;
                    double d = (double) j3;
                    tTRewardVideoActivity.s = (int) (tTRewardVideoActivity.m.C() - d);
                    if (TTRewardVideoActivity.this.s >= 0) {
                        TTRewardVideoActivity.this.k.a(String.valueOf(TTRewardVideoActivity.this.s), (CharSequence) null);
                    }
                    TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity2.s = (int) (tTRewardVideoActivity2.m.C() - d);
                    int i = (int) j3;
                    int h = m.d().h(String.valueOf(TTRewardVideoActivity.this.t));
                    boolean z = h >= 0;
                    if ((TTRewardVideoActivity.this.A.get() || TTRewardVideoActivity.this.y.get()) && TTRewardVideoActivity.this.m.b()) {
                        TTRewardVideoActivity.this.m.o();
                    }
                    TTRewardVideoActivity.this.i.c(i);
                    TTRewardVideoActivity.this.a(j, j2);
                    if (TTRewardVideoActivity.this.s > 0) {
                        TTRewardVideoActivity.this.k.d(true);
                        if (!z || i < h) {
                            TTRewardVideoActivity.this.k.a(String.valueOf(TTRewardVideoActivity.this.s), (CharSequence) null);
                            return;
                        }
                        TTRewardVideoActivity.this.w.getAndSet(true);
                        TTRewardVideoActivity.this.k.a(String.valueOf(TTRewardVideoActivity.this.s), (CharSequence) j.c);
                        TTRewardVideoActivity.this.k.e(true);
                    } else if (com.bytedance.sdk.openadsdk.core.model.l.c(TTRewardVideoActivity.this.c) || com.bytedance.sdk.openadsdk.core.model.l.b(TTRewardVideoActivity.this.c)) {
                        TTRewardVideoActivity.this.a(false);
                    } else if (com.bytedance.sdk.openadsdk.core.model.l.a(TTRewardVideoActivity.this.c) && !TTRewardVideoActivity.this.g.get()) {
                        TTRewardVideoActivity.this.w.getAndSet(true);
                        TTRewardVideoActivity.this.k.d(true);
                        TTRewardVideoActivity.this.k.e(true);
                    } else if (TTRewardVideoActivity.this.h()) {
                        TTRewardVideoActivity.this.a(false);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            }
        };
        this.m.a((c.a) r1);
        this.m.a((c.a) r1);
        if (this.i.x != null) {
            this.i.x.a((c.a) r1);
        }
        boolean a = a(j, z, (Map<String, Object>) hashMap);
        if (a && !z) {
            this.R = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        a(str, false, 0, "", 0, "");
    }

    public void f(int i) {
        if (i == 10000) {
            M();
        } else if (i == 10001) {
            N();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        ad = null;
    }

    public void finish() {
        Q();
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b(bundle)) {
            s();
            t();
            d();
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.l != null) {
            this.l.f();
        }
        Q();
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            c("recycleRes");
        }
        this.T = null;
    }

    public void onRewardBarClick(View view) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            c("onAdVideoBarClick");
            return;
        }
        b bVar = this.T;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ad = this.T;
        super.onSaveInstanceState(bundle);
    }

    public void y() {
        M();
    }
}
