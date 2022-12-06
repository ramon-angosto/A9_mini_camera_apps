package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgca {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final zzgng zzc = zzgng.zzc();
    @Deprecated
    public static final zzgng zzd;
    @Deprecated
    public static final zzgng zze;

    static {
        new zzgcg();
        new zzgcp();
        new zzgcs();
        new zzgcm();
        new zzgcy();
        new zzgdc();
        new zzgcv();
        new zzgdf();
        zzgng zzgng = zzc;
        zzd = zzgng;
        zze = zzgng;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgby.zzo(new zzgcd());
        zzghe.zza();
        zzgby.zzn(new zzgcg(), true);
        zzgby.zzn(new zzgcp(), true);
        if (!zzgdt.zzb()) {
            zzgby.zzn(new zzgcm(), true);
            zzgcs.zzg(true);
            zzgby.zzn(new zzgcv(), true);
            zzgby.zzn(new zzgcy(), true);
            zzgby.zzn(new zzgdc(), true);
            zzgby.zzn(new zzgdf(), true);
        }
    }
}
