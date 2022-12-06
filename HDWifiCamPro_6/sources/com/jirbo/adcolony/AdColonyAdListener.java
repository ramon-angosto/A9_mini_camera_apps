package com.jirbo.adcolony;

import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

class AdColonyAdListener extends AdColonyInterstitialListener {
    private AdColonyAdapter adapter;
    private MediationInterstitialListener mediationInterstitialListener;

    AdColonyAdListener(AdColonyAdapter adColonyAdapter, MediationInterstitialListener mediationInterstitialListener2) {
        this.mediationInterstitialListener = mediationInterstitialListener2;
        this.adapter = adColonyAdapter;
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this.mediationInterstitialListener.onAdLoaded(this.adapter);
        }
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this.mediationInterstitialListener.onAdClicked(this.adapter);
        }
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this.mediationInterstitialListener.onAdClosed(this.adapter);
        }
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            AdColony.requestInterstitial(adColonyInterstitial.getZoneID(), this);
        }
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
        }
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this.mediationInterstitialListener.onAdLeftApplication(this.adapter);
        }
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd(adColonyInterstitial);
            this.mediationInterstitialListener.onAdOpened(this.adapter);
        }
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdColonyAdapter adColonyAdapter = this.adapter;
        if (adColonyAdapter != null && this.mediationInterstitialListener != null) {
            adColonyAdapter.setAd((AdColonyInterstitial) null);
            AdError createSdkError = AdColonyMediationAdapter.createSdkError();
            Log.w(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
            this.mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this.adapter, createSdkError);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.adapter = null;
        this.mediationInterstitialListener = null;
    }
}
