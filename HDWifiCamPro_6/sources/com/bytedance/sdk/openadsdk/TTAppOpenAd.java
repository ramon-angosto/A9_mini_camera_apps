package com.bytedance.sdk.openadsdk;

import android.app.Activity;

@Deprecated
public interface TTAppOpenAd {

    @Deprecated
    public interface AppOpenAdInteractionListener {
        void onAdClicked();

        void onAdCountdownToZero();

        void onAdShow();

        void onAdSkip();
    }

    @Deprecated
    void setOpenAdInteractionListener(AppOpenAdInteractionListener appOpenAdInteractionListener);

    @Deprecated
    void showAppOpenAd(Activity activity);
}
