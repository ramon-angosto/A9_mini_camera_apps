package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgfg implements zzgeu {
    private final zzgep zza;

    zzgfg(zzgep zzgep) {
        this.zza = zzgep;
    }

    public final zzgev zza(byte[] bArr) throws GeneralSecurityException {
        byte[] zzb = zzgpa.zzb();
        byte[] zza2 = zzgpa.zza(zzb, bArr);
        byte[] zzc = zzgpa.zzc(zzb);
        byte[] zzc2 = zzgnv.zzc(zzc, bArr);
        byte[] zzd = zzgfd.zzd(zzgfd.zzb);
        zzgep zzgep = this.zza;
        return new zzgev(zzgep.zzb((byte[]) null, zza2, "eae_prk", zzc2, "shared_secret", zzd, zzgep.zza()), zzc);
    }

    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzgfd.zzf)) {
            return zzgfd.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
