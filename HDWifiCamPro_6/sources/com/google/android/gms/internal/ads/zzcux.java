package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcux implements zzfzc {
    final /* synthetic */ zzcuz zza;

    zzcux(zzcuz zzcuz) {
        this.zza = zzcuz;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcuz zzcuz = this.zza;
        zzfeo zzd = zzcuz.zzh;
        List zzd2 = zzcuz.zzg.zzd(zzcuz.zze, zzcuz.zzf, false, "", (String) obj, zzcuz.zzf.zzc);
        int i = 1;
        if (true == zzt.zzo().zzv(this.zza.zza)) {
            i = 2;
        }
        zzd.zzc(zzd2, i);
    }
}
