package com.google.android.gms.ads.rewardedinterstitial;

import android.content.Context;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcdf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdManagerAdRequest zzc;
    public final /* synthetic */ RewardedInterstitialAdLoadCallback zzd;

    public /* synthetic */ zzb(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adManagerAdRequest;
        this.zzd = rewardedInterstitialAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdManagerAdRequest adManagerAdRequest = this.zzc;
        try {
            new zzcdf(context, str).zza(adManagerAdRequest.zza(), this.zzd);
        } catch (IllegalStateException e) {
            zzcaf.zza(context).zzd(e, "RewardedInterstitialAdManager.load");
        }
    }
}
