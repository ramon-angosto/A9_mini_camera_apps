package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgfq {
    private final Class zza;

    public zzgfq(Class cls) {
        this.zza = cls;
    }

    public abstract zzgso zza(zzgso zzgso) throws GeneralSecurityException;

    public abstract zzgso zzb(zzgpw zzgpw) throws zzgrq;

    public Map zzc() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void zzd(zzgso zzgso) throws GeneralSecurityException;

    public final Class zzg() {
        return this.zza;
    }
}
