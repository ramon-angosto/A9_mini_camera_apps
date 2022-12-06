package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbe {
    public static zzgbd zza(String str) throws GeneralSecurityException {
        zzgbd zzgbd = (zzgbd) zzgby.zzk().get(str);
        if (zzgbd != null) {
            return zzgbd;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
