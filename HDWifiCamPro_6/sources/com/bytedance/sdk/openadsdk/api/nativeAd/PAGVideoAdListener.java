package com.bytedance.sdk.openadsdk.api.nativeAd;

public interface PAGVideoAdListener {
    void onVideoAdComplete();

    void onVideoAdPaused();

    void onVideoAdPlay();

    void onVideoError();
}
