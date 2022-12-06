package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {
    private static final boolean DEBUG = zzs.DEBUG;
    private final BlockingQueue<zzk<?>> zzg;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzk<?>> zzh;
    private final zzb zzi;
    private final zzn zzj;
    private volatile boolean zzk = false;

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb zzb, zzn zzn) {
        super("VolleyCacheDispatcher");
        this.zzg = blockingQueue;
        this.zzh = blockingQueue2;
        this.zzi = zzb;
        this.zzj = zzn;
    }

    public void quit() {
        this.zzk = true;
        interrupt();
    }

    public void run() {
        BlockingQueue<zzk<?>> blockingQueue;
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzi.initialize();
        while (true) {
            try {
                final zzk take = this.zzg.take();
                take.zzc("cache-queue-take");
                if (take.isCanceled()) {
                    take.zzd("cache-discard-canceled");
                } else {
                    zzb.zza zza = this.zzi.zza(take.zzg());
                    if (zza == null) {
                        take.zzc("cache-miss");
                        blockingQueue = this.zzh;
                    } else if (zza.zza()) {
                        take.zzc("cache-hit-expired");
                        take.zza(zza);
                        blockingQueue = this.zzh;
                    } else {
                        take.zzc("cache-hit");
                        zzm zza2 = take.zza(new zzi(zza.data, zza.zzf));
                        take.zzc("cache-hit-parsed");
                        if (!zza.zzb()) {
                            this.zzj.zza((zzk<?>) take, (zzm<?>) zza2);
                        } else {
                            take.zzc("cache-hit-refresh-needed");
                            take.zza(zza);
                            zza2.zzah = true;
                            this.zzj.zza(take, zza2, new Runnable() {
                                public void run() {
                                    try {
                                        zzc.this.zzh.put(take);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            });
                        }
                    }
                    blockingQueue.put(take);
                }
            } catch (InterruptedException unused) {
                if (this.zzk) {
                    return;
                }
            }
        }
    }
}
