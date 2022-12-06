package com.google.ads.mediation.facebook;

import com.google.android.gms.ads.rewarded.RewardItem;

public class FacebookReward implements RewardItem {
    public int getAmount() {
        return 1;
    }

    public String getType() {
        return "";
    }
}
