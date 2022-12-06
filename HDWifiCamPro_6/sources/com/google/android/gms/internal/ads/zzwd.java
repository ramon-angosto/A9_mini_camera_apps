package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzwd implements Runnable {
    public final /* synthetic */ zzwe zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzwd(zzwe zzwe, int i, long j, long j2) {
        this.zza = zzwe;
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        zzwe zzwe = this.zza;
        zzwe.zzb.zzY(this.zzb, this.zzc, this.zzd);
    }
}
