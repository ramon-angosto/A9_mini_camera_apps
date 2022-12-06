package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbbf implements Runnable {
    final /* synthetic */ zzasw zza;
    final /* synthetic */ zzbbk zzb;

    zzbbf(zzbbk zzbbk, zzasw zzasw) {
        this.zzb = zzbbk;
        this.zza = zzasw;
    }

    public final void run() {
        this.zzb.zzb.zzn(this.zza);
    }
}
