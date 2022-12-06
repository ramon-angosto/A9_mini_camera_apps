package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzp implements Continuation<Bundle, String> {
    private final /* synthetic */ zzl zza;

    zzp(zzl zzl) {
        this.zza = zzl;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return zzl.zza((Bundle) task.getResult(IOException.class));
    }
}
