package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzt implements zzaal {
    private final zzzv zza;
    private final long zzb;

    public zzzt(zzzv zzzv, long j) {
        this.zza = zzzv;
        this.zzb = j;
    }

    private final zzaam zza(long j, long j2) {
        return new zzaam((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final long zze() {
        return this.zza.zza();
    }

    public final zzaaj zzg(long j) {
        long j2;
        zzdd.zzb(this.zza.zzk);
        zzzv zzzv = this.zza;
        zzzu zzzu = zzzv.zzk;
        long[] jArr = zzzu.zza;
        long[] jArr2 = zzzu.zzb;
        int zzd = zzen.zzd(jArr, zzzv.zzb(j), true, false);
        long j3 = 0;
        if (zzd == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzd];
        }
        if (zzd != -1) {
            j3 = jArr2[zzd];
        }
        zzaam zza2 = zza(j2, j3);
        if (zza2.zzb == j || zzd == jArr.length - 1) {
            return new zzaaj(zza2, zza2);
        }
        int i = zzd + 1;
        return new zzaaj(zza2, zza(jArr[i], jArr2[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
