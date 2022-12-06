package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zza implements Runnable {
    private final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
