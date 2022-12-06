package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcbi implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcbk zzb;

    zzcbi(zzcbk zzcbk, Context context) {
        this.zzb = zzcbk;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcbh zzcbh;
        zzcbj zzcbj = (zzcbj) this.zzb.zza.get(this.zza);
        if (zzcbj == null || zzcbj.zza + ((Long) zzbki.zza.zze()).longValue() < zzt.zzB().currentTimeMillis()) {
            zzcbh = new zzcbg(this.zza).zza();
        } else {
            zzcbh = new zzcbg(this.zza, zzcbj.zzb).zza();
        }
        zzcbk zzcbk = this.zzb;
        zzcbk.zza.put(this.zza, new zzcbj(zzcbk, zzcbh));
        return zzcbh;
    }
}
