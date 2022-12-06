package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcre implements zzdyq {
    private final zzcpw zza;
    private final zzcrk zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcre(zzcpw zzcpw, zzcrk zzcrk, zzcrd zzcrd) {
        this.zza = zzcpw;
        this.zzb = zzcrk;
    }

    public final /* synthetic */ zzdyq zza(String str) {
        if (str != null) {
            this.zzd = str;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzdyq zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzdyr zzc() {
        zzgxq.zzc(this.zzc, Long.class);
        zzgxq.zzc(this.zzd, String.class);
        return new zzcrg(this.zza, this.zzb, this.zzc, this.zzd, (zzcrf) null);
    }
}
