package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzenl implements zzeou {
    final /* synthetic */ zzenm zza;

    zzenl(zzenm zzenm) {
        this.zza = zzenm;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzh = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxc zzcxc = (zzcxc) obj;
        synchronized (this.zza) {
            zzenm zzenm = this.zza;
            if (zzenm.zzh != null) {
                zzenm.zzh.zzV();
            }
            this.zza.zzh = zzcxc;
            this.zza.zzh.zzW();
        }
    }
}
