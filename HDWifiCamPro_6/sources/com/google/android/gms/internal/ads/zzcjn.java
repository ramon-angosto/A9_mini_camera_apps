package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcjn implements Runnable {
    public final /* synthetic */ zzcjq zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcjn(zzcjq zzcjq, int i, int i2) {
        this.zza = zzcjq;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzN(this.zzb, this.zzc);
    }
}
