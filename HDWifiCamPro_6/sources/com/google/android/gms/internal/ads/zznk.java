package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zznk implements Runnable {
    public final /* synthetic */ zznr zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zznk(zznr zznr, long j) {
        this.zza = zznr;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
