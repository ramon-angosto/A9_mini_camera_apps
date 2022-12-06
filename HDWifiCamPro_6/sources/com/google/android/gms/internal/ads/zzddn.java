package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzddn extends zzdij implements zzdde {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd = false;

    public zzddn(zzddm zzddm, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        zzj(zzddm, executor);
    }

    public final void zza(zze zze) {
        zzo(new zzddg(zze));
    }

    public final void zzb() {
        zzo(zzddi.zza);
    }

    public final void zzc(zzdmo zzdmo) {
        if (!this.zzd) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzo(new zzddf(zzdmo));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        synchronized (this) {
            com.google.android.gms.ads.internal.util.zze.zzg("Timeout waiting for show call succeed to be called.");
            zzc(new zzdmo("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        this.zzc = this.zzb.schedule(new zzddh(this), (long) ((Integer) zzay.zzc().zzb(zzbjc.zzit)).intValue(), TimeUnit.MILLISECONDS);
    }
}
