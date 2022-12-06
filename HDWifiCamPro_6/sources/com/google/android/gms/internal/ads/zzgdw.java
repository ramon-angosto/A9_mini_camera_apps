package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdw extends zzgfr {
    zzgdw() {
        super(zzgjq.class, new zzgdu(zzgaq.class));
    }

    public final zzgfq zza() {
        return new zzgdv(this, zzgjt.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjq.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgjq zzgjq = (zzgjq) zzgso;
        zzgoz.zzb(zzgjq.zza(), 0);
        if (zzgjq.zzf().zzd() != 64) {
            int zzd = zzgjq.zzf().zzd();
            throw new InvalidKeyException("invalid key size: " + zzd + ". Valid keys must have 64 bytes.");
        }
    }

    public final int zzf() {
        return 3;
    }
}
