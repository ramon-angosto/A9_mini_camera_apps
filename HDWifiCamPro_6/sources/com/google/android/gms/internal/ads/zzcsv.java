package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcsv implements Runnable {
    public final /* synthetic */ zzcsw zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcsv(zzcsw zzcsw, Runnable runnable) {
        this.zza = zzcsw;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
