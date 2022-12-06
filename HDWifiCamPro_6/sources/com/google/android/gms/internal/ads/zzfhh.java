package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfhh implements zzgxi {
    private final zzgxv zza;

    public zzfhh(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfpy.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, (ThreadFactory) this.zza.zzb()));
        zzgxq.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
