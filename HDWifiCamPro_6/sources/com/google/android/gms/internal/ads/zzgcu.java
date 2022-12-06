package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgcu extends zzgfq {
    final /* synthetic */ zzgcv zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgcu(zzgcv zzgcv, Class cls) {
        super(cls);
        this.zza = zzgcv;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgjz zzgjz = (zzgjz) zzgso;
        zzgjv zzc = zzgjw.zzc();
        zzc.zzb(0);
        zzc.zza(zzgpw.zzv(zzgox.zza(32)));
        return (zzgjw) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjz.zzd(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzgfp(zzgjz.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzgfp(zzgjz.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgjz zzgjz = (zzgjz) zzgso;
    }
}
