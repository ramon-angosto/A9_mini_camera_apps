package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zznh implements Runnable {
    public final /* synthetic */ zznr zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zznh(zznr zznr, Exception exc) {
        this.zza = zznr;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
