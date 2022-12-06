package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagc implements zzagi {
    private final zzzv zza;
    private final zzzu zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzagc(zzzv zzzv, zzzu zzzu) {
        this.zza = zzzv;
        this.zzb = zzzu;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final long zzd(zzzj zzzj) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final zzaal zze() {
        zzdd.zzf(this.zzc != -1);
        return new zzzt(this.zza, this.zzc);
    }

    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzen.zzd(jArr, j, true, true)];
    }
}
