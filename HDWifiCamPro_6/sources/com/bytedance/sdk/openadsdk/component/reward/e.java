package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.c.c;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.component.c.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.s;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.com.bytedance.overseas.sdk.a.d;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGInterstitialAdImpl */
class e extends PAGInterstitialAd {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public final n b;
    private final AdSlot c;
    /* access modifiers changed from: private */
    public c d;
    private com.com.bytedance.overseas.sdk.a.c e;
    private boolean f = true;
    private boolean g;
    private String h;
    private String i;
    private AtomicBoolean j = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean k = false;
    /* access modifiers changed from: private */
    public String l;
    private boolean m;
    private boolean n;
    private Double o = null;

    e(Context context, n nVar, AdSlot adSlot) {
        this.a = context;
        this.b = nVar;
        this.c = adSlot;
        if (a() == 4) {
            this.e = d.a(this.a, this.b, "fullscreen_interstitial_ad");
        }
        this.g = false;
        this.l = o.a();
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void a(String str) {
        if (!this.j.get()) {
            this.g = true;
            this.h = str;
        }
    }

    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.d = new a(pAGInterstitialAdInteractionListener);
        a(1);
    }

    public void a(c cVar) {
        this.d = cVar;
        a(1);
    }

    public int a() {
        n nVar = this.b;
        if (nVar == null) {
            return -1;
        }
        return nVar.L();
    }

    public void show(Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            l.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.bytedance.sdk.openadsdk.c.c.a(this.b, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            l.e("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
        } else if (!this.j.get()) {
            this.j.set(true);
            n nVar = this.b;
            if (nVar == null || (nVar.J() == null && this.b.P() == null)) {
                com.bytedance.sdk.openadsdk.c.c.a(this.b, "fullscreen_interstitial_ad", "materialMeta error ");
                return;
            }
            Context context = activity == null ? this.a : activity;
            if (context == null) {
                context = m.a();
            }
            if (this.b.l() != 2 || this.b.f() == 5 || this.b.f() == 6) {
                if (com.bytedance.sdk.openadsdk.component.reward.b.c.a(this.b)) {
                    intent = new Intent(context, TTInterstitialActivity.class);
                } else {
                    intent = new Intent(context, TTFullScreenVideoActivity.class);
                }
            } else if (com.bytedance.sdk.openadsdk.component.reward.b.c.a(this.b)) {
                intent = new Intent(context, TTInterstitialExpressActivity.class);
            } else {
                intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
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
            intent.putExtra("show_download_bar", this.f);
            intent.putExtra("is_verity_playable", this.k);
            Double d2 = this.o;
            intent.putExtra(TTAdConstant.CLIENT_BIDDING_AUTION_PRICE, d2 == null ? "" : String.valueOf(d2));
            if (!TextUtils.isEmpty(this.i)) {
                intent.putExtra("rit_scene", this.i);
            }
            if (this.g) {
                intent.putExtra("video_cache_url", this.h);
            }
            if (b.c()) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.ar().toString());
                intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.l);
            } else {
                r.a().h();
                r.a().a(this.b);
                r.a().a(this.d);
                r.a().a(this.e);
                this.d = null;
            }
            com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                public void a() {
                    if (e.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.b.a().a(e.this.b.J().j());
                        } catch (Throwable unused) {
                        }
                    }
                }

                public void a(Throwable th) {
                    l.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                    if (e.this.k) {
                        try {
                            com.bytedance.sdk.openadsdk.h.b.a().a(e.this.b.J().j(), -1, th != null ? th.getMessage() : "playable tool error open");
                        } catch (Throwable unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.c.c.a(e.this.b, "fullscreen_interstitial_ad", "activity start  fail ");
                }
            });
            String v = this.b.v((String) null);
            if (v != null) {
                try {
                    AdSlot b2 = d.a(this.a).b(v);
                    d.a(this.a).a(v);
                    if (b2 == null) {
                        return;
                    }
                    if (!this.g || TextUtils.isEmpty(this.h)) {
                        d.a(this.a).a(b2);
                    } else {
                        d.a(this.a).b(b2);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void a(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            l.e("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        show(activity);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public Map<String, Object> getMediaExtraInfo() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.aj();
        }
        return null;
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

    private void a(final int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            com.bytedance.sdk.component.g.e.c(new g("FullScreen_registerMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(e.this.a);
                    if (i2 == 1 && e.this.d != null) {
                        l.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(e.this.d);
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.e.asInterface(a2.a(1));
                        if (asInterface != null) {
                            try {
                                asInterface.registerFullVideoListener(e.this.l, cVar);
                                l.b("MultiProcess", "end registerFullScreenVideoListener ! ");
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
        if (!this.m) {
            s.a(this.b, d2);
            this.m = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.n) {
            s.a(this.b, d2, str, str2);
            this.n = true;
        }
    }

    public void setPrice(Double d2) {
        this.o = d2;
    }
}
