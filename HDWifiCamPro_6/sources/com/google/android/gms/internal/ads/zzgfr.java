package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgfr {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    protected zzgfr(Class cls, zzggf... zzggfArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i <= 0) {
            zzggf zzggf = zzggfArr[i];
            if (!hashMap.containsKey(zzggf.zzb())) {
                hashMap.put(zzggf.zzb(), zzggf);
                i++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzggf.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzggfArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzgfq zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzgso zzb(zzgpw zzgpw) throws zzgrq;

    public abstract String zzc();

    public abstract void zzd(zzgso zzgso) throws GeneralSecurityException;

    public int zze() {
        return 1;
    }

    public abstract int zzf();

    public final Class zzi() {
        return this.zzc;
    }

    public final Class zzj() {
        return this.zza;
    }

    public final Object zzk(zzgso zzgso, Class cls) throws GeneralSecurityException {
        zzggf zzggf = (zzggf) this.zzb.get(cls);
        if (zzggf != null) {
            return zzggf.zza(zzgso);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzl() {
        return this.zzb.keySet();
    }
}
