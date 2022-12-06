package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfbm implements zzfzc {
    final /* synthetic */ zzeou zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzfjj zzc;
    final /* synthetic */ zzdmh zzd;
    final /* synthetic */ zzfbn zze;

    zzfbm(zzfbn zzfbn, zzeou zzeou, zzfju zzfju, zzfjj zzfjj, zzdmh zzdmh) {
        this.zze = zzfbn;
        this.zza = zzeou;
        this.zzb = zzfju;
        this.zzc = zzfjj;
        this.zzd = zzdmh;
    }

    public final void zza(Throwable th) {
        zzfju zzfju;
        zze zza2 = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zza(zza2);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzha)).booleanValue()) {
                this.zze.zzb.execute(new zzfbk(this, zza2));
                this.zze.zzb.execute(new zzfbl(this, zza2));
            }
            zzfez.zzb(zza2.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zze2 = this.zze.zzg;
                zzfjj zzfjj = this.zzc;
                zzfjj.zza(zza2);
                zzfjj.zze(false);
                zze2.zzb(zzfjj.zzj());
            } else {
                zzfju.zzc(zza2);
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(false);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfju zzfju;
        zzdlg zzdlg = (zzdlg) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzha)).booleanValue()) {
                zzdhe zzn = zzdlg.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdlg);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzha)).booleanValue()) {
                this.zze.zzb.execute(new zzfbi(this));
                this.zze.zzb.execute(new zzfbj(this));
            }
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zze2 = this.zze.zzg;
                zzfjj zzfjj = this.zzc;
                zzfjj.zzb(zzdlg.zzp().zzb);
                zzfjj.zzc(zzdlg.zzl().zzg());
                zzfjj.zze(true);
                zze2.zzb(zzfjj.zzj());
            } else {
                zzfju.zzf(zzdlg.zzp().zzb);
                zzfju.zze(zzdlg.zzl().zzg());
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(true);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }
}
