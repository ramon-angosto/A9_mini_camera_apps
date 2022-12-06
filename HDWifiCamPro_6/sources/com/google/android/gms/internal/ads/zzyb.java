package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzyb implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzyb(zzyc zzyc, String str) {
        this.zza = zzyc;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
