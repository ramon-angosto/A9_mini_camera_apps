package com.mbridge.msdk.out;

public interface SDKInitStatusListener {
    void onInitFail(String str);

    void onInitSuccess();
}
