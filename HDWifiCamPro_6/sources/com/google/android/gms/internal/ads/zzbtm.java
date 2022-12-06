package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbtm implements zzchj {
    final /* synthetic */ zzbtv zza;
    final /* synthetic */ zzfjj zzb;
    final /* synthetic */ zzbtw zzc;

    zzbtm(zzbtw zzbtw, zzbtv zzbtv, zzfjj zzfjj) {
        this.zzc = zzbtw;
        this.zza = zzbtv;
        this.zzb = zzfjj;
    }

    public final void zza() {
        synchronized (this.zzc.zza) {
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbkl.zzd.zze()).booleanValue()) {
                zzbtw zzbtw = this.zzc;
                if (zzbtw.zze != null) {
                    zzfjw zze = zzbtw.zze;
                    zzfjj zzfjj = this.zzb;
                    zzfjj.zze(false);
                    zze.zzb(zzfjj.zzj());
                }
            }
        }
    }
}
