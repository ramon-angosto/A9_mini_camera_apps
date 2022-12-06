package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzsn implements Runnable {
    public final /* synthetic */ zzsr zza;
    public final /* synthetic */ zzss zzb;
    public final /* synthetic */ zzrz zzc;
    public final /* synthetic */ zzse zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzsn(zzsr zzsr, zzss zzss, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        this.zza = zzsr;
        this.zzb = zzss;
        this.zzc = zzrz;
        this.zzd = zzse;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        zzsr zzsr = this.zza;
        this.zzb.zzai(zzsr.zza, zzsr.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
