package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgnt implements zzgaq {
    private static final Collection zza = Arrays.asList(new Integer[]{64});
    private static final byte[] zzb = new byte[16];
    private final zzgos zzc;
    private final byte[] zzd;

    public zzgnt(byte[] bArr) throws GeneralSecurityException {
        if (zzgds.zza(1)) {
            Collection collection = zza;
            int length = bArr.length;
            if (collection.contains(Integer.valueOf(length))) {
                int i = length >> 1;
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, i);
                this.zzd = Arrays.copyOfRange(bArr, i, length);
                this.zzc = new zzgos(copyOfRange);
                return;
            }
            throw new InvalidKeyException("invalid key size: " + length + " bytes; key must have 64 bytes");
        }
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        if (bArr.length <= 2147483631) {
            Cipher cipher = (Cipher) zzgog.zza.zza("AES/CTR/NoPadding");
            byte[][] bArr4 = {bArr2, bArr};
            byte[] zza2 = this.zzc.zza(zzb, 16);
            for (int i = 0; i <= 0; i++) {
                byte[] bArr5 = bArr4[i];
                if (bArr5 == null) {
                    bArr5 = new byte[0];
                }
                zza2 = zzgnv.zzd(zzgnu.zzb(zza2), this.zzc.zza(bArr5, 16));
            }
            byte[] bArr6 = bArr4[1];
            int length = bArr6.length;
            if (length >= 16) {
                int length2 = zza2.length;
                if (length >= length2) {
                    int i2 = length - length2;
                    bArr3 = Arrays.copyOf(bArr6, length);
                    for (int i3 = 0; i3 < zza2.length; i3++) {
                        int i4 = i2 + i3;
                        bArr3[i4] = (byte) (bArr3[i4] ^ zza2[i3]);
                    }
                } else {
                    throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
                }
            } else {
                bArr3 = zzgnv.zzd(zzgnu.zza(bArr6), zzgnu.zzb(zza2));
            }
            byte[] zza3 = this.zzc.zza(bArr3, 16);
            byte[] bArr7 = (byte[]) zza3.clone();
            bArr7[8] = (byte) (bArr7[8] & ByteCompanionObject.MAX_VALUE);
            bArr7[12] = (byte) (bArr7[12] & ByteCompanionObject.MAX_VALUE);
            cipher.init(1, new SecretKeySpec(this.zzd, "AES"), new IvParameterSpec(bArr7));
            return zzgnv.zzc(zza3, cipher.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
