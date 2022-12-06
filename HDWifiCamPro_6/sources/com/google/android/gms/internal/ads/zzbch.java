package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbch implements Runnable {
    final /* synthetic */ zzbci zza;

    zzbch(zzbci zzbci) {
        this.zza = zzbci;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            zzbci zzbci = this.zza;
            if (!zzbci.zzd || !zzbci.zze) {
                zze.zze("App is still foreground");
            } else {
                zzbci.zzd = false;
                zze.zze("App went background");
                for (zzbcj zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzcgp.zzh("", e);
                    }
                }
            }
        }
    }
}
