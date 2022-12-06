package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdx {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    public static final zzgng zzb = zzgng.zzc();
    @Deprecated
    public static final zzgng zzc = zzgng.zzc();

    static {
        new zzgdw();
        try {
            zzgby.zzo(new zzgdz());
            if (!zzgdt.zzb()) {
                zzgby.zzn(new zzgdw(), true);
            }
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
