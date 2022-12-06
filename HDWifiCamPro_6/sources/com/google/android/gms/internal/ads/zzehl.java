package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzehl implements zzfsm {
    public final /* synthetic */ zzeho zza;
    public final /* synthetic */ zzcmp zzb;
    public final /* synthetic */ zzfdk zzc;
    public final /* synthetic */ zzcwn zzd;

    public /* synthetic */ zzehl(zzeho zzeho, zzcmp zzcmp, zzfdk zzfdk, zzcwn zzcwn) {
        this.zza = zzeho;
        this.zzb = zzcmp;
        this.zzc = zzfdk;
        this.zzd = zzcwn;
    }

    public final Object apply(Object obj) {
        zzcmp zzcmp = this.zzb;
        zzfdk zzfdk = this.zzc;
        zzcwn zzcwn = this.zzd;
        if (zzfdk.zzN) {
            zzcmp.zzag();
        }
        zzcmp.zzaa();
        zzcmp.onPause();
        return zzcwn.zza();
    }
}
