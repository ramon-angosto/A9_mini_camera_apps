package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    zzm(zzn zzn, Task task) {
        this.zzb = zzn;
        this.zza = task;
    }

    public final void run() {
        synchronized (this.zzb.zzb) {
            zzn zzn = this.zzb;
            if (zzn.zzc != null) {
                zzn.zzc.onSuccess(this.zza.getResult());
            }
        }
    }
}
