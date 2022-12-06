package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzay implements OnCompleteListener {
    private final zzbd zza;

    zzay(zzbd zzbd) {
        this.zza = zzbd;
    }

    public final void onComplete(Task task) {
        this.zza.zza();
    }
}
