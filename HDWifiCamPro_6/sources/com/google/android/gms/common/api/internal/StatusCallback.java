package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class StatusCallback extends IStatusCallback.Stub {
    private final BaseImplementation.ResultHolder<Status> mResultHolder;

    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.mResultHolder = resultHolder;
    }

    public void onResult(Status status) {
        this.mResultHolder.setResult(status);
    }
}
