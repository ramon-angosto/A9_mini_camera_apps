package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrg implements zzdyr {
    private final Long zza;
    private final String zzb;
    private final zzcpw zzc;
    private final zzcrk zzd;
    private final zzcrg zze = this;

    /* synthetic */ zzcrg(zzcpw zzcpw, zzcrk zzcrk, Long l, String str, zzcrf zzcrf) {
        this.zzc = zzcpw;
        this.zzd = zzcrk;
        this.zza = l;
        this.zzb = str;
    }

    public final zzdzb zza() {
        long longValue = this.zza.longValue();
        zzcrk zzcrk = this.zzd;
        return zzdzc.zza(longValue, zzcrk.zza, zzdyv.zzc(zzcrk.zzb), this.zzc, this.zzb);
    }

    public final zzdzf zzb() {
        long longValue = this.zza.longValue();
        zzcrk zzcrk = this.zzd;
        return zzdzg.zza(longValue, zzcrk.zza, zzdyv.zzc(zzcrk.zzb), this.zzc, this.zzb);
    }
}
