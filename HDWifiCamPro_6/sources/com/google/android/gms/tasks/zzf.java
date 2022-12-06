package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzf<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> zzb;
    /* access modifiers changed from: private */
    public final zzw<TContinuationResult> zzc;

    public zzf(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzw<TContinuationResult> zzw) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzw;
    }

    public final void onCanceled() {
        this.zzc.zzc();
    }

    public final void onFailure(Exception exc) {
        this.zzc.zza(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzc.zzb(tcontinuationresult);
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }

    public final void zzd(Task<TResult> task) {
        this.zza.execute(new zze(this, task));
    }
}
