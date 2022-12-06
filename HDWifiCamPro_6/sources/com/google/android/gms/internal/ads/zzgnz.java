package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgnz implements zzgar {
    private final ECPrivateKey zza;
    private final zzgob zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzgny zze;

    public zzgnz(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzgny zzgny) throws GeneralSecurityException {
        this.zza = eCPrivateKey;
        this.zzb = new zzgob(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzgny;
    }
}
