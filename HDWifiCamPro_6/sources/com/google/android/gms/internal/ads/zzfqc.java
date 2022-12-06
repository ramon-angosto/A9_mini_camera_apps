package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfqc {
    public static zzfzp zza(Task task) {
        zzfqb zzfqb = new zzfqb(task);
        task.addOnCompleteListener(zzfzw.zzb(), new zzfqa(zzfqb));
        return zzfqb;
    }
}
