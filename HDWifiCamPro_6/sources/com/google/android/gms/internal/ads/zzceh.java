package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzceh implements Runnable {
    public final /* synthetic */ zzceu zza;
    public final /* synthetic */ zzcet zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzceh(zzceu zzceu, zzcet zzcet, String str) {
        this.zza = zzceu;
        this.zzb = zzcet;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
