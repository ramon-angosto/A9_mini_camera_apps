package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdr implements zzgak {
    private static final ThreadLocal zza = new zzgdq();
    private final SecretKey zzb;

    public zzgdr(byte[] bArr) throws GeneralSecurityException {
        zzgoz.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
    }

    private static AlgorithmParameterSpec zzc(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i2);
        } catch (ClassNotFoundException unused) {
            if (zzgoy.zzb()) {
                return new IvParameterSpec(bArr, 0, i2);
            }
            throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 28) {
            ((Cipher) zza.get()).init(2, this.zzb, zzc(bArr, 0, 12));
            if (!(bArr2 == null || bArr2.length == 0)) {
                ((Cipher) zza.get()).updateAAD(bArr2);
            }
            return ((Cipher) zza.get()).doFinal(bArr, 12, length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= 2147483619) {
            byte[] bArr3 = new byte[(length + 28)];
            byte[] zza2 = zzgox.zza(12);
            System.arraycopy(zza2, 0, bArr3, 0, 12);
            ((Cipher) zza.get()).init(1, this.zzb, zzc(zza2, 0, zza2.length));
            int doFinal = ((Cipher) zza.get()).doFinal(bArr, 0, length, bArr3, 12);
            if (doFinal == length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
