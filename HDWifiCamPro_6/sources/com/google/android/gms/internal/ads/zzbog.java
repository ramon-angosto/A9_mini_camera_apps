package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbog extends zzbnh {
    final /* synthetic */ zzboj zza;

    /* synthetic */ zzbog(zzboj zzboj, zzbof zzbof) {
        this.zza = zzboj;
    }

    public final void zze(zzbmy zzbmy, String str) {
        zzboj zzboj = this.zza;
        if (zzboj.zzb != null) {
            zzboj.zzb.onCustomClick(zzboj.zzf(zzbmy), str);
        }
    }
}
