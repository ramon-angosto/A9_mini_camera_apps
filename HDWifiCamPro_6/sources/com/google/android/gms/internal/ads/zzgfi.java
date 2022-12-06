package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfi {
    private final zzgak zza;
    private final zzgaq zzb;

    public zzgfi(zzgak zzgak) {
        this.zza = zzgak;
        this.zzb = null;
    }

    public zzgfi(zzgaq zzgaq) {
        this.zza = null;
        this.zzb = zzgaq;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzgak zzgak = this.zza;
        if (zzgak != null) {
            return zzgak.zzb(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
