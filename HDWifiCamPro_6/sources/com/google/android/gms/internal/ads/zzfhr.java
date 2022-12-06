package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfhr {
    public static final zzfhy zza(Callable callable, Object obj, zzfhz zzfhz) {
        return zzb(callable, zzfhz.zzb, obj, zzfhz);
    }

    public static final zzfhy zzb(Callable callable, zzfzq zzfzq, Object obj, zzfhz zzfhz) {
        return new zzfhy(zzfhz, obj, (String) null, zzfhz.zza, Collections.emptyList(), zzfzq.zzb(callable), (zzfhx) null);
    }

    public static final zzfhy zzc(zzfzp zzfzp, Object obj, zzfhz zzfhz) {
        return new zzfhy(zzfhz, obj, (String) null, zzfhz.zza, Collections.emptyList(), zzfzp, (zzfhx) null);
    }

    public static final zzfhy zzd(zzfhl zzfhl, zzfzq zzfzq, Object obj, zzfhz zzfhz) {
        return zzb(new zzfhq(zzfhl), zzfzq, obj, zzfhz);
    }
}
