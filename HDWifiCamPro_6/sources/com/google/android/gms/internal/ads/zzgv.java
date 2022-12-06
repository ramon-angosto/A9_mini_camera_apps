package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgv {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.03f;
    private float zzj = 0.97f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    /* synthetic */ zzgv(float f, float f2, long j, float f3, long j2, long j3, float f4, zzgu zzgu) {
        this.zza = j2;
        this.zzb = j3;
    }

    private static long zzf(long j, long j2, float f) {
        return (long) ((((float) j) * 0.999f) + (((float) j2) * 9.999871E-4f));
    }

    private final void zzg() {
        long j = this.zzc;
        if (j != C.TIME_UNSET) {
            long j2 = this.zzd;
            if (j2 != C.TIME_UNSET) {
                j = j2;
            }
            long j3 = this.zzf;
            if (j3 != C.TIME_UNSET && j < j3) {
                j = j3;
            }
            long j4 = this.zzg;
            if (j4 != C.TIME_UNSET && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze != j) {
            this.zze = j;
            this.zzh = j;
            this.zzm = C.TIME_UNSET;
            this.zzn = C.TIME_UNSET;
            this.zzl = C.TIME_UNSET;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j = this.zzh;
        if (j != C.TIME_UNSET) {
            long j2 = j + this.zzb;
            this.zzh = j2;
            long j3 = this.zzg;
            if (j3 != C.TIME_UNSET && j2 > j3) {
                this.zzh = j3;
            }
            this.zzl = C.TIME_UNSET;
        }
    }

    public final void zzd(zzaw zzaw) {
        long j = zzaw.zzc;
        this.zzc = zzen.zzv(C.TIME_UNSET);
        long j2 = zzaw.zzd;
        this.zzf = zzen.zzv(C.TIME_UNSET);
        long j3 = zzaw.zze;
        this.zzg = zzen.zzv(C.TIME_UNSET);
        float f = zzaw.zzf;
        this.zzj = 0.97f;
        float f2 = zzaw.zzg;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j) {
        this.zzd = j;
        zzg();
    }

    public final float zza(long j, long j2) {
        long j3;
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j4 = j - j2;
        long j5 = this.zzm;
        if (j5 == C.TIME_UNSET) {
            this.zzm = j4;
            this.zzn = 0;
        } else {
            long max = Math.max(j4, zzf(j5, j4, 0.999f));
            this.zzm = max;
            this.zzn = zzf(this.zzn, Math.abs(j4 - max), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j6 = this.zzm + (this.zzn * 3);
        if (this.zzh > j6) {
            long zzv = zzen.zzv(1000);
            float f = this.zzk;
            float f2 = (float) zzv;
            float f3 = this.zzi;
            long[] jArr = new long[3];
            jArr[0] = j6;
            jArr[1] = this.zze;
            long[] jArr2 = jArr;
            jArr2[2] = this.zzh - (((long) ((f - 4.0f) * f2)) + ((long) ((f3 - 4.0f) * f2)));
            j3 = jArr2[0];
            for (int i = 1; i < 3; i++) {
                long j7 = jArr2[i];
                if (j7 > j3) {
                    j3 = j7;
                }
            }
            this.zzh = j3;
        } else {
            long zzr = zzen.zzr(j - ((long) (Math.max(0.0f, this.zzk - 4.0f) / 1.0E-7f)), this.zzh, j6);
            this.zzh = zzr;
            long j8 = this.zzg;
            if (j8 == C.TIME_UNSET || zzr <= j8) {
                j3 = zzr;
            } else {
                this.zzh = j8;
                j3 = j8;
            }
        }
        long j9 = j - j3;
        if (Math.abs(j9) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float zza2 = zzen.zza((((float) j9) * 1.0E-7f) + 1.0f, this.zzj, this.zzi);
        this.zzk = zza2;
        return zza2;
    }
}
