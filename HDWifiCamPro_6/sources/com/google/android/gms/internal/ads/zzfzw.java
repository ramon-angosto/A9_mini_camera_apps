package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfzw {
    public static zzfzq zza(ExecutorService executorService) {
        if (executorService instanceof zzfzq) {
            return (zzfzq) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzfzv((ScheduledExecutorService) executorService);
        }
        return new zzfzs(executorService);
    }

    public static Executor zzb() {
        return zzfyu.INSTANCE;
    }

    static Executor zzc(Executor executor, zzfxx zzfxx) {
        if (executor == null) {
            throw null;
        } else if (executor == zzfyu.INSTANCE) {
            return executor;
        } else {
            return new zzfzr(executor, zzfxx);
        }
    }
}
