package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcp extends zzgfr {
    zzgcp() {
        super(zzgje.class, new zzgcn(zzgak.class));
    }

    static /* bridge */ /* synthetic */ zzgfp zzg(int i, int i2) {
        zzgjg zzc = zzgjh.zzc();
        zzc.zza(i);
        return new zzgfp((zzgjh) zzc.zzam(), i2);
    }

    public final zzgfq zza() {
        return new zzgco(this, zzgjh.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgje.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgje zzgje = (zzgje) zzgso;
        zzgoz.zzb(zzgje.zza(), 0);
        zzgoz.zza(zzgje.zzf().zzd());
    }

    public final int zze() {
        return 2;
    }

    public final int zzf() {
        return 3;
    }
}
