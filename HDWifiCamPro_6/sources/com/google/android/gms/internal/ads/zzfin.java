package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfin implements Runnable {
    public final /* synthetic */ zzfio zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfin(zzfio zzfio, String str) {
        this.zza = zzfio;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
