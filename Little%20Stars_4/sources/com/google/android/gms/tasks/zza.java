package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor zzboH;
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> zzbwk;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> zzbwl;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzh) {
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
                    zza.this.zzbwl.setResult(zza.this.zzbwk.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzh = zza.this.zzbwl;
                        exc = (Exception) e.getCause();
                    } else {
                        zzh = zza.this.zzbwl;
                        exc = e;
                    }
                    zzh.setException(exc);
                } catch (Exception e2) {
                    zza.this.zzbwl.setException(e2);
                }
            }
        });
    }
}
