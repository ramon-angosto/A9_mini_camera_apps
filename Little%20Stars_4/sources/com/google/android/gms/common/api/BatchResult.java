package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzaaO;
    private final PendingResult<?>[] zzakO;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zzaaO = status;
        this.zzakO = pendingResultArr;
    }

    public Status getStatus() {
        return this.zzaaO;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzaa.zzb(batchResultToken.mId < this.zzakO.length, (Object) "The result token does not belong to this batch");
        return this.zzakO[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
