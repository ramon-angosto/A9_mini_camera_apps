package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfzr implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzfxx zzb;

    zzfzr(Executor executor, zzfxx zzfxx) {
        this.zza = executor;
        this.zzb = zzfxx;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zze(e);
        }
    }
}
