package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class AdColonyZone {
    public static final int BANNER = 1;
    public static final int INTERSTITIAL = 0;
    @Deprecated
    public static final int NATIVE = 2;
    private String a;
    private String b;
    private int c = 5;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;

    AdColonyZone(String str) {
        this.a = str;
    }

    private int a(int i2) {
        if (a.d() && !a.b().E() && !a.b().F()) {
            return i2;
        }
        b();
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.i = i2;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.c = i2;
    }

    public int getPlayFrequency() {
        return a(this.g);
    }

    public int getRemainingViewsUntilReward() {
        return a(this.e);
    }

    public int getRewardAmount() {
        return a(this.h);
    }

    public String getRewardName() {
        return a(this.b);
    }

    public int getViewsPerReward() {
        return a(this.f);
    }

    public String getZoneID() {
        return a(this.a);
    }

    public int getZoneType() {
        return this.d;
    }

    public boolean isRewarded() {
        return this.k;
    }

    public boolean isValid() {
        return a(this.j);
    }

    private void b() {
        new e0.a().a("The AdColonyZone API is not available while AdColony is disabled.").a(e0.h);
    }

    private boolean a(boolean z) {
        if (a.d() && !a.b().E() && !a.b().F()) {
            return z;
        }
        b();
        return false;
    }

    private String a(String str) {
        return a(str, "");
    }

    private String a(String str, String str2) {
        if (a.d() && !a.b().E() && !a.b().F()) {
            return str;
        }
        b();
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void a(h0 h0Var) {
        f1 a2 = h0Var.a();
        f1 f2 = c0.f(a2, "reward");
        this.b = c0.h(f2, CampaignEx.JSON_KEY_REWARD_NAME);
        this.h = c0.d(f2, CampaignEx.JSON_KEY_REWARD_AMOUNT);
        this.f = c0.d(f2, "views_per_reward");
        this.e = c0.d(f2, "views_until_reward");
        this.k = c0.b(a2, "rewarded");
        this.c = c0.d(a2, "status");
        this.d = c0.d(a2, "type");
        this.g = c0.d(a2, "play_interval");
        this.a = c0.h(a2, AdColonyAdapterUtils.KEY_ZONE_ID);
        boolean z = true;
        if (this.c == 1) {
            z = false;
        }
        this.j = z;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.i;
    }
}
