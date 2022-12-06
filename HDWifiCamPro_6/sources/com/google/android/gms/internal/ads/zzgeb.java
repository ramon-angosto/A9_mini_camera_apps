package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgeb extends zzgfq {
    final /* synthetic */ zzgec zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgeb(zzgec zzgec, Class cls) {
        super(cls);
        this.zza = zzgec;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgkh zzgkh = (zzgkh) zzgso;
        KeyPair zzc = zzgoe.zzc(zzgoe.zzk(zzgel.zzc(zzgkh.zze().zzf().zzg())));
        ECPoint w = ((ECPublicKey) zzc.getPublic()).getW();
        zzgkp zzd = zzgkq.zzd();
        zzd.zzb(0);
        zzd.zza(zzgkh.zze());
        zzd.zzc(zzgpw.zzv(w.getAffineX().toByteArray()));
        zzd.zzd(zzgpw.zzv(w.getAffineY().toByteArray()));
        zzgkm zzc2 = zzgkn.zzc();
        zzc2.zzc(0);
        zzc2.zzb((zzgkq) zzd.zzam());
        zzc2.zza(zzgpw.zzv(((ECPrivateKey) zzc.getPrivate()).getS().toByteArray()));
        return (zzgkn) zzc2.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgkh.zzd(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzgec.zzh(4, 5, 3, zzgbe.zza("AES128_GCM"), zzgec.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzgec.zzh(4, 5, 3, zzgbe.zza("AES128_GCM"), zzgec.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzgec.zzh(4, 5, 4, zzgbe.zza("AES128_GCM"), zzgec.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzgec.zzh(4, 5, 4, zzgbe.zza("AES128_GCM"), zzgec.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzgec.zzh(4, 5, 4, zzgbe.zza("AES128_GCM"), zzgec.zza, 3));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzgec.zzh(4, 5, 3, zzgbe.zza("AES128_CTR_HMAC_SHA256"), zzgec.zza, 1));
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzgec.zzh(4, 5, 3, zzgbe.zza("AES128_CTR_HMAC_SHA256"), zzgec.zza, 3));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzgec.zzh(4, 5, 4, zzgbe.zza("AES128_CTR_HMAC_SHA256"), zzgec.zza, 1));
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzgec.zzh(4, 5, 4, zzgbe.zza("AES128_CTR_HMAC_SHA256"), zzgec.zza, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgel.zza(((zzgkh) zzgso).zze());
    }
}
