package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgaa implements Runnable {
    @CheckForNull
    zzgac zza;

    zzgaa(zzgac zzgac) {
        this.zza = zzgac;
    }

    public final void run() {
        zzfzp zzf;
        String str;
        zzgac zzgac = this.zza;
        if (zzgac != null && (zzf = zzgac.zza) != null) {
            this.zza = null;
            if (zzf.isDone()) {
                zzgac.zzt(zzf);
                return;
            }
            try {
                ScheduledFuture zzw = zzgac.zzb;
                ScheduledFuture unused = zzgac.zzb = null;
                str = "Timed out";
                if (zzw != null) {
                    long abs = Math.abs(zzw.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                zzgac.zze(new zzgab(str + ": " + zzf, (zzfzz) null));
                zzf.cancel(true);
            } catch (Throwable th) {
                zzf.cancel(true);
                throw th;
            }
        }
    }
}
