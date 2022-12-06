package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgde extends zzgfq {
    final /* synthetic */ zzgdf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgde(zzgdf zzgdf, Class cls) {
        super(cls);
        this.zza = zzgdf;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgnm zzgnm = (zzgnm) zzgso;
        zzgni zzc = zzgnj.zzc();
        zzc.zzb(0);
        zzc.zza(zzgpw.zzv(zzgox.zza(32)));
        return (zzgnj) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgnm.zzd(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzgfp(zzgnm.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzgfp(zzgnm.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgnm zzgnm = (zzgnm) zzgso;
    }
}
