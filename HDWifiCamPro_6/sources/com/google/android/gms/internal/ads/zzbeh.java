package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbeh implements Runnable {
    public final /* synthetic */ zzchh zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzbeh(zzchh zzchh, Future future) {
        this.zza = zzchh;
        this.zzb = future;
    }

    public final void run() {
        zzchh zzchh = this.zza;
        Future future = this.zzb;
        int i = zzbej.zzd;
        if (zzchh.isCancelled()) {
            future.cancel(true);
        }
    }
}
