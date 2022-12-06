package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.view.View;

public interface PAGNativeAdData {
    View getAdLogoView();

    String getButtonText();

    String getDescription();

    PAGImageItem getIcon();

    PAGMediaView getMediaView();

    String getTitle();
}
