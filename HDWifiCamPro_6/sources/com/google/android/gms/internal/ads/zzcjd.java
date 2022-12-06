package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcjd implements Runnable {
    public final /* synthetic */ zzcjq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcjd(zzcjq zzcjq, boolean z, long j) {
        this.zza = zzcjq;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzI(this.zzb, this.zzc);
    }
}
