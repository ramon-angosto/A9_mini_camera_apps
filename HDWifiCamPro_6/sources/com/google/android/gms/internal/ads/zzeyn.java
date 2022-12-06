package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeyn implements zzfzc {
    final /* synthetic */ zzeou zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzfjj zzc;
    final /* synthetic */ zzeyp zzd;
    final /* synthetic */ zzeyq zze;

    zzeyn(zzeyq zzeyq, zzeou zzeou, zzfju zzfju, zzfjj zzfjj, zzeyp zzeyp) {
        this.zze = zzeyq;
        this.zza = zzeou;
        this.zzb = zzfju;
        this.zzc = zzfjj;
        this.zzd = zzeyp;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzfju zzfju;
        zzcwk zzcwk = (zzcwk) this.zze.zze.zzd();
        if (zzcwk == null) {
            zze2 = zzffe.zzb(th, (zzehh) null);
        } else {
            zze2 = zzcwk.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcwk != null) {
                zzcwk.zzc().zza(zze2);
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzgZ)).booleanValue()) {
                    this.zze.zzc.execute(new zzeym(this, zze2));
                }
            } else {
                this.zze.zzd.zza(zze2);
                ((zzcwk) this.zze.zzm(this.zzd).zzh()).zzb().zzc().zzd();
            }
            zzfez.zzb(zze2.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzh = this.zze.zzh;
                zzfjj zzfjj = this.zzc;
                zzfjj.zza(zze2);
                zzfjj.zze(false);
                zzh.zzb(zzfjj.zzj());
            } else {
                zzfju.zzc(zze2);
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(false);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfju zzfju;
        zzcze zzcze = (zzcze) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzgZ)).booleanValue()) {
                zzcze.zzn().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzcze);
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzh = this.zze.zzh;
                zzfjj zzfjj = this.zzc;
                zzfjj.zzb(zzcze.zzp().zzb);
                zzfjj.zzc(zzcze.zzl().zzg());
                zzfjj.zze(true);
                zzh.zzb(zzfjj.zzj());
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
