package com.facebook.ads;

public interface RewardedVideoAdListener extends AdListener {
    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
