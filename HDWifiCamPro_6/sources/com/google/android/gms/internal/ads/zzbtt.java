package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbtt implements Runnable {
    public final /* synthetic */ zzbtu zza;
    public final /* synthetic */ zzbsr zzb;

    public /* synthetic */ zzbtt(zzbtu zzbtu, zzbsr zzbsr) {
        this.zza = zzbtu;
        this.zzb = zzbsr;
    }

    public final void run() {
        zzbsr zzbsr = this.zzb;
        zzbsr.zzr("/result", zzbpt.zzo);
        zzbsr.zzc();
    }
}
