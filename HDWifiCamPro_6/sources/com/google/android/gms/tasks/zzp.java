package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzp<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final SuccessContinuation<TResult, TContinuationResult> zzb;
    private final zzw<TContinuationResult> zzc;

    public zzp(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, zzw<TContinuationResult> zzw) {
        this.zza = executor;
        this.zzb = successContinuation;
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
        this.zza.execute(new zzo(this, task));
    }
}
