package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcv extends zzgfr {
    zzgcv() {
        super(zzgjw.class, new zzgct(zzgak.class));
    }

    public final zzgfq zza() {
        return new zzgcu(this, zzgjz.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgjw.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgjw zzgjw = (zzgjw) zzgso;
        zzgoz.zzb(zzgjw.zza(), 0);
        if (zzgjw.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final int zzf() {
        return 3;
    }
}
