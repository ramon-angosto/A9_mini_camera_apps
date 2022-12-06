package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzghc extends zzgfq {
    final /* synthetic */ zzghd zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzghc(zzghd zzghd, Class cls) {
        super(cls);
        this.zza = zzghd;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgld zzgld = (zzgld) zzgso;
        zzgkz zzc = zzgla.zzc();
        zzc.zzc(0);
        zzc.zzb(zzgld.zzg());
        zzc.zza(zzgpw.zzv(zzgox.zza(zzgld.zza())));
        return (zzgla) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgld.zzf(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzghd.zzm(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzghd.zzm(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzghd.zzm(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzghd.zzm(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzghd.zzm(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzghd.zzm(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzghd.zzm(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzghd.zzm(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzghd.zzm(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzghd.zzm(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgld zzgld = (zzgld) zzgso;
        if (zzgld.zza() >= 16) {
            zzghd.zzn(zzgld.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
