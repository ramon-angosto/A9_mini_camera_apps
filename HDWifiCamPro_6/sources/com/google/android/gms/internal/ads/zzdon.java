package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdon {
    private zzbmb zza;

    public zzdon(zzdoc zzdoc) {
        this.zza = zzdoc;
    }

    public final synchronized zzbmb zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbmb zzbmb) {
        this.zza = zzbmb;
    }
}
