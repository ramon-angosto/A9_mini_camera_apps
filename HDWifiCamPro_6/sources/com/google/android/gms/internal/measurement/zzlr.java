package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlr {
    private static final zzlr zza = new zzlr();
    private final zzlv zzb = new zzlb();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzlr() {
    }

    public static zzlr zza() {
        return zza;
    }

    public final zzlu zzb(Class cls) {
        zzkk.zzf(cls, "messageType");
        zzlu zzlu = (zzlu) this.zzc.get(cls);
        if (zzlu == null) {
            zzlu = this.zzb.zza(cls);
            zzkk.zzf(cls, "messageType");
            zzkk.zzf(zzlu, "schema");
            zzlu zzlu2 = (zzlu) this.zzc.putIfAbsent(cls, zzlu);
            return zzlu2 == null ? zzlu : zzlu2;
        }
    }
}
