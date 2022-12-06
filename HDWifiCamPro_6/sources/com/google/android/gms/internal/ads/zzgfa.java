package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfa extends zzggg {
    public zzgfa() {
        super(zzglr.class, zzglu.class, new zzgey(zzgar.class));
    }

    static /* bridge */ /* synthetic */ zzgfp zzg(int i, int i2, int i3, int i4) {
        zzgln zza = zzglo.zza();
        zza.zzc(i);
        zza.zzb(i2);
        zza.zza(i3);
        zzglk zza2 = zzgll.zza();
        zza2.zza((zzglo) zza.zzam());
        return new zzgfp((zzgll) zza2.zzam(), i4);
    }

    public final zzgfq zza() {
        return new zzgez(this, zzgll.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzglr.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzglr zzglr = (zzglr) zzgso;
        if (zzglr.zzg().zzD()) {
            throw new GeneralSecurityException("Private key is empty.");
        } else if (zzglr.zzk()) {
            zzgoz.zzb(zzglr.zza(), 0);
            zzgfd.zza(zzglr.zzf().zzc());
        } else {
            throw new GeneralSecurityException("Missing public key.");
        }
    }

    public final int zzf() {
        return 4;
    }
}
