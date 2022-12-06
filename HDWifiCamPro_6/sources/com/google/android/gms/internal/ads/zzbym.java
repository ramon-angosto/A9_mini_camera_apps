package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbym extends zzbnh {
    final /* synthetic */ zzbyp zza;

    /* synthetic */ zzbym(zzbyp zzbyp, zzbyl zzbyl) {
        this.zza = zzbyp;
    }

    public final void zze(zzbmy zzbmy, String str) {
        zzbyp zzbyp = this.zza;
        if (zzbyp.zzb != null) {
            zzbyp.zzb.onCustomClick(zzbyp.zzf(zzbmy), str);
        }
    }
}
