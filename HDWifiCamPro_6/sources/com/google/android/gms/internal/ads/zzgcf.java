package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgcf extends zzgfq {
    final /* synthetic */ zzgcg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgcf(zzgcg zzgcg, Class cls) {
        super(cls);
        this.zza = zzgcg;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgij zzgij = (zzgij) zzgso;
        new zzgcj();
        zzgim zzf = zzgci.zzf(zzgij.zze());
        zzgso zza2 = new zzghd().zza().zza(zzgij.zzf());
        zzgif zzc = zzgig.zzc();
        zzc.zza(zzf);
        zzc.zzb((zzgla) zza2);
        zzc.zzc(0);
        return (zzgig) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgij.zzd(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzgcg.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzgcg.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzgcg.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzgcg.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgij zzgij = (zzgij) zzgso;
        ((zzgci) new zzgcj().zza()).zzd(zzgij.zze());
        new zzghd().zza().zzd(zzgij.zzf());
        zzgoz.zza(zzgij.zze().zza());
    }
}
