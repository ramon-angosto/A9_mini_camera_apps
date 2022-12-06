package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgex {
    static zzgeq zza(zzglo zzglo) throws GeneralSecurityException {
        if (zzglo.zze() == 3) {
            return new zzgen(16);
        }
        if (zzglo.zze() == 4) {
            return new zzgen(32);
        }
        if (zzglo.zze() == 5) {
            return new zzgeo();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    static zzgeu zzb(zzglo zzglo) throws GeneralSecurityException {
        if (zzglo.zzg() == 3) {
            return new zzgfg(new zzgep("HmacSha256"));
        }
        if (zzglo.zzg() == 4) {
            return zzgfe.zzc(1);
        }
        if (zzglo.zzg() == 5) {
            return zzgfe.zzc(2);
        }
        if (zzglo.zzg() == 6) {
            return zzgfe.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    static zzgep zzc(zzglo zzglo) {
        if (zzglo.zzf() == 3) {
            return new zzgep("HmacSha256");
        }
        if (zzglo.zzf() == 4) {
            return new zzgep("HmacSha384");
        }
        if (zzglo.zzf() == 5) {
            return new zzgep("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
