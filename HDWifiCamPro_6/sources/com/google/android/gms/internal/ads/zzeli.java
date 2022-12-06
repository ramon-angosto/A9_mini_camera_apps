package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeli implements zzfsm {
    public final /* synthetic */ zzelm zza;
    public final /* synthetic */ zzcmp zzb;
    public final /* synthetic */ zzfdk zzc;
    public final /* synthetic */ zzdud zzd;

    public /* synthetic */ zzeli(zzelm zzelm, zzcmp zzcmp, zzfdk zzfdk, zzdud zzdud) {
        this.zza = zzelm;
        this.zzb = zzcmp;
        this.zzc = zzfdk;
        this.zzd = zzdud;
    }

    public final Object apply(Object obj) {
        zzcmp zzcmp = this.zzb;
        zzfdk zzfdk = this.zzc;
        zzdud zzdud = this.zzd;
        if (zzfdk.zzN) {
            zzcmp.zzag();
        }
        zzcmp.zzaa();
        zzcmp.onPause();
        return zzdud.zzk();
    }
}
