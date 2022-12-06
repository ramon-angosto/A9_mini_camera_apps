package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeea implements Callable {
    public final /* synthetic */ zzeek zza;
    public final /* synthetic */ zzfzp zzb;
    public final /* synthetic */ zzfzp zzc;
    public final /* synthetic */ zzcbc zzd;
    public final /* synthetic */ zzfjj zze;

    public /* synthetic */ zzeea(zzeek zzeek, zzfzp zzfzp, zzfzp zzfzp2, zzcbc zzcbc, zzfjj zzfjj) {
        this.zza = zzeek;
        this.zzb = zzfzp;
        this.zzc = zzfzp2;
        this.zzd = zzcbc;
        this.zze = zzfjj;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
