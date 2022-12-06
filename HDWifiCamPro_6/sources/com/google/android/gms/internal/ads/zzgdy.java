package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgdy implements zzgaq {
    private final zzgbu zza;
    private final zzghn zzb;
    private final zzghn zzc;

    public zzgdy(zzgbu zzgbu) {
        zzghn zzghn;
        this.zza = zzgbu;
        if (zzgbu.zzf()) {
            zzgho zzb2 = zzgfx.zza().zzb();
            zzght zza2 = zzgfu.zza(zzgbu);
            this.zzb = zzb2.zza(zza2, "daead", "encrypt");
            zzghn = zzb2.zza(zza2, "daead", "decrypt");
        } else {
            zzghn = zzgfu.zza;
            this.zzb = zzghn;
        }
        this.zzc = zzghn;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzc2 = zzgnv.zzc(this.zza.zza().zzd(), ((zzgaq) this.zza.zza().zzc()).zza(bArr, bArr2));
            this.zza.zza().zza();
            int length = bArr.length;
            return zzc2;
        } catch (GeneralSecurityException e) {
            throw e;
        }
    }
}
