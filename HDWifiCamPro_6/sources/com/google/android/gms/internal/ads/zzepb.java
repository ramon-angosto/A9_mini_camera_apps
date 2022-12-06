package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzepb implements zzfzc {
    final /* synthetic */ zzeou zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzfjj zzc;
    final /* synthetic */ zzdnd zzd;
    final /* synthetic */ zzepc zze;

    zzepb(zzepc zzepc, zzeou zzeou, zzfju zzfju, zzfjj zzfjj, zzdnd zzdnd) {
        this.zze = zzepc;
        this.zza = zzeou;
        this.zzb = zzfju;
        this.zzc = zzfjj;
        this.zzd = zzdnd;
    }

    public final void zza(Throwable th) {
        zzfju zzfju;
        zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zza(zza2);
        this.zze.zzb.zzA().execute(new zzepa(this, zza2));
        zzfez.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
            zzfjw zze2 = this.zze.zze;
            zzfjj zzfjj = this.zzc;
            zzfjj.zza(zza2);
            zzfjj.zze(false);
            zze2.zzb(zzfjj.zzj());
            return;
        }
        zzfju.zzc(zza2);
        zzfjj zzfjj2 = this.zzc;
        zzfjj2.zze(false);
        zzfju.zza(zzfjj2);
        zzfju.zzg();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfju zzfju;
        zzcze zzcze = (zzcze) obj;
        synchronized (this.zze) {
            zzcze.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcze);
            this.zze.zzb.zzA().execute(new zzeoz(this));
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zze2 = this.zze.zze;
                zzfjj zzfjj = this.zzc;
                zzfjj.zzb(zzcze.zzp().zzb);
                zzfjj.zzc(zzcze.zzl().zzg());
                zzfjj.zze(true);
                zze2.zzb(zzfjj.zzj());
            } else {
                zzfju.zzf(zzcze.zzp().zzb);
                zzfju.zze(zzcze.zzl().zzg());
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(true);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }
}
