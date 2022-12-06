package com.ironsource.mediationsdk.sdk;

import org.json.JSONObject;

public interface k {
    void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener);

    boolean isRewardedVideoAvailable(JSONObject jSONObject);

    void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener);
}
