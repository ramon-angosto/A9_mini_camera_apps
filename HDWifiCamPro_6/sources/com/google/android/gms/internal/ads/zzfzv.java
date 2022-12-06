package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfzv extends zzfzs implements ScheduledExecutorService, zzfzq {
    final ScheduledExecutorService zza;

    zzfzv(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        if (scheduledExecutorService != null) {
            this.zza = scheduledExecutorService;
            return;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzgaf zzf = zzgaf.zzf(runnable, (Object) null);
        return new zzfzt(zzf, this.zza.schedule(zzf, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzfzu zzfzu = new zzfzu(runnable);
        return new zzfzt(zzfzu, this.zza.scheduleAtFixedRate(zzfzu, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzfzu zzfzu = new zzfzu(runnable);
        return new zzfzt(zzfzu, this.zza.scheduleWithFixedDelay(zzfzu, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgaf zzgaf = new zzgaf(callable);
        return new zzfzt(zzgaf, this.zza.schedule(zzgaf, j, timeUnit));
    }
}
