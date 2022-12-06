package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbtl implements zzchl {
    final /* synthetic */ zzbtv zza;
    final /* synthetic */ zzfjj zzb;
    final /* synthetic */ zzbtw zzc;

    zzbtl(zzbtw zzbtw, zzbtv zzbtv, zzfjj zzfjj) {
        this.zzc = zzbtw;
        this.zza = zzbtv;
        this.zzb = zzfjj;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbsr zzbsr = (zzbsr) obj;
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 0;
            zzbtw zzbtw = this.zzc;
            if (!(zzbtw.zzh == null || this.zza == zzbtw.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbkl.zzd.zze()).booleanValue()) {
                zzbtw zzbtw2 = this.zzc;
                if (zzbtw2.zze != null) {
                    zzfjw zze = zzbtw2.zze;
                    zzfjj zzfjj = this.zzb;
                    zzfjj.zze(true);
                    zze.zzb(zzfjj.zzj());
                }
            }
        }
    }
}
