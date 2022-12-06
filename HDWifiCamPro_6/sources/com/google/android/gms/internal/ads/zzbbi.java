package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbbi implements Runnable {
    final /* synthetic */ Surface zza;
    final /* synthetic */ zzbbk zzb;

    zzbbi(zzbbk zzbbk, Surface surface) {
        this.zzb = zzbbk;
        this.zza = surface;
    }

    public final void run() {
        this.zzb.zzb.zzm(this.zza);
    }
}
