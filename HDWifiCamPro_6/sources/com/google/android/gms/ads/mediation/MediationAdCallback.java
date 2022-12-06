package com.google.android.gms.ads.mediation;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface MediationAdCallback {
    void onAdClosed();

    void onAdOpened();

    void reportAdClicked();

    void reportAdImpression();
}
