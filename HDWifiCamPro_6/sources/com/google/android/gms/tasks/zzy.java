package com.google.android.gms.tasks;

import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
public final /* synthetic */ class zzy implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzy(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        this.zza.trySetException(new TimeoutException());
    }
}
