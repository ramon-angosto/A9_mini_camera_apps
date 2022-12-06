package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcg extends zzgfr {
    zzgcg() {
        super(zzgig.class, new zzgce(zzgak.class));
    }

    static /* bridge */ /* synthetic */ zzgfp zzg(int i, int i2, int i3, int i4, int i5, int i6) {
        zzgio zzc = zzgip.zzc();
        zzgir zzc2 = zzgis.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgis) zzc2.zzam());
        zzc.zza(i);
        zzglc zzc3 = zzgld.zzc();
        zzglf zzc4 = zzglg.zzc();
        zzc4.zzb(5);
        zzc4.zza(i4);
        zzc3.zzb((zzglg) zzc4.zzam());
        zzc3.zza(32);
        zzgii zza = zzgij.zza();
        zza.zza((zzgip) zzc.zzam());
        zza.zzb((zzgld) zzc3.zzam());
        return new zzgfp((zzgij) zza.zzam(), i6);
    }

    public final zzgfq zza() {
        return new zzgcf(this, zzgij.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgig.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgig zzgig = (zzgig) zzgso;
        zzgoz.zzb(zzgig.zza(), 0);
        new zzgcj();
        zzgcj.zzh(zzgig.zzf());
        new zzghd();
        zzghd.zzh(zzgig.zzg());
    }

    public final int zze() {
        return 2;
    }

    public final int zzf() {
        return 3;
    }
}
