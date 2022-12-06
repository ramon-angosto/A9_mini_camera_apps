package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaiv implements zzaiu {
    private final zzzl zza;
    private final zzaap zzb;
    private final zzaix zzc;
    private final zzaf zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaiv(zzzl zzzl, zzaap zzaap, zzaix zzaix, String str, int i) throws zzbu {
        this.zza = zzzl;
        this.zzb = zzaap;
        this.zzc = zzaix;
        int i2 = (zzaix.zzb * zzaix.zze) / 8;
        int i3 = zzaix.zzd;
        if (i3 == i2) {
            int i4 = zzaix.zzc * i2;
            int i5 = i4 * 8;
            this.zze = Math.max(i2, i4 / 10);
            zzad zzad = new zzad();
            zzad.zzS(str);
            zzad.zzv(i5);
            zzad.zzO(i5);
            zzad.zzL(this.zze);
            zzad.zzw(zzaix.zzb);
            zzad.zzT(zzaix.zzc);
            zzad.zzN(i);
            this.zzd = zzad.zzY();
            return;
        }
        throw zzbu.zza("Expected block size: " + i2 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzN(new zzaja(this.zzc, 1, (long) i, j));
        this.zzb.zzk(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzzj zzzj, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                zzaix zzaix = this.zzc;
                int i4 = zzaix.zzd;
                int i5 = this.zzg / i4;
            } else {
                int zza2 = zzaan.zza(this.zzb, zzzj, (int) Math.min((long) (i3 - i2), j2), true);
                if (zza2 == -1) {
                    j2 = 0;
                } else {
                    this.zzg += zza2;
                    j2 -= (long) zza2;
                }
            }
        }
        zzaix zzaix2 = this.zzc;
        int i42 = zzaix2.zzd;
        int i52 = this.zzg / i42;
        if (i52 > 0) {
            long j3 = this.zzf;
            long zzw = zzen.zzw(this.zzh, 1000000, (long) zzaix2.zzc);
            int i6 = i52 * i42;
            int i7 = this.zzg - i6;
            this.zzb.zzs(j3 + zzw, 1, i6, i7, (zzaao) null);
            this.zzh += (long) i52;
            this.zzg = i7;
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }
}
