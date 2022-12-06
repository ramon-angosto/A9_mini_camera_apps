package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzejc implements zzfsm {
    public final /* synthetic */ zzeje zza;
    public final /* synthetic */ zzcmp zzb;
    public final /* synthetic */ zzfdk zzc;
    public final /* synthetic */ zzdlh zzd;

    public /* synthetic */ zzejc(zzeje zzeje, zzcmp zzcmp, zzfdk zzfdk, zzdlh zzdlh) {
        this.zza = zzeje;
        this.zzb = zzcmp;
        this.zzc = zzfdk;
        this.zzd = zzdlh;
    }

    public final Object apply(Object obj) {
        zzcmp zzcmp = this.zzb;
        zzfdk zzfdk = this.zzc;
        zzdlh zzdlh = this.zzd;
        if (zzfdk.zzN) {
            zzcmp.zzag();
        }
        zzcmp.zzaa();
        zzcmp.onPause();
        return zzdlh.zzg();
    }
}
