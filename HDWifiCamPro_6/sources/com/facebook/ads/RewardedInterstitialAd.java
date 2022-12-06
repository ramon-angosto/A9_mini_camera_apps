package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class RewardedInterstitialAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedInterstitialAdApi mRewardedInterstitialAdApi;

    public interface RewardedInterstitialAdLoadConfigBuilder extends Ad.LoadConfigBuilder {
        RewardedInterstitialLoadAdConfig build();

        RewardedInterstitialAdLoadConfigBuilder withAdListener(RewardedInterstitialAdListener rewardedInterstitialAdListener);

        RewardedInterstitialAdLoadConfigBuilder withBid(String str);

        RewardedInterstitialAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        RewardedInterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    public interface RewardedInterstitialAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        RewardedInterstitialShowAdConfig build();

        RewardedInterstitialAdShowConfigBuilder withAppOrientation(int i);
    }

    public interface RewardedInterstitialLoadAdConfig extends Ad.LoadAdConfig {
    }

    public interface RewardedInterstitialShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    public RewardedInterstitialAd(Context context, String str) {
        this.mRewardedInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedInterstitialAd(context, str, this);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedInterstitialAdApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mRewardedInterstitialAdApi.loadAd();
    }

    public void loadAd(RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig) {
        this.mRewardedInterstitialAdApi.loadAd(rewardedInterstitialLoadAdConfig);
    }

    public boolean isAdInvalidated() {
        return this.mRewardedInterstitialAdApi.isAdInvalidated();
    }

    public boolean show() {
        return this.mRewardedInterstitialAdApi.show();
    }

    public boolean show(RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig) {
        return this.mRewardedInterstitialAdApi.show(rewardedInterstitialShowAdConfig);
    }

    public void destroy() {
        this.mRewardedInterstitialAdApi.destroy();
    }

    public boolean isAdLoaded() {
        return this.mRewardedInterstitialAdApi.isAdLoaded();
    }

    public String getPlacementId() {
        return this.mRewardedInterstitialAdApi.getPlacementId();
    }

    public int getVideoDuration() {
        return this.mRewardedInterstitialAdApi.getVideoDuration();
    }

    public RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedInterstitialAdApi.buildLoadAdConfig();
    }

    public RewardedInterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedInterstitialAdApi.buildShowAdConfig();
    }
}
