package com.facebook.ads.internal.api;

import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.RewardedVideoAd;

public interface RewardedVideoAdApi extends FullScreenAd {
    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig();

    RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig();

    void destroy();

    String getPlacementId();

    int getVideoDuration();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig);

    void registerAdCompanionView(AdCompanionView adCompanionView);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    boolean show();

    boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig);

    void unregisterAdCompanionView();
}
