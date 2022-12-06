package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfc extends zzgfr {
    public zzgfc() {
        super(zzglu.class, new zzgfb(zzgas.class));
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzglu.zzg(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzglu zzglu = (zzglu) zzgso;
        zzgoz.zzb(zzglu.zza(), 0);
        if (zzglu.zzl()) {
            zzgfd.zza(zzglu.zzc());
            return;
        }
        throw new GeneralSecurityException("Missing HPKE key params.");
    }

    public final int zzf() {
        return 5;
    }
}
