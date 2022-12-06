package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcdk implements zzfzc {
    final /* synthetic */ zzfzp zza;

    zzcdk(zzcdl zzcdl, zzfzp zzfzp) {
        this.zza = zzfzp;
    }

    public final void zza(Throwable th) {
        zzcdl.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzcdl.zzc.remove(this.zza);
    }
}
