package com.google.android.gms.internal.appset;

import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    /* synthetic */ zzj(zzl zzl, zzi zzi) {
        this.zza = zzl;
    }

    public final void run() {
        long zza2 = this.zza.zza();
        if (zza2 != -1 && DefaultClock.getInstance().currentTimeMillis() > zza2) {
            zzl.zze(this.zza.zzb);
        }
    }
}
