package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfd {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm = "KEM".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzn = "HPKE".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzo = "HPKE-v1".getBytes(StandardCharsets.UTF_8);

    static void zza(zzglo zzglo) throws GeneralSecurityException {
        if (zzglo.zzg() == 2 || zzglo.zzg() == 1) {
            throw new GeneralSecurityException("Invalid KEM param: ".concat(zzgli.zza(zzglo.zzg())));
        }
        String str = "UNRECOGNIZED";
        if (zzglo.zzf() == 2 || zzglo.zzf() == 1) {
            int zzf2 = zzglo.zzf();
            if (zzf2 == 2) {
                str = "KDF_UNKNOWN";
            } else if (zzf2 == 3) {
                str = "HKDF_SHA256";
            } else if (zzf2 == 4) {
                str = "HKDF_SHA384";
            } else if (zzf2 == 5) {
                str = "HKDF_SHA512";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        } else if (zzglo.zze() == 2 || zzglo.zze() == 1) {
            int zze2 = zzglo.zze();
            if (zze2 == 2) {
                str = "AEAD_UNKNOWN";
            } else if (zze2 == 3) {
                str = "AES_128_GCM";
            } else if (zze2 == 4) {
                str = "AES_256_GCM";
            } else if (zze2 == 5) {
                str = "CHACHA20_POLY1305";
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
        }
    }

    static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzgnv.zzc(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    static byte[] zzd(byte[] bArr) throws GeneralSecurityException {
        return zzgnv.zzc(zzm, bArr);
    }

    static byte[] zze(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzgnv.zzc(zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzgnv.zzc(zzc(2, i), zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }
}
