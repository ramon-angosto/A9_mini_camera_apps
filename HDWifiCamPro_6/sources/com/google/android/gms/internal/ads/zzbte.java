package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbte implements Runnable {
    public final /* synthetic */ zzbtw zza;
    public final /* synthetic */ zzbtv zzb;
    public final /* synthetic */ zzbsr zzc;

    public /* synthetic */ zzbte(zzbtw zzbtw, zzbtv zzbtv, zzbsr zzbsr) {
        this.zza = zzbtw;
        this.zzb = zzbtv;
        this.zzc = zzbsr;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
