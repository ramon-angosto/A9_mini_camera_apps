package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbsw implements Runnable {
    public final /* synthetic */ zzbsz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbsw(zzbsz zzbsz, String str) {
        this.zza = zzbsz;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzp(this.zzb);
    }
}
