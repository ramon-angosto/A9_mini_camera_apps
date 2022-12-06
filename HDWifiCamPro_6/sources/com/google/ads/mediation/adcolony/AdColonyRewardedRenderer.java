package com.google.ads.mediation.adcolony;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.jirbo.adcolony.AdColonyManager;

public class AdColonyRewardedRenderer implements MediationRewardedAd {
    /* access modifiers changed from: private */
    public final MediationRewardedAdConfiguration adConfiguration;
    private AdColonyInterstitial mAdColonyInterstitial;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mAdLoadCallback;
    private MediationRewardedAdCallback mRewardedAdCallback;

    /* access modifiers changed from: package-private */
    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
    }

    /* access modifiers changed from: package-private */
    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
    }

    public AdColonyRewardedRenderer(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.mAdLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        final String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(this.adConfiguration.getServerParameters()), this.adConfiguration.getMediationExtras());
        if (!AdColonyRewardedEventForwarder.getInstance().isListenerAvailable(zoneFromRequest) || !this.adConfiguration.getBidResponse().isEmpty()) {
            AdColonyManager.getInstance().configureAdColony(this.adConfiguration, new AdColonyManager.InitializationListener() {
                public void onInitializeSuccess() {
                    if (TextUtils.isEmpty(zoneFromRequest)) {
                        AdError createAdapterError = AdColonyMediationAdapter.createAdapterError(101, "Missing or invalid Zone ID.");
                        Log.e(AdColonyMediationAdapter.TAG, createAdapterError.getMessage());
                        AdColonyRewardedRenderer.this.mAdLoadCallback.onFailure(createAdapterError);
                        return;
                    }
                    AdColonyAdOptions adOptionsFromAdConfig = AdColonyManager.getInstance().getAdOptionsFromAdConfig(AdColonyRewardedRenderer.this.adConfiguration);
                    AdColony.setRewardListener(AdColonyRewardedEventForwarder.getInstance());
                    AdColonyRewardedEventForwarder.getInstance().addListener(zoneFromRequest, AdColonyRewardedRenderer.this);
                    AdColony.requestInterstitial(zoneFromRequest, AdColonyRewardedEventForwarder.getInstance(), adOptionsFromAdConfig);
                }

                public void onInitializeFailed(AdError adError) {
                    Log.w(AdColonyMediationAdapter.TAG, adError.getMessage());
                    AdColonyRewardedRenderer.this.mAdLoadCallback.onFailure(adError);
                }
            });
            return;
        }
        AdError createAdapterError = AdColonyMediationAdapter.createAdapterError(102, "Failed to load ad from AdColony: Only a maximum of one ad can be loaded per Zone ID.");
        Log.e(AdColonyMediationAdapter.TAG, createAdapterError.getMessage());
        this.mAdLoadCallback.onFailure(createAdapterError);
    }

    /* access modifiers changed from: package-private */
    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        this.mAdColonyInterstitial = adColonyInterstitial;
        this.mRewardedAdCallback = this.mAdLoadCallback.onSuccess(this);
    }

    /* access modifiers changed from: package-private */
    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdError createSdkError = AdColonyMediationAdapter.createSdkError();
        Log.w(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
        this.mAdLoadCallback.onFailure(createSdkError);
    }

    /* access modifiers changed from: package-private */
    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        this.mAdColonyInterstitial = null;
        AdColony.requestInterstitial(adColonyInterstitial.getZoneID(), AdColonyRewardedEventForwarder.getInstance());
    }

    /* access modifiers changed from: package-private */
    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    /* access modifiers changed from: package-private */
    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
            this.mRewardedAdCallback.onVideoStart();
            this.mRewardedAdCallback.reportAdImpression();
        }
    }

    /* access modifiers changed from: package-private */
    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    /* access modifiers changed from: package-private */
    public void onReward(AdColonyReward adColonyReward) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            if (adColonyReward.success()) {
                this.mRewardedAdCallback.onUserEarnedReward(new AdColonyReward(adColonyReward.getRewardName(), adColonyReward.getRewardAmount()));
            }
        }
    }

    public void showAd(Context context) {
        if (this.mAdColonyInterstitial == null) {
            AdError createAdapterError = AdColonyMediationAdapter.createAdapterError(105, "No ad to show.");
            Log.w(AdColonyMediationAdapter.TAG, createAdapterError.getMessage());
            this.mRewardedAdCallback.onAdFailedToShow(createAdapterError);
            return;
        }
        if (AdColony.getRewardListener() != AdColonyRewardedEventForwarder.getInstance()) {
            Log.w(AdColonyMediationAdapter.TAG, "AdColony's reward listener has been changed since load time. Setting the listener back to the Google AdColony adapter to be able to detect rewarded events.");
            AdColony.setRewardListener(AdColonyRewardedEventForwarder.getInstance());
        }
        this.mAdColonyInterstitial.show();
    }
}
