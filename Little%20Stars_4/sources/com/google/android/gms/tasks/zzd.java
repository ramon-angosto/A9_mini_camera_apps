package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    private final Executor zzboH;
    /* access modifiers changed from: private */
    public OnFailureListener zzbwr;
    /* access modifiers changed from: private */
    public final Object zzpp = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzboH = executor;
        this.zzbwr = onFailureListener;
    }

    public void cancel() {
        synchronized (this.zzpp) {
            this.zzbwr = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.zzpp) {
                if (this.zzbwr != null) {
                    this.zzboH.execute(new Runnable() {
                        public void run() {
                            synchronized (zzd.this.zzpp) {
                                if (zzd.this.zzbwr != null) {
                                    zzd.this.zzbwr.onFailure(task.getException());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
