package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgej implements zzgas {
    final zzgbu zza;

    public zzgej(zzgbu zzgbu) {
        this.zza = zzgbu;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzgbu zzgbu = this.zza;
        if (zzgbu.zza() != null) {
            return zzgnv.zzc(zzgbu.zza().zzd(), ((zzgas) this.zza.zza().zzc()).zza(bArr, bArr2));
        }
        throw new GeneralSecurityException("keyset without primary key");
    }
}
