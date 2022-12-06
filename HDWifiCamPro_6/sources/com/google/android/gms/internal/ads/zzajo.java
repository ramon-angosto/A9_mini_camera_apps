package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzajo implements Runnable {
    final /* synthetic */ zzakd zza;
    final /* synthetic */ zzajp zzb;

    zzajo(zzajp zzajp, zzakd zzakd) {
        this.zzb = zzajp;
        this.zza = zzakd;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
