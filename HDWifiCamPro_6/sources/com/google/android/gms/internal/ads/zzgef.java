package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgef {
    @Deprecated
    public static final zzgng zza = zzgng.zzc();
    @Deprecated
    public static final zzgng zzb = zzgng.zzc();
    @Deprecated
    public static final zzgng zzc = zzgng.zzc();

    static {
        new zzgee();
        new zzgec();
        try {
            zzgby.zzo(new zzgeh());
            zzgby.zzo(new zzgek());
            zzgca.zza();
            if (!zzgdt.zzb()) {
                zzgby.zzl(new zzgec(), new zzgee(), true);
                zzgby.zzl(new zzgfa(), new zzgfc(), true);
            }
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
