package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzxu implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzxu(zzyc zzyc, Exception exc) {
        this.zza = zzyc;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
