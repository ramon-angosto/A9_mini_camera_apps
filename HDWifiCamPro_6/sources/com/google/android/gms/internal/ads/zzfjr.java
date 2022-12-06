package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfjr implements zzfzc {
    final /* synthetic */ zzfju zza;
    final /* synthetic */ zzfjj zzb;
    final /* synthetic */ boolean zzc;

    zzfjr(zzfju zzfju, zzfjj zzfjj, boolean z) {
        this.zza = zzfju;
        this.zzb = zzfjj;
        this.zzc = z;
    }

    public final void zza(Throwable th) {
        zzfjj zzfjj = this.zzb;
        if (zzfjj.zzh()) {
            zzfju zzfju = this.zza;
            zzfjj.zze(false);
            zzfju.zza(zzfjj);
            if (this.zzc) {
                this.zza.zzg();
            }
        }
    }

    public final void zzb(Object obj) {
        zzfju zzfju = this.zza;
        zzfjj zzfjj = this.zzb;
        zzfjj.zze(true);
        zzfju.zza(zzfjj);
        if (this.zzc) {
            this.zza.zzg();
        }
    }
}
