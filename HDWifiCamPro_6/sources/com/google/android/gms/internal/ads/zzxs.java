package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzxs implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzxs(zzyc zzyc, int i, long j) {
        this.zza = zzyc;
        this.zzb = i;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}
