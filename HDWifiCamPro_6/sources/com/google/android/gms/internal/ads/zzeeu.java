package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeeu implements zzdfv, zzdeo, zzddd {
    private final zzfiq zza;
    private final zzfir zzb;
    private final zzcgc zzc;

    public zzeeu(zzfiq zzfiq, zzfir zzfir, zzcgc zzcgc) {
        this.zza = zzfiq;
        this.zzb = zzfir;
        this.zzc = zzcgc;
    }

    public final void zza(zze zze) {
        zzfiq zzfiq = this.zza;
        zzfiq.zza("action", "ftl");
        zzfiq.zza("ftl", String.valueOf(zze.zza));
        zzfiq.zza("ed", zze.zzc);
        this.zzb.zzb(this.zza);
    }

    public final void zzb(zzfdw zzfdw) {
        this.zza.zzh(zzfdw, this.zzc);
    }

    public final void zzbE(zzcbc zzcbc) {
        this.zza.zzi(zzcbc.zza);
    }

    public final void zzn() {
        zzfir zzfir = this.zzb;
        zzfiq zzfiq = this.zza;
        zzfiq.zza("action", "loaded");
        zzfir.zzb(zzfiq);
    }
}
