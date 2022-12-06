package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzchv implements Runnable {
    final /* synthetic */ zzcic zza;

    zzchv(zzcic zzcic) {
        this.zza = zzcic;
    }

    public final void run() {
        zzcic zzcic = this.zza;
        if (zzcic.zzr != null) {
            zzcic.zzr.zza();
        }
    }
}
