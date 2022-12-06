package com.mbridge.msdk.out;

public interface OnMBMediaViewListenerPlus {
    void onEnterFullscreen();

    void onExitFullscreen();

    void onFinishRedirection(Campaign campaign, String str);

    void onRedirectionFailed(Campaign campaign, String str);

    void onStartRedirection(Campaign campaign, String str);

    void onVideoAdClicked(Campaign campaign);

    void onVideoComplete();

    void onVideoStart();
}
