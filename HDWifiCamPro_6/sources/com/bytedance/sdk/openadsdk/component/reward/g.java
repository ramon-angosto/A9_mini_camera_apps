package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.s;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.com.bytedance.overseas.sdk.a.c;
import com.com.bytedance.overseas.sdk.a.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGRewardVideoAdImpl */
class g extends PAGRewardedAd {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public final n b;
    private final AdSlot c;
    /* access modifiers changed from: private */
    public b d;
    private c e;
    private boolean f = true;
    private boolean g;
    private String h;
    private String i;
    private AtomicBoolean j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public String k;
    private boolean l;
    private boolean m;
    private Double n = null;

    g(Context context, n nVar, AdSlot adSlot) {
        this.a = context;
        this.b = nVar;
        this.c = adSlot;
        if (a() == 4) {
            this.e = d.a(this.a, this.b, "rewarded_video");
        }
        this.g = false;
        this.k = o.a();
    }

    public void a(String str) {
        if (!this.j.get()) {
            this.g = true;
            this.h = str;
        }
    }

    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.d = new h(pAGRewardedAdInteractionListener);
        a(0);
    }

    public void a(b bVar) {
        this.d = bVar;
        a(0);
    }

    public int a() {
        n nVar = this.b;
        if (nVar == null) {
            return -1;
        }
        return nVar.L();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public int b() {
        n nVar = this.b;
        if (nVar == null) {
            return -1;
        }
        if (p.i(nVar)) {
            return 2;
        }
        return p.j(this.b) ? 1 : 0;
    }

    public String c() {
        return this.b.n();
    }

    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            l.e("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.bytedance.sdk.openadsdk.c.c.a(this.b, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            l.e("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
        } else if (!this.j.get()) {
            this.j.set(true);
            n nVar = this.b;
            if (nVar == null || nVar.J() == null) {
                com.bytedance.sdk.openadsdk.c.c.a(this.b, "fullscreen_interstitial_ad", "materialMeta error ");
                return;
            }
            Context context = activity == null ? this.a : activity;
            if (context == null) {
                context = m.a();
            }
            if (this.b.l() != 2 || this.b.f() == 5 || this.b.f() == 6) {
                intent = new Intent(context, TTRewardVideoActivity.class);
            } else {
                intent = new Intent(context, TTRewardExpressVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(268435456);
            }
            int i2 = 0;
            try {
                i2 = activity.getWindowManager().getDefaultDisplay().getRotation();
            } catch (Exception unused) {
            }
            intent.putExtra("orientation_angle", i2);
            intent.putExtra(CampaignEx.JSON_KEY_REWARD_NAME, this.b.j());
            intent.putExtra(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.b.k());
            intent.putExtra("media_extra", this.c.getMediaExtra());
            intent.putExtra(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, this.c.getUserID());
            intent.putExtra("show_download_bar", this.f);
            Double d2 = this.n;
            intent.putExtra(TTAdConstant.CLIENT_BIDDING_AUTION_PRICE, d2 == null ? "" : String.valueOf(d2));
            if (!TextUtils.isEmpty(this.i)) {
                intent.putExtra("rit_scene", this.i);
            }
            if (this.g) {
                intent.putExtra("video_cache_url", this.h);
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.ar().toString());
                intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.k);
            } else {
                r.a().h();
                r.a().a(this.b);
                r.a().a(this.d);
                r.a().a(this.e);
                this.d = null;
            }
            com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                public void a() {
                }

                public void a(Throwable th) {
                    l.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                    com.bytedance.sdk.openadsdk.c.c.a(g.this.b, "fullscreen_interstitial_ad", "activity start  fail ");
                }
            });
            String v = this.b.v((String) null);
            if (v != null) {
                try {
                    AdSlot b2 = m.a(this.a).b(v);
                    m.a(this.a).a(v);
                    if (b2 == null) {
                        return;
                    }
                    if (!this.g || TextUtils.isEmpty(this.h)) {
                        m.a(this.a).a(b2);
                    } else {
                        m.a(this.a).b(b2);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.aj();
        }
        return null;
    }

    public void a(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            l.e("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        show(activity);
    }

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            e.c(new com.bytedance.sdk.component.g.g("Reward_registerMultiProcessListener") {
                public void run() {
                    a a2 = a.a(g.this.a);
                    if (i2 == 0 && g.this.d != null) {
                        l.b("MultiProcess", "start registerRewardVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.d(g.this.d);
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.g.asInterface(a2.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(g.this.k, dVar);
                                l.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    public void win(Double d2) {
        if (!this.l) {
            s.a(this.b, d2);
            this.l = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.m) {
            s.a(this.b, d2, str, str2);
            this.m = true;
        }
    }

    public void setPrice(Double d2) {
        this.n = d2;
    }
}
