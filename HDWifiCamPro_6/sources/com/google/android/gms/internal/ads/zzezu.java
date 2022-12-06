package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzezu implements zzeov {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcom zzc;
    /* access modifiers changed from: private */
    public final zzeof zzd;
    /* access modifiers changed from: private */
    public final zzeoj zze;
    /* access modifiers changed from: private */
    public final ViewGroup zzf;
    private zzbjx zzg;
    /* access modifiers changed from: private */
    public final zzdfp zzh;
    /* access modifiers changed from: private */
    public final zzfjw zzi;
    /* access modifiers changed from: private */
    public final zzdhv zzj;
    private final zzfed zzk;
    /* access modifiers changed from: private */
    public zzfzp zzl;

    public zzezu(Context context, Executor executor, zzq zzq, zzcom zzcom, zzeof zzeof, zzeoj zzeoj, zzfed zzfed, zzdhv zzdhv) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcom;
        this.zzd = zzeof;
        this.zze = zzeoj;
        this.zzk = zzfed;
        this.zzh = zzcom.zzf();
        this.zzi = zzcom.zzy();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdhv;
        zzfed.zzr(zzq);
    }

    public final boolean zza() {
        zzfzp zzfzp = this.zzl;
        return zzfzp != null && !zzfzp.isDone();
    }

    public final boolean zzb(zzl zzl2, String str, zzeot zzeot, zzeou zzeou) throws RemoteException {
        zzcxz zzcxz;
        zzfju zzfju;
        if (str == null) {
            zze.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzezq(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue() && zzl2.zzf) {
                this.zzc.zzk().zzm(true);
            }
            zzfed zzfed = this.zzk;
            zzfed.zzs(str);
            zzfed.zzE(zzl2);
            zzfef zzG = zzfed.zzG();
            zzfjj zzb2 = zzfji.zzb(this.zza, zzfjt.zzf(zzG), 3, zzl2);
            if (!((Boolean) zzbkx.zzc.zze()).booleanValue() || !this.zzk.zzg().zzk) {
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzgY)).booleanValue()) {
                    zzcxy zze2 = this.zzc.zze();
                    zzdck zzdck = new zzdck();
                    zzdck.zzc(this.zza);
                    zzdck.zzf(zzG);
                    zze2.zzi(zzdck.zzg());
                    zzdik zzdik = new zzdik();
                    zzdik.zzj(this.zzd, this.zzb);
                    zzdik.zzk(this.zzd, this.zzb);
                    zze2.zzf(zzdik.zzn());
                    zze2.zze(new zzemp(this.zzg));
                    zze2.zzd(new zzdmy(zzdpb.zza, (zzbf) null));
                    zze2.zzg(new zzcyw(this.zzh, this.zzj));
                    zze2.zzc(new zzcwz(this.zzf));
                    zzcxz = zze2.zzj();
                } else {
                    zzcxy zze3 = this.zzc.zze();
                    zzdck zzdck2 = new zzdck();
                    zzdck2.zzc(this.zza);
                    zzdck2.zzf(zzG);
                    zze3.zzi(zzdck2.zzg());
                    zzdik zzdik2 = new zzdik();
                    zzdik2.zzj(this.zzd, this.zzb);
                    zzdik2.zza(this.zzd, this.zzb);
                    zzdik2.zza(this.zze, this.zzb);
                    zzdik2.zzl(this.zzd, this.zzb);
                    zzdik2.zzd(this.zzd, this.zzb);
                    zzdik2.zze(this.zzd, this.zzb);
                    zzdik2.zzf(this.zzd, this.zzb);
                    zzdik2.zzb(this.zzd, this.zzb);
                    zzdik2.zzk(this.zzd, this.zzb);
                    zzdik2.zzi(this.zzd, this.zzb);
                    zze3.zzf(zzdik2.zzn());
                    zze3.zze(new zzemp(this.zzg));
                    zze3.zzd(new zzdmy(zzdpb.zza, (zzbf) null));
                    zze3.zzg(new zzcyw(this.zzh, this.zzj));
                    zze3.zzc(new zzcwz(this.zzf));
                    zzcxz = zze3.zzj();
                }
                zzcxz zzcxz2 = zzcxz;
                if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
                    zzfju zzj2 = zzcxz2.zzj();
                    zzj2.zzh(3);
                    zzj2.zzb(zzl2.zzp);
                    zzfju = zzj2;
                } else {
                    zzfju = null;
                }
                zzdah zzd2 = zzcxz2.zzd();
                this.zzl = zzd2.zzh(zzd2.zzi());
                zzfzg.zzr(this.zzl, new zzezt(this, zzeou, zzfju, zzb2, zzcxz2), this.zzb);
                return true;
            }
            zzeof zzeof = this.zzd;
            if (zzeof != null) {
                zzeof.zza(zzffe.zzd(7, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            }
            return false;
        }
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfed zzi() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzd.zza(zzffe.zzd(6, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(zzbc zzbc) {
        this.zze.zza(zzbc);
    }

    public final void zzp(zzdfq zzdfq) {
        this.zzh.zzj(zzdfq, this.zzb);
    }

    public final void zzq(zzbjx zzbjx) {
        this.zzg = zzbjx;
    }

    public final boolean zzr() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzt.zzp();
        return zzs.zzS(view, view.getContext());
    }
}
