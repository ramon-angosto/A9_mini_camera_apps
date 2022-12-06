package com.bytedance.sdk.openadsdk;

public interface CustomEventInterstitialListener {
    void onInterstitialClicked();

    void onInterstitialDismissed();

    void onInterstitialImpression();

    void onInterstitialShowFail();

    void onInterstitialShown();

    void onLeaveApplication();
}
