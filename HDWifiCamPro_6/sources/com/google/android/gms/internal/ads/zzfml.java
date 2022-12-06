package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfml {
    private final BlockingQueue zza = new LinkedBlockingQueue();
    private final ThreadPoolExecutor zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.zza);
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfmk zzd = null;

    private final void zzc() {
        this.zzd = (zzfmk) this.zzc.poll();
        zzfmk zzfmk = this.zzd;
        if (zzfmk != null) {
            zzfmk.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfmk zzfmk) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfmk zzfmk) {
        zzfmk.zzb(this);
        this.zzc.add(zzfmk);
        if (this.zzd == null) {
            zzc();
        }
    }
}
