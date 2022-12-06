package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgfx {
    private static final zzgfx zza = new zzgfx();
    private static final zzgfw zzb = new zzgfw((zzgfv) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgfx zza() {
        return zza;
    }

    public final zzgho zzb() {
        zzgho zzgho = (zzgho) this.zzc.get();
        return zzgho == null ? zzb : zzgho;
    }
}
