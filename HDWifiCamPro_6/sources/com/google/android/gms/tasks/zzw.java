package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzw<TResult> extends Task<TResult> {
    private final Object zza = new Object();
    private final zzr<TResult> zzb = new zzr<>();
    private boolean zzc;
    private volatile boolean zzd;
    private TResult zze;
    private Exception zzf;

    zzw() {
    }

    private final void zzf() {
        Preconditions.checkState(this.zzc, "Task is not yet complete");
    }

    private final void zzg() {
        if (this.zzd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void zzh() {
        if (this.zzc) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    private final void zzi() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zzb(this);
            }
        }
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        zzh zzh = new zzh(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzb.zza(zzh);
        zzv.zza(activity).zzb(zzh);
        zzi();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        zzj zzj = new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzb.zza(zzj);
        zzv.zza(activity).zzb(zzj);
        zzi();
        return this;
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        zzl zzl = new zzl(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzb.zza(zzl);
        zzv.zza(activity).zzb(zzl);
        zzi();
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        zzn zzn = new zzn(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzb.zza(zzn);
        zzv.zza(activity).zzb(zzn);
        zzi();
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            zzf();
            zzg();
            Exception exc = this.zzf;
            if (exc == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzc && !this.zzd && this.zzf == null) {
                z = true;
            }
        }
        return z;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzw zzw = new zzw();
        this.zzb.zza(new zzp(executor, successContinuation, zzw));
        zzi();
        return zzw;
    }

    public final void zza(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb(this);
    }

    public final void zzb(TResult tresult) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = tresult;
        }
        this.zzb.zzb(this);
    }

    public final boolean zzc() {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zzd(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exc;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final boolean zze(TResult tresult) {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = tresult;
            this.zzb.zzb(this);
            return true;
        }
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzw));
        zzi();
        return zzw;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzf(executor, continuation, zzw));
        zzi();
        return zzw;
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener));
        zzi();
        return this;
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw zzw = new zzw();
        this.zzb.zza(new zzp(executor, successContinuation, zzw));
        zzi();
        return zzw;
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzb.zza(new zzh(executor, onCanceledListener));
        zzi();
        return this;
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzb.zza(new zzl(executor, onFailureListener));
        zzi();
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzb.zza(new zzn(executor, onSuccessListener));
        zzi();
        return this;
    }

    public final <X extends Throwable> TResult getResult(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zza) {
            zzf();
            zzg();
            if (!cls.isInstance(this.zzf)) {
                Exception exc = this.zzf;
                if (exc == null) {
                    tresult = this.zze;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.zzf));
            }
        }
        return tresult;
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(executor, onCompleteListener));
        zzi();
        return this;
    }
}
