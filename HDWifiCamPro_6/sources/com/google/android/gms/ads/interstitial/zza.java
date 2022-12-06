package com.google.android.gms.ads.interstitial;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzcaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ AdRequest zzc;
    public final /* synthetic */ InterstitialAdLoadCallback zzd;

    public /* synthetic */ zza(Context context, String str, AdRequest adRequest, InterstitialAdLoadCallback interstitialAdLoadCallback) {
        this.zza = context;
        this.zzb = str;
        this.zzc = adRequest;
        this.zzd = interstitialAdLoadCallback;
    }

    public final void run() {
        Context context = this.zza;
        String str = this.zzb;
        AdRequest adRequest = this.zzc;
        try {
            new zzbsm(context, str).zza(adRequest.zza(), this.zzd);
        } catch (IllegalStateException e) {
            zzcaf.zza(context).zzd(e, "InterstitialAd.load");
        }
    }
}
