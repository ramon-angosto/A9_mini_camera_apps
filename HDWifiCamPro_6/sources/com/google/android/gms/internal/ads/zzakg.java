package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzakg {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzajn zze;
    private final zzajw zzf;
    private final zzajx[] zzg;
    private zzajp zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzaju zzk;

    public zzakg(zzajn zzajn, zzajw zzajw, int i) {
        zzaju zzaju = new zzaju(new Handler(Looper.getMainLooper()));
        this.zze = zzajn;
        this.zzf = zzajw;
        this.zzg = new zzajx[4];
        this.zzk = zzaju;
    }

    public final zzakd zza(zzakd zzakd) {
        zzakd.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzakd);
        }
        zzakd.zzg(this.zza.incrementAndGet());
        zzakd.zzm("add-to-queue");
        zzc(zzakd, 0);
        this.zzc.add(zzakd);
        return zzakd;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzakd zzakd) {
        synchronized (this.zzb) {
            this.zzb.remove(zzakd);
        }
        synchronized (this.zzi) {
            for (zzakf zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzakd, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzakd zzakd, int i) {
        synchronized (this.zzj) {
            for (zzake zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzajp zzajp = this.zzh;
        if (zzajp != null) {
            zzajp.zzb();
        }
        zzajx[] zzajxArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzajx zzajx = zzajxArr[i];
            if (zzajx != null) {
                zzajx.zza();
            }
        }
        this.zzh = new zzajp(this.zzc, this.zzd, this.zze, this.zzk, (byte[]) null);
        this.zzh.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzajx zzajx2 = new zzajx(this.zzd, this.zzf, this.zze, this.zzk, (byte[]) null);
            this.zzg[i2] = zzajx2;
            zzajx2.start();
        }
    }
}
