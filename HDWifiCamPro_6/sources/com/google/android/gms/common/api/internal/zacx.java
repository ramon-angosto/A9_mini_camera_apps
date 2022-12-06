package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zacx implements Continuation<Boolean, Void> {
    zacx() {
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (((Boolean) task.getResult()).booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
