package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgcm extends zzgfr {
    zzgcm() {
        super(zzgiv.class, new zzgck(zzgak.class));
    }

    static /* bridge */ /* synthetic */ zzgfp zzg(int i, int i2, int i3) {
        zzgix zzc = zzgiy.zzc();
        zzc.zza(i);
        zzgja zzc2 = zzgjb.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgjb) zzc2.zzam());
        return new zzgfp((zzgiy) zzc.zzam(), i3);
    }

    public final zzgfq zza() {
        return new zzgcl(this, zzgiy.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgiv.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgiv zzgiv = (zzgiv) zzgso;
        zzgoz.zzb(zzgiv.zza(), 0);
        zzgoz.zza(zzgiv.zzg().zzd());
        if (zzgiv.zzf().zza() != 12 && zzgiv.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final int zzf() {
        return 3;
    }
}
