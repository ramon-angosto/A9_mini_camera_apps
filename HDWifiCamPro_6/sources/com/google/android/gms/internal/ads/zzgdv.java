package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgdv extends zzgfq {
    final /* synthetic */ zzgdw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgdv(zzgdw zzgdw, Class cls) {
        super(cls);
        this.zza = zzgdw;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgjp zzc = zzgjq.zzc();
        zzc.zza(zzgpw.zzv(zzgox.zza(((zzgjt) zzgso).zza())));
        zzc.zzb(0);
        return (zzgjq) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjt.zze(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzgjs zzc = zzgjt.zzc();
        zzc.zza(64);
        hashMap.put("AES256_SIV", new zzgfp((zzgjt) zzc.zzam(), 1));
        zzgjs zzc2 = zzgjt.zzc();
        zzc2.zza(64);
        hashMap.put("AES256_SIV_RAW", new zzgfp((zzgjt) zzc2.zzam(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgjt zzgjt = (zzgjt) zzgso;
        if (zzgjt.zza() != 64) {
            int zza2 = zzgjt.zza();
            throw new InvalidAlgorithmParameterException("invalid key size: " + zza2 + ". Valid keys must have 64 bytes.");
        }
    }
}
