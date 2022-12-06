package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbk {
    @Deprecated
    public static final zzgbf zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzgmk zzg = zzgmk.zzg(bArr, zzgqq.zza());
            for (zzgmj zzgmj : zzg.zzh()) {
                if (zzgmj.zzc().zzi() == 2 || zzgmj.zzc().zzi() == 3 || zzgmj.zzc().zzi() == 4) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzgbf.zza(zzg);
        } catch (zzgrq unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
