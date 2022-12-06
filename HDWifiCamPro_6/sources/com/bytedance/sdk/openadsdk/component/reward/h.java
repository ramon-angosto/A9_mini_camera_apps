package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;

/* compiled from: PAGRewardedAdWrapper */
public class h implements b {
    private TTRewardVideoAd.RewardAdInteractionListener a;
    private PAGRewardedAdInteractionListener b;

    public h(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.a = rewardAdInteractionListener;
        this.b = null;
    }

    public h(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.b = pAGRewardedAdInteractionListener;
        this.a = null;
    }

    public void a() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
            return;
        }
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdShowed();
        }
    }

    public void b() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
            return;
        }
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
        }
    }

    public void c() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdClose();
            return;
        }
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdDismissed();
        }
    }

    public void d() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        } else {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        }
    }

    public void e() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoError();
        } else {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        }
    }

    public void a(boolean z, int i, String str, int i2, String str2) {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify(z, i, str, i2, str2);
            return;
        }
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        if (pAGRewardedAdInteractionListener == null) {
            return;
        }
        if (z) {
            pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i, str));
        } else {
            pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i2, str2);
        }
    }

    public void f() {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.a;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        } else {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.b;
        }
    }
}
