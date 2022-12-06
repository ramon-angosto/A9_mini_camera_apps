package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfda implements zzeou {
    final /* synthetic */ zzfdb zza;

    zzfda(zzfdb zzfdb) {
        this.zza = zzfdb;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzduc zzduc = (zzduc) obj;
        synchronized (this.zza) {
            this.zza.zzg = zzduc;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzcJ)).booleanValue()) {
                zzduc.zzd().zza = this.zza.zzd;
            }
            this.zza.zzg.zzW();
        }
    }
}
