package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzajx extends Thread {
    private final BlockingQueue zza;
    private final zzajw zzb;
    private final zzajn zzc;
    private volatile boolean zzd = false;
    private final zzaju zze;

    public zzajx(BlockingQueue blockingQueue, zzajw zzajw, zzajn zzajn, zzaju zzaju, byte[] bArr) {
        this.zza = blockingQueue;
        this.zzb = zzajw;
        this.zzc = zzajn;
        this.zze = zzaju;
    }

    private void zzb() throws InterruptedException {
        zzakd zzakd = (zzakd) this.zza.take();
        SystemClock.elapsedRealtime();
        zzakd.zzt(3);
        try {
            zzakd.zzm("network-queue-take");
            zzakd.zzw();
            TrafficStats.setThreadStatsTag(zzakd.zzc());
            zzajz zza2 = this.zzb.zza(zzakd);
            zzakd.zzm("network-http-complete");
            if (!zza2.zze || !zzakd.zzv()) {
                zzakj zzh = zzakd.zzh(zza2);
                zzakd.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzakd.zzj(), zzh.zzb);
                    zzakd.zzm("network-cache-written");
                }
                zzakd.zzq();
                this.zze.zzb(zzakd, zzh, (Runnable) null);
                zzakd.zzs(zzh);
                zzakd.zzt(4);
                return;
            }
            zzakd.zzp("not-modified");
            zzakd.zzr();
        } catch (zzakm e) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzakd, e);
            zzakd.zzr();
        } catch (Exception e2) {
            zzakp.zzc(e2, "Unhandled exception %s", e2.toString());
            zzakm zzakm = new zzakm((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzakd, zzakm);
            zzakd.zzr();
        } finally {
            zzakd.zzt(4);
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzakp.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
