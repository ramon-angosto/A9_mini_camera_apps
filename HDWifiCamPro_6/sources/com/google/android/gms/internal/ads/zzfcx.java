package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfcx implements zzeov {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcom zzc;
    /* access modifiers changed from: private */
    public final zzfcn zzd;
    /* access modifiers changed from: private */
    public final zzfaz zze;
    private final zzfdx zzf;
    /* access modifiers changed from: private */
    public final zzfjw zzg;
    private final zzfed zzh;
    private zzfzp zzi;

    public zzfcx(Context context, Executor executor, zzcom zzcom, zzfaz zzfaz, zzfcn zzfcn, zzfed zzfed, zzfdx zzfdx) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcom;
        this.zze = zzfaz;
        this.zzd = zzfcn;
        this.zzh = zzfed;
        this.zzf = zzfdx;
        this.zzg = zzcom.zzy();
    }

    /* access modifiers changed from: private */
    public final zzdug zzk(zzfax zzfax) {
        zzfcw zzfcw = (zzfcw) zzfax;
        zzdug zzi2 = this.zzc.zzi();
        zzdck zzdck = new zzdck();
        zzdck.zzc(this.zza);
        zzdck.zzf(zzfcw.zza);
        String str = zzfcw.zzb;
        zzdck.zze(this.zzf);
        zzi2.zzd(zzdck.zzg());
        zzi2.zzc(new zzdik().zzn());
        return zzi2;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzl zzl, String str, zzeot zzeot, zzeou zzeou) throws RemoteException {
        zzfju zzfju;
        zzcbz zzcbz = new zzcbz(zzl, str);
        if (zzcbz.zzb == null) {
            zze.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzfcq(this));
            return false;
        }
        zzfzp zzfzp = this.zzi;
        if (zzfzp != null && !zzfzp.isDone()) {
            return false;
        }
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            zzfaz zzfaz = this.zze;
            if (zzfaz.zzd() != null) {
                zzfju zzh2 = ((zzduh) zzfaz.zzd()).zzh();
                zzh2.zzh(5);
                zzh2.zzb(zzcbz.zza.zzp);
                zzfju = zzh2;
                zzfez.zza(this.zza, zzcbz.zza.zzf);
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue() && zzcbz.zza.zzf) {
                    this.zzc.zzk().zzm(true);
                }
                zzfed zzfed = this.zzh;
                zzfed.zzs(zzcbz.zzb);
                zzfed.zzr(zzq.zzd());
                zzfed.zzE(zzcbz.zza);
                zzfef zzG = zzfed.zzG();
                zzfjj zzb2 = zzfji.zzb(this.zza, zzfjt.zzf(zzG), 5, zzcbz.zza);
                zzfcw zzfcw = new zzfcw((zzfcv) null);
                zzfcw.zza = zzG;
                zzfcw.zzb = null;
                this.zzi = this.zze.zzc(new zzfba(zzfcw, (zzcbc) null), new zzfcr(this), (Object) null);
                zzfzg.zzr(this.zzi, new zzfcu(this, zzeou, zzfju, zzb2, zzfcw), this.zzb);
                return true;
            }
        }
        zzfju = null;
        zzfez.zza(this.zza, zzcbz.zza.zzf);
        this.zzc.zzk().zzm(true);
        zzfed zzfed2 = this.zzh;
        zzfed2.zzs(zzcbz.zzb);
        zzfed2.zzr(zzq.zzd());
        zzfed2.zzE(zzcbz.zza);
        zzfef zzG2 = zzfed2.zzG();
        zzfjj zzb22 = zzfji.zzb(this.zza, zzfjt.zzf(zzG2), 5, zzcbz.zza);
        zzfcw zzfcw2 = new zzfcw((zzfcv) null);
        zzfcw2.zza = zzG2;
        zzfcw2.zzb = null;
        this.zzi = this.zze.zzc(new zzfba(zzfcw2, (zzcbc) null), new zzfcr(this), (Object) null);
        zzfzg.zzr(this.zzi, new zzfcu(this, zzeou, zzfju, zzb22, zzfcw2), this.zzb);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zzd.zza(zzffe.zzd(6, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i) {
        this.zzh.zzo().zza(i);
    }
}
