package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbde extends zzbdl {
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzbde(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    public final void zzb(int i) {
    }

    public final void zzc(zze zze) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzd(zzbdj zzbdj) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzbdf(zzbdj, this.zzb));
        }
    }
}
