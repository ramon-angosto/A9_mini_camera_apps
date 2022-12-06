package com.google.ads.mediation.adcolony;

import android.content.Context;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.jirbo.adcolony.AdColonyManager;

public class AdColonyInterstitialRenderer extends AdColonyInterstitialListener implements MediationInterstitialAd {
    private AdColonyInterstitial adColonyInterstitial;
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mAdLoadCallback;
    private MediationInterstitialAdCallback mInterstitialAdCallback;

    AdColonyInterstitialRenderer(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mAdLoadCallback = mediationAdLoadCallback;
        this.adConfiguration = mediationInterstitialAdConfiguration;
    }

    public void render() {
        AdColony.requestInterstitial(AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(this.adConfiguration.getServerParameters()), this.adConfiguration.getMediationExtras()), this, AdColonyManager.getInstance().getAdOptionsFromAdConfig(this.adConfiguration));
    }

    public void showAd(Context context) {
        this.adColonyInterstitial.show();
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial2) {
        this.adColonyInterstitial = adColonyInterstitial2;
        this.mInterstitialAdCallback = this.mAdLoadCallback.onSuccess(this);
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdError createSdkError = AdColonyMediationAdapter.createSdkError();
        Log.w(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
        this.mAdLoadCallback.onFailure(createSdkError);
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial2) {
        super.onLeftApplication(adColonyInterstitial2);
        this.mInterstitialAdCallback.reportAdClicked();
        this.mInterstitialAdCallback.onAdLeftApplication();
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial2) {
        super.onOpened(adColonyInterstitial2);
        this.mInterstitialAdCallback.onAdOpened();
        this.mInterstitialAdCallback.reportAdImpression();
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial2) {
        super.onClosed(adColonyInterstitial2);
        this.mInterstitialAdCallback.onAdClosed();
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial2) {
        super.onExpiring(adColonyInterstitial2);
        AdColony.requestInterstitial(adColonyInterstitial2.getZoneID(), this);
    }
}
