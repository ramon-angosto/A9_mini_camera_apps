package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsw {
    private static final zzgsw zza = new zzgsw();
    private final zzgti zzb = new zzgsg();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzgsw() {
    }

    public static zzgsw zza() {
        return zza;
    }

    public final zzgth zzb(Class cls) {
        zzgro.zzf(cls, "messageType");
        zzgth zzgth = (zzgth) this.zzc.get(cls);
        if (zzgth == null) {
            zzgth = this.zzb.zza(cls);
            zzgro.zzf(cls, "messageType");
            zzgro.zzf(zzgth, "schema");
            zzgth zzgth2 = (zzgth) this.zzc.putIfAbsent(cls, zzgth);
            return zzgth2 == null ? zzgth : zzgth2;
        }
    }
}
