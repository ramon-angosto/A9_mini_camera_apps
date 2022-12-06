package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzghb extends zzggf {
    zzghb(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzgso zzgso) throws GeneralSecurityException {
        zzgla zzgla = (zzgla) zzgso;
        int zzg = zzgla.zzg().zzg();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzgla.zzh().zzE(), "HMAC");
        int zza = zzgla.zzg().zza();
        int i = zzg - 2;
        if (i == 1) {
            return new zzgov(new zzgou("HMACSHA1", secretKeySpec), zza);
        }
        if (i == 2) {
            return new zzgov(new zzgou("HMACSHA384", secretKeySpec), zza);
        }
        if (i == 3) {
            return new zzgov(new zzgou("HMACSHA256", secretKeySpec), zza);
        }
        if (i == 4) {
            return new zzgov(new zzgou("HMACSHA512", secretKeySpec), zza);
        }
        if (i == 5) {
            return new zzgov(new zzgou("HMACSHA224", secretKeySpec), zza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
