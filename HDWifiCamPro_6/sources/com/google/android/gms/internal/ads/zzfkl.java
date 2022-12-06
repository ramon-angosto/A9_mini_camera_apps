package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfkl implements Runnable {
    public final /* synthetic */ zzfkm zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzfju zzc;

    public /* synthetic */ zzfkl(zzfkm zzfkm, String str, zzfju zzfju) {
        this.zza = zzfkm;
        this.zzb = str;
        this.zzc = zzfju;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc);
    }
}
