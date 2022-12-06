package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgcr extends zzgfq {
    final /* synthetic */ zzgcs zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgcr(zzgcs zzgcs, Class cls) {
        super(cls);
        this.zza = zzgcs;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgjj zzc = zzgjk.zzc();
        zzc.zza(zzgpw.zzv(zzgox.zza(((zzgjn) zzgso).zza())));
        zzc.zzb(0);
        return (zzgjk) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjn.zze(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzgcs.zzh(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzgcs.zzh(16, 3));
        hashMap.put("AES256_GCM_SIV", zzgcs.zzh(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzgcs.zzh(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgoz.zza(((zzgjn) zzgso).zza());
    }
}
