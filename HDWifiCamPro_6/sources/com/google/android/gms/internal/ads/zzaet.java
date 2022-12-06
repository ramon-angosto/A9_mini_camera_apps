package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaet implements zzaes {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaet(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzaet zza(long j, long j2, zzaab zzaab, zzef zzef) {
        int i;
        long j3 = j;
        zzaab zzaab2 = zzaab;
        zzef zzef2 = zzef;
        zzef2.zzG(10);
        int zze = zzef.zze();
        if (zze <= 0) {
            return null;
        }
        int i2 = zzaab2.zzd;
        long zzw = zzen.zzw((long) zze, ((long) (i2 >= 32000 ? 1152 : 576)) * 1000000, (long) i2);
        int zzo = zzef.zzo();
        int zzo2 = zzef.zzo();
        int zzo3 = zzef.zzo();
        zzef2.zzG(2);
        long j4 = j2 + ((long) zzaab2.zzc);
        long[] jArr = new long[zzo];
        long[] jArr2 = new long[zzo];
        int i3 = 0;
        long j5 = j2;
        while (i3 < zzo) {
            int i4 = zzo2;
            jArr[i3] = (((long) i3) * zzw) / ((long) zzo);
            long j6 = j4;
            jArr2[i3] = Math.max(j5, j6);
            if (zzo3 == 1) {
                i = zzef.zzk();
            } else if (zzo3 == 2) {
                i = zzef.zzo();
            } else if (zzo3 == 3) {
                i = zzef.zzm();
            } else if (zzo3 != 4) {
                return null;
            } else {
                i = zzef.zzn();
            }
            long j7 = (long) i;
            int i5 = i4;
            j5 += j7 * ((long) i5);
            i3++;
            jArr = jArr;
            zzo2 = i5;
            j4 = j6;
        }
        long[] jArr3 = jArr;
        if (!(j3 == -1 || j3 == j5)) {
            zzdw.zze("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new zzaet(jArr3, jArr2, zzw, j5);
    }

    public final long zzb() {
        return this.zzd;
    }

    public final long zzc(long j) {
        return this.zza[zzen.zzd(this.zzb, j, true, true)];
    }

    public final long zze() {
        return this.zzc;
    }

    public final zzaaj zzg(long j) {
        int zzd2 = zzen.zzd(this.zza, j, true, true);
        zzaam zzaam = new zzaam(this.zza[zzd2], this.zzb[zzd2]);
        if (zzaam.zzb < j) {
            long[] jArr = this.zza;
            if (zzd2 != jArr.length - 1) {
                int i = zzd2 + 1;
                return new zzaaj(zzaam, new zzaam(jArr[i], this.zzb[i]));
            }
        }
        return new zzaaj(zzaam, zzaam);
    }

    public final boolean zzh() {
        return true;
    }
}
