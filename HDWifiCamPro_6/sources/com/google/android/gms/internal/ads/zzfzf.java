package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfzf {
    private final boolean zza;
    private final zzfvn zzb;

    /* synthetic */ zzfzf(boolean z, zzfvn zzfvn, zzfzd zzfzd) {
        this.zza = z;
        this.zzb = zzfvn;
    }

    public final zzfzp zza(Callable callable, Executor executor) {
        return new zzfyt(this.zzb, this.zza, executor, callable);
    }
}
