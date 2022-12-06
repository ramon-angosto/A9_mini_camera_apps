package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzchy implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcic zzc;

    zzchy(zzcic zzcic, int i, int i2) {
        this.zzc = zzcic;
        this.zza = i;
        this.zzb = i2;
    }

    public final void run() {
        zzcic zzcic = this.zzc;
        if (zzcic.zzr != null) {
            zzcic.zzr.zzj(this.zza, this.zzb);
        }
    }
}
