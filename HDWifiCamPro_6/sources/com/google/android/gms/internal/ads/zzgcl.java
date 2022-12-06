package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgcl extends zzgfq {
    final /* synthetic */ zzgcm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgcl(zzgcm zzgcm, Class cls) {
        super(cls);
        this.zza = zzgcm;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgiy zzgiy = (zzgiy) zzgso;
        zzgiu zzc = zzgiv.zzc();
        zzc.zza(zzgpw.zzv(zzgox.zza(zzgiy.zza())));
        zzc.zzb(zzgiy.zzf());
        zzc.zzc(0);
        return (zzgiv) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgiy.zze(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzgcm.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzgcm.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzgcm.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzgcm.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgiy zzgiy = (zzgiy) zzgso;
        zzgoz.zza(zzgiy.zza());
        if (zzgiy.zzf().zza() != 12 && zzgiy.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
