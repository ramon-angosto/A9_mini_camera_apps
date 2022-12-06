package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.common.b;
import java.util.List;

@Deprecated
public interface TTAdNative {

    @Deprecated
    public interface AppOpenAdListener extends b {
        void onAppOpenAdLoaded(TTAppOpenAd tTAppOpenAd);

        void onError(int i, String str);
    }

    @Deprecated
    public interface BannerAdListener extends b {
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        void onError(int i, String str);
    }

    @Deprecated
    public interface FeedAdListener extends b {
        @Deprecated
        void onError(int i, String str);

        @Deprecated
        void onFeedAdLoad(List<TTFeedAd> list);
    }

    @Deprecated
    public interface FullScreenVideoAdListener extends b {
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        void onFullScreenVideoCached();
    }

    @Deprecated
    public interface InteractionAdListener extends b {
        void onError(int i, String str);

        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    @Deprecated
    public interface NativeAdListener extends b {
        void onError(int i, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    @Deprecated
    public interface NativeExpressAdListener extends b {
        void onError(int i, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    @Deprecated
    public interface RewardVideoAdListener extends b {
        void onError(int i, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        void onRewardVideoCached();
    }

    @Deprecated
    void loadAppOpenAd(AdSlot adSlot, AppOpenAdListener appOpenAdListener, int i);

    @Deprecated
    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    @Deprecated
    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    @Deprecated
    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    @Deprecated
    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);
}
