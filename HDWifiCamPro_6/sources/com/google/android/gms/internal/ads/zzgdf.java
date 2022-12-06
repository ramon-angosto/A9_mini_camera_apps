package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdf extends zzgfr {
    zzgdf() {
        super(zzgnj.class, new zzgdd(zzgak.class));
    }

    public final zzgfq zza() {
        return new zzgde(this, zzgnm.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgnj.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgnj zzgnj = (zzgnj) zzgso;
        zzgoz.zzb(zzgnj.zza(), 0);
        if (zzgnj.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final int zzf() {
        return 3;
    }
}
