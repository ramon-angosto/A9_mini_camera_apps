package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdz implements Runnable {
    public final /* synthetic */ zzed zza;
    public final /* synthetic */ zzwj zzb;

    public /* synthetic */ zzdz(zzed zzed, zzwj zzwj, byte[] bArr) {
        this.zza = zzed;
        this.zzb = zzwj;
    }

    public final void run() {
        zzed zzed = this.zza;
        zzwj zzwj = this.zzb;
        zzwj.zza.zzk(zzed.zza());
    }
}
