package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdi {
    private static final ThreadLocal zza = new zzgdh();
    private final SecretKey zzb;
    private final boolean zzc;

    public zzgdi(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (zzgds.zza(2)) {
            zzgoz.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = z;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    private static AlgorithmParameterSpec zzc(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        if (!zzgoy.zzb() || zzgoy.zza() > 19) {
            return new GCMParameterSpec(128, bArr, 0, 12);
        }
        return new IvParameterSpec(bArr, 0, 12);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int i = 12;
        if (bArr.length == 12) {
            boolean z = this.zzc;
            int i2 = true != z ? 16 : 28;
            int length = bArr2.length;
            if (length < i2) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (!z || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                ((Cipher) zza.get()).init(2, this.zzb, zzc(bArr, 0, 12));
                if (!(bArr3 == null || bArr3.length == 0)) {
                    ((Cipher) zza.get()).updateAAD(bArr3);
                }
                boolean z2 = this.zzc;
                if (true != z2) {
                    i = 0;
                }
                if (z2) {
                    length -= 12;
                }
                return ((Cipher) zza.get()).doFinal(bArr2, i, length);
            } else {
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
        } else {
            throw new GeneralSecurityException("iv is wrong size");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length == 12) {
            int length = bArr2.length;
            if (length <= 2147483619) {
                boolean z = this.zzc;
                byte[] bArr4 = new byte[(z ? length + 28 : length + 16)];
                if (z) {
                    System.arraycopy(bArr, 0, bArr4, 0, 12);
                }
                ((Cipher) zza.get()).init(1, this.zzb, zzc(bArr, 0, 12));
                int doFinal = ((Cipher) zza.get()).doFinal(bArr2, 0, length, bArr4, true != this.zzc ? 0 : 12);
                if (doFinal == length + 16) {
                    return bArr4;
                }
                throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length)}));
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }
}
