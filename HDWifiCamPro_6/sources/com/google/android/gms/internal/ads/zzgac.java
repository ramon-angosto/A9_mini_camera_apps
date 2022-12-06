package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgac extends zzfyw {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzfzp zza;
    /* access modifiers changed from: private */
    @CheckForNull
    public ScheduledFuture zzb;

    private zzgac(zzfzp zzfzp) {
        if (zzfzp != null) {
            this.zza = zzfzp;
            return;
        }
        throw null;
    }

    static zzfzp zzg(zzfzp zzfzp, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgac zzgac = new zzgac(zzfzp);
        zzgaa zzgaa = new zzgaa(zzgac);
        zzgac.zzb = scheduledExecutorService.schedule(zzgaa, j, timeUnit);
        zzfzp.zzc(zzgaa, zzfyu.INSTANCE);
        return zzgac;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        zzfzp zzfzp = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (zzfzp == null) {
            return null;
        }
        String str = "inputFuture=[" + zzfzp + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzs(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
