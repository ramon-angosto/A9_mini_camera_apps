package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzd<TResult, TContinuationResult> implements zzq<TResult> {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> zzb;
    /* access modifiers changed from: private */
    public final zzw<TContinuationResult> zzc;

    public zzd(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzw<TContinuationResult> zzw) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzw;
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }

    public final void zzd(Task<TResult> task) {
        this.zza.execute(new zzc(this, task));
    }
}
