package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.component.b.a;

public class TTC5Proxy {
    public static void loadFeed(Context context, AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        adSlot.setDurationSlotType(5);
        a.a().a(context, adSlot, feedAdListener);
    }

    public static void loadFeed(Context context, AdSlot adSlot, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        adSlot.setDurationSlotType(5);
        a.a().a(context, adSlot, pAGNativeAdLoadListener);
    }
}
