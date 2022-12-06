package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzn implements Runnable {
    private final zzl zza;
    private final Bundle zzb;
    private final TaskCompletionSource zzc;

    zzn(zzl zzl, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.zza = zzl;
        this.zzb = bundle;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
