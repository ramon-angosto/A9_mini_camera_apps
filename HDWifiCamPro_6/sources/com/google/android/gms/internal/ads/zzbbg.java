package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbbg implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzbbk zzc;

    zzbbg(zzbbk zzbbk, int i, long j) {
        this.zzc = zzbbk;
        this.zza = i;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzb.zzl(this.zza, this.zzb);
    }
}
