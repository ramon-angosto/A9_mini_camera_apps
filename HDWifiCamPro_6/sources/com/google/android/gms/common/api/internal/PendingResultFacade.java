package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        throw null;
    }

    public final B await() {
        throw null;
    }

    public final B await(long j, TimeUnit timeUnit) {
        throw null;
    }

    public final void cancel() {
        throw null;
    }

    public final boolean isCanceled() {
        throw null;
    }

    public final void setResultCallback(ResultCallback<? super B> resultCallback) {
        throw null;
    }

    public final void setResultCallback(ResultCallback<? super B> resultCallback, long j, TimeUnit timeUnit) {
        throw null;
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super B, ? extends S> resultTransform) {
        throw null;
    }
}
