package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzggt extends zzgfq {
    zzggt(zzggu zzggu, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgia zzgia = (zzgia) zzgso;
        zzghw zzc = zzghx.zzc();
        zzc.zzc(0);
        zzc.zza(zzgpw.zzv(zzgox.zza(zzgia.zza())));
        zzc.zzb(zzgia.zzf());
        return (zzghx) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgia.zze(zzgpw, zzgqq.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzghz zzc = zzgia.zzc();
        zzc.zza(32);
        zzgic zzc2 = zzgid.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgid) zzc2.zzam());
        hashMap.put("AES_CMAC", new zzgfp((zzgia) zzc.zzam(), 1));
        zzghz zzc3 = zzgia.zzc();
        zzc3.zza(32);
        zzgic zzc4 = zzgid.zzc();
        zzc4.zza(16);
        zzc3.zzb((zzgid) zzc4.zzam());
        hashMap.put("AES256_CMAC", new zzgfp((zzgia) zzc3.zzam(), 1));
        zzghz zzc5 = zzgia.zzc();
        zzc5.zza(32);
        zzgic zzc6 = zzgid.zzc();
        zzc6.zza(16);
        zzc5.zzb((zzgid) zzc6.zzam());
        hashMap.put("AES256_CMAC_RAW", new zzgfp((zzgia) zzc5.zzam(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgia zzgia = (zzgia) zzgso;
        zzggu.zzm(zzgia.zzf());
        zzggu.zzn(zzgia.zza());
    }
}
