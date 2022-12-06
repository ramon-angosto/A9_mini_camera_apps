package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzczr implements zzfzc {
    final /* synthetic */ zzfzc zza;
    final /* synthetic */ zzczs zzb;

    zzczr(zzczs zzczs, zzfzc zzfzc) {
        this.zzb = zzczs;
        this.zza = zzfzc;
    }

    public final void zza(Throwable th) {
        zzchc.zze.execute(new zzczp(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzchc.zze.execute(new zzczp(this.zzb));
        this.zza.zzb((zzcze) obj);
    }
}
