package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzsp implements Runnable {
    public final /* synthetic */ zzsr zza;
    public final /* synthetic */ zzss zzb;
    public final /* synthetic */ zzrz zzc;
    public final /* synthetic */ zzse zzd;

    public /* synthetic */ zzsp(zzsr zzsr, zzss zzss, zzrz zzrz, zzse zzse) {
        this.zza = zzsr;
        this.zzb = zzss;
        this.zzc = zzrz;
        this.zzd = zzse;
    }

    public final void run() {
        zzsr zzsr = this.zza;
        this.zzb.zzah(zzsr.zza, zzsr.zzb, this.zzc, this.zzd);
    }
}
