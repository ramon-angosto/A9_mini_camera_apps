package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgaz implements zzgba {
    final /* synthetic */ zzggg zza;
    final /* synthetic */ zzgfr zzb;

    zzgaz(zzggg zzggg, zzgfr zzgfr) {
        this.zza = zzggg;
        this.zzb = zzgfr;
    }

    public final zzgau zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzgbw(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzgau zzb() {
        zzggg zzggg = this.zza;
        return new zzgbw(zzggg, this.zzb, zzggg.zzi());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return this.zzb.getClass();
    }

    public final Set zze() {
        return this.zza.zzl();
    }
}
