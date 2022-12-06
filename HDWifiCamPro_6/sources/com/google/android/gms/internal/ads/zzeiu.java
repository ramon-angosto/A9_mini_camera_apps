package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeiu implements zzfzc {
    final /* synthetic */ zzeiv zza;

    zzeiu(zzeiv zzeiv) {
        this.zza = zzeiv;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zza(zza2);
        zzfez.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcxc) obj).zzW();
    }
}
