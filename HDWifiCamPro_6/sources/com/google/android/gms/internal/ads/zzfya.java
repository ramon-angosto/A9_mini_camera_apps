package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfya extends AbstractExecutorService implements zzfzq {
    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzgaf.zzf(runnable, obj);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (zzfzp) super.submit(runnable);
    }

    public final zzfzp zza(Runnable runnable) {
        return (zzfzp) super.submit(runnable);
    }

    public final zzfzp zzb(Callable callable) {
        return (zzfzp) super.submit(callable);
    }

    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzgaf(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzfzp) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (zzfzp) super.submit(callable);
    }
}
