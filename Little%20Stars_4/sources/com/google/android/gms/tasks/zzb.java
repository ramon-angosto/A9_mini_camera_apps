package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Executor zzboH;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> zzbwk;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> zzbwl;

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> zzh) {
        this.zzboH = executor;
        this.zzbwk = continuation;
        this.zzbwl = zzh;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        this.zzboH.execute(new Runnable() {
            public void run() {
                zzh zzh;
                Exception exc;
                try {
                    Task task = (Task) zzb.this.zzbwk.then(task);
                    if (task == null) {
                        zzb.this.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    task.addOnSuccessListener(TaskExecutors.zzbwy, zzb.this);
                    task.addOnFailureListener(TaskExecutors.zzbwy, (OnFailureListener) zzb.this);
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzh = zzb.this.zzbwl;
                        exc = (Exception) e.getCause();
                    } else {
                        zzh = zzb.this.zzbwl;
                        exc = e;
                    }
                    zzh.setException(exc);
                } catch (Exception e2) {
                    zzb.this.zzbwl.setException(e2);
                }
            }
        });
    }

    public void onFailure(@NonNull Exception exc) {
        this.zzbwl.setException(exc);
    }

    public void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzbwl.setResult(tcontinuationresult);
    }
}
