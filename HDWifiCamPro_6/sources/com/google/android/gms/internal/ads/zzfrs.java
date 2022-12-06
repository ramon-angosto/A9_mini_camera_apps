package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfrs extends zzfro {
    final /* synthetic */ zzfry zza;

    zzfrs(zzfry zzfry) {
        this.zza = zzfry;
    }

    public final void zza() {
        zzfry zzfry = this.zza;
        if (zzfry.zzn != null) {
            zzfry.zzc.zzd("Unbind from service.", new Object[0]);
            zzfry zzfry2 = this.zza;
            zzfry2.zzb.unbindService(zzfry2.zzm);
            this.zza.zzh = false;
            this.zza.zzn = null;
            this.zza.zzm = null;
        }
        this.zza.zzt();
    }
}
