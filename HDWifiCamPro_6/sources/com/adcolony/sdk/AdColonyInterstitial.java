package com.adcolony.sdk;

import android.content.Context;
import android.content.Intent;
import androidx.browser.customtabs.CustomTabsCallback;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.z0;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;

public class AdColonyInterstitial {
    public static final int ADCOLONY_IAP_ENGAGEMENT_END_CARD = 0;
    public static final int ADCOLONY_IAP_ENGAGEMENT_OVERLAY = 1;
    /* access modifiers changed from: private */
    public AdColonyInterstitialListener a;
    private f b;
    /* access modifiers changed from: private */
    public c c;
    private AdColonyAdOptions d;
    private p0 e;
    private int f;
    /* access modifiers changed from: private */
    public String g;
    private String h;
    private final String i;
    private String j;
    private String k;
    private g l;
    private boolean m;
    private String n;
    final z0.b o = new a();

    class a implements z0.b {
        private boolean a;

        a() {
        }

        public boolean a() {
            return this.a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
            r0 = com.adcolony.sdk.a.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
            if (r0.I() == false) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
            r0.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r0 = new com.adcolony.sdk.e0.a().a("Ad show failed due to a native timeout (5000 ms). ");
            r0.a("Interstitial with adSessionId(" + com.adcolony.sdk.AdColonyInterstitial.a(r3.b) + "). ").a("Reloading controller.").a(com.adcolony.sdk.e0.i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (com.adcolony.sdk.a.d() != false) goto L_0x0012;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.a     // Catch:{ all -> 0x0056 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                return
            L_0x0007:
                r0 = 1
                r3.a = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                boolean r0 = com.adcolony.sdk.a.d()
                if (r0 != 0) goto L_0x0012
                return
            L_0x0012:
                com.adcolony.sdk.k r0 = com.adcolony.sdk.a.b()
                boolean r1 = r0.I()
                if (r1 == 0) goto L_0x001f
                r0.a()
            L_0x001f:
                com.adcolony.sdk.e0$a r0 = new com.adcolony.sdk.e0$a
                r0.<init>()
                java.lang.String r1 = "Ad show failed due to a native timeout (5000 ms). "
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Interstitial with adSessionId("
                r1.append(r2)
                com.adcolony.sdk.AdColonyInterstitial r2 = com.adcolony.sdk.AdColonyInterstitial.this
                java.lang.String r2 = r2.g
                r1.append(r2)
                java.lang.String r2 = "). "
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                java.lang.String r1 = "Reloading controller."
                com.adcolony.sdk.e0$a r0 = r0.a((java.lang.String) r1)
                com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.i
                r0.a((com.adcolony.sdk.e0) r1)
                return
            L_0x0056:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.AdColonyInterstitial.a.run():void");
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (!(a.a() instanceof AdColonyInterstitialActivity) && AdColonyInterstitial.this.a != null) {
                AdColonyInterstitial.this.a.onOpened(AdColonyInterstitial.this);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ d a;
        final /* synthetic */ String b;

        c(d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        public void run() {
            Context a2 = a.a();
            if (a2 instanceof b) {
                this.a.a(a2, c0.b(), this.b);
            } else {
                if (AdColonyInterstitial.this.a != null) {
                    AdColonyInterstitial.this.a.onClosed(AdColonyInterstitial.this);
                    AdColonyInterstitial.this.setListener((AdColonyInterstitialListener) null);
                }
                AdColonyInterstitial.this.o();
                AdColonyInterstitial.this.destroy();
                a.b().e(false);
            }
            if (AdColonyInterstitial.this.c != null) {
                this.a.a(AdColonyInterstitial.this.c);
                c unused = AdColonyInterstitial.this.c = null;
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ AdColonyInterstitialListener a;

        d(AdColonyInterstitialListener adColonyInterstitialListener) {
            this.a = adColonyInterstitialListener;
        }

        public void run() {
            this.a.onRequestNotFilled(AdColony.a(AdColonyInterstitial.this.getZoneID()));
        }
    }

    class e implements Runnable {
        final /* synthetic */ AdColonyInterstitialListener a;

        e(AdColonyInterstitialListener adColonyInterstitialListener) {
            this.a = adColonyInterstitialListener;
        }

        public void run() {
            this.a.onExpiring(AdColonyInterstitial.this);
        }
    }

    interface f {
        void a();
    }

    enum g {
        REQUESTED,
        FILLED,
        NOT_FILLED,
        EXPIRED,
        SHOWN,
        CLOSED
    }

    AdColonyInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, String str2) {
        this.a = adColonyInterstitialListener;
        this.i = str2;
        this.g = str;
        this.l = g.REQUESTED;
    }

    private boolean k() {
        String e2 = a.b().s().e();
        String viewNetworkPassFilter = getViewNetworkPassFilter();
        return viewNetworkPassFilter == null || viewNetworkPassFilter.length() == 0 || viewNetworkPassFilter.equals(e2) || viewNetworkPassFilter.equals("all") || (viewNetworkPassFilter.equals(CustomTabsCallback.ONLINE_EXTRAS_KEY) && (e2.equals("wifi") || e2.equals("cell"))) || (viewNetworkPassFilter.equals("offline") && e2.equals("none"));
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
    }

    public boolean cancel() {
        if (this.c == null) {
            return false;
        }
        Context a2 = a.a();
        if (a2 != null && !(a2 instanceof AdColonyInterstitialActivity)) {
            return false;
        }
        f1 b2 = c0.b();
        c0.a(b2, "id", this.c.a());
        new h0("AdSession.on_request_close", this.c.k(), b2).c();
        return true;
    }

    /* access modifiers changed from: package-private */
    public c d() {
        return this.c;
    }

    public boolean destroy() {
        a.b().c().f().remove(this.g);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        if (a.d()) {
            k b2 = a.b();
            d c2 = b2.c();
            z0.b((Runnable) new b());
            AdColonyZone adColonyZone = b2.C().get(this.i);
            if (adColonyZone != null && adColonyZone.isRewarded()) {
                f1 f1Var = new f1();
                c0.b(f1Var, CampaignEx.JSON_KEY_REWARD_AMOUNT, adColonyZone.getRewardAmount());
                c0.a(f1Var, CampaignEx.JSON_KEY_REWARD_NAME, adColonyZone.getRewardName());
                c0.b(f1Var, "success", true);
                c0.a(f1Var, AdColonyAdapterUtils.KEY_ZONE_ID, this.i);
                b2.e(new h0("AdColony.v4vc_reward", 0, f1Var));
            }
            z0.b((Runnable) new c(c2, str));
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.k;
    }

    public AdColonyInterstitialListener getListener() {
        return this.a;
    }

    public String getViewNetworkPassFilter() {
        return this.n;
    }

    public String getZoneID() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.e != null;
    }

    public boolean isExpired() {
        g gVar = this.l;
        return gVar == g.EXPIRED || gVar == g.SHOWN || gVar == g.CLOSED;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.l == g.FILLED;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.l == g.REQUESTED;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.l == g.SHOWN;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        z0.c((Runnable) this.o);
        Context a2 = a.a();
        if (a2 == null || !a.d() || this.o.a()) {
            return false;
        }
        a.b().a(this.c);
        a.b().a(this);
        z0.a(new Intent(a2, AdColonyInterstitialActivity.class));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        f fVar;
        synchronized (this) {
            r();
            fVar = this.b;
            if (fVar != null) {
                this.b = null;
            } else {
                fVar = null;
            }
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        s();
        AdColonyInterstitialListener adColonyInterstitialListener = this.a;
        if (adColonyInterstitialListener == null) {
            return false;
        }
        z0.b((Runnable) new e(adColonyInterstitialListener));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        u();
        AdColonyInterstitialListener adColonyInterstitialListener = this.a;
        if (adColonyInterstitialListener == null) {
            return false;
        }
        z0.b((Runnable) new d(adColonyInterstitialListener));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.l = g.CLOSED;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.l = g.EXPIRED;
    }

    public void setListener(AdColonyInterstitialListener adColonyInterstitialListener) {
        this.a = adColonyInterstitialListener;
    }

    public void setViewNetworkPassFilter(String str) {
        this.n = str;
    }

    public boolean show() {
        boolean z = false;
        if (!a.d()) {
            return false;
        }
        k b2 = a.b();
        f1 b3 = c0.b();
        c0.a(b3, AdColonyAdapterUtils.KEY_ZONE_ID, this.i);
        c0.b(b3, "type", 0);
        c0.a(b3, "id", this.g);
        if (m()) {
            c0.b(b3, "request_fail_reason", 24);
            new e0.a().a("This ad object has already been shown. Please request a new ad ").a("via AdColony.requestInterstitial.").a(e0.f);
        } else if (this.l == g.EXPIRED) {
            c0.b(b3, "request_fail_reason", 17);
            new e0.a().a("This ad object has expired. Please request a new ad via AdColony").a(".requestInterstitial.").a(e0.f);
        } else if (b2.J()) {
            c0.b(b3, "request_fail_reason", 23);
            new e0.a().a("Can not show ad while an interstitial is already active.").a(e0.f);
        } else if (a(b2.C().get(this.i))) {
            c0.b(b3, "request_fail_reason", 11);
        } else if (!k()) {
            c0.b(b3, "request_fail_reason", 9);
            new e0.a().a("Tried to show interstitial ad during unacceptable network conditions.").a(e0.f);
        } else {
            v();
            a.b().e(true);
            z0.a((Runnable) this.o, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            z = true;
        }
        AdColonyAdOptions adColonyAdOptions = this.d;
        if (adColonyAdOptions != null) {
            c0.b(b3, "pre_popup", adColonyAdOptions.a);
            c0.b(b3, "post_popup", this.d.b);
        }
        AdColonyZone adColonyZone = b2.C().get(this.i);
        if (adColonyZone != null && adColonyZone.isRewarded() && b2.w() == null) {
            new e0.a().a("Rewarded ad: show() called with no reward listener set.").a(e0.f);
        }
        new h0("AdSession.launch_ad_unit", 1, b3).c();
        return z;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.l = g.FILLED;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.l = g.NOT_FILLED;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        this.l = g.SHOWN;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        this.k = str;
    }

    /* access modifiers changed from: package-private */
    public boolean a(AdColonyZone adColonyZone) {
        if (adColonyZone != null) {
            if (adColonyZone.getPlayFrequency() <= 1) {
                return false;
            }
            if (adColonyZone.a() == 0) {
                adColonyZone.b(adColonyZone.getPlayFrequency() - 1);
                return false;
            }
            adColonyZone.b(adColonyZone.a() - 1);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.j = str;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.m = z;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        boolean z;
        synchronized (this) {
            if (this.l == g.CLOSED) {
                z = true;
            } else {
                this.b = fVar;
                z = false;
            }
        }
        if (z) {
            fVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f1 f1Var) {
        if (!f1Var.b()) {
            this.e = new p0(f1Var, this.g);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyAdOptions adColonyAdOptions) {
        this.d = adColonyAdOptions;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f = i2;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        String str = this.h;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public p0 e() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.h = str;
    }
}
