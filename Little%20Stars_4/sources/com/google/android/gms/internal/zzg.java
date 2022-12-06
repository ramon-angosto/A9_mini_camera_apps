package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
    private final zzb zzi;
    private final zzn zzj;
    private volatile boolean zzk = false;
    private final BlockingQueue<zzk<?>> zzx;
    private final zzf zzy;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf zzf, zzb zzb, zzn zzn) {
        super("VolleyNetworkDispatcher");
        this.zzx = blockingQueue;
        this.zzy = zzf;
        this.zzi = zzb;
        this.zzj = zzn;
    }

    @TargetApi(14)
    private void zzb(zzk<?> zzk2) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzk2.zzf());
        }
    }

    private void zzb(zzk<?> zzk2, zzr zzr) {
        this.zzj.zza(zzk2, zzk2.zzb(zzr));
    }

    public void quit() {
        this.zzk = true;
        interrupt();
    }

    public void run() {
        String str;
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk take = this.zzx.take();
                try {
                    take.zzc("network-queue-take");
                    if (take.isCanceled()) {
                        str = "network-discard-cancelled";
                    } else {
                        zzb(take);
                        zzi zza = this.zzy.zza(take);
                        take.zzc("network-http-complete");
                        if (!zza.zzA || !take.zzv()) {
                            zzm zza2 = take.zza(zza);
                            take.zzc("network-parse-complete");
                            if (take.zzq() && zza2.zzaf != null) {
                                this.zzi.zza(take.zzg(), zza2.zzaf);
                                take.zzc("network-cache-written");
                            }
                            take.zzu();
                            this.zzj.zza((zzk<?>) take, (zzm<?>) zza2);
                        } else {
                            str = "not-modified";
                        }
                    }
                    take.zzd(str);
                } catch (zzr e) {
                    e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    zzb(take, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzr = new zzr((Throwable) e2);
                    zzr.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzj.zza((zzk<?>) take, zzr);
                }
            } catch (InterruptedException unused) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}
