package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgco extends zzgfq {
    final /* synthetic */ zzgcp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgco(zzgcp zzgcp, Class cls) {
        super(cls);
        this.zza = zzgcp;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgjd zzc = zzgje.zzc();
        zzc.zza(zzgpw.zzv(zzgox.zza(((zzgjh) zzgso).zza())));
        zzc.zzb(0);
        return (zzgje) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjh.zze(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgcp.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzgcp.zzg(16, 3));
        hashMap.put("AES256_GCM", zzgcp.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzgcp.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgoz.zza(((zzgjh) zzgso).zza());
    }
}
