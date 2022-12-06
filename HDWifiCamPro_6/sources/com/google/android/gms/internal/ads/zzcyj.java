package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcyj implements Runnable {
    public final /* synthetic */ zzcyk zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcyj(zzcyk zzcyk, Runnable runnable) {
        this.zza = zzcyk;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
