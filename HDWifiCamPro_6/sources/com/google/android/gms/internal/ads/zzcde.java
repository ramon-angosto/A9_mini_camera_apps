package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcde extends zzccr {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcdf zzb;

    public zzcde(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcdf zzcdf) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcdf;
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzcdf zzcdf;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzcdf = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzcdf);
        }
    }
}
