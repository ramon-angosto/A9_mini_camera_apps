package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzu implements Executor {
    private final Handler zza = new zza(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
