package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.a.b.b;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import java.util.List;

public abstract class PAGNativeAd implements PAGClientBidding, PangleAd {
    public abstract PAGNativeAdData getNativeAdData();

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener);

    public abstract void showPrivacyActivity();

    public static void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        b.b().a(str, pAGNativeRequest, pAGNativeAdLoadListener);
    }
}
