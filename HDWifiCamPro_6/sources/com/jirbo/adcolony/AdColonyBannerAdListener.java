package com.jirbo.adcolony;

import android.util.Log;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

class AdColonyBannerAdListener extends AdColonyAdViewListener {
    private AdColonyAdapter adapter;
    private MediationBannerListener mediationBannerListener;

    AdColonyBannerAdListener(AdColonyAdapter adColonyAdapter, MediationBannerListener mediationBannerListener2) {
        this.mediationBannerListener = mediationBannerListener2;
        this.adapter = adColonyAdapter;
    }

    public void onClicked(AdColonyAdView adColonyAdView) {
        AdColonyAdapter adColonyAdapter;
        MediationBannerListener mediationBannerListener2 = this.mediationBannerListener;
        if (mediationBannerListener2 != null && (adColonyAdapter = this.adapter) != null) {
            mediationBannerListener2.onAdClicked(adColonyAdapter);
        }
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
        AdColonyAdapter adColonyAdapter;
        MediationBannerListener mediationBannerListener2 = this.mediationBannerListener;
        if (mediationBannerListener2 != null && (adColonyAdapter = this.adapter) != null) {
            mediationBannerListener2.onAdOpened(adColonyAdapter);
        }
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
        AdColonyAdapter adColonyAdapter;
        MediationBannerListener mediationBannerListener2 = this.mediationBannerListener;
        if (mediationBannerListener2 != null && (adColonyAdapter = this.adapter) != null) {
            mediationBannerListener2.onAdClosed(adColonyAdapter);
        }
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
        AdColonyAdapter adColonyAdapter;
        MediationBannerListener mediationBannerListener2 = this.mediationBannerListener;
        if (mediationBannerListener2 != null && (adColonyAdapter = this.adapter) != null) {
            mediationBannerListener2.onAdLeftApplication(adColonyAdapter);
        }
    }

    public void onRequestFilled(AdColonyAdView adColonyAdView) {
        AdColonyAdapter adColonyAdapter;
        if (this.mediationBannerListener != null && (adColonyAdapter = this.adapter) != null) {
            adColonyAdapter.setAdView(adColonyAdView);
            this.mediationBannerListener.onAdLoaded(this.adapter);
        }
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        if (this.mediationBannerListener != null && this.adapter != null) {
            AdError createSdkError = AdColonyMediationAdapter.createSdkError();
            Log.w(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
            this.mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this.adapter, createSdkError);
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.adapter = null;
        this.mediationBannerListener = null;
    }
}
