package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcfu extends zzb {
    final /* synthetic */ zzcfy zza;

    zzcfu(zzcfy zzcfy) {
        this.zza = zzcfy;
    }

    public final void zza() {
        zzcfy zzcfy = this.zza;
        zzbjf zzbjf = new zzbjf(zzcfy.zze, zzcfy.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                zzt.zze();
                zzbji.zza(this.zza.zzg, zzbjf);
            } catch (IllegalArgumentException e) {
                zze.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
