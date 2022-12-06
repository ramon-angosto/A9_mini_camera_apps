package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfu {
    public static final zzghn zza = new zzgft((zzgfs) null);

    public static zzght zza(zzgbu zzgbu) {
        zzgbc zzgbc;
        zzghp zzghp = new zzghp();
        zzghp.zzb(zzgbu.zzb());
        for (List it : zzgbu.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzgbo zzgbo = (zzgbo) it2.next();
                    int zze = zzgbo.zze() - 2;
                    if (zze == 1) {
                        zzgbc = zzgbc.zza;
                    } else if (zze == 2) {
                        zzgbc = zzgbc.zzb;
                    } else if (zze == 3) {
                        zzgbc = zzgbc.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzghp.zza(zzgbc, zzgbo.zza(), zzgbo.zzb());
                }
            }
        }
        if (zzgbu.zza() != null) {
            zzghp.zzc(zzgbu.zza().zza());
        }
        try {
            return zzghp.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
