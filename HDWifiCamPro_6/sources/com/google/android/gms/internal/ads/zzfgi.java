package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfgi implements zzfzc {
    final /* synthetic */ zzfgl zza;
    final /* synthetic */ zzfgm zzb;

    zzfgi(zzfgm zzfgm, zzfgl zzfgl) {
        this.zzb = zzfgm;
        this.zza = zzfgl;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            zzfgm zzfgm = this.zzb;
            if (zzfgm.zzf == 1) {
                zzfgm.zzh();
            }
        }
    }
}
