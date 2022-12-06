package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzezt implements zzfzc {
    final /* synthetic */ zzeou zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzfjj zzc;
    final /* synthetic */ zzcxz zzd;
    final /* synthetic */ zzezu zze;

    zzezt(zzezu zzezu, zzeou zzeou, zzfju zzfju, zzfjj zzfjj, zzcxz zzcxz) {
        this.zze = zzezu;
        this.zza = zzeou;
        this.zzb = zzfju;
        this.zzc = zzfjj;
        this.zzd = zzcxz;
    }

    public final void zza(Throwable th) {
        zzfju zzfju;
        zze zza2 = this.zzd.zzd().zza(th);
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zzd.zzf().zza(zza2);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzgY)).booleanValue()) {
                this.zze.zzb.execute(new zzezs(this, zza2));
            }
            zzezu zzezu = this.zze;
            zzezu.zzh.zzd(zzezu.zzj.zzc());
            zzfez.zzb(zza2.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzj = this.zze.zzi;
                zzfjj zzfjj = this.zzc;
                zzfjj.zza(zza2);
                zzfjj.zze(false);
                zzj.zzb(zzfjj.zzj());
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
        zzcxc zzcxc = (zzcxc) obj;
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zze.zzf.removeAllViews();
            if (zzcxc.zzc() != null) {
                ViewParent parent = zzcxc.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzcxc.zzl() != null) {
                        str = zzcxc.zzl().zzg();
                    }
                    com.google.android.gms.ads.internal.util.zze.zzj("Banner view provided from " + str + " already has a parent view. Removing its old parent.");
                    ((ViewGroup) parent).removeView(zzcxc.zzc());
                }
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzgY)).booleanValue()) {
                zzdhe zzn = zzcxc.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzc(this.zze.zze);
            }
            this.zze.zzf.addView(zzcxc.zzc());
            this.zza.zzb(zzcxc);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzgY)).booleanValue()) {
                zzezu zzezu = this.zze;
                Executor zzk = zzezu.zzb;
                zzeof zzg = zzezu.zzd;
                zzg.getClass();
                zzk.execute(new zzezr(zzg));
            }
            this.zze.zzh.zzd(zzcxc.zza());
            if (!((Boolean) zzbkl.zzc.zze()).booleanValue() || (zzfju = this.zzb) == null) {
                zzfjw zzj = this.zze.zzi;
                zzfjj zzfjj = this.zzc;
                zzfjj.zzb(zzcxc.zzp().zzb);
                zzfjj.zzc(zzcxc.zzl().zzg());
                zzfjj.zze(true);
                zzj.zzb(zzfjj.zzj());
            } else {
                zzfju.zzf(zzcxc.zzp().zzb);
                zzfju.zze(zzcxc.zzl().zzg());
                zzfjj zzfjj2 = this.zzc;
                zzfjj2.zze(true);
                zzfju.zza(zzfjj2);
                zzfju.zzg();
            }
        }
    }
}
