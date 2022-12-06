package com.google.ads.mediation.facebook;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener {
    private final MediationRewardedAdConfiguration adConfiguration;
    private final AtomicBoolean didRewardedAdClose = new AtomicBoolean();
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private RewardedVideoAd rewardedAd;
    private MediationRewardedAdCallback rewardedAdCallback;
    private final AtomicBoolean showAdCalled = new AtomicBoolean();

    public FacebookRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback2) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.mediationAdLoadCallback = mediationAdLoadCallback2;
    }

    public void render() {
        Context context = this.adConfiguration.getContext();
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.mediationAdLoadCallback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.adConfiguration);
        this.rewardedAd = new RewardedVideoAd(context, placementID);
        if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
            this.rewardedAd.setExtraHints(new ExtraHints.Builder().mediationData(this.adConfiguration.getWatermark()).build());
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withBid(this.adConfiguration.getBidResponse()).withAdExperience(getAdExperienceType()).build());
    }

    public void showAd(Context context) {
        this.showAdCalled.set(true);
        if (!this.rewardedAd.show()) {
            AdError adError = new AdError(110, "Failed to present rewarded ad.", "com.google.ads.mediation.facebook");
            Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError);
            }
            this.rewardedAd.destroy();
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.rewardedAdCallback;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onVideoStart();
            this.rewardedAdCallback.onAdOpened();
        }
    }

    /* access modifiers changed from: package-private */
    public AdExperienceType getAdExperienceType() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public void onRewardedVideoCompleted() {
        this.rewardedAdCallback.onVideoComplete();
        this.rewardedAdCallback.onUserEarnedReward(new FacebookReward());
    }

    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        if (this.showAdCalled.get()) {
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError2);
            }
        } else {
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback2 = this.mediationAdLoadCallback;
            if (mediationAdLoadCallback2 != null) {
                mediationAdLoadCallback2.onFailure(adError2);
            }
        }
        this.rewardedAd.destroy();
    }

    public void onAdLoaded(Ad ad) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback2 = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback2 != null) {
            this.rewardedAdCallback = mediationAdLoadCallback2.onSuccess(this);
        }
    }

    public void onAdClicked(Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    public void onLoggingImpression(Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdImpression();
        }
    }

    public void onRewardedVideoClosed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.didRewardedAdClose.getAndSet(true) && (mediationRewardedAdCallback = this.rewardedAdCallback) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    public void onRewardedVideoActivityDestroyed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.didRewardedAdClose.getAndSet(true) && (mediationRewardedAdCallback = this.rewardedAdCallback) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }
}
