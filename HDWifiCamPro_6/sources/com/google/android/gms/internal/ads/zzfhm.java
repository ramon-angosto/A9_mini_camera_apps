package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfhm implements zzfzp {
    private final Object zza;
    private final String zzb;
    private final zzfzp zzc;

    public zzfhm(Object obj, String str, zzfzp zzfzp) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = zzfzp;
    }

    public final boolean cancel(boolean z) {
        return this.zzc.cancel(z);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return this.zzc.get();
    }

    public final boolean isCancelled() {
        return this.zzc.isCancelled();
    }

    public final boolean isDone() {
        return this.zzc.isDone();
    }

    public final String toString() {
        String str = this.zzb;
        int identityHashCode = System.identityHashCode(this);
        return str + "@" + identityHashCode;
    }

    public final Object zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zzc.zzc(runnable, executor);
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzc.get(j, timeUnit);
    }
}
