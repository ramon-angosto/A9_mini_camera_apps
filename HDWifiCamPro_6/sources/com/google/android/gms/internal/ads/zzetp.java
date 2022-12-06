package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzetp implements zzeve {
    private final zzeve zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzetp(zzeve zzeve, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeve;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final int zza() {
        return this.zza.zza();
    }

    public final zzfzp zzb() {
        zzfzp zzb2 = this.zza.zzb();
        long j = this.zzb;
        if (j > 0) {
            zzb2 = zzfzg.zzo(zzb2, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfzg.zzg(zzb2, Throwable.class, zzeto.zza, zzchc.zzf);
    }
}
