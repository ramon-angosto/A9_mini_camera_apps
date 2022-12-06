package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgax implements zzgba {
    final /* synthetic */ zzgau zza;

    zzgax(zzgau zzgau) {
        this.zza = zzgau;
    }

    public final zzgau zza(Class cls) throws GeneralSecurityException {
        if (this.zza.zzc().equals(cls)) {
            return this.zza;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzgau zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zza.getClass();
    }

    public final Class zzd() {
        return null;
    }

    public final Set zze() {
        return Collections.singleton(this.zza.zzc());
    }
}
