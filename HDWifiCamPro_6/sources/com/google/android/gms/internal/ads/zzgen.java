package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgen implements zzgeq {
    private final int zza;

    zzgen(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.zza = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
    }

    public final int zza() {
        return this.zza;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws GeneralSecurityException {
        int length = bArr.length;
        if (length == this.zza) {
            return new zzgdi(bArr, false).zzb(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzgfd.zzi;
        }
        if (i == 32) {
            return zzgfd.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }
}
