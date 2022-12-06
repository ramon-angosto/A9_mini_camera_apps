package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabf {
    protected final zzaap zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzabf(int i, int i2, long j, int i3, zzaap zzaap) {
        i2 = i2 != 1 ? 2 : i2;
        this.zzd = j;
        this.zze = i3;
        this.zza = zzaap;
        this.zzb = zzi(i, i2 == 2 ? 1667497984 : 1651965952);
        this.zzc = i2 == 2 ? zzi(i, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i, int i2) {
        return ((i / 10) + 48) | (((i % 10) + 48) << 8) | i2;
    }

    private final long zzj(int i) {
        return (this.zzd * ((long) i)) / ((long) this.zze);
    }

    private final zzaam zzk(int i) {
        return new zzaam(((long) this.zzl[i]) * zzj(1), this.zzk[i]);
    }

    public final zzaaj zza(long j) {
        int zzj2 = (int) (j / zzj(1));
        int zzc2 = zzen.zzc(this.zzl, zzj2, true, true);
        if (this.zzl[zzc2] == zzj2) {
            zzaam zzk2 = zzk(zzc2);
            return new zzaaj(zzk2, zzk2);
        }
        zzaam zzk3 = zzk(zzc2);
        int i = zzc2 + 1;
        return i < this.zzk.length ? new zzaaj(zzk3, zzk(i)) : new zzaaj(zzk3, zzk3);
    }

    public final void zzb(long j) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i = this.zzj;
        jArr2[i] = j;
        this.zzl[i] = this.zzi;
        this.zzj = i + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i) {
        this.zzf = i;
        this.zzg = i;
    }

    public final void zzf(long j) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzl[zzen.zzd(this.zzk, j, true, true)];
    }

    public final boolean zzg(int i) {
        return this.zzb == i || this.zzc == i;
    }

    public final boolean zzh(zzzj zzzj) throws IOException {
        int i = this.zzg;
        int zze2 = i - this.zza.zze(zzzj, i, false);
        this.zzg = zze2;
        boolean z = zze2 == 0;
        if (z) {
            if (this.zzf > 0) {
                this.zza.zzs(zzj(this.zzh), Arrays.binarySearch(this.zzl, this.zzh) >= 0 ? 1 : 0, this.zzf, 0, (zzaao) null);
            }
            this.zzh++;
        }
        return z;
    }
}
