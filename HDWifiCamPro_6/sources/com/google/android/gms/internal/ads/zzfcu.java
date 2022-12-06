package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfcu implements zzfzc {
    final /* synthetic */ zzeou zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzfjj zzc;
    final /* synthetic */ zzfcw zzd;
    final /* synthetic */ zzfcx zze;

    zzfcu(zzfcx zzfcx, zzeou zzeou, zzfju zzfju, zzfjj zzfjj, zzfcw zzfcw) {
        this.zze = zzfcx;
        this.zza = zzeou;
        this.zzb = zzfju;
        this.zzc = zzfjj;
        this.zzd = zzfcw;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzfju zzfju;
        zzduh zzduh = (zzduh) this.zze.zze.zzd();
        if (zzduh == null) {
            zze2 = zzffe.zzb(th, (zzehh) null);
        } else {
            zze2 = zzduh.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzduh != null) {
                zzduh.zza().zza(zze2);
                this.zze.zzb.execute(new zzfct(this, zze2));
            } else {
                this.zze.zzd.zza(zze2);
                this.zze.zzk(this.zzd).zze().zzb().zzc().zzd();
            }
            zzfez.zzb(zze2.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzg = this.zze.zzg;
                zzfjj zzfjj = this.zzc;
                zzfjj.zza(zze2);
                zzfjj.zze(false);
                zzg.zzb(zzfjj.zzj());
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
        zzduc zzduc = (zzduc) obj;
        synchronized (this.zze) {
            zzduc.zzn().zzd(this.zze.zzd);
            this.zza.zzb(zzduc);
            zzfcx zzfcx = this.zze;
            Executor zzh = zzfcx.zzb;
            zzfcn zzf = zzfcx.zzd;
            zzf.getClass();
            zzh.execute(new zzfcs(zzf));
            this.zze.zzd.zzv();
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzg = this.zze.zzg;
                zzfjj zzfjj = this.zzc;
                zzfjj.zzb(zzduc.zzp().zzb);
                zzfjj.zzc(zzduc.zzl().zzg());
                zzfjj.zze(true);
                zzg.zzb(zzfjj.zzj());
            } else {
                zzfju.zzf(zzduc.zzp().zzb);
                zzfju.zze(zzduc.zzl().zzg());
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(true);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }
}
