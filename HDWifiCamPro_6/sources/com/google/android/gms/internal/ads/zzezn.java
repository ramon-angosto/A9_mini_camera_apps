package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzezn implements zzeou {
    final /* synthetic */ zzezo zza;

    zzezn(zzezo zzezo) {
        this.zza = zzezo;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcwv zzcwv = (zzcwv) obj;
        synchronized (this.zza) {
            zzcwv zzcwv2 = this.zza.zza;
            if (zzcwv2 != null) {
                zzcwv2.zzV();
            }
            zzezo zzezo = this.zza;
            zzezo.zza = zzcwv;
            zzcwv.zzc(zzezo);
            zzezo zzezo2 = this.zza;
            zzezo2.zzg.zzl(new zzcww(zzcwv, zzezo2, zzezo2.zzg));
            zzcwv.zzW();
        }
    }
}
