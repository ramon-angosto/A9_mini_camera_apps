package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

@Deprecated
public interface TTRewardVideoAd extends TTClientBidding {

    @Deprecated
    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardVerify(boolean z, int i, String str, int i2, String str2);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    @Deprecated
    String getAdCreativeToken();

    @Deprecated
    int getInteractionType();

    @Deprecated
    Map<String, Object> getMediaExtraInfo();

    @Deprecated
    int getRewardVideoAdType();

    @Deprecated
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @Deprecated
    void setShowDownLoadBar(boolean z);

    @Deprecated
    void showRewardVideoAd(Activity activity);

    @Deprecated
    void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
