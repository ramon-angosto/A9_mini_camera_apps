package com.bytedance.sdk.openadsdk;

import android.content.Context;

public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    TTAdManager debugLog(int i);

    String getBiddingToken();

    String getBiddingToken(String str);

    @Deprecated
    int getCcpa();

    @Deprecated
    int getCoppa();

    int getDebugLog();

    @Deprecated
    int getGdpr();

    String getSDKVersion();

    String getSupportRegion();

    boolean isExpressAd(String str, String str2);

    boolean isFullScreenVideoAd(String str, String str2);

    @Deprecated
    TTAdManager isUseTextureView(boolean z);

    boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4);

    @Deprecated
    TTAdManager openDebugMode();

    @Deprecated
    void requestPermissionIfNecessary(Context context);

    @Deprecated
    TTAdManager setAllowShowNotifiFromSDK(boolean z);

    @Deprecated
    TTAdManager setAppId(String str);

    @Deprecated
    TTAdManager setCcpa(int i);

    @Deprecated
    TTAdManager setCoppa(int i);

    @Deprecated
    TTAdManager setData(String str);

    @Deprecated
    TTAdManager setGdpr(int i);

    TTAdManager setIconId(int i);

    @Deprecated
    TTAdManager setKeywords(String str);

    @Deprecated
    TTAdManager setName(String str);

    @Deprecated
    TTAdManager setNeedClearTaskReset(String[] strArr);

    @Deprecated
    TTAdManager setPaid(boolean z);

    @Deprecated
    TTAdManager setTitleBarTheme(int i);

    @Deprecated
    void showPrivacyProtection();
}
