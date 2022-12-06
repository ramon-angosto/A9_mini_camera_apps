package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzz implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ Callable zzb;

    zzz(zzw zzw, Callable callable) {
        this.zza = zzw;
        this.zzb = callable;
    }

    public final void run() {
        try {
            this.zza.zzb(this.zzb.call());
        } catch (Exception e) {
            this.zza.zza(e);
        } catch (Throwable th) {
            this.zza.zza(new RuntimeException(th));
        }
    }
}
