package com.google.ads.mediation.adcolony;

import android.util.Log;
import android.view.View;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.jirbo.adcolony.AdColonyManager;

public class AdColonyBannerRenderer extends AdColonyAdViewListener implements MediationBannerAd {
    private AdColonyAdView adColonyAdView;
    private final MediationBannerAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mAdLoadCallback;
    private MediationBannerAdCallback mBannerAdCallback;

    public AdColonyBannerRenderer(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.mAdLoadCallback = mediationAdLoadCallback;
        this.adConfiguration = mediationBannerAdConfiguration;
    }

    public void render() {
        if (this.adConfiguration.getAdSize() == null) {
            AdError createAdapterError = AdColonyMediationAdapter.createAdapterError(101, "Failed to request banner with unsupported size: null");
            Log.e(AdColonyMediationAdapter.TAG, createAdapterError.getMessage());
            this.mAdLoadCallback.onFailure(createAdapterError);
            return;
        }
        AdColony.requestAdView(AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(this.adConfiguration.getServerParameters()), this.adConfiguration.getMediationExtras()), this, new AdColonyAdSize(AdColonyAdapterUtils.convertPixelsToDp(this.adConfiguration.getAdSize().getWidthInPixels(this.adConfiguration.getContext())), AdColonyAdapterUtils.convertPixelsToDp(this.adConfiguration.getAdSize().getHeightInPixels(this.adConfiguration.getContext()))), AdColonyManager.getInstance().getAdOptionsFromAdConfig(this.adConfiguration));
    }

    public void onRequestFilled(AdColonyAdView adColonyAdView2) {
        this.adColonyAdView = adColonyAdView2;
        this.mBannerAdCallback = this.mAdLoadCallback.onSuccess(this);
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdError createSdkError = AdColonyMediationAdapter.createSdkError();
        Log.w(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
        this.mAdLoadCallback.onFailure(createSdkError);
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView2) {
        this.mBannerAdCallback.onAdLeftApplication();
    }

    public void onOpened(AdColonyAdView adColonyAdView2) {
        this.mBannerAdCallback.onAdOpened();
    }

    public void onClosed(AdColonyAdView adColonyAdView2) {
        this.mBannerAdCallback.onAdClosed();
    }

    public void onClicked(AdColonyAdView adColonyAdView2) {
        this.mBannerAdCallback.reportAdClicked();
    }

    public View getView() {
        return this.adColonyAdView;
    }
}
