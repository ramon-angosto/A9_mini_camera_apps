package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagh {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzef zzg = new zzef(255);

    zzagh() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzzj zzzj, boolean z) throws IOException {
        zza();
        this.zzg.zzC(27);
        if (zzzm.zzc(zzzj, this.zzg.zzH(), 0, 27, z) && this.zzg.zzs() == 1332176723) {
            if (this.zzg.zzk() == 0) {
                this.zza = this.zzg.zzk();
                this.zzb = this.zzg.zzp();
                this.zzg.zzq();
                this.zzg.zzq();
                this.zzg.zzq();
                int zzk = this.zzg.zzk();
                this.zzc = zzk;
                this.zzd = zzk + 27;
                this.zzg.zzC(zzk);
                if (zzzm.zzc(zzzj, this.zzg.zzH(), 0, this.zzc, z)) {
                    for (int i = 0; i < this.zzc; i++) {
                        this.zzf[i] = this.zzg.zzk();
                        this.zze += this.zzf[i];
                    }
                    return true;
                }
            } else if (z) {
                return false;
            } else {
                throw zzbu.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzzj zzzj, long j) throws IOException {
        int i;
        zzdd.zzd(zzzj.zzf() == zzzj.zze());
        this.zzg.zzC(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || zzzj.zzf() + 4 < j) && zzzm.zzc(zzzj, this.zzg.zzH(), 0, 4, true)) {
                this.zzg.zzF(0);
                if (this.zzg.zzs() != 1332176723) {
                    ((zzyy) zzzj).zzo(1, false);
                } else {
                    zzzj.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i != 0 && zzzj.zzf() >= j) || zzzj.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzzj.zzc(1) == -1);
        return false;
    }
}
