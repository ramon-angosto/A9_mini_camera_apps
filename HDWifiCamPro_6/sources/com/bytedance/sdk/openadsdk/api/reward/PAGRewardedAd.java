package com.bytedance.sdk.openadsdk.api.reward;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.a.e.a;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;

public abstract class PAGRewardedAd implements PAGClientBidding, PangleAd {
    public abstract void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        new a().a(str, pAGRewardedRequest, pAGRewardedAdLoadListener);
    }
}
