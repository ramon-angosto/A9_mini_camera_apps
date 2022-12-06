package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzxv implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzxv(zzyc zzyc, long j, int i) {
        this.zza = zzyc;
        this.zzb = j;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
