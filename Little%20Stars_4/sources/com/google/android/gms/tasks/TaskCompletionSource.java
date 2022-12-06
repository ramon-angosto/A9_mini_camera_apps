package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult> {
    private final zzh<TResult> zzbwx = new zzh<>();

    @NonNull
    public Task<TResult> getTask() {
        return this.zzbwx;
    }

    public void setException(@NonNull Exception exc) {
        this.zzbwx.setException(exc);
    }

    public void setResult(TResult tresult) {
        this.zzbwx.setResult(tresult);
    }
}
