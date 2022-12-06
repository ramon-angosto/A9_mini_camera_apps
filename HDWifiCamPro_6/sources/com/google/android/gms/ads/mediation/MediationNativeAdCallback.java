package com.google.android.gms.ads.mediation;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface MediationNativeAdCallback extends MediationAdCallback {
    void onAdLeftApplication();

    void onVideoComplete();

    void onVideoMute();

    void onVideoPause();

    void onVideoPlay();

    void onVideoUnmute();
}
