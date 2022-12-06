package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcia implements Runnable {
    final /* synthetic */ zzcic zza;

    zzcia(zzcic zzcic) {
        this.zza = zzcic;
    }

    public final void run() {
        zzcic zzcic = this.zza;
        if (zzcic.zzr != null) {
            if (!zzcic.zzs) {
                zzcic.zzr.zzg();
                this.zza.zzs = true;
            }
            this.zza.zzr.zze();
        }
    }
}
