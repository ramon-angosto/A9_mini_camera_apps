package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfdf implements zzeou {
    final /* synthetic */ zzfdh zza;

    zzfdf(zzfdh zzfdh) {
        this.zza = zzfdh;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzduc zzduc = (zzduc) obj;
        synchronized (this.zza) {
            this.zza.zzd = zzduc;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzcJ)).booleanValue()) {
                zzduc.zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzW();
        }
    }
}
