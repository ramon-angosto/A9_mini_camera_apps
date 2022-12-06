package com.mbridge.msdk.out;

public interface BannerAdListener {
    void closeFullScreen(MBridgeIds mBridgeIds);

    void onClick(MBridgeIds mBridgeIds);

    void onCloseBanner(MBridgeIds mBridgeIds);

    void onLeaveApp(MBridgeIds mBridgeIds);

    void onLoadFailed(MBridgeIds mBridgeIds, String str);

    void onLoadSuccessed(MBridgeIds mBridgeIds);

    void onLogImpression(MBridgeIds mBridgeIds);

    void showFullScreen(MBridgeIds mBridgeIds);
}
