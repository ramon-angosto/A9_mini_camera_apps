package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzd implements ThreadFactory {
    static final ThreadFactory zza = new zzd();

    private zzd() {
    }

    public final Thread newThread(Runnable runnable) {
        return zza.zza(runnable);
    }
}
