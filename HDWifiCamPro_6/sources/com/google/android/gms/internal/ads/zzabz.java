package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabz extends zzzw {
    private final long zza;

    public zzabz(zzzj zzzj, long j) {
        super(zzzj);
        zzdd.zzd(zzzj.zzf() >= j);
        this.zza = j;
    }

    public final long zzd() {
        return super.zzd() - this.zza;
    }

    public final long zze() {
        return super.zze() - this.zza;
    }

    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
