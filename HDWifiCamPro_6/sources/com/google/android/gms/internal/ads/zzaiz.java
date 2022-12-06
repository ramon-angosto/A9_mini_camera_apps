package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaiz {
    public static Pair zza(zzzj zzzj) throws IOException {
        zzzj.zzj();
        zzaiy zzd = zzd(1684108385, zzzj, new zzef(8));
        ((zzyy) zzzj).zzo(8, false);
        return Pair.create(Long.valueOf(zzzj.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzaix zzb(zzzj zzzj) throws IOException {
        byte[] bArr;
        zzef zzef = new zzef(16);
        zzaiy zzd = zzd(1718449184, zzzj, zzef);
        zzdd.zzf(zzd.zzb >= 16);
        zzyy zzyy = (zzyy) zzzj;
        zzyy.zzm(zzef.zzH(), 0, 16, false);
        zzef.zzF(0);
        int zzi = zzef.zzi();
        int zzi2 = zzef.zzi();
        int zzh = zzef.zzh();
        int zzh2 = zzef.zzh();
        int zzi3 = zzef.zzi();
        int zzi4 = zzef.zzi();
        int i = ((int) zzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzyy.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzen.zzf;
        }
        zzyy.zzo((int) (zzzj.zze() - zzzj.zzf()), false);
        return new zzaix(zzi, zzi2, zzh, zzh2, zzi3, zzi4, bArr);
    }

    public static boolean zzc(zzzj zzzj) throws IOException {
        zzef zzef = new zzef(8);
        int i = zzaiy.zza(zzzj, zzef).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzyy) zzzj).zzm(zzef.zzH(), 0, 4, false);
        zzef.zzF(0);
        int zze = zzef.zze();
        if (zze == 1463899717) {
            return true;
        }
        zzdw.zzb("WavHeaderReader", "Unsupported form type: " + zze);
        return false;
    }

    private static zzaiy zzd(int i, zzzj zzzj, zzef zzef) throws IOException {
        zzaiy zza = zzaiy.zza(zzzj, zzef);
        while (true) {
            int i2 = zza.zza;
            if (i2 == i) {
                return zza;
            }
            zzdw.zze("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zza.zzb + 8;
            if (j <= 2147483647L) {
                ((zzyy) zzzj).zzo((int) j, false);
                zza = zzaiy.zza(zzzj, zzef);
            } else {
                int i3 = zza.zza;
                throw zzbu.zzc("Chunk is too large (~2GB+) to skip; id: " + i3);
            }
        }
    }
}
