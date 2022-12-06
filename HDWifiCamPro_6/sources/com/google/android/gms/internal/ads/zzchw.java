package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzchw implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcic zzc;

    zzchw(zzcic zzcic, String str, String str2) {
        this.zzc = zzcic;
        this.zza = str;
        this.zzb = str2;
    }

    public final void run() {
        zzcic zzcic = this.zzc;
        if (zzcic.zzr != null) {
            zzcic.zzr.zzb(this.zza, this.zzb);
        }
    }
}
