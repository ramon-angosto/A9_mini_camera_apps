package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeit implements Runnable {
    public final /* synthetic */ zzeiv zza;
    public final /* synthetic */ zzfdw zzb;
    public final /* synthetic */ zzfdk zzc;

    public /* synthetic */ zzeit(zzeiv zzeiv, zzfdw zzfdw, zzfdk zzfdk) {
        this.zza = zzeiv;
        this.zzb = zzfdw;
        this.zzc = zzfdk;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
