package com.bytedance.sdk.openadsdk;

public interface TTClientBidding {
    void loss(Double d, String str, String str2);

    void setPrice(Double d);

    void win(Double d);
}
