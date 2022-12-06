package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfzk implements zzfzp {
    static final zzfzp zza = new zzfzk((Object) null);
    private static final Logger zzb = Logger.getLogger(zzfzk.class.getName());
    private final Object zzc;

    zzfzk(Object obj) {
        this.zzc = obj;
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final Object get() {
        return this.zzc;
    }

    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException {
        if (timeUnit != null) {
            return this.zzc;
        }
        throw null;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.zzc + "]]";
    }

    public final void zzc(Runnable runnable, Executor executor) {
        zzfsx.zzc(runnable, "Runnable was null.");
        zzfsx.zzc(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }
}
