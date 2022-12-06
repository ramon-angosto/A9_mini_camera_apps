package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzxt implements Runnable {
    public final /* synthetic */ zzyc zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzxt(zzyc zzyc, Object obj, long j) {
        this.zza = zzyc;
        this.zzb = obj;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc);
    }
}
