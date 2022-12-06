package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzsl implements Runnable {
    public final /* synthetic */ zzsr zza;
    public final /* synthetic */ zzss zzb;
    public final /* synthetic */ zzse zzc;

    public /* synthetic */ zzsl(zzsr zzsr, zzss zzss, zzse zzse) {
        this.zza = zzsr;
        this.zzb = zzss;
        this.zzc = zzse;
    }

    public final void run() {
        zzsr zzsr = this.zza;
        this.zzb.zzaf(zzsr.zza, zzsr.zzb, this.zzc);
    }
}
