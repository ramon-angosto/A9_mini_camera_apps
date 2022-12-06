package com.adcolony.sdk;

import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class AdColonyReward {
    private int a;
    private String b;
    private String c;
    private boolean d;

    AdColonyReward(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.a = c0.d(a2, CampaignEx.JSON_KEY_REWARD_AMOUNT);
        this.b = c0.h(a2, CampaignEx.JSON_KEY_REWARD_NAME);
        this.d = c0.b(a2, "success");
        this.c = c0.h(a2, AdColonyAdapterUtils.KEY_ZONE_ID);
    }

    public int getRewardAmount() {
        return this.a;
    }

    public String getRewardName() {
        return this.b;
    }

    public String getZoneID() {
        return this.c;
    }

    public boolean success() {
        return this.d;
    }
}
