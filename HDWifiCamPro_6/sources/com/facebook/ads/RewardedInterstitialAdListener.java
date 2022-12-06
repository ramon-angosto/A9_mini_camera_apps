package com.facebook.ads;

public interface RewardedInterstitialAdListener extends AdListener {
    void onRewardedInterstitialClosed();

    void onRewardedInterstitialCompleted();
}
