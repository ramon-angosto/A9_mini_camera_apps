package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbad {
    private static final byte[] zza = {0, 0, 0, 1};
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair zza(byte[] bArr) {
        zzbaj zzbaj = new zzbaj(bArr, bArr.length);
        int zzc2 = zzc(zzbaj);
        int zzd = zzd(zzbaj);
        int zza2 = zzbaj.zza(4);
        if (zzc2 == 5 || zzc2 == 29) {
            zzd = zzd(zzbaj);
            if (zzc(zzbaj) == 22) {
                zza2 = zzbaj.zza(4);
            }
        }
        int i = zzc[zza2];
        zzbac.zzc(i != -1);
        return Pair.create(Integer.valueOf(zzd), Integer.valueOf(i));
    }

    public static byte[] zzb(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 + 4)];
        System.arraycopy(zza, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    private static int zzc(zzbaj zzbaj) {
        int zza2 = zzbaj.zza(5);
        return zza2 == 31 ? zzbaj.zza(6) + 32 : zza2;
    }

    private static int zzd(zzbaj zzbaj) {
        int zza2 = zzbaj.zza(4);
        if (zza2 == 15) {
            return zzbaj.zza(24);
        }
        zzbac.zzc(zza2 < 13);
        return zzb[zza2];
    }
}
