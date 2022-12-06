package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class HandlerExecutor implements Executor {
    private final Handler zza;

    public HandlerExecutor(Looper looper) {
        this.zza = new zzi(looper);
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
