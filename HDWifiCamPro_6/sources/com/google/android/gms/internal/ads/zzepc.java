package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzepc implements zzeov {
    private final zzfed zza;
    /* access modifiers changed from: private */
    public final zzcom zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzeos zzd;
    /* access modifiers changed from: private */
    public final zzfjw zze;
    private zzczs zzf;

    public zzepc(zzcom zzcom, Context context, zzeos zzeos, zzfed zzfed) {
        this.zzb = zzcom;
        this.zzc = context;
        this.zzd = zzeos;
        this.zza = zzfed;
        this.zze = zzcom.zzy();
        zzfed.zzu(zzeos.zzd());
    }

    public final boolean zza() {
        zzczs zzczs = this.zzf;
        return zzczs != null && zzczs.zzf();
    }

    public final boolean zzb(zzl zzl, String str, zzeot zzeot, zzeou zzeou) throws RemoteException {
        zzfju zzfju;
        zzt.zzp();
        if (zzs.zzD(this.zzc) && zzl.zzs == null) {
            zze.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new zzeox(this));
            return false;
        } else if (str == null) {
            zze.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new zzeoy(this));
            return false;
        } else {
            zzfez.zza(this.zzc, zzl.zzf);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue() && zzl.zzf) {
                this.zzb.zzk().zzm(true);
            }
            int i = ((zzeow) zzeot).zza;
            zzfed zzfed = this.zza;
            zzfed.zzE(zzl);
            zzfed.zzz(i);
            zzfef zzG = zzfed.zzG();
            zzfjj zzb2 = zzfji.zzb(this.zzc, zzfjt.zzf(zzG), 8, zzl);
            zzbz zzbz = zzG.zzn;
            if (zzbz != null) {
                this.zzd.zzd().zzi(zzbz);
            }
            zzdnc zzh = this.zzb.zzh();
            zzdck zzdck = new zzdck();
            zzdck.zzc(this.zzc);
            zzdck.zzf(zzG);
            zzh.zzf(zzdck.zzg());
            zzdik zzdik = new zzdik();
            zzdik.zzk(this.zzd.zzd(), this.zzb.zzA());
            zzh.zze(zzdik.zzn());
            zzh.zzd(this.zzd.zzc());
            zzh.zzc(new zzcwz((ViewGroup) null));
            zzdnd zzg = zzh.zzg();
            if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
                zzfju zzf2 = zzg.zzf();
                zzf2.zzh(8);
                zzf2.zzb(zzl.zzp);
                zzfju = zzf2;
            } else {
                zzfju = null;
            }
            this.zzb.zzw().zzc(1);
            zzfzq zzfzq = zzchc.zza;
            zzgxq.zzb(zzfzq);
            ScheduledExecutorService zzB = this.zzb.zzB();
            zzdah zza2 = zzg.zza();
            this.zzf = new zzczs(zzfzq, zzB, zza2.zzh(zza2.zzi()));
            this.zzf.zze(new zzepb(this, zzeou, zzfju, zzb2, zzg));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zza(zzffe.zzd(4, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zza(zzffe.zzd(6, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
    }
}
