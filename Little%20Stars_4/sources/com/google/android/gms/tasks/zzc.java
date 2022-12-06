package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    private final Executor zzboH;
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> zzbwp;
    /* access modifiers changed from: private */
    public final Object zzpp = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzboH = executor;
        this.zzbwp = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.zzpp) {
            this.zzbwp = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzpp) {
            if (this.zzbwp != null) {
                this.zzboH.execute(new Runnable() {
                    public void run() {
                        synchronized (zzc.this.zzpp) {
                            if (zzc.this.zzbwp != null) {
                                zzc.this.zzbwp.onComplete(task);
                            }
                        }
                    }
                });
            }
        }
    }
}
