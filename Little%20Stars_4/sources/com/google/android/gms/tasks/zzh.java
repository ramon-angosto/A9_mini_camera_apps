package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult> extends Task<TResult> {
    private boolean zzbwA;
    private TResult zzbwB;
    private Exception zzbwC;
    private final zzg<TResult> zzbwz = new zzg<>();
    private final Object zzpp = new Object();

    private static class zza extends zzoq {
        private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();

        private zza(zzor zzor) {
            super(zzor);
            this.zzaop.zza("TaskOnStopCallback", (zzoq) this);
        }

        public static zza zzv(Activity activity) {
            zzor zzs = zzs(activity);
            zza zza = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(zzs) : zza;
        }

        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference<zzf<?>> weakReference : this.mListeners) {
                    zzf zzf = (zzf) weakReference.get();
                    if (zzf != null) {
                        zzf.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzf) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference(zzf));
            }
        }
    }

    zzh() {
    }

    private void zzMN() {
        zzaa.zza(this.zzbwA, (Object) "Task is not yet complete");
    }

    private void zzMO() {
        zzaa.zza(!this.zzbwA, (Object) "Task is already complete");
    }

    private void zzMP() {
        synchronized (this.zzpp) {
            if (this.zzbwA) {
                this.zzbwz.zza(this);
            }
        }
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzc = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzbwz.zza(zzc);
        zza.zzv(activity).zzb(zzc);
        zzMP();
        return this;
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzbwz.zza(new zzc(executor, onCompleteListener));
        zzMP();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzd = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzbwz.zza(zzd);
        zza.zzv(activity).zzb(zzd);
        zzMP();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzbwz.zza(new zzd(executor, onFailureListener));
        zzMP();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zze = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzbwz.zza(zze);
        zza.zzv(activity).zzb(zze);
        zzMP();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzbwz.zza(new zze(executor, onSuccessListener));
        zzMP();
        return this;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzh = new zzh();
        this.zzbwz.zza(new zza(executor, continuation, zzh));
        zzMP();
        return zzh;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzh = new zzh();
        this.zzbwz.zza(new zzb(executor, continuation, zzh));
        zzMP();
        return zzh;
    }

    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzpp) {
            exc = this.zzbwC;
        }
        return exc;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzpp) {
            zzMN();
            if (this.zzbwC == null) {
                tresult = this.zzbwB;
            } else {
                throw new RuntimeExecutionException(this.zzbwC);
            }
        }
        return tresult;
    }

    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzpp) {
            zzMN();
            if (cls.isInstance(this.zzbwC)) {
                throw ((Throwable) cls.cast(this.zzbwC));
            } else if (this.zzbwC == null) {
                tresult = this.zzbwB;
            } else {
                throw new RuntimeExecutionException(this.zzbwC);
            }
        }
        return tresult;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.zzpp) {
            z = this.zzbwA;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzpp) {
            z = this.zzbwA && this.zzbwC == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzaa.zzb(exc, (Object) "Exception must not be null");
        synchronized (this.zzpp) {
            zzMO();
            this.zzbwA = true;
            this.zzbwC = exc;
        }
        this.zzbwz.zza(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzpp) {
            zzMO();
            this.zzbwA = true;
            this.zzbwB = tresult;
        }
        this.zzbwz.zza(this);
    }
}
