package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcuu implements Runnable {
    public final /* synthetic */ zzcuz zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcuu(zzcuz zzcuz, int i, int i2) {
        this.zza = zzcuz;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc);
    }
}
