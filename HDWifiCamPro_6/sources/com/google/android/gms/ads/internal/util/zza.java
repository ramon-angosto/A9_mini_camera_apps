package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zza implements Runnable {
    final /* synthetic */ zzb zza;

    zza(zzb zzb) {
        this.zza = zzb;
    }

    public final void run() {
        this.zza.zzb = Thread.currentThread();
        this.zza.zza();
    }
}
