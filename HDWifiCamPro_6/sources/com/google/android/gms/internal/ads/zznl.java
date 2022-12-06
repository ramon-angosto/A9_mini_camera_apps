package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zznl implements Runnable {
    public final /* synthetic */ zznr zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zznl(zznr zznr, boolean z) {
        this.zza = zznr;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzp(this.zzb);
    }
}
