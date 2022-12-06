package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgaf extends zzfyw implements RunnableFuture {
    @CheckForNull
    private volatile zzfzo zza;

    zzgaf(zzfym zzfym) {
        this.zza = new zzgad(this, zzfym);
    }

    static zzgaf zzf(Runnable runnable, Object obj) {
        return new zzgaf(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzfzo zzfzo = this.zza;
        if (zzfzo != null) {
            zzfzo.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzfzo zzfzo = this.zza;
        if (zzfzo == null) {
            return super.zza();
        }
        return "task=[" + zzfzo + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfzo zzfzo;
        if (zzu() && (zzfzo = this.zza) != null) {
            zzfzo.zzh();
        }
        this.zza = null;
    }

    zzgaf(Callable callable) {
        this.zza = new zzgae(this, callable);
    }
}
