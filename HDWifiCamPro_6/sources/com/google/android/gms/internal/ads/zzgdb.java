package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgdb extends zzgfq {
    final /* synthetic */ zzgdc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgdb(zzgdc zzgdc, Class cls) {
        super(cls);
        this.zza = zzgdc;
    }

    public final /* bridge */ /* synthetic */ zzgso zza(zzgso zzgso) throws GeneralSecurityException {
        zzgmx zzc = zzgmy.zzc();
        zzc.zza((zzgnb) zzgso);
        zzc.zzb(0);
        return (zzgmy) zzc.zzam();
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgnb.zze(zzgpw, zzgqq.zza());
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgnb zzgnb = (zzgnb) zzgso;
        if (zzgnb.zzf().isEmpty() || !zzgnb.zzg()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
