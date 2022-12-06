package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeom implements zzeou {
    final /* synthetic */ zzeon zza;

    zzeom(zzeon zzeon) {
        this.zza = zzeon;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzh = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdlg zzdlg = (zzdlg) obj;
        synchronized (this.zza) {
            this.zza.zzh = zzdlg;
            this.zza.zzh.zzW();
        }
    }
}
