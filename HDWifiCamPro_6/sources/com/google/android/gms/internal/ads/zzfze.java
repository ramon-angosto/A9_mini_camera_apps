package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfze implements Runnable {
    final Future zza;
    final zzfzc zzb;

    zzfze(Future future, zzfzc zzfzc) {
        this.zza = future;
        this.zzb = zzfzc;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzgai) || (zza2 = zzgaj.zza((zzgai) future)) == null) {
            try {
                this.zzb.zzb(zzfzg.zzp(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzb.zza(e2);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfsq zza2 = zzfsr.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
