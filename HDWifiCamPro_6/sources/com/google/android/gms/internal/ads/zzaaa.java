package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaaa implements zzaal {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzaaa(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdd.zzd(length == length2);
        boolean z = length2 > 0;
        this.zzd = z;
        if (!z || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            this.zza = new long[i];
            this.zzb = new long[i];
            System.arraycopy(jArr, 0, this.zza, 1, length2);
            System.arraycopy(jArr2, 0, this.zzb, 1, length2);
        }
        this.zzc = j;
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzaaj zzg(long j) {
        if (!this.zzd) {
            zzaam zzaam = zzaam.zza;
            return new zzaaj(zzaam, zzaam);
        }
        int zzd2 = zzen.zzd(this.zzb, j, true, true);
        zzaam zzaam2 = new zzaam(this.zzb[zzd2], this.zza[zzd2]);
        if (zzaam2.zzb != j) {
            long[] jArr = this.zzb;
            if (zzd2 != jArr.length - 1) {
                int i = zzd2 + 1;
                return new zzaaj(zzaam2, new zzaam(jArr[i], this.zza[i]));
            }
        }
        return new zzaaj(zzaam2, zzaam2);
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
