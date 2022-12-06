package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface MediationInterstitialListener {
    void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter);

    @Deprecated
    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError);

    void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter);
}
