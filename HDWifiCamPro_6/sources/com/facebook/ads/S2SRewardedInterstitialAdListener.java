package com.facebook.ads;

public interface S2SRewardedInterstitialAdListener extends RewardedInterstitialAdListener {
    void onRewardServerFailed();

    void onRewardServerSuccess();
}
