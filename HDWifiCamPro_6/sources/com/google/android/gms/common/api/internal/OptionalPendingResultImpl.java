package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zaa;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.zaa = (BasePendingResult) pendingResult;
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        this.zaa.addStatusListener(statusListener);
    }

    public final R await() {
        return this.zaa.await();
    }

    public final void cancel() {
        this.zaa.cancel();
    }

    public final R get() {
        if (this.zaa.isReady()) {
            return this.zaa.await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final boolean isCanceled() {
        return this.zaa.isCanceled();
    }

    public final boolean isDone() {
        return this.zaa.isReady();
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        this.zaa.setResultCallback(resultCallback);
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        return this.zaa.then(resultTransform);
    }

    public final R await(long j, TimeUnit timeUnit) {
        return this.zaa.await(j, timeUnit);
    }

    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        this.zaa.setResultCallback(resultCallback, j, timeUnit);
    }
}
