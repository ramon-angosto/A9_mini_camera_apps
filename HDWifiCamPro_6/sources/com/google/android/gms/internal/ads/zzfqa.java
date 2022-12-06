package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfqa implements OnCompleteListener {
    public final /* synthetic */ zzfqb zza;

    public /* synthetic */ zzfqa(zzfqb zzfqb) {
        this.zza = zzfqb;
    }

    public final void onComplete(Task task) {
        zzfqb zzfqb = this.zza;
        if (task.isCanceled()) {
            zzfqb.cancel(false);
        } else if (task.isSuccessful()) {
            zzfqb.zzd(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzfqb.zze(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
