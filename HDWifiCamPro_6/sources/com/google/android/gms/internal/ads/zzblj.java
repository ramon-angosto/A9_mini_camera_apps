package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzblj {
    static final AtomicBoolean zza = new AtomicBoolean();
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();

    static zzblh zza() {
        return (zzblh) zzb.get();
    }

    static zzbli zzb() {
        return (zzbli) zzc.get();
    }

    public static void zzc(zzblh zzblh) {
        zzb.set(zzblh);
    }
}
