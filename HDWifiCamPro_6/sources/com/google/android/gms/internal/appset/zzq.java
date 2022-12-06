package com.google.android.gms.internal.appset;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final /* synthetic */ class zzq implements Continuation {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzr) {
        this.zza = zzr;
    }

    public final Object then(Task task) {
        return zzr.zza(this.zza, task);
    }
}
