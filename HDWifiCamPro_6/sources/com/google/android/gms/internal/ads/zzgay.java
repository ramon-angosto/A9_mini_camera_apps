package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgay implements zzgba {
    final /* synthetic */ zzgfr zza;

    zzgay(zzgfr zzgfr) {
        this.zza = zzgfr;
    }

    public final zzgau zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzgaw(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzgau zzb() {
        zzgfr zzgfr = this.zza;
        return new zzgaw(zzgfr, zzgfr.zzi());
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return null;
    }

    public final Set zze() {
        return this.zza.zzl();
    }
}
