package com.bytedance.sdk.openadsdk.api.reward;

import com.bytedance.sdk.openadsdk.api.PAGAdListener;

public interface PAGRewardedAdInteractionListener extends PAGAdListener {
    void onUserEarnedReward(PAGRewardItem pAGRewardItem);

    void onUserEarnedRewardFail(int i, String str);
}
