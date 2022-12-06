package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzges implements zzgar {
    private final zzgew zza;
    private final zzgeu zzb;
    private final zzgeq zzc;
    private final zzgep zzd;

    private zzges(zzgew zzgew, zzgeu zzgeu, zzgep zzgep, zzgeq zzgeq, int i, byte[] bArr) {
        this.zza = zzgew;
        this.zzb = zzgeu;
        this.zzd = zzgep;
        this.zzc = zzgeq;
    }

    static zzges zza(zzglr zzglr) throws GeneralSecurityException {
        zzgew zzgew;
        if (!zzglr.zzk()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        } else if (!zzglr.zzf().zzl()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        } else if (!zzglr.zzg().zzD()) {
            zzglo zzc2 = zzglr.zzf().zzc();
            zzgeu zzb2 = zzgex.zzb(zzc2);
            zzgep zzc3 = zzgex.zzc(zzc2);
            zzgeq zza2 = zzgex.zza(zzc2);
            int zzg = zzc2.zzg();
            int i = 1;
            if (zzg - 2 == 1) {
                int zzg2 = zzglr.zzf().zzc().zzg() - 2;
                if (zzg2 == 1) {
                    zzgew = zzgfh.zza(zzglr.zzg().zzE());
                } else if (zzg2 == 2 || zzg2 == 3 || zzg2 == 4) {
                    byte[] zzE = zzglr.zzg().zzE();
                    byte[] zzE2 = zzglr.zzf().zzh().zzE();
                    int zzg3 = zzglr.zzf().zzc().zzg() - 2;
                    if (zzg3 != 2) {
                        if (zzg3 == 3) {
                            i = 2;
                        } else if (zzg3 == 4) {
                            i = 3;
                        } else {
                            throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
                        }
                    }
                    zzgew = zzgff.zza(zzE, zzE2, i);
                } else {
                    throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
                }
                return new zzges(zzgew, zzb2, zzc3, zza2, 32, (byte[]) null);
            }
            throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzgli.zza(zzg)));
        } else {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
    }
}
