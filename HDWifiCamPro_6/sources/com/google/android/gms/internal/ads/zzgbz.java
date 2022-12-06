package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgbz {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzgmp zza(zzgmk zzgmk) {
        zzgmm zza2 = zzgmp.zza();
        zza2.zzb(zzgmk.zzc());
        for (zzgmj zzgmj : zzgmk.zzh()) {
            zzgmn zza3 = zzgmo.zza();
            zza3.zzb(zzgmj.zzc().zzf());
            zza3.zzd(zzgmj.zzi());
            zza3.zzc(zzgmj.zzj());
            zza3.zza(zzgmj.zza());
            zza2.zza((zzgmo) zza3.zzam());
        }
        return (zzgmp) zza2.zzam();
    }

    public static void zzb(zzgmk zzgmk) throws GeneralSecurityException {
        int zzc = zzgmk.zzc();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzgmj zzgmj : zzgmk.zzh()) {
            if (zzgmj.zzi() == 3) {
                if (!zzgmj.zzh()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzgmj.zza())}));
                } else if (zzgmj.zzj() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzgmj.zza())}));
                } else if (zzgmj.zzi() != 2) {
                    if (zzgmj.zza() == zzc) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= zzgmj.zzc().zzi() == 5;
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzgmj.zza())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
