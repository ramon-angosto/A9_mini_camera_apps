package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

@Deprecated
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final PendingResult<R> pendingResult;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult2) {
        this.pendingResult = pendingResult2;
    }

    public final void addStatusListener() {
    }

    public final R await() {
        return this.pendingResult.await();
    }

    public final void cancel() {
    }

    public final R get() {
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public final boolean isCanceled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        this.pendingResult.setResultCallback(resultCallback);
    }

    public final R await(long j, TimeUnit timeUnit) {
        return this.pendingResult.await(j, timeUnit);
    }

    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.pendingResult.setResultCallback(looper, resultCallback);
    }

    public final void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
