package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgfh implements zzgew {
    private final zzgpc zza;
    private final zzgpc zzb;

    private zzgfh(byte[] bArr, byte[] bArr2) {
        this.zza = zzgpc.zza(bArr);
        this.zzb = zzgpc.zza(bArr2);
    }

    static zzgfh zza(byte[] bArr) throws GeneralSecurityException {
        return new zzgfh(bArr, zzgpa.zzc(bArr));
    }
}
