package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzelp implements Runnable {
    public final /* synthetic */ zzelq zza;
    public final /* synthetic */ zzfdw zzb;
    public final /* synthetic */ zzfdk zzc;
    public final /* synthetic */ zzehf zzd;

    public /* synthetic */ zzelp(zzelq zzelq, zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) {
        this.zza = zzelq;
        this.zzb = zzfdw;
        this.zzc = zzfdk;
        this.zzd = zzehf;
    }

    public final void run() {
        zzelq zzelq = this.zza;
        zzels.zze(this.zzb, this.zzc, this.zzd);
    }
}
