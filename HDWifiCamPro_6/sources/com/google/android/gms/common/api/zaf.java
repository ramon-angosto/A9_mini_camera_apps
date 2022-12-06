package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaf<R extends Result> extends BasePendingResult<R> {
    private final R zae;

    public zaf(R r) {
        super(Looper.getMainLooper());
        this.zae = r;
    }

    /* access modifiers changed from: protected */
    public final R createFailedResult(Status status) {
        if (status.getStatusCode() == this.zae.getStatus().getStatusCode()) {
            return this.zae;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
