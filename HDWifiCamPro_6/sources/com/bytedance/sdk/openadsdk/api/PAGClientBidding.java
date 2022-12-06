package com.bytedance.sdk.openadsdk.api;

public interface PAGClientBidding {
    void loss(Double d, String str, String str2);

    void setPrice(Double d);

    void win(Double d);
}
