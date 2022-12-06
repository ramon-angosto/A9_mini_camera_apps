package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface RewardedVideoManualListener extends RewardedVideoListener {
    void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError);

    void onRewardedVideoAdReady();
}
