package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgff implements zzgew {
    private final zzgpc zza;
    private final zzgpc zzb;

    private zzgff(byte[] bArr, byte[] bArr2) {
        this.zza = zzgpc.zza(bArr);
        this.zzb = zzgpc.zza(bArr2);
    }

    static zzgff zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        zzgoe.zze(zzgoe.zzj(zzgoe.zzk(i), 1, bArr2), zzgoe.zzh(i, bArr));
        return new zzgff(bArr, bArr2);
    }
}
