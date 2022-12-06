package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

@Deprecated
public interface TTFullScreenVideoAd extends TTClientBidding {

    @Deprecated
    public interface FullScreenVideoAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    @Deprecated
    String getAdCreativeToken();

    @Deprecated
    int getFullVideoAdType();

    @Deprecated
    int getInteractionType();

    @Deprecated
    Map<String, Object> getMediaExtraInfo();

    @Deprecated
    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    @Deprecated
    void setShowDownLoadBar(boolean z);

    @Deprecated
    void showFullScreenVideoAd(Activity activity);

    @Deprecated
    void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
