package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgos implements zzghu {
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc = zzgnu.zzb(this.zzb);

    public zzgos(byte[] bArr) throws GeneralSecurityException {
        zzgoz.zza(bArr.length);
        this.zza = new SecretKeySpec(bArr, "AES");
        Cipher zzb2 = zzb();
        zzb2.init(1, this.zza);
        this.zzb = zzgnu.zzb(zzb2.doFinal(new byte[16]));
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgds.zza(1)) {
            return (Cipher) zzgog.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zzb2 = zzb();
            zzb2.init(1, this.zza);
            int length = bArr.length;
            int max = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
            if (max * 16 == length) {
                bArr2 = zzgnv.zze(bArr, (max - 1) * 16, this.zzb, 0, 16);
            } else {
                bArr2 = zzgnv.zzd(zzgnu.zza(Arrays.copyOfRange(bArr, (max - 1) * 16, length)), this.zzc);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zzb2.doFinal(zzgnv.zze(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(zzb2.doFinal(zzgnv.zzd(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
