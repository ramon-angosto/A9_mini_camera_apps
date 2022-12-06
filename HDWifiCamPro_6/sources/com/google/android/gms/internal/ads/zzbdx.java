package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbdx {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbdt(this);
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public zzbea zzd;
    private Context zze;
    /* access modifiers changed from: private */
    public zzbed zzf;

    static /* bridge */ /* synthetic */ void zzh(zzbdx zzbdx) {
        synchronized (zzbdx.zzc) {
            zzbea zzbea = zzbdx.zzd;
            if (zzbea != null) {
                if (zzbea.isConnected() || zzbdx.zzd.isConnecting()) {
                    zzbdx.zzd.disconnect();
                }
                zzbdx.zzd = null;
                zzbdx.zzf = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzc
            monitor-enter(r0)
            android.content.Context r1 = r3.zze     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzbea r1 = r3.zzd     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.zzbdv r1 = new com.google.android.gms.internal.ads.zzbdv     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbdw r2 = new com.google.android.gms.internal.ads.zzbdw     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbea r1 = r3.zzd(r1, r2)     // Catch:{ all -> 0x0025 }
            r3.zzd = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbea r1 = r3.zzd     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.zzl():void");
    }

    public final long zza(zzbeb zzbeb) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2;
            }
            if (this.zzd.zzp()) {
                try {
                    long zze2 = this.zzf.zze(zzbeb);
                    return zze2;
                } catch (RemoteException e) {
                    zze.zzh("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    public final zzbdy zzb(zzbeb zzbeb) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                zzbdy zzbdy = new zzbdy();
                return zzbdy;
            }
            try {
                if (this.zzd.zzp()) {
                    zzbdy zzg = this.zzf.zzg(zzbeb);
                    return zzg;
                }
                zzbdy zzf2 = this.zzf.zzf(zzbeb);
                return zzf2;
            } catch (RemoteException e) {
                zze.zzh("Unable to call into cache service.", e);
                return new zzbdy();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized zzbea zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbea(this.zze, zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzc
            monitor-enter(r0)
            android.content.Context r1 = r2.zze     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zze = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzdp     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzdo     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzbdu r3 = new com.google.android.gms.internal.ads.zzbdu     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbck r1 = com.google.android.gms.ads.internal.zzt.zzb()     // Catch:{ all -> 0x0048 }
            r1.zzc(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.zzi(android.content.Context):void");
    }

    public final void zzj() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdq)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzds)).booleanValue()) {
                    ScheduledFuture scheduledFuture = this.zza;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zza = zzchc.zzd.schedule(this.zzb, ((Long) zzay.zzc().zzb(zzbjc.zzdr)).longValue(), TimeUnit.MILLISECONDS);
                } else {
                    zzs.zza.removeCallbacks(this.zzb);
                    zzs.zza.postDelayed(this.zzb, ((Long) zzay.zzc().zzb(zzbjc.zzdr)).longValue());
                }
            }
        }
    }
}
