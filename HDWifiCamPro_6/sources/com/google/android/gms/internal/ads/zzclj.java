package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzclj implements Runnable {
    public final /* synthetic */ zzciy zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzclj(zzciy zzciy, boolean z, long j) {
        this.zza = zzciy;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        zzciy zzciy = this.zza;
        boolean z = this.zzb;
        long j = this.zzc;
        int i = zzclk.zzd;
        zzciy.zzx(z, j);
    }
}
