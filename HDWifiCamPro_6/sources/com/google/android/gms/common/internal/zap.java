package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zap implements PendingResult.StatusListener {
    final /* synthetic */ PendingResult zaa;
    final /* synthetic */ TaskCompletionSource zab;
    final /* synthetic */ PendingResultUtil.ResultConverter zac;
    final /* synthetic */ zas zad;

    zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zas) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = resultConverter;
        this.zad = zas;
    }

    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.zab.setResult(this.zac.convert(this.zaa.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.zab.setException(ApiExceptionUtil.fromStatus(status));
    }
}
