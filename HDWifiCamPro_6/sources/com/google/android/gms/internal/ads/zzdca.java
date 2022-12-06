package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdca implements zzdda, zzdjx, zzdhr, zzddq, zzbbq {
    /* access modifiers changed from: private */
    public final zzdds zza;
    private final zzfdk zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzfzy zze = zzfzy.zzf();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();

    public zzdca(zzdds zzdds, zzfdk zzfdk, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = zzdds;
        this.zzb = zzfdk;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzd(true);
            }
        }
    }

    public final void zzbv() {
    }

    public final void zzc(zzbbp zzbbp) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziS)).booleanValue() && this.zzb.zzZ != 2 && zzbbp.zzj && this.zzg.compareAndSet(false, true)) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final void zzd() {
    }

    public final synchronized void zze() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(true);
        }
    }

    public final void zzf() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbp)).booleanValue()) {
            zzfdk zzfdk = this.zzb;
            if (zzfdk.zzZ != 2) {
                return;
            }
            if (zzfdk.zzr == 0) {
                this.zza.zza();
                return;
            }
            zzfzg.zzr(this.zze, new zzdbz(this), this.zzd);
            this.zzf = this.zzc.schedule(new zzdby(this), (long) this.zzb.zzr, TimeUnit.MILLISECONDS);
        }
    }

    public final void zzg() {
    }

    public final void zzj() {
    }

    public final synchronized void zzk(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zze(new Exception());
        }
    }

    public final void zzm() {
    }

    public final void zzo() {
        int i = this.zzb.zzZ;
        if (i == 0 || i == 1) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zziS)).booleanValue()) {
                this.zza.zza();
            }
        }
    }

    public final void zzp(zzcbs zzcbs, String str, String str2) {
    }

    public final void zzr() {
    }
}
