package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfiu implements zzfir {
    private final zzfir zza;
    private final Queue zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) zzay.zzc().zzb(zzbjc.zzhv)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfiu(zzfir zzfir, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfir;
        long intValue = (long) ((Integer) zzay.zzc().zzb(zzbjc.zzhu)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzfit(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ void zzc(zzfiu zzfiu) {
        while (!zzfiu.zzb.isEmpty()) {
            zzfiu.zza.zzb((zzfiq) zzfiu.zzb.remove());
        }
    }

    public final String zza(zzfiq zzfiq) {
        return this.zza.zza(zzfiq);
    }

    public final void zzb(zzfiq zzfiq) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzfiq);
        } else if (!this.zzd.getAndSet(true)) {
            Queue queue = this.zzb;
            zzfiq zzb2 = zzfiq.zzb("dropped_event");
            Map zzj = zzfiq.zzj();
            if (zzj.containsKey("action")) {
                zzb2.zza("dropped_action", (String) zzj.get("action"));
            }
            queue.offer(zzb2);
        }
    }
}
