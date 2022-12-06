package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzczq implements zzfzc {
    final /* synthetic */ zzfzc zza;
    final /* synthetic */ zzczs zzb;

    zzczq(zzczs zzczs, zzfzc zzfzc) {
        this.zzb = zzczs;
        this.zza = zzfzc;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzchc.zze.execute(new zzczp(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzczs.zzb(this.zzb, ((zzczl) obj).zza, this.zza);
    }
}
