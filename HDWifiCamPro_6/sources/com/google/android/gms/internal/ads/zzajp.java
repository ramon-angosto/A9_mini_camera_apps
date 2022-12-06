package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzajp extends Thread {
    private static final boolean zza = zzakp.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzajn zzd;
    private volatile boolean zze = false;
    private final zzakq zzf;
    private final zzaju zzg;

    public zzajp(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzajn zzajn, zzaju zzaju, byte[] bArr) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzajn;
        this.zzg = zzaju;
        this.zzf = new zzakq(this, blockingQueue2, zzaju, (byte[]) null);
    }

    private void zzc() throws InterruptedException {
        zzakd zzakd = (zzakd) this.zzb.take();
        zzakd.zzm("cache-queue-take");
        zzakd.zzt(1);
        try {
            zzakd.zzw();
            zzajm zza2 = this.zzd.zza(zzakd.zzj());
            if (zza2 == null) {
                zzakd.zzm("cache-miss");
                if (!this.zzf.zzc(zzakd)) {
                    this.zzc.put(zzakd);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (zza2.zza(currentTimeMillis)) {
                zzakd.zzm("cache-hit-expired");
                zzakd.zze(zza2);
                if (!this.zzf.zzc(zzakd)) {
                    this.zzc.put(zzakd);
                }
                zzakd.zzt(2);
                return;
            }
            zzakd.zzm("cache-hit");
            zzakj zzh = zzakd.zzh(new zzajz(zza2.zza, zza2.zzg));
            zzakd.zzm("cache-hit-parsed");
            if (!zzh.zzc()) {
                zzakd.zzm("cache-parsing-failed");
                this.zzd.zzc(zzakd.zzj(), true);
                zzakd.zze((zzajm) null);
                if (!this.zzf.zzc(zzakd)) {
                    this.zzc.put(zzakd);
                }
                zzakd.zzt(2);
                return;
            }
            if (zza2.zzf < currentTimeMillis) {
                zzakd.zzm("cache-hit-refresh-needed");
                zzakd.zze(zza2);
                zzh.zzd = true;
                if (!this.zzf.zzc(zzakd)) {
                    this.zzg.zzb(zzakd, zzh, new zzajo(this, zzakd));
                } else {
                    this.zzg.zzb(zzakd, zzh, (Runnable) null);
                }
            } else {
                this.zzg.zzb(zzakd, zzh, (Runnable) null);
            }
            zzakd.zzt(2);
        } finally {
            zzakd.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzakp.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzakp.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
