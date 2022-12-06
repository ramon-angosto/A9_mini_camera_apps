package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghe {
    @Deprecated
    public static final zzgng zza = zzgng.zzc();
    @Deprecated
    public static final zzgng zzb;
    @Deprecated
    public static final zzgng zzc;

    static {
        new zzghd();
        zzgng zzgng = zza;
        zzb = zzgng;
        zzc = zzgng;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgby.zzo(new zzghj());
        zzgby.zzn(new zzghd(), true);
        if (!zzgdt.zzb()) {
            zzgby.zzn(new zzggu(), true);
            zzgha.zza();
        }
    }
}
