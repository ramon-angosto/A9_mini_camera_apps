package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* renamed from: a */
    private final Activity f962a;

    /* renamed from: b */
    private final int f963b;

    protected ResolvingResultCallbacks(Activity activity, int i) {
        this.f962a = (Activity) Preconditions.checkNotNull(activity, "Activity must not be null");
        this.f963b = i;
    }

    public final void onFailure(Status status) {
        try {
            if (status.hasResolution()) {
                status.startResolutionForResult(this.f962a, this.f963b);
            } else {
                onUnresolvableFailure(status);
            }
        } catch (Exception e) {
            HMSLog.m1377e("ResolvingResultCallbacks", "Failed to start resolution: " + e);
            onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
