package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzt implements Executor {
    zzt() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
