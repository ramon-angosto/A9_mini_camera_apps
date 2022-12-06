package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzb implements CustomEventInterstitialListener {
    final /* synthetic */ CustomEventAdapter zza;
    private final CustomEventAdapter zzb;
    private final MediationInterstitialListener zzc;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = customEventAdapter;
        this.zzb = customEventAdapter2;
        this.zzc = mediationInterstitialListener;
    }

    public final void onAdClicked() {
        zzcgp.zze("Custom event adapter called onAdClicked.");
        this.zzc.onAdClicked(this.zzb);
    }

    public final void onAdClosed() {
        zzcgp.zze("Custom event adapter called onAdClosed.");
        this.zzc.onAdClosed(this.zzb);
    }

    public final void onAdFailedToLoad(int i) {
        zzcgp.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter) this.zzb, i);
    }

    public final void onAdLeftApplication() {
        zzcgp.zze("Custom event adapter called onAdLeftApplication.");
        this.zzc.onAdLeftApplication(this.zzb);
    }

    public final void onAdLoaded() {
        zzcgp.zze("Custom event adapter called onReceivedAd.");
        this.zzc.onAdLoaded(this.zza);
    }

    public final void onAdOpened() {
        zzcgp.zze("Custom event adapter called onAdOpened.");
        this.zzc.onAdOpened(this.zzb);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzcgp.zze("Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter) this.zzb, adError);
    }
}
