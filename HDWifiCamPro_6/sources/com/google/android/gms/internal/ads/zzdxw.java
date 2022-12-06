package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdxw implements Runnable {
    public final /* synthetic */ zzdxx zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdxw(zzdxx zzdxx, String str) {
        this.zza = zzdxx;
        this.zzb = str;
    }

    public final void run() {
        zzdxx zzdxx = this.zza;
        zzdxx.zzd.zza(this.zzb);
    }
}
