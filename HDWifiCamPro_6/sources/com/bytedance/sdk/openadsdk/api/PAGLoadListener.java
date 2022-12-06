package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.b;

public interface PAGLoadListener<Ad> extends b {
    void onAdLoaded(Ad ad);

    void onError(int i, String str);
}
