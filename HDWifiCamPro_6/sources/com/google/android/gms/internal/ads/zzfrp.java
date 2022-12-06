package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfrp implements OnCompleteListener {
    public final /* synthetic */ zzfry zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzfrp(zzfry zzfry, TaskCompletionSource taskCompletionSource) {
        this.zza = zzfry;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzq(this.zzb, task);
    }
}
