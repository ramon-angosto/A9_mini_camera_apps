package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final /* synthetic */ class zzh implements Executor {
    static final Executor zza = new zzh();

    private zzh() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
