package com.google.ads.mediation.adcolony;

import com.google.android.gms.ads.rewarded.RewardItem;

class AdColonyReward implements RewardItem {
    private final int rewardAmount;
    private final String rewardType;

    public AdColonyReward(String str, int i) {
        this.rewardType = str;
        this.rewardAmount = i;
    }

    public String getType() {
        return this.rewardType;
    }

    public int getAmount() {
        return this.rewardAmount;
    }
}
