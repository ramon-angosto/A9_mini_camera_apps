package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgov implements zzgbj {
    private final zzghu zza;
    private final int zzb;

    public zzgov(zzghu zzghu, int i) throws GeneralSecurityException {
        this.zza = zzghu;
        this.zzb = i;
        if (i >= 10) {
            zzghu.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgnv.zzb(zzb(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        return this.zza.zza(bArr, this.zzb);
    }
}
