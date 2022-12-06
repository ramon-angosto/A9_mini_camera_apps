package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzchh implements zzfzp {
    private final zzfzy zza = zzfzy.zzf();

    private static final boolean zza(boolean z) {
        if (!z) {
            zzt.zzo().zzs(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    public final Object get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final void zzc(Runnable runnable, Executor executor) {
        this.zza.zzc(runnable, executor);
    }

    public final boolean zzd(Object obj) {
        boolean zzd = this.zza.zzd(obj);
        zza(zzd);
        return zzd;
    }

    public final boolean zze(Throwable th) {
        boolean zze = this.zza.zze(th);
        zza(zze);
        return zze;
    }

    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
