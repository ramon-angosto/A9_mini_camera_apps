package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdzj implements Runnable {
    public final /* synthetic */ zzdzs zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzchh zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzfjj zzf;

    public /* synthetic */ zzdzj(zzdzs zzdzs, Object obj, zzchh zzchh, String str, long j, zzfjj zzfjj) {
        this.zza = zzdzs;
        this.zzb = obj;
        this.zzc = zzchh;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzfjj;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
