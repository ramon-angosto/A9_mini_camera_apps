package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcj extends zzgfr {
    zzgcj() {
        super(zzgim.class, new zzgch(zzgor.class));
    }

    public static final void zzh(zzgim zzgim) throws GeneralSecurityException {
        zzgoz.zzb(zzgim.zza(), 0);
        zzgoz.zza(zzgim.zzh().zzd());
        zzm(zzgim.zzg());
    }

    /* access modifiers changed from: private */
    public static final void zzm(zzgis zzgis) throws GeneralSecurityException {
        if (zzgis.zza() < 12 || zzgis.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final zzgfq zza() {
        return new zzgci(this, zzgip.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgim.zzf(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzh((zzgim) zzgso);
    }

    public final int zzf() {
        return 3;
    }
}
