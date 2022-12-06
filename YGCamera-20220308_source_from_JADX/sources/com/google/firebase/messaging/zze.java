package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final /* synthetic */ class zze implements Runnable {
    private final zzc zza;
    private final Intent zzb;
    private final TaskCompletionSource zzc;

    zze(zzc zzc2, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.zza = zzc2;
        this.zzb = intent;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        zzc zzc2 = this.zza;
        Intent intent = this.zzb;
        TaskCompletionSource taskCompletionSource = this.zzc;
        try {
            zzc2.zzc(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }
}
