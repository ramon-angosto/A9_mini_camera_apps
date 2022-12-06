package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzxy implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzxy(zzyc zzyc, String str, long j, long j2) {
        this.zza = zzyc;
        this.zzb = str;
        this.zzc = j;
        this.zzd = j2;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc, this.zzd);
    }
}
