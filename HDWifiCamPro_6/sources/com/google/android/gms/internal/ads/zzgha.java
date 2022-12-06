package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgha {
    private static final zzgpc zza = zzgpc.zza("type.googleapis.com/google.crypto.tink.AesCmacKey".getBytes(StandardCharsets.US_ASCII));
    private static final zzgge zzb = zzgge.zzc(zzggw.zza, zzggv.class, zzggi.class);
    private static final zzggb zzc;
    private static final zzgfo zzd = zzgfo.zzc(zzggy.zza, zzggr.class, zzggh.class);
    private static final zzgfl zze;

    static {
        zzggx zzggx = zzggx.zza;
        zzgpc zzgpc = zza;
        zzc = zzggb.zzc(zzggx, zzgpc, zzggi.class);
        zze = zzgfl.zzc(zzggz.zza, zzgpc, zzggh.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzgfy zza2 = zzgfy.zza();
        zza2.zze(zzb);
        zza2.zzd(zzc);
        zza2.zzc(zzd);
        zza2.zzb(zze);
    }
}
