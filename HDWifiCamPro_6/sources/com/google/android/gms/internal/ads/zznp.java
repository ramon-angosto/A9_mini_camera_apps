package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zznp implements Runnable {
    public final /* synthetic */ zznr zza;
    public final /* synthetic */ zzaf zzb;
    public final /* synthetic */ zzgt zzc;

    public /* synthetic */ zznp(zznr zznr, zzaf zzaf, zzgt zzgt) {
        this.zza = zznr;
        this.zzb = zzaf;
        this.zzc = zzgt;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}
