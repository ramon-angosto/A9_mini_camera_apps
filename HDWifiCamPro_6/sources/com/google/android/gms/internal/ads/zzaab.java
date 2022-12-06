package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaab {
    public int zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!zzaac.zzm(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.zza = i2;
        this.zzb = zzaac.zza[3 - i3];
        int i8 = zzaac.zzb[i5];
        this.zzd = i8;
        int i9 = 2;
        if (i2 == 2) {
            i8 /= 2;
            this.zzd = i8;
        } else if (i2 == 0) {
            i8 /= 4;
            this.zzd = i8;
        }
        int i10 = (i >>> 9) & 1;
        this.zzg = zzaac.zzl(i2, i3);
        if (i3 == 3) {
            if (i2 == 3) {
                i7 = zzaac.zzc[i4 - 1];
            } else {
                i7 = zzaac.zzd[i4 - 1];
            }
            this.zzf = i7;
            this.zzc = (((i7 * 12) / i8) + i10) * 4;
        } else {
            int i11 = 144;
            if (i2 == 3) {
                if (i3 == 2) {
                    i6 = zzaac.zze[i4 - 1];
                } else {
                    i6 = zzaac.zzf[i4 - 1];
                }
                this.zzf = i6;
                this.zzc = ((i6 * 144) / i8) + i10;
            } else {
                int i12 = zzaac.zzg[i4 - 1];
                this.zzf = i12;
                if (i3 == 1) {
                    i11 = 72;
                }
                this.zzc = ((i11 * i12) / i8) + i10;
            }
        }
        if (((i >> 6) & 3) == 3) {
            i9 = 1;
        }
        this.zze = i9;
        return true;
    }
}
