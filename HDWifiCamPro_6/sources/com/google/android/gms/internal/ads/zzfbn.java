package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfbn implements zzeov {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcom zzc;
    /* access modifiers changed from: private */
    public final zzeof zzd;
    /* access modifiers changed from: private */
    public final zzfcn zze;
    private zzbjx zzf;
    /* access modifiers changed from: private */
    public final zzfjw zzg;
    private final zzfed zzh;
    /* access modifiers changed from: private */
    public zzfzp zzi;

    public zzfbn(Context context, Executor executor, zzcom zzcom, zzeof zzeof, zzfcn zzfcn, zzfed zzfed) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcom;
        this.zzd = zzeof;
        this.zzh = zzfed;
        this.zze = zzfcn;
        this.zzg = zzcom.zzy();
    }

    public final boolean zza() {
        zzfzp zzfzp = this.zzi;
        return zzfzp != null && !zzfzp.isDone();
    }

    public final boolean zzb(zzl zzl, String str, zzeot zzeot, zzeou zzeou) {
        zzdmh zzf2;
        zzfju zzfju;
        if (str == null) {
            zze.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzfbh(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue() && zzl.zzf) {
                this.zzc.zzk().zzm(true);
            }
            zzq zzq = ((zzfbg) zzeot).zza;
            zzfed zzfed = this.zzh;
            zzfed.zzs(str);
            zzfed.zzr(zzq);
            zzfed.zzE(zzl);
            zzfef zzG = zzfed.zzG();
            zzfjj zzb2 = zzfji.zzb(this.zza, zzfjt.zzf(zzG), 4, zzl);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzha)).booleanValue()) {
                zzdmg zzg2 = this.zzc.zzg();
                zzdck zzdck = new zzdck();
                zzdck.zzc(this.zza);
                zzdck.zzf(zzG);
                zzg2.zze(zzdck.zzg());
                zzdik zzdik = new zzdik();
                zzdik.zzj(this.zzd, this.zzb);
                zzdik.zzk(this.zzd, this.zzb);
                zzg2.zzd(zzdik.zzn());
                zzg2.zzc(new zzemp(this.zzf));
                zzf2 = zzg2.zzf();
            } else {
                zzdik zzdik2 = new zzdik();
                zzfcn zzfcn = this.zze;
                if (zzfcn != null) {
                    zzdik2.zze(zzfcn, this.zzb);
                    zzdik2.zzf(this.zze, this.zzb);
                    zzdik2.zzb(this.zze, this.zzb);
                }
                zzdmg zzg3 = this.zzc.zzg();
                zzdck zzdck2 = new zzdck();
                zzdck2.zzc(this.zza);
                zzdck2.zzf(zzG);
                zzg3.zze(zzdck2.zzg());
                zzdik2.zzj(this.zzd, this.zzb);
                zzdik2.zze(this.zzd, this.zzb);
                zzdik2.zzf(this.zzd, this.zzb);
                zzdik2.zzb(this.zzd, this.zzb);
                zzdik2.zza(this.zzd, this.zzb);
                zzdik2.zzl(this.zzd, this.zzb);
                zzdik2.zzk(this.zzd, this.zzb);
                zzdik2.zzi(this.zzd, this.zzb);
                zzdik2.zzc(this.zzd, this.zzb);
                zzg3.zzd(zzdik2.zzn());
                zzg3.zzc(new zzemp(this.zzf));
                zzf2 = zzg3.zzf();
            }
            zzdmh zzdmh = zzf2;
            if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
                zzfju zzf3 = zzdmh.zzf();
                zzf3.zzh(4);
                zzf3.zzb(zzl.zzp);
                zzfju = zzf3;
            } else {
                zzfju = null;
            }
            zzdah zza2 = zzdmh.zza();
            this.zzi = zza2.zzh(zza2.zzi());
            zzfzg.zzr(this.zzi, new zzfbm(this, zzeou, zzfju, zzb2, zzdmh), this.zzb);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zza(zzffe.zzd(6, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
    }

    public final void zzi(zzbjx zzbjx) {
        this.zzf = zzbjx;
    }
}
