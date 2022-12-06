package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzh<TResult> implements zzq<TResult> {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    @Nullable
    public OnCanceledListener zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(Task<TResult> task) {
        if (task.isCanceled()) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzg(this));
                }
            }
        }
    }
}
