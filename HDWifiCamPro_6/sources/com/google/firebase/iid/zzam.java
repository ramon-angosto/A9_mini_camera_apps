package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzam implements Continuation {
    private final zzan zza;
    private final Pair zzb;

    zzam(zzan zzan, Pair pair) {
        this.zza = zzan;
        this.zzb = pair;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
